package by.epam.training.resource;

import java.util.ResourceBundle;

public class MessageManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.messages");

    public MessageManager() {
    }

    public static String getProperty(String key){
        return resourceBundle.getString(key);
    }
}
