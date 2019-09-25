package by.epam.training.xxx;

import by.epam.training.action.TextFunctionality;
import by.epam.training.reader.DataReader;

public class Main {
    public static void main(String[] args) throws Exception {
        DataReader reader = new DataReader();
        String text = reader.readTextFromFile("/data/data.txt");
        System.out.println(text);
        TextFunctionality textFunctionality = new TextFunctionality();
    }
}
