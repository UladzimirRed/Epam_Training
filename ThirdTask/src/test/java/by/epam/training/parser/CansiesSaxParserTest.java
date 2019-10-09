package by.epam.training.parser;

import by.epam.training.exception.WrongFileException;
import by.epam.training.exception.XMLFileException;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CansiesSaxParserTest {

    public CandiesSaxParser saxParser = new CandiesSaxParser();

    List<String> paths = Arrays.asList("src\\test\\resources\\candies.xml",
            "src\\test\\resources\\emptyFile.xml",
            "src\\test\\resources\\wrongCandies.xml",
            "wrongPath.xml");

    @Test
    public void parseIdeal() throws WrongFileException, XMLFileException {
        saxParser.buildListCandies(paths.get(0)).forEach(System.out::println);
    }

    @Test(expectedExceptions = XMLFileException.class)
    public void parseEmptyFile() throws WrongFileException, XMLFileException {
        saxParser.buildListCandies(paths.get(1));
    }

    @Test(expectedExceptions = XMLFileException.class)
    public void parseWrongFile() throws WrongFileException, XMLFileException {
        saxParser.buildListCandies(paths.get(2));
    }

    @Test(expectedExceptions = WrongFileException.class)
    public void parseWrongPath() throws WrongFileException, XMLFileException {
        saxParser.buildListCandies(paths.get(3));
    }
}
