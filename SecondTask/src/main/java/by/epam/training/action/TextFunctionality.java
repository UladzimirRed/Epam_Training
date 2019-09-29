package by.epam.training.action;

import by.epam.training.composite.ComponentType;
import by.epam.training.composite.TextComponent;
import by.epam.training.composite.TextComposite;
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

    public void sortWordsBySize(TextComponent component) {
        if (component.getType().equals(ComponentType.SENTENCE)) {
            component.getComponents().sort(
                    Comparator.comparing(lexeme -> lexeme.getComponents().stream()
                            .filter(element -> element instanceof TextComposite)
                            .findFirst().toString().length()));
            return;
        }
        List<TextComponent> children = component.getComponents();
        if (children != null && !children.isEmpty()) {
            for (TextComponent child : children) {
                sortWordsBySize(child);
            }
        }
    }

}
