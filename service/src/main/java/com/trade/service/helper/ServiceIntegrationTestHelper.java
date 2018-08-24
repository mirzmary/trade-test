package com.trade.service.helper;

import com.trade.persistence.currency.CurrencyRepository;
import com.trade.persistence.currency.entity.Currency;
import com.trade.service.currency.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ServiceIntegrationTestHelper extends CommonTestHelper {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private CurrencyRepository currencyRepository;

    public Currency createAndPersistCurrency() {
        final Currency currency = createCurrency();
        final Optional<Currency> existingCurrency = currencyService.getByCode(currency.getCode());
        return existingCurrency.orElseGet(() -> currencyRepository.save(currency));
    }
}
