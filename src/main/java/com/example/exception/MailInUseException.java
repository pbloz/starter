package com.example.exception;

public class MailInUseException extends RuntimeException {

    public MailInUseException() {
        super();
    }

    public MailInUseException(String message) {
        super(message);
    }

    public MailInUseException(String message, Throwable t) {
        super(message, t);
    }

}
