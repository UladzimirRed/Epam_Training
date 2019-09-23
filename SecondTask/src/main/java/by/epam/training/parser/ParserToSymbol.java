package by.epam.training.parser;

import by.epam.training.composite.ComponentType;
import by.epam.training.composite.TextComponent;
import by.epam.training.composite.TextElement;

public class ParserToSymbol extends TextParser {
    private static final ParserToSymbol INSTANCE = new ParserToSymbol();

    public static ParserToSymbol getInstance() {
        return INSTANCE;
    }

    @Override
    public TextComponent parse(TextComponent currentTextComponent, String text) {
        for (int i = 0; i < text.length(); i++) {
            currentTextComponent.add(new TextElement(text.charAt(i)), ComponentType.SYMBOL);
        }
        return currentTextComponent;
    }
}
