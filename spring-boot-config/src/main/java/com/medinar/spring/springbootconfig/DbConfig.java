package com.medinar.spring.springbootconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author rommelmedina
 */
@ConfigurationProperties("db")
@Configuration
public class DbConfig {

    private String connection;
    private String host;
    private int port;

    public DbConfig() {
    }

    public DbConfig(String connection, String host, int port) {
        this.connection = connection;
        this.host = host;
        this.port = port;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "DbConfig{" + "connection=" + connection + ", host=" + host + ", port=" + port + '}';
    }

}
