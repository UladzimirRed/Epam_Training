package by.epam.training.action;

import by.epam.training.composite.*;
import by.epam.training.reader.DataReader;
import by.epam.training.util.LexemeComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


public class TextFunctionality {
    private static final Logger logger = LogManager.getLogger(DataReader.class);

    public TextComposite sortParagraphsBySentenceQuantity(TextComposite textComposite) {
        TextComposite sortedTextComposite = new TextComposite(ComponentType.TEXT);

        if (textComposite.getType().equals(ComponentType.TEXT)) {
            List<TextComponent> paragraphs = textComposite.getComponents();

            List<TextComponent> sortedParagraphs = new ArrayList<>(paragraphs);
            sortedParagraphs.sort(Comparator.comparingInt(comp -> comp.getComponents().size()));

            sortedTextComposite.addAll(sortedParagraphs);
        }
        logger.info("Paragraphs sorted by the number of sentences");
        return sortedTextComposite;
    }

    public TextComposite sortSentencesByNumberOfWords(TextComposite textComposite) {
        TextComposite sortedTextComposite = new TextComposite(ComponentType.TEXT);

        List<TextComponent> paragraphs = textComposite.getComponents();
        for (TextComponent paragraph : paragraphs) {
            TextComposite paragraphComposite = new TextComposite(ComponentType.PARAGRAPH);

            List<TextComponent> sortedSentences = new ArrayList<>(paragraph.getComponents());
            sortedSentences.sort(Comparator.comparingInt(sentence -> sentence.getComponents().size()));

            paragraphComposite.addAll(sortedSentences);
            sortedTextComposite.add(paragraphComposite);
        }
        logger.info("Sentences sorted by the number of words");
        return sortedTextComposite;
    }

    public TextComposite sortLexemesByOccurrenceOfSymbolAndThenAlphabetic(TextComponent textComposite, char symbol) {
        TextComposite sortedTextComposite = new TextComposite(ComponentType.TEXT);

        List<TextComponent> paragraphs = textComposite.getComponents();
        for (TextComponent paragraph : paragraphs) {
            TextComposite paragraphComposite = new TextComposite(ComponentType.PARAGRAPH);
            List<TextComponent> sentences = paragraph.getComponents();

            for (TextComponent sentence : sentences) {
                TextComposite sentenceComposite = new TextComposite(ComponentType.SENTENCE);
                List<TextComponent> sortedLexemes = new ArrayList<>(sentence.getComponents());

                sortedLexemes.sort(new LexemeComparator(symbol));
                sentenceComposite.addAll(sortedLexemes);
                paragraphComposite.add(sentenceComposite);
            }
            sortedTextComposite.add(paragraphComposite);
        }
        logger.info("Lexemes sorted by occurrence of symbol '" + symbol + "' and than by alphabet");
        return sortedTextComposite;
    }
}
