package by.epam.training.parser;

import by.epam.training.exception.XMLParseFileException;

import java.util.List;

public interface Parser {
    List parse (String path) throws XMLParseFileException;
}
