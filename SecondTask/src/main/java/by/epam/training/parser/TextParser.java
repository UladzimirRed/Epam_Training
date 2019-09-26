package by.epam.training.parser;

import by.epam.training.composite.ComponentType;
import by.epam.training.composite.TextComponent;
import by.epam.training.composite.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TextParser implements SourceParsable<String, TextComponent> {
    private static Logger logger = LogManager.getLogger(TextParser.class);
    private static final String PARAGRAPH_REGEX = "\\r\\n";
    private SourceParsable<String, TextComponent> nextParser = new ParagraphParser();

    @Override
    public TextComposite parseText(String data) {
        logger.debug(data);
        String[] paragraphs = data.split(PARAGRAPH_REGEX);
        TextComposite textDataComponent = new TextComposite(ComponentType.TEXT);
        for (String paragraph : paragraphs) {
            logger.debug(paragraph);
            textDataComponent.add(nextParser.parseText(paragraph));
        }
        logger.debug(textDataComponent);
        return textDataComponent;
    }
}
