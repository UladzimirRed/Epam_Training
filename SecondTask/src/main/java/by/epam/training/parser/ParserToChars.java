package by.epam.training.parser;

import by.epam.training.composite.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserToChars implements SourceParsable<String, TextComponent> {
    private static final String PUNCT = "\\p{Punct}+";
    private static Logger logger = LogManager.getLogger(ParserToChars.class);


    @Override
    public TextComponent parseText(String data) {
        TextComponent textDataComponent = new TextComposite(ComponentType.CHAR);
        char[] chars = data.toCharArray();
        for (char element : chars
        ) {
            textDataComponent.add(new TextElement(ElementType.TEXT, element));
        }
        Pattern patternPunctuation = Pattern.compile(PUNCT);

        for (TextComponent textComponent : textDataComponent.selectList()
        ) {
            Matcher matcherPunct = patternPunctuation.matcher(textComponent.toString());
            while (matcherPunct.find()) {
                TextElement element = (TextElement) textComponent;
                element.setElementType(ElementType.PUNCT);
                textComponent = element;
            }
            logger.debug(textComponent.toString() + " " + ((TextElement) textComponent).getElementType());
        }
        logger.debug(textDataComponent);
        return textDataComponent;
    }
}
