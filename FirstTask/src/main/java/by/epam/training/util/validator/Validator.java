package by.epam.training.util.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern LINE_PATTERN = Pattern.compile("^-?[\\d]+(.[\\d]+)?,-?[\\d]+(.[\\d]+)?; -?[\\d]+(.[\\d]+)?,-?[\\d]+(.[\\d]+)?$");

    public static boolean validate(String line) {

        Matcher matcher = LINE_PATTERN.matcher(line);
        return matcher.matches();
    }
}