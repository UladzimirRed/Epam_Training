package by.epam.training.parser.factory;

import by.epam.training.exception.XMLFileException;
import by.epam.training.parser.AbstractCandiesParser;
import by.epam.training.parser.CandiesDomParser;
import by.epam.training.parser.CandiesSaxParser;
import by.epam.training.parser.CandiesStaxParser;

public class CandiesParserFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    public AbstractCandiesParser parseXML(String typeParser) throws XMLFileException {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new CandiesDomParser();
            case STAX:
                return new CandiesStaxParser();
            case SAX:
                return new CandiesSaxParser();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
