package com.trade.service.helper;


import com.trade.crosscutting.currencyholiday.CurrencyHolidayResponseModel;
import com.trade.service.trade.dto.BaseTradeDto;
import com.trade.service.trade.dto.OptionTradeDto;
import com.trade.service.trade.enums.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CommonTestHelper {

    public static final LocalDate CURRENT_DATE_STRING = LocalDate.of(2016, 10, 9);
    public static final String CURRENT_DATE = "2016-10-09";
    private static final String TRADER_NAME = "Johann Baumfiddler";
    private static final String CURRENCY = "USD";
    private static final String CURRENCY_PAIR = "USDEUR";


    public BaseTradeDto createBaseTradeDto() {
        final BaseTradeDto baseTradeDto = new BaseTradeDto();
        baseTradeDto.setCustomer(Counterparty.PLUTO1.name());
        baseTradeDto.setLegalEntity(LegalEntity.CS_ZURICH.displayName());
        baseTradeDto.setType(Type.Spot.name());
        baseTradeDto.setDirection(Direction.SELL.name());
        baseTradeDto.setAmount1(BigDecimal.valueOf(1000));
        baseTradeDto.setAmount2(BigDecimal.valueOf(1200));
        baseTradeDto.setRate(BigDecimal.valueOf(1.2));
        baseTradeDto.setCcyPair(CURRENCY_PAIR);
        baseTradeDto.setValueDate(CURRENT_DATE_STRING.minusDays(10));
        baseTradeDto.setTradeDate(CURRENT_DATE_STRING.minusDays(12));
        baseTradeDto.setTrader(TRADER_NAME);
        return baseTradeDto;
    }

    public OptionTradeDto createOptionTradeDto() {
        final OptionTradeDto optionTradeDto = new OptionTradeDto();

        optionTradeDto.setCustomer(Counterparty.PLUTO1.name());
        optionTradeDto.setLegalEntity(LegalEntity.CS_ZURICH.displayName());
        optionTradeDto.setType(Type.Spot.name());
        optionTradeDto.setDirection(Direction.SELL.name());
        optionTradeDto.setAmount1(BigDecimal.valueOf(1000));
        optionTradeDto.setAmount2(BigDecimal.valueOf(1200));
        optionTradeDto.setRate(BigDecimal.valueOf(1.2));
        optionTradeDto.setCcyPair(CURRENCY_PAIR);
        optionTradeDto.setValueDate(CURRENT_DATE_STRING.minusDays(10));
        optionTradeDto.setTradeDate(CURRENT_DATE_STRING.minusDays(12));
        optionTradeDto.setTrader(TRADER_NAME);

        optionTradeDto.setDeliveryDate(CURRENT_DATE_STRING.minusDays(4));
        optionTradeDto.setExpiryDate(CURRENT_DATE_STRING.minusDays(5));
        optionTradeDto.setExerciseStartDate(CURRENT_DATE_STRING.minusDays(5));
        optionTradeDto.setPremiumDate(CURRENT_DATE_STRING.minusDays(8));
        optionTradeDto.setStyle(Style.AMERICAN.name());
        optionTradeDto.setStrategy(Strategy.CALL.name());
        optionTradeDto.setPremium(BigDecimal.valueOf(0.12));
        optionTradeDto.setPayCcy(CURRENCY);
        optionTradeDto.setPremiumCcy(CURRENCY);
        optionTradeDto.setPremiumType("%USD");

        return optionTradeDto;

    }

    public CurrencyHolidayResponseModel createCurrencyHolidayResponseModel() {
        final CurrencyHolidayResponseModel model = new CurrencyHolidayResponseModel();
        model.setDate(CURRENT_DATE_STRING.minusDays(10));
        model.setCountryCode("US");
        return model;
    }
}
