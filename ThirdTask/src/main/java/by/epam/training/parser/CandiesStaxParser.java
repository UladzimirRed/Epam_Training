package by.epam.training.parser;

import by.epam.training.entity.*;
import by.epam.training.exception.WrongFileException;
import by.epam.training.exception.XMLFileException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CandiesStaxParser extends AbstractCandiesParser {
    private List<Candy> candies = new ArrayList<>();
    private Candy candy = null;
    private CandyKind candyKind = null;
    private Ingredient ingredient = null;
    private EnergyValue energyValue = null;
    private Production production = null;
    private XMLInputFactory inputFactory;
    private String content = null;
    private static final String DEFAULT_UNIT = "mg";

    public CandiesStaxParser() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public List<Candy> getCandies() {
        return candies;
    }

    @Override
    public List<Candy> buildListCandies(String path) throws WrongFileException, XMLFileException {
        FileInputStream inputStream;
        XMLStreamReader reader;
        try {
            inputStream = new FileInputStream(new File(path));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        switch (reader.getLocalName()) {
                            case "candy":
                                candy = new Candy();
                                candy.setId(reader.getAttributeValue(0));
                                break;
                            case "ingredient":
                                ingredient = new Ingredient();
                                if (reader.getAttributeValue(0) != null) {
                                    ingredient.setUnit(reader.getAttributeValue(0));
                                } else {
                                    ingredient.setUnit(DEFAULT_UNIT);
                                }
                                break;
                            case "energyValue":
                                energyValue = new EnergyValue();
                                break;
                            case "production":
                                production = new Production();
                                break;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        content = reader.getText().trim();
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        switch (reader.getLocalName()) {
                            case "candy":
                                candies.add(candy);
                                break;
                            case "title":
                                candy.setTitle(content);
                                break;
                            case "energy":
                                candy.setEnergy(Integer.parseInt(content));
                                break;
                            case "type":
                                candyKind = new CandyKind();
                                candyKind.setType(KindsOfCandies.valueOf(content));
                                break;
                            case "stuffed":
                                candyKind.setStuffed(Boolean.parseBoolean(content));
                                candy.setKind(candyKind);
                                break;
                            case "water":
                                ingredient.setWater(Double.parseDouble(content));
                                break;
                            case "sugar":
                                ingredient.setSugar(Double.parseDouble(content));
                                break;
                            case "vanillin":
                                ingredient.setVanillin(Double.parseDouble(content));
                                candy.setIngredient(ingredient);
                                break;
                            case "proteins":
                                energyValue.setProteins(Double.parseDouble(content));
                                break;
                            case "fats":
                                energyValue.setFats(Double.parseDouble(content));
                                break;
                            case "carbohydrates":
                                energyValue.setCarbohydrates(Double.parseDouble(content));
                                candy.setEnergyValue(energyValue);
                                break;
                            case "manufactor":
                                production.setManufactor(content);
                                break;
                            case "country":
                                production.setCountry(content);
                                break;
                            case "foundingDate":
                                production.setFoundingDate(LocalDateTime.parse(content));
                                candy.setProduction(production);
                                break;
                        }
                        break;
                    case XMLStreamReader.START_DOCUMENT:
                        candies = new ArrayList<>();
                        break;
                }
            }

        } catch (XMLStreamException e) {
            throw new XMLFileException(e);
        } catch (FileNotFoundException e) {
            throw new WrongFileException(e);
        }
        return candies;
    }

}


