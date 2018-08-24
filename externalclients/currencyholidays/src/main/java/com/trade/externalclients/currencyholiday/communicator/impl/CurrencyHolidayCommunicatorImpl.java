package com.trade.externalclients.currencyholiday.communicator.impl;

import com.trade.crosscutting.currencyholiday.CurrencyHolidayResponseModel;
import com.trade.externalclients.currencyholiday.communicator.CurrencyHolidayCommunicator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
public class CurrencyHolidayCommunicatorImpl implements CurrencyHolidayCommunicator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyHolidayCommunicatorImpl.class);

    private static final String RESOURCE_BASE_PATH = "api/v1";

    private final Client client;

    private final String apiPath;

    public CurrencyHolidayCommunicatorImpl(final Client client, final String apiPath) {
        LOGGER.debug("Initializing user identity resource client.");
        this.client = client;
        this.apiPath = apiPath;
        LOGGER.debug("User identity resource client initialized.");
    }

    @Override
    public List<CurrencyHolidayResponseModel> getCurrencyHolidaysByCountryAndYear(final String countryCode, final Integer year) {
        Assert.notNull(countryCode, "countryCode can't be null when getting holidays per country for a specific year.");
        Assert.notNull(year, "Year can't be null when getting holidays per country for a specific year.");
        return client
                .target(apiPath)
                .path(RESOURCE_BASE_PATH)
                .path("get")
                .path(countryCode)
                .path(year.toString())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<ArrayList<CurrencyHolidayResponseModel>>() {
                });
    }
}
