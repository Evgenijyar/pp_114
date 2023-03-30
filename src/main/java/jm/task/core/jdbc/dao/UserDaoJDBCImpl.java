package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        Util util = new Util();
        Connection connection = util.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Users (Id BIGINT AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(20), LastName VARCHAR(20), Age TINYINT);");
        } catch (SQLException e) {
        }
        try {
            connection.close();
        } catch (SQLException e) {
        }
    }

    public void dropUsersTable() {
        Util util = new Util();
        Connection connection = util.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Users");
        } catch (SQLException e) {
        }
        try {
            connection.close();
        } catch (SQLException e) {
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Util util = new Util();
        Connection connection = util.getConnection();
        try {
            Statement statement = connection.createStatement();
            StringBuilder s = new StringBuilder("INSERT Users(Name, LastName, Age) VALUES ('");
            s.append(name);
            s.append("', '");
            s.append(lastName);
            s.append("', ");
            s.append(age);
            s.append(");");
            statement.executeUpdate(s.toString());
        } catch (SQLException e) {
        }
        try {
            connection.close();
        } catch (SQLException e) {
        }
    }

    public void removeUserById(long id) {
        Util util = new Util();
        Connection connection = util.getConnection();
        try {
            Statement statement = connection.createStatement();
            StringBuilder s = new StringBuilder("DELETE FROM Users WHERE Id=");
            s.append(id);
            s.append(";");
            statement.executeUpdate(s.toString());
        } catch (SQLException e) {
        }
        try {
            connection.close();
        } catch (SQLException e) {
        }
    }


    public List<User> getAllUsers() {
        Util util = new Util();
        Connection connection = util.getConnection();

        List<User> userList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("Id"));
                user.setName(resultSet.getString("Name"));
                user.setLastName(resultSet.getString("LastName"));
                user.setAge(resultSet.getByte("Age"));
                userList.add(user);
            }
        } catch (SQLException e) {
        }
        try {
            connection.close();
        } catch (SQLException e) {
        }

        return userList;
    }

    public void cleanUsersTable() {
        Util util = new Util();
        Connection connection = util.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Users");
        } catch (SQLException e) {
        }
        try {
            connection.close();
        } catch (SQLException e) {
        }
    }
}
