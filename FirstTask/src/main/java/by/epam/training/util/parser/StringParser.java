package by.epam.training.util.parser;

import by.epam.training.util.reader.FileReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class StringParser {
    private static final Logger logger = LogManager.getLogger(FileReader.class);
    private static final String POINT_DELIMITER = ";\\s*";
    private static final String COORDINATE_DELIMITER = ",\\s*";

    public static double[] parseLineIntoArrayOfValues(String line) {
        String[] points = line.split(POINT_DELIMITER);

        String[] point1 = points[0].split(COORDINATE_DELIMITER);
        String[] point2 = points[1].split(COORDINATE_DELIMITER);

        double coordinateX1 = Double.parseDouble(point1[0]);
        double coordinateY1 = Double.parseDouble(point1[1]);
        double coordinateX2 = Double.parseDouble(point2[0]);
        double coordinateY2 = Double.parseDouble(point2[1]);

        return new double[]{coordinateX1, coordinateX2, coordinateY1, coordinateY2};
    }
}
