package com.trade.externalclients.currencyholiday.client.impl;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.trade.externalclients.currencyholiday.client.CurrencyHolidayJerseyClientBuilder;
import org.glassfish.jersey.client.ClientProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@Component
public class CurrencyHolidayJerseyClientBuilderImpl implements CurrencyHolidayJerseyClientBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyHolidayJerseyClientBuilderImpl.class);

    @Value("${jersey.client.timeout.connect}")
    private Integer connectTimeout;

    @Value("${jersey.client.timeout.read}")
    private Integer readTimeout;

    public CurrencyHolidayJerseyClientBuilderImpl(){
        LOGGER.debug("Initializing currency holiday api client.");
    }

    @Override
    public Client buildCurrencyHolidayClient() {
        LOGGER.debug("Building currency holiday api Jersey client");
        final Client client = ClientBuilder.newBuilder().register(JacksonJsonProvider.class).build();
        // values are in milliseconds
        client.property(ClientProperties.CONNECT_TIMEOUT, connectTimeout);
        client.property(ClientProperties.READ_TIMEOUT, readTimeout);
        LOGGER.debug("Successfully created currency holiday Jersey client - {}", client);
        return client;
    }
}
