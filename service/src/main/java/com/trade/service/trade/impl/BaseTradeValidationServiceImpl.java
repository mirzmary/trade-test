package com.trade.service.trade.impl;

import com.trade.crosscutting.common.ValidationResult;
import com.trade.crosscutting.common.enums.ErrorEnum;
import com.trade.crosscutting.currencyholiday.CurrencyHolidayResponseModel;
import com.trade.service.common.validationcomponent.impl.CommonValidationComponentImpl;
import com.trade.service.currencyholiday.CurrencyHolidayService;
import com.trade.service.helper.currencyhelper.CurrencyHelperUtil;
import com.trade.service.helper.currencyhelper.CurrencyLocales;
import com.trade.service.trade.BaseTradeValidationService;
import com.trade.service.trade.dto.BaseTradeDto;
import com.trade.service.trade.enums.Counterparty;
import com.trade.service.trade.enums.Direction;
import com.trade.service.trade.enums.LegalEntity;
import com.trade.service.trade.enums.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@Qualifier("baseTradeValidationComponentImpl")
public class BaseTradeValidationServiceImpl extends CommonValidationComponentImpl implements BaseTradeValidationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTradeValidationServiceImpl.class);

    @Autowired
    private CurrencyHolidayService currencyHolidayService;

    @Value("${validation.currentdate}")
    private String currentDate;

    @Override
    public ValidationResult validateTrade(final BaseTradeDto baseTradeDto) {
        final ValidationResult validationResult = new ValidationResult();
        if (!validateDateAfter(baseTradeDto.getTradeDate(), LocalDate.parse(currentDate))) {
            LOGGER.info("Trade Date - {} can not be after Current date - {}", baseTradeDto.getTradeDate(), currentDate);
            validationResult.put(ErrorEnum.INVALID_TRADE_DATE, String.format("Trade Date - %s can not be after Current date - %s", baseTradeDto.getTradeDate(), currentDate));
        }
        if (!Counterparty.contains(baseTradeDto.getCustomer())) {
            LOGGER.info("Invalid Counterparty - {}", baseTradeDto.getCustomer());
            validationResult.put(ErrorEnum.INVALID_COUNTERPARTY, String.format("Invalid Counterparty - %s ", baseTradeDto.getCustomer()));
        }
        if (!Type.contains(baseTradeDto.getType())) {
            LOGGER.info("Invalid Type - {}", baseTradeDto.getType());
            validationResult.put(ErrorEnum.INVALID_TYPE, String.format("Invalid Type - %s ", baseTradeDto.getType()));
        }
        if (!Direction.contains(baseTradeDto.getDirection())) {
            LOGGER.info("Invalid Direction - {}", baseTradeDto.getDirection());
            validationResult.put(ErrorEnum.INVALID_DIRECTION, String.format("Invalid Direction - %s ", baseTradeDto.getDirection()));
        }
        if (!LegalEntity.contains(baseTradeDto.getLegalEntity())) {
            LOGGER.info("Invalid LegalEntity - {}", baseTradeDto.getLegalEntity());
            validationResult.put(ErrorEnum.INVALID_LEGAL_ENTITY, String.format("Invalid LegalEntity - %s ", baseTradeDto.getLegalEntity()));
        }
        if (!validateAmount(baseTradeDto.getAmount1())) {
            LOGGER.info("Invalid Amount1 - {}", baseTradeDto.getAmount1());
            validationResult.put(ErrorEnum.INVALID_AMOUNT1, String.format("Invalid Amount1 - %s ", baseTradeDto.getAmount1()));
        }
        if (!validateAmount(baseTradeDto.getAmount2())) {
            LOGGER.info("Invalid Amount2 - {}", baseTradeDto.getAmount2());
            validationResult.put(ErrorEnum.INVALID_AMOUNT2, String.format("Invalid Amount2 - %s ", baseTradeDto.getAmount2()));
        }
        if (!validateAmount(baseTradeDto.getRate())) {
            LOGGER.info("Invalid Rate - {}", baseTradeDto.getRate());
            validationResult.put(ErrorEnum.INVALID_RATE, String.format("Invalid Rate - %s ", baseTradeDto.getRate()));
        }
        if (!validateDateAfter(baseTradeDto.getTradeDate(), baseTradeDto.getValueDate())) {
            LOGGER.info("Value Date - {} should be after Trade Date - {}", baseTradeDto.getValueDate(), baseTradeDto.getTradeDate());
            validationResult.put(ErrorEnum.INVALID_VALUE_DATE, String.format("Value Date - %s should be after Trade Date - %s", baseTradeDto.getValueDate(), baseTradeDto.getTradeDate()));
        }
        if (!validateWeekday(baseTradeDto.getValueDate())) {
            LOGGER.info("Value Date - {} should not be weekend day.", baseTradeDto.getValueDate());
            validationResult.put(ErrorEnum.INVALID_VALUE_DATE_WEEKEND, String.format("Value Date - %s should not be weekend day.", baseTradeDto.getValueDate()));
        }
        if (!validateString(baseTradeDto.getCcyPair())) {
            LOGGER.info("Invalid Currency Pair - {}", baseTradeDto.getCcyPair());
            validationResult.put(ErrorEnum.INVALID_CURRENCY_PAIR, String.format("Invalid Currency Pair - %s ", baseTradeDto.getCcyPair()));
        } else {
            final List<String> currencyList = CurrencyHelperUtil.getCurrenciesFromPair(baseTradeDto.getCcyPair());
            final List<CurrencyLocales> validCurrencies = CurrencyHelperUtil.getAllCurrencies();
            currencyList.forEach(c -> {
                if (validCurrencies.stream().noneMatch(validCurrency -> validCurrency.getCurrency().equals(c))) {
                    LOGGER.info("Invalid Currency - {}", c);
                    validationResult.put(ErrorEnum.INVALID_CURRENCY, String.format("Invalid Currency - %s ", c));
                } else if (!validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_VALUE_DATE_WEEKEND)) {
                    final String countryCode = validCurrencies.stream().filter(currency -> currency.getCurrency().equals(c)).findFirst().get().getLocaleList().get(0).getCountry();
                    final List<CurrencyHolidayResponseModel> currencyHolidays = currencyHolidayService.getCurrencyHolidays(countryCode, baseTradeDto.getValueDate().getYear());
                    if (currencyHolidays.stream().anyMatch(currencyHoliday -> currencyHoliday.getDate().equals(baseTradeDto.getValueDate()))) {
                        LOGGER.info("Invalid Currency - {}", c);
                        validationResult.put(ErrorEnum.INVALID_CURRENCY, String.format("Invalid Currency - %s ", c));
                    }
                }
            });
        }
        return validationResult;
    }
}
