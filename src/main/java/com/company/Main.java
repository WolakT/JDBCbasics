package com.company;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        String dbUser = "intellij";
        String dbPassword = "pass123";

        DataBaseServer server = new DataBaseServer("localhost", "javadb", "intellij", "pass123");

        try {
            server.connect();
            Statement statement1 = server.returnStatement();
            ResultSet resultSet = statement1.executeQuery("select * from users;");
            while (resultSet.next()) {
                int id = resultSet.getInt(resultSet.findColumn("id"));
                String name = resultSet.getString(resultSet.findColumn("name"));
                String surname = resultSet.getString(resultSet.findColumn("surname"));
                System.out.println(id + " " + name + " " + surname);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        /*try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost/javadb?" +
                    "user=" + dbUser + "&password=" + dbPassword);

            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()){
                int id = resultSet.getInt(resultSet.findColumn("id"));
                String name = resultSet.getString(resultSet.findColumn("name"));
                String surname = resultSet.getString(resultSet.findColumn("surname"));
                System.out.println(id + " " + name + " " + surname );

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }*/
    }
}
