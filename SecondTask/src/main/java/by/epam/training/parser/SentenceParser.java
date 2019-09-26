package by.epam.training.parser;

import by.epam.training.composite.ComponentType;
import by.epam.training.composite.TextComponent;
import by.epam.training.composite.TextComposite;


public class SentenceParser implements SourceParsable<String, TextComponent> {
    private static final String LEXEME_DIVIDER = "(?>\\s)";
    private SourceParsable<String, TextComponent> nextParser = new LexemeParser();

    @Override
    public TextComposite parseText(String data) {
        String[] lexemes = data.split(LEXEME_DIVIDER);
        TextComposite textComponent = new TextComposite(ComponentType.SENTENCE);
        for (String lexeme : lexemes) {
            textComponent.add(nextParser.parseText(lexeme.trim()));
        }
        return textComponent;
    }
}
