package by.epam.training.parser;

import by.epam.training.composite.ComponentType;
import by.epam.training.composite.TextComponent;
import by.epam.training.composite.TextComposite;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ParserToSentence implements SourceParsable<String,TextComponent> {
    private static final String SENTENCE_REG = "(?<=[.?!…])";
    private static Logger logger = LogManager.getLogger(ParserToSentence.class);
    private SourceParsable<String,TextComponent> nextParser = new ParserToLexeme();

    @Override
    public TextComponent parseText(String data) {
        String[] sentences = data.split(SENTENCE_REG);
        TextComponent textDataComponent = new TextComposite(ComponentType.SENTENCE);
        for (String sentence : sentences
        ) {
            logger.debug(sentence);
            textDataComponent.add(nextParser.parseText(sentence));
        }
        logger.debug(textDataComponent);
        return textDataComponent;
    }
}
