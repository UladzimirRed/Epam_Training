package by.epam.training.action;

import by.epam.training.composite.ComponentType;
import by.epam.training.composite.TextComponent;
import by.epam.training.parser.TextFromPunctSplitter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;


public class TextFunctionality {
    private static Logger logger = LogManager.getLogger(TextFunctionality.class);

    public String showSortedParagraphsBySentenceLength(TextComponent component) {
        return component.selectList().stream()
                .sorted((o1, o2) -> o2.selectList().size() - o1.selectList().size())
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    public String showSortedSentencesByLexemeSize(TextComponent component) {
        StringBuffer stringBuffer = new StringBuffer();
        if (component.checkType().equals(ComponentType.LEXEME)) {
            return component.selectList().stream()
                    .map(TextComponent::toString)
                    .sorted((o1, o2) -> o2.length() - o1.length())
                    .collect(Collectors.joining(" "));
        } else {
            for (int i = 0; i < component.selectList().size(); i++) {
                stringBuffer.append(showSortedSentencesByLexemeSize(component.getChild(i)));
            }
        }
        return stringBuffer.toString();
    }

    public String showSortedSentencesByWordSize(TextComponent component) {
        StringBuffer stringBuffer = new StringBuffer();
        if (component.checkType().equals(ComponentType.LEXEME)) {
            ArrayList<TextComponent> temp = new ArrayList<>(component.selectList());
            ArrayList<String> sentenceByWordsTemp = new ArrayList<>();
            for (TextComponent lexeme : temp
            ) {
                sentenceByWordsTemp.addAll(TextFromPunctSplitter.splitTextFromPuncts(lexeme.toString()));
            }
            sentenceByWordsTemp.sort((o1, o2) -> o2.length() - o1.length());
            return sentenceByWordsTemp.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" "));
        } else {
            for (int i = 0; i < component.selectList().size(); i++) {
                stringBuffer.append(showSortedSentencesByWordSize(component.getChild(i)));
            }
        }
        return stringBuffer.toString();
    }

    private int countSymbolAppearance(TextComponent lexeme, char symbol) {
        return lexeme.selectList().stream()
                .mapToInt(word -> (int) word.selectList()
                        .stream()
                        .filter(leaf -> leaf.toString().charAt(0) == (symbol))
                        .count())
                .sum();
    }

    public String showSortedLexemesInSentencesBySymbolQuantity(TextComponent component, char symbol) {
        StringBuffer stringBuffer = new StringBuffer();
        if (component.checkType().equals(ComponentType.LEXEME)) {
            ArrayList<TextComponent> temp = new ArrayList<>(component.selectList());
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
            for (int i = 0; i < component.selectList().size(); i++) {

                stringBuffer.append(showSortedLexemesInSentencesBySymbolQuantity(component.getChild(i), symbol));
            }
        }
        return stringBuffer.toString();
    }

}
