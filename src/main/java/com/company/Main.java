package com.company;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.List;

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

        DatabaseUsersDAO dao = new DatabaseUsersDAO( server);
        dao.add(new User(0,"Janusz", "Iksinski"));
        List<User> list = dao.get();
        for (User user : list) {
            System.out.println(user);
        }


    }
}
