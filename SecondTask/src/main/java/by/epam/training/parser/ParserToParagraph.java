package by.epam.training.parser;

import by.epam.training.composite.ComponentType;
import by.epam.training.composite.TextComponent;
import by.epam.training.composite.TextComposite;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ParserToParagraph implements SourceParsable<String,TextComponent> {
    private static Logger logger = LogManager.getLogger(ParserToParagraph.class);
    private static final String PARAGRAPH_REGEX = "(?=\\s{4}.*)";
    private SourceParsable<String,TextComponent> nextParser = new ParserToSentence();

    @Override
    public TextComponent parseText(String data) {
        logger.debug(data);
        String[] paragraphs = data.split(PARAGRAPH_REGEX);
        TextComponent textDataComponent = new TextComposite(ComponentType.PARAGRAPH);
        for (String paragraph : paragraphs
        ) {
            logger.debug(paragraph);
            textDataComponent.add(nextParser.parseText(paragraph));
        }
        logger.debug(textDataComponent);
        return textDataComponent;
    }
}
