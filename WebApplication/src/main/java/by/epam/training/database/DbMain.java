package by.epam.training.database;

import by.epam.training.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DbMain {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/courier_exchange_db";
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "1256");
        properties.put("autoReconnect", "true");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useUnicode", "true");
        properties.put("useSSL", "false");
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM profiles WHERE login = 'admin' AND password = 'admin'";
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();

//            resultSet.moveToInsertRow();
//            resultSet.updateInt(1, 3);
//            resultSet.updateString(2, "Meleshkevich");
//            resultSet.updateInt(3, 256000502);
//            resultSet.insertRow();
//            resultSet.moveToCurrentRow();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String login = resultSet.getString(2);
                String password = resultSet.getString(3);
                int role = resultSet.getInt(4);
                users.add(new User(id, login, password, role));
            }
            System.out.println(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
