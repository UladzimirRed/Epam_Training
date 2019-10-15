package by.epam.training.util.parser;

public class TruckStringParser {
    private static final String DELIMITER = ",\\s*";

    public String[] parseLine(String line) {
        String[] arrayOfData = line.split(DELIMITER);
        return arrayOfData;
    }
}
