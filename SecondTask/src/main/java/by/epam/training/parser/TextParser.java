package by.epam.training.parser;

import by.epam.training.composite.*;

public class TextParser implements SourceParsable<String, TextComponent> {
    private static final String PARAGRAPH_REGEX = "\\r\\n";
    private SourceParsable<String, TextComponent> nextParser = new ParagraphParser();

    @Override
    public TextComposite parseText(String data) {
        String[] paragraphs = data.split(PARAGRAPH_REGEX);
        TextComposite textDataComponent = new TextComposite(ComponentType.TEXT);
        for (String paragraph : paragraphs) {
            textDataComponent.add(nextParser.parseText(paragraph.trim()));
        }
        return textDataComponent;
    }
}
