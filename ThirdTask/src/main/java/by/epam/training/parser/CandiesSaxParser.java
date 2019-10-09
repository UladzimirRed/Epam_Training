package by.epam.training.parser;

import by.epam.training.entity.Candy;
import by.epam.training.exception.WrongFileException;
import by.epam.training.exception.XMLFileException;
import by.epam.training.handler.CandyHandler;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CandiesSaxParser extends AbstractCandiesParser {
    private static List<Candy> candies = new ArrayList<>();

    @Override
    public List<Candy> buildListCandies(String path) throws XMLFileException, WrongFileException {
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = parserFactory.newSAXParser();
            CandyHandler handler = new CandyHandler();
            saxParser.parse(new FileInputStream(path), handler);

            for (Candy candy : handler.getCandyList()) {
                candies.add(candy);
            }
        } catch (SAXException | ParserConfigurationException e) {
            throw new XMLFileException(e);
        } catch (IOException e) {
            throw new WrongFileException(e);
        }
        return candies;
    }
}
