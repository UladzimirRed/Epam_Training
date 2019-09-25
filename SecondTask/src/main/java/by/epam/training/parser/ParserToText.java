package by.epam.training.parser;

import by.epam.training.composite.ComponentType;
import by.epam.training.composite.TextComponent;
import by.epam.training.composite.TextComposite;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

    public class ParserToText implements SourceParsable<String,TextComponent> {
        private static Logger logger = LogManager.getLogger(ParserToText.class);
        private SourceParsable<String,TextComponent> nextParser = new ParserToParagraph();

        @Override
        public TextComponent parseText(String data) {
            logger.debug(data);
            TextComponent textDataComponent = new TextComposite(ComponentType.TEXT);
            textDataComponent.add(nextParser.parseText(data));
            logger.debug(textDataComponent);
            return textDataComponent;
        }
    }
