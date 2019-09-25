package by.epam.training.parser;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextFromPunctSplitter {
    private static final String OPERATION_DIVIDER = "(?=[…\\p{Punct}])";
    private static final String OPERATION = "(?<=[…\\p{Punct}])";
    private static Logger logger = LogManager.getLogger(TextFromPunctSplitter.class);


    public static List<String> splitTextFromPuncts(String lexeme) {
        Pattern punctPattern = Pattern.compile(OPERATION_DIVIDER);
        List<String> list = punctPattern.splitAsStream(lexeme).collect(Collectors.toList());
        Pattern punct = Pattern.compile(OPERATION);
        logger.debug(list);
        ArrayList<String> temp = new ArrayList<>();
        for (String element : list) {
            temp.addAll(punct.splitAsStream(element).collect(Collectors.toList()));
        }
        logger.debug(temp);
        return temp;
    }
}
