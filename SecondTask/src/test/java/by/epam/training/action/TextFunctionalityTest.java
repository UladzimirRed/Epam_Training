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
    private static final char SYMBOL = 'e';
    private DataReader reader;
    private TextParser parser;
    private TextComposite textDataComponent;
    private static Logger logger;
    private TextFunctionality analyzer;
    private String expected;

    @BeforeMethod
    public void setUp() throws Exception {
        logger = LogManager.getLogger(TextFunctionalityTest.class);
        reader = new DataReader();
        parser = new TextParser();
        textDataComponent = (TextComposite) parser.parseText(reader.readTextFromFile("/testData/testData.txt"));
        analyzer = new TextFunctionality();
        expected = reader.readTextFromFile("/testData/testData.txt");
    }

    @AfterMethod
    public void tearDown() {
        reader = null;
        parser = null;
        textDataComponent = null;
        analyzer = null;
        logger = null;

    }

    @Test
    public void sortParagraphsBySentenceLengthTest() throws DataReaderException {
        TextComposite actual = createComponent();
        analyzer.sortParagraphsBySentenceQuantity(actual);
        System.out.println(expected);
        System.out.println();
        System.out.println(actual);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void sortedSentencesByLexemesSizeTest() {
        String actual = analyzer.sortSentencesByLexemeSize(textDataComponent);
        logger.info("Actual sort lexemes in sentence by length was successful");
        logger.debug("Source text:" + expected);
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void sortSentencesByNumberOfWordsTest() throws DataReaderException {
        TextComposite actual = createComponent();
        analyzer.sortSentencesByNumberOfWords(actual);

        System.out.println(expected);
        System.out.println();
        System.out.println(actual);
        Assert.assertNotEquals(expected, actual);
    }

    private TextComposite createComponent() throws DataReaderException {
        return parser.parseText(reader.readTextFromFile("/testData/testData.txt"));
    }

    @Test
    public void sortLexemesBySymbolQuantityInTextBySentencesTest() {
        String actual = analyzer.sortLexemesInSentencesBySymbolQuantity(textDataComponent, SYMBOL);
        logger.info("Actual sort lexemes in sentences by symbol " + SYMBOL + " appearance was successful" );
        logger.debug("Source text:" + expected);
        Assert.assertNotEquals(actual, expected);
    }

//   @Test
//   public void showSortedLexemesBySymbolQuantityInTextTest() {
//       String actual = analyzer.showTextLexemesSortedBySymbolQuantityThenAlphabetically(textDataComponent, SYMBOL);
//       logger.info("Actual sort text lexemes by symbol " + SYMBOL + " appearance: " + actual);
//       logger.debug("Source text:" + expected);
//       Assert.assertNotEquals(actual, expected);
//   }
}
