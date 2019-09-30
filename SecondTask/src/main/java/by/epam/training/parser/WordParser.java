package by.epam.training.parser;

import by.epam.training.composite.*;

public class WordParser implements SourceParsable<String, TextComponent> {

    @Override
    public TextComposite parseText(String data) {
        TextComposite textDataComponent = new TextComposite(ComponentType.WORD);
        char[] chars = data.toCharArray();
        for (char element : chars) {
            textDataComponent.add(new TextElement(ElementType.TEXT, element));
        }
        return textDataComponent;
    }
}
