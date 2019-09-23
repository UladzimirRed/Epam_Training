package by.epam.training.parser;

import by.epam.training.composite.ComponentType;
import by.epam.training.composite.TextComponent;
import by.epam.training.composite.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserToWordAndExpression extends TextParser {
    private static final String REGULAR_EXPRESSION = "([A-Za-z]+)|([\\d&~|^<>()]+)|\\W";
    private static final String BIT_REGULAR_EXPRESSION = "([\\d&~|^<>()][\\d&~|^<>()]+)";
    private Pattern pattern = Pattern.compile(REGULAR_EXPRESSION);
    private Pattern bitPattern = Pattern.compile(BIT_REGULAR_EXPRESSION);
    private static final ParserToWordAndExpression INSTANCE = new ParserToWordAndExpression();

    public static ParserToWordAndExpression getInstance() {
        return INSTANCE;
    }

    private ParserToWordAndExpression() {
        setTextParser(ParserToSymbol.getInstance());
    }

    @Override
    public TextComponent parse(TextComponent currentTextComponent, String text) {
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            Matcher matcher1 = bitPattern.matcher(matcher.group());
            if (matcher1.find() && matcher1.group().length() >= 2) {
                TextComposite wordAndExpression = new TextComposite(ComponentType.EXPRESSION);
            } else {
                TextComposite wordAndExpression = new TextComposite(ComponentType.WORD);
                currentTextComponent.add(getTextParser().parse(wordAndExpression, matcher.group()), ComponentType.WORD);
            }
        }
        return currentTextComponent;
    }
}
