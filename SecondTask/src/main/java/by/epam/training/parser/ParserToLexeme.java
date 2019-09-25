package by.epam.training.parser;

import by.epam.training.composite.ComponentType;
import by.epam.training.composite.TextComponent;
import by.epam.training.composite.TextComposite;

import java.util.regex.Pattern;


public class ParserToLexeme implements SourceParsable<String, TextComponent> {
    private static final String LEXEME_DIVIDER = "(?>\\s)";
    private static final String NOT_WORD = "(\\p{Punct}*?\\d+?\\p{Punct}*?)+?\\s*";
    private SourceParsable<String, TextComponent> nextParser = new ParserToWord();

    @Override
    public TextComponent parseText(String data) {
        String[] lexemes = data.split(LEXEME_DIVIDER);
        TextComponent textComponent = new TextComposite(ComponentType.LEXEME);
        Pattern pattern = Pattern.compile(NOT_WORD);
        for (String lexeme : lexemes) {
            textComponent.add(nextParser.parseText(lexeme));
        }
        return textComponent;
    }
}
