package by.epam.training.parser;

import by.epam.training.entity.Candy;
import by.epam.training.exception.WrongFileException;
import by.epam.training.exception.XMLFileException;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCandiesParser {
    private List<Candy> candies;

    public AbstractCandiesParser() {
        candies = new ArrayList<>();
    }

    public AbstractCandiesParser(List<Candy> candies) {
        this.candies = candies;
    }

    public List<Candy> getCandies() {
        return candies;
    }

    abstract public List<Candy> buildListCandies(String path) throws XMLFileException, WrongFileException, FileNotFoundException, XMLStreamException;
}
