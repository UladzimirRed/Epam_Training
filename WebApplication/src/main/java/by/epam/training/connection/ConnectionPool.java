package by.epam.training.connection;

import by.epam.training.exception.ConnectionPoolException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public enum ConnectionPool {
    INSTANCE;

    private static Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static String url;
    private static String user;
    private static String password;
    private BlockingQueue<ProxyConnection> freeConnections;
    private Queue<ProxyConnection> givenAwayConnections;
    private final static int DEFAULT_POOL_SIZE = 32;

    ConnectionPool() {
        register();
        initDatabase();
        initPool();

    }

    private void register() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            logger.fatal("Couldn't register driver" + e);
            throw new RuntimeException("Couldn't register driver", e);
        }
    }

    private void initDatabase() {
        ResourceBundle bundle = ResourceBundle.getBundle("/resources/database/database");
        url = bundle.getString("database.url");
        user = bundle.getString("database.user");
        password = bundle.getString("database.password");
    }

    private void initPool() {
        freeConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        givenAwayConnections = new ArrayDeque<>();
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++){
            try {
                createConnection();
            } catch (ConnectionPoolException e) {
                logger.log(Level.ERROR, e);   //TODO WHAT CAN I DO?
            }
        }
        if (freeConnections.isEmpty()){
            logger.fatal("Couldn't init connection pool");
            throw new RuntimeException("Couldn't init connection pool");
        }
        if (freeConnections.size() == DEFAULT_POOL_SIZE) {
            logger.log(Level.INFO, "Successfully initialized connection pool");
        }
    }

    private void createConnection() throws ConnectionPoolException {
        try {
            ProxyConnection connection = new ProxyConnection(DriverManager.getConnection(url, user, password));
            freeConnections.add(connection);
        } catch (SQLException e) {
            throw new ConnectionPoolException("Couldn't create connection", e);
        }
    }


    public ProxyConnection takeConnection() {
        ProxyConnection connection = null;
        try {
            connection = freeConnections.take();
            givenAwayConnections.offer(connection);
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, e);
        }
        return connection;
    }


    public void releaseConnection(Connection connection) {
        givenAwayConnections.remove(connection);
        freeConnections.offer((ProxyConnection) connection);
    }

    public void destroyPool() throws ConnectionPoolException {
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnections.take().reallyClose();
            } catch (InterruptedException e) {
                logger.log(Level.ERROR, e);
            }
            deregisterDrivers();
        }
    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.error("Couldn't deregister driver", e);
            }
        });


    }
}
