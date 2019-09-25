package by.epam.training.reader;

import by.epam.training.exception.DataReaderException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader {
    private static final Logger logger = LogManager.getLogger(DataReader.class);
    private Path path;

    public String readTextFromFile(String pathToFile) throws DataReaderException {
        String text;
        if (!pathToFile.isEmpty()) {
            try {
                path = Paths.get(getClass().getResource(pathToFile).toURI());
            } catch (URISyntaxException e) {
                throw new DataReaderException("String " + pathToFile + " could not be parsed as a URI reference.", e);
            }
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
