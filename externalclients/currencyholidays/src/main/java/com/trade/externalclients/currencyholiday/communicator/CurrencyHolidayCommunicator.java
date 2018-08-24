package com.trade.externalclients.currencyholiday.communicator;



import com.trade.crosscutting.currencyholiday.CurrencyHolidayResponseModel;

import java.util.List;

public interface CurrencyHolidayCommunicator {

    List<CurrencyHolidayResponseModel> getCurrencyHolidaysByCountryAndYear(final String countryCode, final Integer year);
}
