package com.lysenko.airlines.model;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {
    private static final String PROPERTIES_PATH = "/pool_conf.properties";
    private static ConnectionPool instance;

    private final BasicDataSource dataSource = new BasicDataSource();

    private ConnectionPool() {
        try {
            Properties properties = new Properties();
            properties.load(ConnectionPool.class.getResourceAsStream(PROPERTIES_PATH));
            dataSource.setDriverClassName(properties.getProperty("db.driver"));
            dataSource.setUrl(properties.getProperty("db.url"));
            dataSource.setUsername(properties.getProperty("db.user"));
            dataSource.setPassword(properties.getProperty("db.password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

