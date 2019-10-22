package by.epam.training.dao;

import by.epam.training.entity.Entity;
import by.epam.training.exception.DaoException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseDao<K, T extends Entity> {
    Logger logger = LogManager.getLogger(BaseDao.class);

    List<T> findAll() throws DaoException;

    boolean delete(T t) throws DaoException;

    boolean create(T t) throws DaoException;

    T update(T t) throws DaoException;


    default void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Couldn't close statement: " + e.getMessage());
        }
    }


    default void close(Connection connection) {
        try {
            if (connection != null){
                //FIXME return connection to pool
                connection.close();
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Couldn't close connection: " + e.getMessage());
        }
    }
}
