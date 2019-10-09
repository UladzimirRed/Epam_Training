package by.epam.training.exception;

public class XMLFileException extends Exception {
    public XMLFileException(String message) {
        super(message);
    }

    public XMLFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLFileException(Throwable cause) {
        super(cause);
    }
}
