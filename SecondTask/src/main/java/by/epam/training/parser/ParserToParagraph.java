package by.epam.training.parser;

import by.epam.training.composite.ComponentType;
import by.epam.training.composite.TextComponent;
import by.epam.training.composite.TextComposite;

public class ParserToParagraph extends TextParser {
    private static final String REGULAR_EXPRESSION = "\\s{4}+";
    private static final ParserToParagraph INSTANCE = new ParserToParagraph();

    public static ParserToParagraph getInstance() {
        return INSTANCE;
    }

    private ParserToParagraph() {
        setTextParser(ParserToSentence.getInstance());
    }

    @Override
    public TextComponent parse(TextComponent currentTextComponent, String text) {
        String[] sentences = text.split(REGULAR_EXPRESSION);
        for (int i = 1; i < sentences.length; i++) {
            TextComposite paragraph = new TextComposite(ComponentType.PARAGRAPH);
            currentTextComponent.add(getTextParser().parse(paragraph, sentences[i]), ComponentType.PARAGRAPH);
        }
        return currentTextComponent;
    }
}
