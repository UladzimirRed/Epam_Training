package by.epam.training.parser.impl;

import by.epam.training.entity.*;
import by.epam.training.exception.XMLParseFileException;
import by.epam.training.parser.XmlParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.geom.Arc2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements XmlParser {
    private List<Candy> candies;
    private DocumentBuilder documentBuilder;

    public DomParser() throws XMLParseFileException {
        this.candies = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new XMLParseFileException(e);
        }
    }

    @Override
    public List<Candy> parseXml(String path) throws XMLParseFileException {
        try {
            Document document = documentBuilder.parse(path);
            Element element = document.getDocumentElement();
            NodeList candiesList = element.getElementsByTagName("candy");
            for (int i = 0; i < candiesList.getLength(); i++) {
                Element candyElement = (Element) candiesList.item(i);
                Candy candy = parseCandy(candyElement);
                candies.add(candy);
            }
        } catch (SAXException | IOException e) {
            throw new XMLParseFileException(e);
        }
        return candies;
    }

    private Candy parseCandy(Element candyElement) {
        Candy candy = new Candy();
        candy.setId(candyElement.getAttribute("id"));
        candy.setTitle(getElementTextContent(candyElement, "title"));
        Integer energy = Integer.parseInt(getElementTextContent(candyElement, "energy"));
        candy.setEnergy(energy);

//        CandyKind candyKind = new CandyKind();
//        Element kindElement = (Element) candyElement.getElementsByTagName("kind");
//        // FIXME ENUMERATION
//        boolean isStuffed = Boolean.parseBoolean(getElementTextContent(kindElement, "stuffed"));
//        candyKind.setStuffed(isStuffed);
//        candy.setKind(candyKind);

        Ingredient ingredient = new Ingredient();
        Element ingredientElement = (Element) candyElement.getElementsByTagName("ingredient").item(0);
        Double water = Double.parseDouble(getElementTextContent(ingredientElement, "water"));
        ingredient.setWater(water);
        Double sugar = Double.parseDouble(getElementTextContent(ingredientElement, "sugar"));
        ingredient.setSugar(sugar);
        Double vanillin = Double.parseDouble(getElementTextContent(ingredientElement, "vanillin"));
        ingredient.setVanillin(vanillin);
        candy.setIngredient(ingredient);

        EnergyValue energyValue = new EnergyValue();
        Element energyElement = (Element) candyElement.getElementsByTagName("energyValue").item(0);
        Double proteins = Double.parseDouble(getElementTextContent(energyElement, "proteins"));
        energyValue.setProteins(proteins);
        Double fats = Double.parseDouble(getElementTextContent(energyElement, "fats"));
        energyValue.setFats(fats);
        Double carbohydrates = Double.parseDouble(getElementTextContent(energyElement, "carbohydrates"));
        energyValue.setCarbohydrates(carbohydrates);
        candy.setEnergyValue(energyValue);

        Production production = new Production();
        Element productionElement = (Element) candyElement.getElementsByTagName("production").item(0);
        production.setManufactor(getElementTextContent(productionElement, "manufactor"));
        production.setCountry(getElementTextContent(productionElement, "country"));
        // FIXME FOUNDING DATE
//        production.setFoundingDate(getElementTextContent(productionElement, "foundingDate"));
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
