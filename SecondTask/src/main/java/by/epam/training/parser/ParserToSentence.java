package by.epam.training.parser;

import by.epam.training.composite.ComponentType;
import by.epam.training.composite.TextComponent;
import by.epam.training.composite.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserToSentence extends TextParser {
    private static final String REGULAR_EXPRESSION = ".*?([!?]|[.]+)";
    private Pattern pattern = Pattern.compile(REGULAR_EXPRESSION);
    private static ParserToSentence INSTANCE = new ParserToSentence();

    public static ParserToSentence getInstance() {
        return INSTANCE;
    }

    private ParserToSentence() {
        setTextParser(ParserToLexeme.getInstance());
    }

    @Override
    public TextComponent parse(TextComponent currentTextComponent, String text) {
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            TextComposite sentence = new TextComposite(ComponentType.SENTENCE);
            currentTextComponent.add(getTextParser().parse(sentence, matcher.group()), ComponentType.SENTENCE);
        }
        return currentTextComponent;
    }
}
