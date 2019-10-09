package by.epam.training.parser;

import by.epam.training.exception.WrongFileException;
import by.epam.training.exception.XMLFileException;
import org.testng.annotations.Test;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class CandiesStaxParserTest {
    public CandiesStaxParser staxParser = new CandiesStaxParser();

    List<String> paths = Arrays.asList("src\\test\\resources\\candies.xml",
            "src\\test\\resources\\emptyFile.xml",
            "src\\test\\resources\\wrongCandies.xml",
            "wrongPath.xml");

    @Test
    public void parse() throws WrongFileException, XMLFileException {
        staxParser.buildListCandies(paths.get(0)).forEach(System.out::println);
    }

    @Test(expectedExceptions = XMLFileException.class)
    public void parseEmptyFile() throws WrongFileException, XMLFileException {
        staxParser.buildListCandies(paths.get(1));
    }

    @Test(expectedExceptions = XMLFileException.class)
    public void parseWrongFile() throws WrongFileException, XMLFileException {
        staxParser.buildListCandies(paths.get(2));
    }

    @Test(expectedExceptions = WrongFileException.class)
    public void parseWrongPath() throws WrongFileException, XMLFileException {
        staxParser.buildListCandies(paths.get(3));
    }
}
