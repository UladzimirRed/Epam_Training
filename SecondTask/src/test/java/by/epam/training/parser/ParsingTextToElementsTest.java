package by.epam.training.parser;

import by.epam.training.composite.TextComponent;
import by.epam.training.composite.TextComposite;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParsingTextToElementsTest {
    private static TextParser parseToParagraph = ParserToParagraph.getInstance();
    private static TextParser parseToSentence = ParserToSentence.getInstance();
    private static TextParser parseToLexeme =ParserToLexeme.getInstance();
    private static TextParser parseToWordAndExpression = ParserToWordAndExpression.getInstance();
    private static TextParser parseToSymbol = ParserToSymbol.getInstance();
    private String wholeText;
    private String paragraph1;
    private String paragraph2;
    private String sentence1;
    private String sentence2;
    private String lexeme1;
    private String lexeme2;
    private String word1;
    private String word2;

    @BeforeClass
    public void initialiseParsingTextToElementsAction() {
        wholeText = "    It has survived - not only (five) centuries, but also "
                + "the leap into 13<<2 electronic typesetting, remaining 30>>>3"
                + " essentially ~6&9|(3&4) unchanged. It was popularised in the"
                + " 5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1) with the release of"
                + " Letraset sheets containing Lorem Ipsum passages, and more"
                + " recently with desktop publishing software like Aldus"
                + " PageMarker including versions of Lorem Ipsum.    It is a"
                + " long established fact that a reader will be distracted by"
                + " the readable content of a page when looking at its layout."
                + " The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 "
                + "Ipsum is that it has a more-or-less normal distribution of"
                + " letters, as opposed to using (Content here), content here',"
                + " making it look like readable English.    It is a"
                + " (8^5|1&2<<(2|5>>2&71))|1200 established fact that a reader"
                + " will be of a page when looking at its layout.    Bye.";
        paragraph1 = "It has survived - not only (five) centuries, but also "
                + "the leap into 13<<2 electronic typesetting, remaining 30>>>3"
                + " essentially ~6&9|(3&4) unchanged. It was popularised in the"
                + " 5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1) with the release of"
                + " Letraset sheets containing Lorem Ipsum passages, and more"
                + " recently with desktop publishing software like Aldus"
                + " PageMarker including versions of Lorem Ipsum.";
        paragraph2 = "It is a"
                + " long established fact that a reader will be distracted by"
                + " the readable content of a page when looking at its layout."
                + " The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 "
                + "Ipsum is that it has a more-or-less normal distribution of"
                + " letters, as opposed to using (Content here), content here',"
                + " making it look like readable English.";
        sentence1 = "It has survived - not only (five) centuries, but also "
                + "the leap into 13<<2 electronic typesetting, remaining 30>>>3"
                + " essentially ~6&9|(3&4) unchanged.";
        sentence2 = "It was popularised in the"
                + " 5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1) with the release of"
                + " Letraset sheets containing Lorem Ipsum passages, and more"
                + " recently with desktop publishing software like Aldus"
                + " PageMarker including versions of Lorem Ipsum.";
        lexeme1 = "(five)";
        lexeme2 = "centuries,";
        word1 = "electronic";
        word2 = "~6&9|(3&4)";
    }

    @DataProvider(name = "dataProviderForParseToParagraphAction")
    public Object[][] dataProviderForParseToParagraphAction() {
        return new Object[][] {{wholeText, 4}};
    }

    @Test(dataProvider = "dataProviderForParseToParagraphAction")
    public void parseToParagraphAction(String text, int numberOfParagraphs) {
        TextComposite composite = new TextComposite();
        TextComponent actual = parseToParagraph.parse(composite, text);
        int expected = numberOfParagraphs;
        Assert.assertEquals(actual.getComponents().size(), expected);
    }

    @DataProvider(name = "dataProviderForParseToSentenceAction")
    public Object[][] dataProviderForParseToSentenceAction() {
        return new Object[][]{{paragraph1, 2}, {paragraph2, 2}};
    }

    @Test (dataProvider = "dataProviderForParseToSentenceAction")
    public void parseToSentenceAction(String paragraph, int size) {
        TextComposite composite = new TextComposite();
        TextComponent actual = parseToSentence.parse(composite, paragraph);
        int expected = size;
        Assert.assertEquals(actual.getComponents().size(), expected);
    }

    @DataProvider(name = "dataProviderForParseToLexemeAction")
    public Object[][] dataProviderForParseToLexemeAction() {
        return new Object[][]{{sentence1, 21}, {sentence2, 31}};
    }

    @Test (dataProvider = "dataProviderForParseToLexemeAction")
    public void parseToLexemeAction(String sentence, int size) {
        TextComposite composite = new TextComposite();
        TextComponent actual = parseToLexeme.parse(composite, sentence);
        int expected = size;
        Assert.assertEquals(actual.getComponents().size(), expected);
    }

    @DataProvider(name = "dataProviderForParseToWordAndExpressionAction")
    public Object[][] dataProviderForParseToWordAndExpressionAction() {
        return new Object[][]{{lexeme1, 3}, {lexeme2, 2}};
    }

    @Test (dataProvider = "dataProviderForParseToWordAndExpressionAction")
    public void parseToWordAndExpressionAction(String lexeme, int size) {
        TextComposite composite = new TextComposite();
        TextComponent actual = parseToWordAndExpression.parse(composite, lexeme);
        int expected = size;
        Assert.assertEquals(actual.getComponents().size(), expected);
    }

    @DataProvider(name = "dataProviderForParseToSymbolAction")
    public Object[][] dataProviderForParseToSymbolAction() {
        return new Object[][]{{word1, 10}, {word2, 10}};
    }

    @Test (dataProvider = "dataProviderForParseToSymbolAction")
    public void parseToSymbolAction(String word, int size) {
        TextComposite composite = new TextComposite();
        TextComponent actual = parseToSymbol.parse(composite, word);
        int expected = size;
        Assert.assertEquals(actual.getComponents().size(), expected);
    }
}
