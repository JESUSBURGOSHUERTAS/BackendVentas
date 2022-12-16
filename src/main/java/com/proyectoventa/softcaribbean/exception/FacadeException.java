package com.proyectoventa.softcaribbean.exception;

public class FacadeException extends Exception{
    public FacadeException() {
    }

    public FacadeException(String message) {
        super(message);
    }

    public FacadeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacadeException(Throwable cause) {
        super(cause);
    }

    public FacadeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
