package by.epam.training.exception;

public class XMLParseFileException extends Exception{  //TODO change name

    public XMLParseFileException(String message) {
        super(message);
    }

    public XMLParseFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLParseFileException(Throwable cause) {
        super(cause);
    }
}
