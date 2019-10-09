package by.epam.training.parser;

import by.epam.training.exception.WrongFileException;
import by.epam.training.exception.XMLFileException;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CandiesDomParserTest {
    public CandiesDomParser domParser = new CandiesDomParser();

    public CandiesDomParserTest() throws XMLFileException {
    }

    List<String> paths = Arrays.asList("src\\test\\resources\\candies.xml",
            "src\\test\\resources\\emptyFile.xml",
            "src\\test\\resources\\wrongCandies.xml",
            "wrongPath.xml");

    @Test
    public void parse() throws WrongFileException, XMLFileException {
        domParser.buildListCandies(paths.get(0)).forEach(System.out::println);
    }

    @Test(expectedExceptions = XMLFileException.class)
    public void parseEmptyFile() throws XMLFileException, WrongFileException {
        domParser.buildListCandies(paths.get(1));
    }

    @Test(expectedExceptions = XMLFileException.class)
    public void parseWrongFile() throws WrongFileException, XMLFileException {
        domParser.buildListCandies(paths.get(2));
    }

    @Test(expectedExceptions = XMLFileException.class)
    public void parseWrongPath() throws XMLFileException, WrongFileException {
        domParser.buildListCandies(paths.get(3));
    }

}
