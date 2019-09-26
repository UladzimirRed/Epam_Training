package by.epam.training.reader;

import by.epam.training.exception.DataReaderException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataReaderTest {
    private static DataReader dataReader = new DataReader();
    private String expectedText;

    @BeforeClass
    public void initialiseReadingAction() {
        expectedText = "    It has survived - not only (five) centuries, but also the leap into 13<<2 electronic typesetting, remaining 3>>5 essentially ~6&9|(3&4) unchanged… It was popularised in the 5|(1&2&(3|(4&(8^5|6&47)|3)|2)|1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\r\n" +
                "    It is a long established. Fact that a reader will. Be distracted by the readable content of a page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English?\r\n" +
                "    It is a (4^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page when looking at its layout!\r\n" +
                "    Bye.";
    }

    @Test
    public void readTextFromFileTest() throws DataReaderException {
        String pathToFile = "/testData/testData.txt";
        String actualText = dataReader.readTextFromFile(pathToFile);
        Assert.assertEquals(actualText, expectedText);

    }
}
