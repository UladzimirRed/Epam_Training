package by.epam.training.parser;

import by.epam.training.composite.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LexemeParser implements SourceParsable<String, TextComponent> {
    private static Logger logger = LogManager.getLogger(LexemeParser.class);
    private static final String PUNCT = "\\p{Punct}+";
    private SourceParsable<String, TextComponent> nextParser = new WordParser();

    @Override
    public TextComposite parseText(String data) {
        List<String> words = TextFromPunctSplitter.splitTextFromPuncts(data);
        logger.debug((words));
        TextComposite textDataComponent = new TextComposite(ComponentType.LEXEME);
        for (String word : words) {
            if (word.matches(PUNCT)) {
                textDataComponent.add(new TextElement(ElementType.PUNCT, word.charAt(0)));
            } else {
                textDataComponent.add(nextParser.parseText(word.trim()));
            }

        }

        logger.debug(textDataComponent);
        return textDataComponent;
    }
}
