package ru.dz.lessons.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created on 10.09.2014.
 */
@Configuration
@PropertySource(value = "classpath:activity-database.properties", ignoreResourceNotFound = true)
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() throws PropertyVetoException, URISyntaxException {
        String username, password, dbUrl, driverClassName;
        username = "postgres";
        password = "postgres";
        dbUrl = "jdbc:postgresql://localhost:5432/todos";
        driverClassName = "org.postgresql.Driver";
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClassName);
        dataSource.setJdbcUrl(dbUrl);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}