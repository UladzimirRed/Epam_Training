package by.epam.training.parser;

import by.epam.training.composite.TextComponent;

public abstract class TextParser {
    public TextParser textParser;

    public TextParser getTextParser() {
        return textParser;
    }

    public void setTextParser(TextParser currentParser) {
        this.textParser = currentParser;
    }

    public abstract TextComponent parse(TextComponent currentTextComponent, String text);
}
