package by.epam.training.util;

import by.epam.training.composite.TextComponent;

import java.util.Comparator;

public class LexemeComparator implements Comparator<TextComponent> {
    private char symbol;

    public LexemeComparator(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        int result = countOccurrenceOfSymbol(o2, symbol) - countOccurrenceOfSymbol(o1, symbol);
        if (result == 0) {
            result = o1.toString().compareTo(o2.toString());
        }
        return result;
    }

    private int countOccurrenceOfSymbol(TextComponent textComponent, char symbol) {
        int counter = 0;
        String lexeme = textComponent.toString();
        for (char ch : lexeme.toCharArray()) {
            if (ch == symbol) {
                counter++;
            }
        }
        return counter;
    }
}
