package com.trade.persistence.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerAwarePersistenceRuntimeException extends PersistenceRuntimeException {

    private static final long serialVersionUID = -659839380235080533L;

    //region Properties
    protected final Logger LOGGER;

    //endregion

    //region Constructors
    public LoggerAwarePersistenceRuntimeException(final Object caller, final String message, final Object... args) {
        super(String.format(message, args));
        final String errorMessage = String.format(message, args);
        this.LOGGER = LoggerFactory.getLogger(caller.getClass());
        this.LOGGER.error(errorMessage);
    }

    public LoggerAwarePersistenceRuntimeException(final Object caller, final String message, final Throwable cause, final Object... args) {
        super(String.format(message, args), cause);
        final String errorMessage = String.format(message, args);
        this.LOGGER = LoggerFactory.getLogger(caller.getClass());
        this.LOGGER.error(errorMessage);
    }
    //endregion
}
