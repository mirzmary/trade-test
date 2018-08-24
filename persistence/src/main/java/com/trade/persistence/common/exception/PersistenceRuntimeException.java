package com.trade.persistence.common.exception;


public class PersistenceRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -4402320416112463612L;

    public PersistenceRuntimeException() {

    }

    public PersistenceRuntimeException(final String message) {
        super(message);
    }

    public PersistenceRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
