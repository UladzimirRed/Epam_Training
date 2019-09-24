package by.epam.training.action;

import by.epam.training.composite.TextComponent;
import by.epam.training.composite.TextComposite;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFunctionality {
    private static Logger logger = LogManager.getLogger(TextFunctionality.class);
    private static final String REGULAR_EXPRESSION = "[A-Za-z]+";
    private static Pattern pattern = Pattern.compile(REGULAR_EXPRESSION);

    private static Comparator<TextComponent>
            comparatorForSortingByNumberOfSentences = Comparator.comparingInt(o -> o.getComponents().size());

    private static Comparator<TextComponent>
            comparatorForSortingWordsByLength = (o1, o2) -> {
        String wordFromSentence1 = getWordFromLexeme(o1.toString());
        String wordFromSentence2 = getWordFromLexeme(o2.toString());
        return Integer.compare(wordFromSentence1.length(),
                wordFromSentence2.length());
    };

    private static String getWordFromLexeme(final String lexeme) {
        Matcher matcher = pattern.matcher(lexeme);
        if (matcher.find()) {
            return matcher.group();
        }
        return lexeme;
    }

    public void sortParagraphsByNumberOfSentences(TextComposite textComposite) {
        textComposite.setIsOutputText(false);
        Collections.sort(textComposite.getComponents(), comparatorForSortingByNumberOfSentences);
        logger.info("Sorting paragraphs by number of sentences ended successful");
        textComposite.setIsOutputText(true);
    }

    public void sortWordsInSentenceByLength(TextComposite textComposite) {
        textComposite.setIsOutputText(false);
        for (TextComponent paragraphComponent : textComposite.getComponents()) {
            for (TextComponent sentenceComponent : paragraphComponent.getComponents()) {
                Collections.sort(sentenceComponent.getComponents(), comparatorForSortingWordsByLength);
            }
        }
        logger.info("Sorting words in every sentence by length of word ended successful");
        textComposite.setIsOutputText(true);
    }

    public String sortLexemesByEntranceOfSomeSymbol(TextComposite textComposite, final String symbol) {
        Comparator<String> comparatorForSortingByNumberOfEntrance
                = (o1, o2) -> {
            int numberOfEntrance1 = getNumberOfEntrance(o1, symbol);
            int numberOfEntrance2 = getNumberOfEntrance(o2, symbol);
            int difference = Integer.compare(numberOfEntrance2, numberOfEntrance1);
            if (difference == 0) {
                return o1.compareTo(o2);
            } else {
                return difference;
            }
        };

        List<String> listWithLexemes = new ArrayList<>();

        for (TextComponent paragraph : textComposite.getComponents()) {
            for (TextComponent sentence : paragraph.getComponents()) {
                sentence.setIsOutputText(false);
                for (TextComponent lexeme : sentence.getComponents()) {
                    listWithLexemes.add(lexeme.toString());
                }
                sentence.setIsOutputText(true);
            }
        }

        Collections.sort(listWithLexemes,
                comparatorForSortingByNumberOfEntrance);
        logger.info("Sorting lexemes in text by number of entrance of some symbol ended successful");

        StringBuilder stringSortedLexemesByEntrance = new StringBuilder();
        for (String lexeme : listWithLexemes) {
            stringSortedLexemesByEntrance.append(lexeme + " ");
        }
        return stringSortedLexemesByEntrance.toString();
    }

    private static int getNumberOfEntrance(final String lexeme, final String symbol) {
        return lexeme.length() - lexeme.replace(symbol, "").length();
    }
}
