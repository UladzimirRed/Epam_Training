package by.epam.training.parser;

import by.epam.training.composite.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser implements SourceParsable<String, TextComponent> {

    private static Logger logger = LogManager.getLogger(WordParser.class);

    @Override
    public TextComposite parseText(String data) {
        TextComposite textDataComponent = new TextComposite(ComponentType.WORD);
        char[] chars = data.toCharArray();
        for (char element : chars) {
            textDataComponent.add(new TextElement(ElementType.TEXT, element));
        }
        logger.debug(textDataComponent);
        return textDataComponent;
    }
}
