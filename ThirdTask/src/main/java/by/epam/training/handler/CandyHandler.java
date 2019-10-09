package by.epam.training.handler;

import by.epam.training.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CandyHandler extends DefaultHandler {
    private List<Candy> candyList = new ArrayList<>();
    private Candy candy = null;
    private Ingredient ingredient = null;
    private CandyKind candyKind = null;
    private EnergyValue energyValue = null;
    private Production production = null;
    private String content = null;
    private static final String ID = "id";
    private static final String UNIT = "unit";
    private static final String DEFAULT_UNIT = "mg";

    public List<Candy> getCandyList() {
        return candyList;
    }

    @Override
    public void startElement(String uri, String localMane, String qName, Attributes attributes) {
        switch (qName) {
            case "candy":
                candy = new Candy();
                candy.setId(attributes.getValue(ID));
                break;
            case "ingredient":
                ingredient = new Ingredient();
                if (attributes.getValue(UNIT) != null) {
                    ingredient.setUnit(attributes.getValue(UNIT));
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
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case "candy":
                candyList.add(candy);
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
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        content = String.copyValueOf(ch, start, length).trim();
    }

}
