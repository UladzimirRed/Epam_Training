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
        String url = "jdbc:mysql://localhost:3306/project_database";
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "1256");
        properties.put("autoReconnect", "true");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useUnicode", "true");
        properties.put("useSSL", "false");
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT id, lastName, phone FROM users";
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
                String name = resultSet.getString(2);
                int number = resultSet.getInt(3);
                users.add(new User(id, name, number));
            }
            System.out.println(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
