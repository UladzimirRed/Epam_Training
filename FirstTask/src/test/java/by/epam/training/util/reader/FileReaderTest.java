package by.epam.training.util.reader;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class FileReaderTest {

    @Test
    public void readTest() throws Exception {
        FileReader fileReader = new FileReader();
        List<String> expectedStringList = Collections.singletonList("-56.66,0; 2,3");
        String pathToFile = "/testData/testData.txt";
        List<String> actualStringList = fileReader.read(pathToFile);
        Assert.assertEquals(actualStringList.get(0), expectedStringList.get(0));
    }
}
