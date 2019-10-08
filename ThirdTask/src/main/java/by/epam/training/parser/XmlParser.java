package by.epam.training.parser;

import by.epam.training.entity.Candy;
import by.epam.training.exception.WrongFileException;
import by.epam.training.exception.XMLParseFileException;

import java.util.List;

public interface XmlParser {
    List<Candy> parseXml (String path) throws XMLParseFileException, WrongFileException;
}
