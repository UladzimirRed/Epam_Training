package by.epam.training.parser;

import by.epam.training.composite.*;

import java.util.List;

public class LexemeParser implements SourceParsable<String, TextComponent> {
    private static final String PUNCT = "\\p{Punct}+";
    private SourceParsable<String, TextComponent> nextParser = new WordParser();

    @Override
    public TextComposite parseText(String data) {
        List<String> words = TextFromPunctSplitter.splitTextFromPuncts(data);
        TextComposite textDataComponent = new TextComposite(ComponentType.LEXEME);
        for (String word : words) {
            if (word.matches(PUNCT)) {
                textDataComponent.add(new TextElement(ElementType.PUNCT, word.charAt(0)));
            } else {
                textDataComponent.add(nextParser.parseText(word.trim()));
            }

        }
        return textDataComponent;
    }
}
