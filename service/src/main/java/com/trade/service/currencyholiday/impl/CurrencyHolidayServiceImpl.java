package com.trade.service.currencyholiday.impl;

import com.trade.crosscutting.currencyholiday.CurrencyHolidayResponseModel;
import com.trade.externalclients.currencyholiday.communicator.CurrencyHolidayCommunicator;
import com.trade.service.currencyholiday.CurrencyHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class CurrencyHolidayServiceImpl implements CurrencyHolidayService {

    @Autowired
    private CurrencyHolidayCommunicator currencyHolidayCommunicator;

    @Override
    public List<CurrencyHolidayResponseModel> getCurrencyHolidays(final String countryCode, final Integer year) {
        Assert.notNull(countryCode, "countryCode can't be null when getting holidays per country for a specific year.");
        Assert.notNull(year, "Year can't be null when getting holidays per country for a specific year.");
        return currencyHolidayCommunicator.getCurrencyHolidaysByCountryAndYear(countryCode, year);
    }
}
