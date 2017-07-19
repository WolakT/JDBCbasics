package com.company;

import java.sql.*;

/**
 * Created by RENT on 2017-07-19.
 */
public class DataBaseServer {
    private String address;
    private String database;
    private String user;
    private String password;
    private Connection connection;

    public DataBaseServer(String address, String database, String user, String password) {
        this.address = address;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://" + address + "/" + database + "?" +
                "user=" + user + "&password=" + password);

    }
    public Statement returnStatement() throws SQLException {
        if(connection == null) {
            throw new IllegalStateException("Call connect() first!");
        }

        return connection.createStatement();
    }
    public void close() {
        if (connection != null) try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
