package com.trade.api.rest.config.provider;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Provider
public class DateParamConverterProvider implements ParamConverterProvider {

    private final DateTimeFormatter formatter;

    public DateParamConverterProvider(final String dateFormat) {
        this.formatter = DateTimeFormatter.ofPattern(dateFormat);
    }

    public DateParamConverterProvider() {
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    @Override
    public <T> ParamConverter<T> getConverter(final Class<T> rawType, final Type genericType, final Annotation[] annotations) {

        if (rawType != LocalDate.class) {
            return null;
        }

        return (ParamConverter<T>) new ParamConverter<LocalDate>() {
            @Override
            public LocalDate fromString(final String value) {
                try {
                    if (value == null) {
                        return null;
                    }
                    return LocalDate.parse(value, formatter);
                } catch (Exception ex) {
                    throw new WebApplicationException("Bad formatted date", 400);
                }
            }

            @Override
            public String toString(final LocalDate localDateTime) {
                return localDateTime.format(formatter);
            }
        };
    }
}