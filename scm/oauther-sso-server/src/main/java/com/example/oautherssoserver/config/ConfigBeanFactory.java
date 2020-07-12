package com.example.oautherssoserver.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

/**
 * @author sleepwalker
 */
public class ConfigBeanFactory {

    public DataSource dataSource(){
        return new HikariDataSource(hikariConfig());
    }

    public HikariConfig hikariConfig(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setConnectionTestQuery("SELECT 1");
        hikariConfig.setMinimumIdle(1);
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/sleepwalker?serverTimezone=GMT%2B8");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("123456");
        hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
        return hikariConfig;
    }

}
