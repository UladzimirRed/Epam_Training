package by.epam.training.dao.impl;

import by.epam.training.dao.UserDao;
import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
    private static final String SQL_SELECT_USER_BY_LASTNAME = "SELECT id, phone FROM users WHERE lastName=?";
    private static final String SQL_SELECT_ALL_USERS = "SELECT id, phone, lastName FROM users";

    @Override
    public List<User> findUserByLastName(String namePattern) throws DaoException {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_database", "root", "1256");
            statement = connection.prepareStatement(SQL_SELECT_USER_BY_LASTNAME);
            statement.setString(1, namePattern);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("lastName"));
                user.setPhone(resultSet.getInt("phone"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return users;
    }

    @Override
    public List<User> findAll() throws DaoException {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_database", "root", "1256");
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("lastName"));
                user.setPhone(resultSet.getInt("phone"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
        return users;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public User update(User user) {
        return null;
    }
}
