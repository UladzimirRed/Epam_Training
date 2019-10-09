package by.epam.training.parser;

import by.epam.training.entity.*;
import by.epam.training.exception.WrongFileException;
import by.epam.training.exception.XMLFileException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CandiesDomParser extends AbstractCandiesParser {
    private static final String CANDY = "candy";
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String ENERGY = "energy";
    private static final String KIND = "kind";
    private static final String TYPE = "type";
    private static final String STUFFED = "stuffed";
    private static final String INGREDIENT = "ingredient";
    private static final String UNIT = "unit";
    private static final String WATER = "water";
    private static final String SUGAR = "sugar";
    private static final String VANILLIN = "vanillin";
    private static final String ENERGY_VALUE = "energyValue";
    private static final String PROTEINS = "proteins";
    private static final String FATS = "fats";
    private static final String CARBOHYDRATES = "carbohydrates";
    private static final String PRODUCTION = "production";
    private static final String MANUFACTOR = "manufactor";
    private static final String COUNTRY = "country";
    private static final String FOUNDING_DATE = "foundingDate";
    private static final String DEFAULT_UNIT = "mg";

    private List<Candy> candies;
    private DocumentBuilder documentBuilder;

    public CandiesDomParser() throws XMLFileException {
        this.candies = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new XMLFileException(e);
        }
    }

    @Override
    public List<Candy> buildListCandies(String path) throws XMLFileException, WrongFileException {
        try {
            Document document = documentBuilder.parse(path);
            Element element = document.getDocumentElement();
            NodeList candiesList = element.getElementsByTagName(CANDY);
            for (int i = 0; i < candiesList.getLength(); i++) {
                Element candyElement = (Element) candiesList.item(i);
                Candy candy = parseCandy(candyElement);
                candies.add(candy);
            }
        } catch (SAXException | IOException e) {
            throw new XMLFileException(e);
        }
        return candies;
    }

    private Candy parseCandy(Element candyElement) {
        Candy candy = new Candy();
        candy.setId(candyElement.getAttribute(ID));
        candy.setTitle(getElementTextContent(candyElement, TITLE));
        int energy = Integer.parseInt(getElementTextContent(candyElement, ENERGY));
        candy.setEnergy(energy);

        CandyKind candyKind = new CandyKind();
        Element kindElement = (Element) candyElement.getElementsByTagName(KIND).item(0);
        candyKind.setType(KindsOfCandies.valueOf(getElementTextContent(kindElement, TYPE)));
        boolean isStuffed = Boolean.parseBoolean(getElementTextContent(kindElement, STUFFED));
        candyKind.setStuffed(isStuffed);
        candy.setKind(candyKind);

        Ingredient ingredient = new Ingredient();
        Element ingredientElement = (Element) candyElement.getElementsByTagName(INGREDIENT).item(0);
        if (ingredientElement.getAttribute(UNIT) != null) {
            ingredient.setUnit(ingredientElement.getAttribute(UNIT));
        } else {
            ingredient.setUnit(DEFAULT_UNIT);
        }
        double water = Double.parseDouble(getElementTextContent(ingredientElement, WATER));
        ingredient.setWater(water);
        double sugar = Double.parseDouble(getElementTextContent(ingredientElement, SUGAR));
        ingredient.setSugar(sugar);
        double vanillin = Double.parseDouble(getElementTextContent(ingredientElement, VANILLIN));
        ingredient.setVanillin(vanillin);
        candy.setIngredient(ingredient);

        EnergyValue energyValue = new EnergyValue();
        Element energyElement = (Element) candyElement.getElementsByTagName(ENERGY_VALUE).item(0);
        double proteins = Double.parseDouble(getElementTextContent(energyElement, PROTEINS));
        energyValue.setProteins(proteins);
        double fats = Double.parseDouble(getElementTextContent(energyElement, FATS));
        energyValue.setFats(fats);
        double carbohydrates = Double.parseDouble(getElementTextContent(energyElement, CARBOHYDRATES));
        energyValue.setCarbohydrates(carbohydrates);
        candy.setEnergyValue(energyValue);

        Production production = new Production();
        Element productionElement = (Element) candyElement.getElementsByTagName(PRODUCTION).item(0);
        production.setManufactor(getElementTextContent(productionElement, MANUFACTOR));
        production.setCountry(getElementTextContent(productionElement, COUNTRY));
        String dateString = getElementTextContent(candyElement, FOUNDING_DATE);
        production.setFoundingDate(LocalDateTime.parse(dateString.trim()));
        candy.setProduction(production);
        return candy;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String textContent = node.getTextContent();
        return textContent;
    }
}
