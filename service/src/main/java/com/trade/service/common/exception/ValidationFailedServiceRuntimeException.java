package com.trade.service.common.exception;

import java.io.Serializable;

public class ValidationFailedServiceRuntimeException extends LoggerAwareServiceRuntimeException {

    private static final long serialVersionUID = 5658627586308277920L;

    //region Constructors
    public ValidationFailedServiceRuntimeException(final Object caller, final Class<? extends Serializable> dto) {
        super(caller, "Validation failed for enums %s - %s", dto.getClass(), dto);
    }

    public ValidationFailedServiceRuntimeException(final Object caller, String message) {
        super(caller, message);
    }
    //endregion
}

