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
package pl.java.scalatech.config.hikari;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Profile( "dev" )
@Configuration
@Slf4j
@EnableConfigurationProperties( HikariCPConfig.class )
@EnableMetrics(proxyTargetClass = true)
public class HikariCPConfiguration {

    @Autowired
    private MetricRegistry metricRegistry;

    @Autowired
    public HikariCPConfig hikariCPConfig;

    @Value( "${spring.datasource.url}" )
    public String url;

    @Value( "${spring.datasource.username}" )
    public String username;

    @Value( "${spring.datasource.password}" )
    public String password;

    //@Value( "${spring.datasource.driver-class-name  ?: org.h2.Driver}" )
    public String driverClassName = "org.h2.Driver";




    @Bean(name="hikariDataSource",destroyMethod="close")
    public DataSource hikariDataSource() {
        log.info( "configure hikariCP config" );
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName( driverClassName );
      // dataSource.setDataSourceProperties( hikariCPConfig.getHikariDatasource() );
        dataSource.setUsername( username );
        dataSource.setPassword( password );
        dataSource.setJdbcUrl( url );
        dataSource.addDataSourceProperty("dataSource.cachePrepStmts", "true");
        dataSource.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
        dataSource.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
        dataSource.addDataSourceProperty("dataSource.useServerPrepStmts", "true");
        dataSource.setMaximumPoolSize(80);
        dataSource.setConnectionTimeout(2000);
        dataSource.setMinimumIdle(30);
        dataSource.setMetricRegistry(metricRegistry);
        dataSource.setConnectionTestQuery("SELECT 1;");

        return dataSource;
    }

}