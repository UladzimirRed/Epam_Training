package by.epam.training.resource;

import java.util.ResourceBundle;

public class ConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.config");

    public ConfigurationManager() {
    }

    public static String getProperty(String key){
        return resourceBundle.getString(key);
    }
}
