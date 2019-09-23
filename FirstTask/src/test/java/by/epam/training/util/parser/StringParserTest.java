package by.epam.training.util.parser;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class StringParserTest {

    @Test
    public void parseLineIntoArrayOfValues() {
        String testLine = "2, 3; 4, 5";
        double[] expectedValues = {2, 4, 3, 5};
        double[] actualValues = StringParser.parseLineIntoArrayOfValues(testLine);
        Assert.assertTrue(Arrays.equals(expectedValues, actualValues));
    }
}
