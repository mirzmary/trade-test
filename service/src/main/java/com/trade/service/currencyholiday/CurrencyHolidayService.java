package com.trade.service.currencyholiday;

import com.trade.crosscutting.currencyholiday.CurrencyHolidayResponseModel;

import java.util.List;

public interface CurrencyHolidayService {

    List<CurrencyHolidayResponseModel> getCurrencyHolidays(final String countryCode, final Integer year);
}
