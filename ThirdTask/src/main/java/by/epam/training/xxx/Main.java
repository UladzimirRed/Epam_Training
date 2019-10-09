package by.epam.training.xxx;

import by.epam.training.entity.Candy;
import by.epam.training.exception.WrongFileException;
import by.epam.training.exception.XMLFileException;
import by.epam.training.parser.CandiesDomParser;
import by.epam.training.parser.CandiesSaxParser;
import by.epam.training.parser.CandiesStaxParser;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws XMLFileException, FileNotFoundException, WrongFileException, XMLStreamException {
        CandiesStaxParser candiesStaxParser = new CandiesStaxParser();
        CandiesDomParser candiesDomParser = new CandiesDomParser();
        CandiesSaxParser candiesSaxParser = new CandiesSaxParser();

        List<Candy> candies;
        candies = candiesSaxParser.buildListCandies("D:\\Java\\IdeaProjects\\EpamTraining\\ThirdTask\\src\\main\\resources\\data\\candies.xml");
        for (int i = 0; i < candies.size(); i++){
            System.out.println(candies.get(i));
        }

    }
}
