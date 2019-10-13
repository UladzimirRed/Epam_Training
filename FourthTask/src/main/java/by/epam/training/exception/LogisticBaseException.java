package by.epam.training.exception;

public class LogisticBaseException extends Exception{

    public LogisticBaseException() {
    }

    public LogisticBaseException(String message) {
        super(message);
    }

    public LogisticBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogisticBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
