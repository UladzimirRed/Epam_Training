package by.epam.training.parser.impl;

import by.epam.training.director.Director;
import by.epam.training.exception.XMLParseFileException;
import by.epam.training.parser.Parser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class JaxbParser implements Parser {
    private static final Logger logger = LogManager.getLogger(Director.class);


    @Override
    public List parse(String path) throws XMLParseFileException {
        return null;
    }
}
