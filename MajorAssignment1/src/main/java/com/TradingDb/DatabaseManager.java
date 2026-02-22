package com.TradingDb;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {
    private static HikariDataSource hikariDataSource;

    //all threads will share same database connection to prevent them creating new connection ever time
    static {
        HikariConfig config=new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/trading_engine");
        config.setUsername("postgres");
        config.setPassword("postgres");

        config.setMaximumPoolSize(20);
        config.setMinimumIdle(5);
        hikariDataSource=new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return hikariDataSource.getConnection();
    }

    public static void  closePool(){
        if(hikariDataSource!=null){
            hikariDataSource.close();
        }
    }
}
