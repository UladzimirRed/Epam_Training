package by.epam.training.dao;

import by.epam.training.entity.Entity;
import by.epam.training.exception.DaoException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseDao<T extends Entity> {
    Logger logger = LogManager.getLogger(BaseDao.class);

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
