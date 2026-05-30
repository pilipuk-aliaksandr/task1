package by.pilipuk.inno.exception;

public class CustomArrayException extends RuntimeException {

    public CustomArrayException(String message) {
        super(message);
    }

    public CustomArrayException(String message, Throwable cause) {
        super(message, cause);
    }
}