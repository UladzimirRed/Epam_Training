package by.epam.training.parser;

import by.epam.training.composite.ComponentType;
import by.epam.training.composite.TextComponent;
import by.epam.training.composite.TextComposite;

public class ParserToLexeme extends TextParser {
    private static final ParserToLexeme INSTANCE = new ParserToLexeme();

    public static ParserToLexeme getInstance() {
        return INSTANCE;
    }

    public ParserToLexeme() {
        setTextParser(ParserToWordAndExpression.getInstance());
    }

    @Override
    public TextComponent parse(TextComponent currentTextComponent, String text) {
        String[] array = text.split("\\s+");
        for (int i = 0; i < array.length; i++) {
            TextComposite lexeme = new TextComposite(ComponentType.LEXEME);
            currentTextComponent.add(getTextParser().parse(lexeme, array[i]), ComponentType.LEXEME);
        }
        return currentTextComponent;
    }
}
