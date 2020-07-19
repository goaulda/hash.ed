package com.hash.exception;

public class AnyErrorHandlingException extends RuntimeException {

    public AnyErrorHandlingException() {
    }

    public AnyErrorHandlingException(String message) {
        super(message);
    }

    public AnyErrorHandlingException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnyErrorHandlingException(Throwable cause) {
        super(cause);
    }

    public AnyErrorHandlingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
