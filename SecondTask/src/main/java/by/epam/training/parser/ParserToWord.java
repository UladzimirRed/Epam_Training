package by.epam.training.parser;

import by.epam.training.composite.ComponentType;
import by.epam.training.composite.TextComponent;
import by.epam.training.composite.TextComposite;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class ParserToWord implements SourceParsable<String, TextComponent> {
    private static Logger logger = LogManager.getLogger(ParserToWord.class);
    private SourceParsable<String, TextComponent> nextParser = new ParserToChars();

    @Override
    public TextComponent parseText(String data) {
        List<String> words = TextFromPunctSplitter.splitTextFromPuncts(data);
        logger.debug((words));
        TextComponent textDataComponent = new TextComposite(ComponentType.WORD);
        for (String word : words) {
            textDataComponent.add(nextParser.parseText(word));
        }
        logger.debug(textDataComponent);
        return textDataComponent;
    }
}
