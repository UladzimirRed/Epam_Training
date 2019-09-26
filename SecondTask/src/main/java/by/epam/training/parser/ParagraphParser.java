package by.epam.training.parser;

import by.epam.training.composite.ComponentType;
import by.epam.training.composite.TextComponent;
import by.epam.training.composite.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ParagraphParser implements SourceParsable<String, TextComponent> {
    private static final String SENTENCE_REG = "(?<=[.?!…])";
    private static Logger logger = LogManager.getLogger(ParagraphParser.class);
    private SourceParsable<String, TextComponent> nextParser = new SentenceParser();

    @Override
    public TextComposite parseText(String data) {
        String[] sentences = data.split(SENTENCE_REG);
        TextComposite textDataComponent = new TextComposite(ComponentType.PARAGRAPH);
        for (String sentence : sentences) {
            logger.debug(sentence);
            textDataComponent.add(nextParser.parseText(sentence));
        }
        logger.debug(textDataComponent);
        return textDataComponent;
    }
}
