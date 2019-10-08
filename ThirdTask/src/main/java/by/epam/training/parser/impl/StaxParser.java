package by.epam.training.parser.impl;

import by.epam.training.entity.*;
import by.epam.training.exception.WrongFileException;
import by.epam.training.exception.XMLParseFileException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StaxParser {
    private List<Candy> candies = new ArrayList<>();
    private Candy candy = null;
    private CandyKind candyKind = null;
    private Ingredient ingredient = null;
    private EnergyValue energyValue = null;
    private Production production = null;
    private XMLInputFactory inputFactory;
    private String content = null;

    public StaxParser() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public List<Candy> getCandies() {
        return candies;
    }

    public List<Candy> parseXml(String path) throws XMLParseFileException, WrongFileException, FileNotFoundException, XMLStreamException {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;

        inputStream = new FileInputStream(new File(path));
        reader = inputFactory.createXMLStreamReader(inputStream);
        while (reader.hasNext()) {
//                int event = reader.next();
//                if (event == XMLStreamConstants.START_ELEMENT) {
//                    name = reader.getLocalName();
//                    if (KindsOfCandies.valueOf(name.toUpperCase()) == KindsOfCandies.CHOCOLATE) {
//                        Candy candy = buildCandies(reader);
//                        candies.add(candy);
//                    }
//                }
//            }
//        } catch (FileNotFoundException e) {
//            throw new WrongFileException(e);
//        } catch (XMLStreamException e) {
//            throw new XMLParseFileException(e);
//        } finally {
//            try {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//            } catch (IOException e) {
//                throw new WrongFileException(e);
//            }
//        }
//    }
//
//    private Candy buildCandies(XMLStreamReader reader) throws XMLStreamException {
//        while (reader.hasNext()) {
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
                        case "type":
                            candyKind = new CandyKind();
//                            candyKind.setType(KindsOfCandies.valueOf(content));
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
                            Calendar calendar = Calendar.getInstance();
                            String[] strings = content.split("-");
                            calendar.set(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), Integer.parseInt(strings[2]));
                            production.setFoundingDate(calendar);
                            candy.setProduction(production);
                            break;
                    }

                    break;
                case XMLStreamReader.START_DOCUMENT:
                    candies = new ArrayList<>();
                    break;
            }

        }

        return candies;
    }
}


