package by.epam.training.parser.impl;

import by.epam.training.entity.Candy;
import by.epam.training.handler.CandyHandler;
import by.epam.training.parser.XmlParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxParser implements XmlParser {
    private static final Logger logger = LogManager.getLogger(SAXParser.class);

    @Override
    public List<Candy> parseXml(String path) {
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = parserFactory.newSAXParser();
            CandyHandler handler = new CandyHandler();
            saxParser.parse(new FileInputStream(path), handler);
            List<Candy> candies = new ArrayList<>();
            for (Candy candy : handler.getCandyList()) {
                candies.add(candy);

            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
