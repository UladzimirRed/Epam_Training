package by.epam.training.action;

import by.epam.training.composite.ComponentType;
import by.epam.training.composite.TextComponent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;


public class TextFunctionality {
    private static Logger logger = LogManager.getLogger(TextFunctionality.class);

    public void sortParagraphsBySentenceQuantity(TextComponent component) {
        if (component.getType().equals(ComponentType.TEXT)) {
            component.getComponents().sort(Comparator.comparingInt(o -> o.getComponents().size()));
            return;
        }
        List<TextComponent> children = component.getComponents();
        if (children != null && !children.isEmpty()) {
            for (TextComponent child : children) {
                sortParagraphsBySentenceQuantity(child);
            }
        }
    }

    public String sortSentencesByLexemeSize(TextComponent component) {
        StringBuffer stringBuffer = new StringBuffer();
        if (component.getType().equals(ComponentType.LEXEME)) {
            return component.getComponents().stream()
                    .map(TextComponent::toString)
                    .sorted((o1, o2) -> o2.length() - o1.length())
                    .collect(Collectors.joining(" "));
        } else {
            for (int i = 0; i < component.getComponents().size(); i++) {
                stringBuffer.append(sortSentencesByLexemeSize(component.getChild(i)));
            }
        }
        return stringBuffer.toString();
    }

    public void sortSentencesByNumberOfWords(TextComponent component) {
        if (component.getType().equals(ComponentType.PARAGRAPH)) {
            component.getComponents().sort(Comparator.comparing(sentence -> sentence.getComponents().size()));
            return;
        }
        List<TextComponent> children = component.getComponents();
        if (children != null && !children.isEmpty()) {
            for (TextComponent child : children) {
                sortSentencesByNumberOfWords(child);
            }
        }
    }

    private int countSymbolAppearance(TextComponent lexeme, char symbol) {
        return lexeme.getComponents().stream()
                .mapToInt(word -> (int) word.getComponents()
                        .stream()
                        .filter(leaf -> leaf.toString().charAt(0) == (symbol))
                        .count())
                .sum();
    }

    public String sortLexemesInSentencesBySymbolQuantity(TextComponent component, char symbol) {
        StringBuffer stringBuffer = new StringBuffer();
        if (component.getType().equals(ComponentType.LEXEME)) {
            ArrayList<TextComponent> temp = new ArrayList<>(component.getComponents());
            logger.debug(temp);
            for (int i = 0; i < temp.size(); i++) {
                TextComponent lexeme = temp.get(i);
                int k = countSymbolAppearance(lexeme, symbol);
                Comparator<TextComponent> comparator;
                comparator = Comparator.comparing(comp -> k - TextFunctionality.this.countSymbolAppearance(comp, symbol));
                comparator = comparator.thenComparing(Object::toString);
                temp.sort(comparator);
            }
            logger.debug(temp);
            return temp.stream()
                    .map(TextComponent::toString)
                    .collect(Collectors.joining(" "));
        } else {
            for (int i = 0; i < component.getComponents().size(); i++) {

                stringBuffer.append(sortLexemesInSentencesBySymbolQuantity(component.getChild(i), symbol));
            }
        }
        return stringBuffer.toString();
    }

}
