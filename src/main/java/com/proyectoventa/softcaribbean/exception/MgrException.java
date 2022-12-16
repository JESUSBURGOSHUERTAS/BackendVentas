package com.proyectoventa.softcaribbean.exception;

public class MgrException extends Exception{
    public MgrException() {
    }

    public MgrException(String message) {
        super(message);
    }

    public MgrException(String message, Throwable cause) {
        super(message, cause);
    }

    public MgrException(Throwable cause) {
        super(cause);
    }

    public MgrException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
