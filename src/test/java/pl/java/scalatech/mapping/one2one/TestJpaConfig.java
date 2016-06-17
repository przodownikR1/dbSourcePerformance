package pl.java.scalatech.mapping.one2one;

import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import pl.java.scalatech.config.JpaLoggerConfig;
import pl.java.scalatech.config.hikari.HikariCPConfiguration;

@Configuration
@EnableJpaRepositories(basePackages = {"pl.java.scalatech.repository.mapping"})
@EntityScan(basePackages = {"pl.java.scalatech.domain.one2one"})
@PropertySource(value = "classpath:application.properties")
@Import({ DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class, PersistenceExceptionTranslationAutoConfiguration.class,
        PropertyPlaceholderAutoConfiguration.class ,HikariCPConfiguration.class,JpaLoggerConfig.class})
@Profile("one2one")
public class TestJpaConfig {

}
