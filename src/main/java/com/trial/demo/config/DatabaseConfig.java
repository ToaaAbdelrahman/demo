package com.trial.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {
    @Value("${spring.flyway.url}")
    private String jdbcUrl;
    @Value("${spring.flyway.user}")
    private String username;
    @Value("${spring.flyway.password}")
    private String password;

    @Bean
    @FlywayDataSource
    @ConfigurationProperties(prefix = "spring.flyway.datasource")
    HikariDataSource flywayDataSource() {
        HikariDataSource dataSource = DataSourceBuilder.create().type(HikariDataSource.class).build();
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
}
