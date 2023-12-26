package com.example.liquibasedemo.Util;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

public class Utils {



    public static HikariConfig getDbConfig(String url, String username, String password, String driverClassName) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driverClassName);

        System.out.println("Config is: "+config);

        return config;
    }



}
