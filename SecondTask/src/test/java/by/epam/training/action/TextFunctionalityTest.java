package by.epam.training.action;

import by.epam.training.composite.TextComposite;
import by.epam.training.parser.ParserToParagraph;
import by.epam.training.reader.DataReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class TextFunctionalityTest {
    private static final char SYMBOL = 'e';
    private DataReader reader;
    private ParserToParagraph parser;
    private TextComposite textDataComponent;
    private static Logger logger;
    private TextFunctionality analyzer;
    private String expected;

    @BeforeMethod
    public void setUp() throws Exception {
        logger = LogManager.getLogger(TextFunctionalityTest.class);
        reader = new DataReader();
        parser = new ParserToParagraph();
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
    public void showSortedParagraphsBySentenceLengthTest() {
        String actual = analyzer.showSortedParagraphsBySentenceLength(textDataComponent);
        logger.info("sort paragraphs by sentence quantity was successful" );
        logger.debug("Source text:" + expected);
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void showSortedSentencesByLexemesSizeTest() {
        String actual = analyzer.showSortedSentencesByLexemeSize(textDataComponent);
        logger.info("Actual sort lexemes in sentence by length was successful");
        logger.debug("Source text:" + expected);
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void showSortedSentencesByWordSizeTest() {
        String actual = analyzer.showSortedSentencesByWordSize(textDataComponent);
        logger.info("Actual sort words in sentence by length was successful");
        logger.debug("Source text:" + expected);
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void showSortedLexemesBySymbolQuantityInTextBySentencesTest() {
        String actual = analyzer.showSortedLexemesInSentencesBySymbolQuantity(textDataComponent, SYMBOL);
        logger.info("Actual sort lexemes in sentences by symbol " + SYMBOL + " appearance was successful" );
        logger.debug("Source text:" + expected);
        Assert.assertNotEquals(actual, expected);
    }

//    @Test
//    public void showSortedLexemesBySymbolQuantityInTextTest() {
//        String actual = analyzer.showTextLexemesSortedBySymbolQuantityThenAlphabetically(textDataComponent, SYMBOL);
//        logger.info("Actual sort text lexemes by symbol " + SYMBOL + " appearance: " + actual);
//        logger.debug("Source text:" + expected);
//        Assert.assertNotEquals(actual, expected);
//    }
}
