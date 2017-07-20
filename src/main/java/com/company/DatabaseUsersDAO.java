package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-07-19.
 */
public class DatabaseUsersDAO implements UsersDAO {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    private DataBaseServer server;

    public DatabaseUsersDAO(DataBaseServer server) {
        this.server = server;
    }

    public void connect() throws SQLException {
        server.connect();
    }

    public List<User> get() {
        Statement statement1 = null;
        List<User> list = new ArrayList<User>();
        try {
            this.connect();
            statement1 = server.returnStatement();
            ResultSet resultSet = statement1.executeQuery("select * from users;");
            while (resultSet.next()) {
                int id = resultSet.getInt(resultSet.findColumn(ID));
                String name = resultSet.getString(resultSet.findColumn(NAME));
                String surname = resultSet.getString(resultSet.findColumn(SURNAME));

                list.add(new User(id, name, surname));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement1 != null) {
                try {
                    statement1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    public void add(User user) {
        Statement statement1 = null;
        try {
            this.connect();
            statement1 = server.returnStatement();

            statement1.executeUpdate("insert into users (name, surname) value" +
                    " (\"" + user.getName() + "\",\"" + user.getSurname() + "\");");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement1 != null) {
                try {
                    statement1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void update(User user) {
        Statement statement = null;
        try {
            statement = server.returnStatement();

            statement.executeUpdate("update users set name = \"" + user.getName() +
                    "\", surname = \"" + user.getSurname() + "\" where id = " + user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void delete(User user) {

        Statement statement1 = null;
        try {
            statement1 = server.returnStatement();

            statement1.executeUpdate("delete from users where id = " + user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement1 != null) {
                try {
                    statement1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

