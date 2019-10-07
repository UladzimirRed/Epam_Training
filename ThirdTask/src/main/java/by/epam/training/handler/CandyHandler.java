package by.epam.training.handler;

import by.epam.training.entity.Candy;
import by.epam.training.entity.Ingredients;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class CandyHandler extends DefaultHandler {
    private static final Logger logger = LogManager.getLogger(CandyHandler.class);
    private List<Candy> candyList = new ArrayList<>();
    private Candy candy;
    private Ingredients ingredient = null;

    public List<Candy> getCandyList() {
        return candyList;
    }

    @Override
    public void startDocument() {
        logger.info("Sax parsing started");
    }

}
