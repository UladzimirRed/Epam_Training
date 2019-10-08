package by.epam.training;

import by.epam.training.entity.Candy;
import by.epam.training.exception.WrongFileException;
import by.epam.training.exception.XMLParseFileException;
import by.epam.training.parser.impl.DomParser;
import by.epam.training.parser.impl.SaxParser;
import by.epam.training.parser.impl.StaxParser;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws XMLParseFileException, FileNotFoundException, WrongFileException, XMLStreamException {
        StaxParser staxParser = new StaxParser();
        DomParser domParser = new DomParser();
        SaxParser saxParser = new SaxParser();

        List<Candy> candies;
        candies = staxParser.parseXml("D:\\Java\\IdeaProjects\\EpamTraining\\ThirdTask\\src\\main\\resources\\data\\candies.xml");
        for (int i = 0; i < candies.size(); i++){
            System.out.println(candies.get(i));
        }

    }
}
