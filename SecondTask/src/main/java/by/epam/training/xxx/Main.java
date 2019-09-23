package by.epam.training.xxx;

import by.epam.training.reader.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader();
        String text = reader.readTextFromFile("/data/data.txt");
        System.out.println(text);
        System.out.println();
    }
}
