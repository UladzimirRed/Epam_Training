package by.epam.training.reader;

import by.epam.training.exception.DataReaderException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    private static final Logger logger = LogManager.getLogger(FileReader.class);
    private Path path;

    public String readTextFromFile(String pathToFile) throws Exception {
        String text;
        if (!pathToFile.isEmpty()) {
            path = Paths.get(getClass().getResource(pathToFile).toURI());
        } else {
            logger.warn("The file path is missing. Please, indicate the path");
            throw new DataReaderException("Path argument is null");
        }
        try (Stream<String> lineStream = Files.lines(path)) {
            text = lineStream.collect(Collectors.joining());
            logger.info("Reading file was successful");
            if (text.isEmpty()) {
                logger.error("List is empty! Please, check your data!");
            }
        } catch (Exception e) {
            throw new DataReaderException("Error in reading file: ", e);
        }
        return text;
    }
}
