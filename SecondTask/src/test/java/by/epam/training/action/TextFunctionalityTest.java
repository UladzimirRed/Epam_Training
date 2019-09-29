package by.epam.training.action;

import by.epam.training.composite.TextComposite;
import by.epam.training.exception.DataReaderException;
import by.epam.training.parser.TextParser;
import by.epam.training.reader.DataReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class TextFunctionalityTest {

    private DataReader reader;
    private TextParser parser;
    private TextComposite textDataComponent;
    private TextFunctionality analyzer;
    private String expected;

    @BeforeMethod
    public void setUp() throws Exception {
        reader = new DataReader();
        parser = new TextParser();
        textDataComponent = parser.parseText(reader.readTextFromFile("/testData/testData.txt"));
        analyzer = new TextFunctionality();
        expected = reader.readTextFromFile("/testData/testData.txt");
    }

    @AfterMethod
    public void tearDown() {
        reader = null;
        parser = null;
        textDataComponent = null;
        analyzer = null;

    }

    @Test
    public void sortParagraphsBySentenceLengthTest() throws DataReaderException {
        TextComposite actual = createComponent();
        analyzer.sortParagraphsBySentenceQuantity(actual);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void sortSentencesByNumberOfWordsTest() throws DataReaderException {
        TextComposite actual = createComponent();
        analyzer.sortSentencesByNumberOfWords(actual);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void sortWordsBySize() throws DataReaderException {
        TextComposite actual = createComponent();
        analyzer.sortWordsBySize(actual);
        Assert.assertNotEquals(expected, actual);
    }

    private TextComposite createComponent() throws DataReaderException {
        return parser.parseText(reader.readTextFromFile("/testData/testData.txt"));
    }
}
