package com.trade.api.rest.config;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Provider
public class LocalDateParamConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(
            final Class<T> rawType, final Type genericType, final Annotation[] antns) {

        if (LocalDate.class == rawType) {
            return new ParamConverter<T>() {

                final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                @Override
                public T fromString(final String string) {
                    try {
                        if (string == null) {
                            return null;
                        }
                        final LocalDate localDate = LocalDate.parse(string, formatter);
                        return rawType.cast(localDate);
                    } catch (Exception ex) {
                        throw new BadRequestException(ex);
                    }
                }

                @Override
                public String toString(final T t) {
                    final LocalDate localDate = (LocalDate) t;
                    return formatter.format(localDate);
                }
            };
        }

        return null;
    }
}
