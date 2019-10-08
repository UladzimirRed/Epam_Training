package by.epam.training.parser.impl;

import by.epam.training.entity.Candy;
import by.epam.training.exception.WrongFileException;
import by.epam.training.exception.XMLParseFileException;
import by.epam.training.handler.CandyHandler;
import by.epam.training.parser.XmlParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxParser implements XmlParser {
    private static final Logger logger = LogManager.getLogger(SAXParser.class);
    private static List<Candy> candies = new ArrayList<>();
    @Override
    public List<Candy> parseXml(String path) throws XMLParseFileException, WrongFileException {
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = parserFactory.newSAXParser();
            CandyHandler handler = new CandyHandler();
            saxParser.parse(new FileInputStream(path), handler);

            for (Candy candy : handler.getCandyList()) {
                candies.add(candy);
            }
        } catch (SAXException | ParserConfigurationException e) {
            throw new XMLParseFileException(e);
        } catch (IOException e) {
            throw new WrongFileException(e);
        }
        return candies;
    }
}
