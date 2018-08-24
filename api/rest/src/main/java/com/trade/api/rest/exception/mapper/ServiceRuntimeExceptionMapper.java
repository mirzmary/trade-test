package com.trade.api.rest.exception.mapper;

import com.trade.service.common.exception.ServiceRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.util.Optional;

@Provider
public class ServiceRuntimeExceptionMapper implements ExceptionMapper<ServiceRuntimeException> {

    public Response toResponse(final ServiceRuntimeException ex) {
        final ResponseStatus responseStatus = getResponseStatus(ex);
        return Response.status(Optional.ofNullable(responseStatus).map(rs -> rs.code().value()).orElse(HttpStatus.INTERNAL_SERVER_ERROR.value())).
                type("application/json").
                build();
    }

    // region private methods

    private ResponseStatus getResponseStatus(final ServiceRuntimeException ex) {
        for (final Annotation annotation : ex.getClass().getAnnotations()) {
            if (annotation.annotationType().equals(ResponseStatus.class)) {
                return (ResponseStatus) annotation;
            }
        }
        return null;
    }

    // endregion
}
