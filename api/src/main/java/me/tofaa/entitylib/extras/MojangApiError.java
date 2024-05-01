package me.tofaa.entitylib.extras;

public class MojangApiError extends RuntimeException {

    public MojangApiError() {
    }

    public MojangApiError(String message) {
        super(message);
    }

    public MojangApiError(String message, Throwable cause) {
        super(message, cause);
    }

    public MojangApiError(Throwable cause) {
        super(cause);
    }

    public MojangApiError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
