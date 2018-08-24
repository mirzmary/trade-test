package com.trade.service.currency;

import com.trade.persistence.currency.entity.Currency;
import com.trade.service.common.AbstractServiceIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CurrencyServiceIntegrationTest extends AbstractServiceIntegrationTest {

    @Autowired
    private CurrencyService currencyService;

    @Test
    public void testGetCurrencyByCode() throws Exception {
        // Given
        getHelper().createAndPersistCurrency();
        final String code = "USD";
        // When
        final Optional<Currency> currency = currencyService.getByCode(code);
        // Then
        Assert.assertTrue(currency.isPresent());
    }
}
