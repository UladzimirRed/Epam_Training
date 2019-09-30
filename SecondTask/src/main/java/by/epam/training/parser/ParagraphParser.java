package by.epam.training.parser;

import by.epam.training.composite.*;

public class ParagraphParser implements SourceParsable<String, TextComponent> {
    private static final String SENTENCE_REG = "(?<=[.?!…])";
    private SourceParsable<String, TextComponent> nextParser = new SentenceParser();

    @Override
    public TextComposite parseText(String data) {
        String[] sentences = data.split(SENTENCE_REG);
        TextComposite textDataComponent = new TextComposite(ComponentType.PARAGRAPH);
        for (String sentence : sentences) {
            textDataComponent.add(nextParser.parseText(sentence.trim()));
        }
        return textDataComponent;
    }
}
