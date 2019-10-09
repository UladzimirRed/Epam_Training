package by.epam.training.exception;

public class WrongFileException extends Exception {
    public WrongFileException(String message) {
        super(message);
    }

    public WrongFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongFileException(Throwable cause) {
        super(cause);
    }
}
