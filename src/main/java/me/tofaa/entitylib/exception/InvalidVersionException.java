package me.tofaa.entitylib.exception;

public class InvalidVersionException extends RuntimeException {

    public InvalidVersionException() {
    }

    public InvalidVersionException(String message) {
        super(message);
    }

    public InvalidVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidVersionException(Throwable cause) {
        super(cause);
    }

    public InvalidVersionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
