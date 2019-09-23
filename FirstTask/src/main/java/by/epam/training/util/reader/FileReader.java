package by.epam.training.util.reader;

import by.epam.training.exception.ProjectException;
import by.epam.training.util.validator.Validator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    private static final Logger logger = LogManager.getLogger(FileReader.class);

    public List<String> read(String pathToFile) throws Exception {
        if (pathToFile == null) {
            throw new ProjectException("Null path to file in read method.");
        }
        List<String> ellipsesList;
        Path path = Paths.get(getClass().getResource(pathToFile).toURI());
        try (Stream<String> lineStream = Files.newBufferedReader(path).lines()) {
            ellipsesList = lineStream.collect(Collectors.toList());
            if (ellipsesList.isEmpty()) {
                logger.error("List is empty! Please, check your data!");
            }
        } catch (IOException e) {
            throw new ProjectException("Error in reading file: ", e);
        }
        List<String> validList = new ArrayList<>();
        for (String s : ellipsesList) {
            if (Validator.validate(s)) {
                validList.add(s);
            } else {
                logger.error("Line \"" + s + "\" is not valid. The application does not use this string.");
            }
        }
        return validList;
    }
}