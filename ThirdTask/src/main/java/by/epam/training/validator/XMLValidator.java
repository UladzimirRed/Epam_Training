package by.epam.training.validator;

import by.epam.training.director.Director;
import by.epam.training.exception.WrongFileException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.net.URL;

public class XMLValidator {
    private Logger logger = LogManager.getLogger(Director.class);
    Schema schema = null;
    String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
    String schemaName = "data/candies.xsd";


    public boolean isValid(String xmlFilePath) throws WrongFileException {
        boolean result = false;
        try {
            URL schemaURL = getClass().getClassLoader().getResource(schemaName);
            schema = schemaFactory.newSchema(schemaURL);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlFilePath);
            validator.validate(source);
            result = true;
        } catch (SAXException e) {
            logger.error("Wrong XSD scheme, check your data", e);
        } catch (IOException e) {
            throw new WrongFileException("Wrong file", e);
        }
        return result;
    }
}
