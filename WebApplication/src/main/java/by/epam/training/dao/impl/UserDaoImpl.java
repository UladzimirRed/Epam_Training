package by.epam.training.dao.impl;

import by.epam.training.connection.ConnectionPool;
import by.epam.training.connection.ProxyConnection;
import by.epam.training.dao.UserDao;
import by.epam.training.entity.User;
import by.epam.training.exception.ConnectionPoolException;
import by.epam.training.exception.DaoException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final ConnectionPool pool;
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
    private static final String SQL_SELECT_USER_BY_LASTNAME = "SELECT id, password FROM profiles WHERE login=?";
    private static final String SQL_SELECT_ALL_USERS = "SELECT id,  login, password FROM profiles";
    private static final String SQL_CHECK_USER_MATCHES =
            "SELECT login, password FROM profiles WHERE login =? AND password = ?";
    private static final String SQL_FIND_USER_BY_LOGIN = "SELECT id, login, password, role FROM profiles WHERE login = ?";


    public UserDaoImpl() {
        pool = ConnectionPool.INSTANCE;
    }

    public User login(User user) throws DaoException {
        ProxyConnection connection = null;
        try {
            connection = pool.takeConnection();
            String login = user.getLogin();
            String password = user.getPassword();
            if (userMatches(login, password)){
                return findUserByLogin(connection, login);
            }else {
                return null;
            }
        }finally {
            pool.releaseConnection(connection);
        }
    }

    public boolean userMatches(String login, String password) throws DaoException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        ProxyConnection connection = null;
        try {
            connection = pool.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_CHECK_USER_MATCHES);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    private User findUserByLogin(ProxyConnection connection, String login) throws DaoException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return createUserFromQueryResult(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new DaoException();
        }finally {
            close(preparedStatement);
            pool.releaseConnection(connection);
        }
    }

    private User createUserFromQueryResult(ResultSet resultSet) throws DaoException {
        try {
            return new User(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

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
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
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
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
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
