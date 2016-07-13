/*
 * Copyright (C) 2016 Scalatech
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.java.scalatech.jpa;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;


/**
 * @author Sławomir Borowiec 
 * Module name : commonDao
 * Creating time :  1 mar 2014 15:03:19
 
 */
public class CustomHibernateJpaDialect extends HibernateJpaDialect {

    private static final long serialVersionUID = 1L;

    /* 
     * This method is overridden to set custom isolation levels on the connection
     * (non-Javadoc)
     * @see org.springframework.orm.jpa.vendor.HibernateJpaDialect#beginTransaction(javax.persistence.EntityManager, org.springframework.transaction.TransactionDefinition)
     */
    @Override
    public Object beginTransaction(final EntityManager entityManager,
            final TransactionDefinition definition)
            throws PersistenceException, SQLException, TransactionException {

        Session session = (Session) entityManager.getDelegate();
        if (definition.getTimeout() != TransactionDefinition.TIMEOUT_DEFAULT) {
            getSession(entityManager).getTransaction().setTimeout(
                    definition.getTimeout());
        }

        final TransactionData data = new TransactionData();

        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                Integer previousIsolationLevel = DataSourceUtils
                        .prepareConnectionForTransaction(connection, definition);
                data.setPreviousIsolationLevel(previousIsolationLevel);
                data.setConnection(connection);
            }
        });

        entityManager.getTransaction().begin();

        Object springTransactionData = prepareTransaction(entityManager,
                definition.isReadOnly(), definition.getName());

        data.setSpringTransactionData(springTransactionData);

        return data;
    }

    @Override
    public void cleanupTransaction(Object transactionData) {
        super.cleanupTransaction(((TransactionData) transactionData)
                .getSpringTransactionData());
        ((TransactionData) transactionData).resetIsolationLevel();
    }

    private static class TransactionData {

        private Object springTransactionData;
        private Integer previousIsolationLevel;
        private Connection connection;

        public TransactionData() {
        }

        public void resetIsolationLevel() {
            if (this.previousIsolationLevel != null) {
                DataSourceUtils.resetConnectionAfterTransaction(connection,
                        previousIsolationLevel);
            }
        }

        public Object getSpringTransactionData() {
            return this.springTransactionData;
        }

        public void setSpringTransactionData(Object springTransactionData) {
            this.springTransactionData = springTransactionData;
        }

        public void setPreviousIsolationLevel(Integer previousIsolationLevel) {
            this.previousIsolationLevel = previousIsolationLevel;
        }

        public void setConnection(Connection connection) {
            this.connection = connection;
        }

    }
}