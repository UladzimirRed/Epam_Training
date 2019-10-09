package by.epam.training.validator;

import by.epam.training.handler.CandyErrorHandler;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


public class ValidatorXsd {
    private static final Logger logger = LogManager.getLogger(ValidatorXsd.class);
    private static final String LOG_FILE_PATH = String.valueOf
            (ClassLoader.getSystemResourceAsStream("logs/app.txt"));
    private static final String LANGUAGE = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private static final String XML_FILE_PATH = String.valueOf
            (ClassLoader.getSystemResourceAsStream("data/candies.xml"));
    private static final String XSD_FILE_PATH = String.valueOf
            (ClassLoader.getSystemResourceAsStream("data/candies.xsd"));

    public boolean isValid() {
        try {
            File schemaLocation = new File(XSD_FILE_PATH);
            SchemaFactory factory = SchemaFactory.newInstance(LANGUAGE);
            CandyErrorHandler candyErrorHandler = new CandyErrorHandler(LOG_FILE_PATH);
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(XML_FILE_PATH);
            validator.validate(source);
            validator.setErrorHandler(candyErrorHandler);
            logger.info("File: " + XML_FILE_PATH + " is valid.");
        } catch (IOException | SAXException e) {
            logger.error("Validation error. Check your xml/xsd data");
            return false;
        }
        return true;
    }
}
