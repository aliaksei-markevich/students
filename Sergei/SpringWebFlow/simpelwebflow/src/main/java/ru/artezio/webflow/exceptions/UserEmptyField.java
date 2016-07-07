package ru.artezio.webflow.exceptions;

/**
 * Created by Администратор on 07.07.2016.
 */
public class UserEmptyField extends Exception {
    public UserEmptyField() {
        super();
    }

    public UserEmptyField(String message) {
        super(message);
    }

    public UserEmptyField(String message, Throwable cause) {
        super(message, cause);
    }

    public UserEmptyField(Throwable cause) {
        super(cause);
    }

    protected UserEmptyField(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
