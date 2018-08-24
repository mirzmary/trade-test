package com.trade.api.rest.exception.mapper;

import org.springframework.http.HttpStatus;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.net.SocketTimeoutException;

@Provider
public class ProcessingExceptionMapper implements ExceptionMapper<ProcessingException> {

    @Override
    public Response toResponse(final ProcessingException ex) {
        if(ex.getCause() instanceof SocketTimeoutException){
            return Response.status(HttpStatus.REQUEST_TIMEOUT.value()).
                    build();
        }
        return Response.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).
                build();
    }
}