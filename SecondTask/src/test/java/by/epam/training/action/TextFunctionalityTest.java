package by.epam.training.action;

import by.epam.training.composite.TextComposite;
import by.epam.training.parser.TextParser;
import by.epam.training.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.*;

public class TextFunctionalityTest {
    private static final String TEST_PATH = "/testData/testData.txt";
    private TextComposite textDataComponent;
    private TextFunctionality analyzer;

    @BeforeMethod
    public void setUp() throws Exception {
        DataReader reader = new DataReader();
        TextParser parser = new TextParser();
        textDataComponent = parser.parseText(reader.readTextFromFile(TEST_PATH));
        analyzer = new TextFunctionality();
    }

    @Test
    public void sortParagraphsBySentenceQuantityTest() {
        TextComposite actual = analyzer.sortParagraphsBySentenceQuantity(textDataComponent);
        String expected = "    It is a (4^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page when looking at its layout! \n" +
                "    Bye. \n" +
                "    It has survived - not only (five) centuries, but also the leap into 13<<2 electronic typesetting, remaining 3>>5 essentially ~6&9|(3&4) unchanged… It was popularised in the 5|(1&2&(3|(4&(8^5|6&47)|3)|2)|1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. \n" +
                "    It is a long established. Fact that a reader will. Be distracted by the readable content of a page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English? \n";
        Assert.assertEquals(actual.toString(), expected);
    }

    @Test
    public void sortSentencesByNumberOfWordsTest() {
        TextComposite actual = analyzer.sortSentencesByNumberOfWords(textDataComponent);
        String expected = "    It has survived - not only (five) centuries, but also the leap into 13<<2 electronic typesetting, remaining 3>>5 essentially ~6&9|(3&4) unchanged… It was popularised in the 5|(1&2&(3|(4&(8^5|6&47)|3)|2)|1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. \n" +
                "    It is a long established. Fact that a reader will. Be distracted by the readable content of a page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English? \n" +
                "    It is a (4^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page when looking at its layout! \n" +
                "    Bye. \n";
        Assert.assertEquals(actual.toString(), expected);
    }

    @Test
    public void sortLexemesByOccurrenceOfSymbolAndThenAlphabeticTest() {
        TextComposite actual = analyzer.sortLexemesByOccurrenceOfSymbolAndThenAlphabetic(textDataComponent, 'e');
        String expected = "    centuries, electronic essentially typesetting, (five) leap remaining survived the unchanged… - 13<<2 3>>5 It also but has into not only ~6&9|(3&4) release Letraset PageMaker recently sheets Lorem Lorem desktop like more passages, popularised software the the versions 5|(1&2&(3|(4&(8^5|6&47)|3)|2)|1) Aldus Ipsum Ipsum. It and containing in including of of publishing was with with \n" +
                "    established. It a is long reader Fact a that will. readable Be content distracted page the when a at by its layout. looking of here', here), letters, more-or-less readable (Content The content like opposed (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 English? Ipsum a as distribution has is it it look making normal of of point that to using using \n" +
                "    established reader be page when (4^5|1&2<<(2|5>>2&71))|1200 It a a a at fact is its layout! looking of that will \n" +
                "    Bye. \n";
        Assert.assertEquals(actual.toString(), expected);
    }
}
