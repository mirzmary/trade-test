package com.trade.service.currency.impl;

import com.trade.persistence.currency.CurrencyRepository;
import com.trade.persistence.currency.entity.Currency;
import com.trade.service.common.AbstractServiceImplTest;
import com.trade.service.currency.CurrencyService;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.easymock.EasyMock.expect;

public class CurrencyServiceImplTest extends AbstractServiceImplTest {

    @TestSubject
    private CurrencyService currencyService = new CurrencyServiceImpl();

    @Mock
    private CurrencyRepository currencyRepository;

    @Test(expected = IllegalArgumentException.class)
    public void testGetCurrencyByCodeWithIllegalArguments() throws Exception {
        // Test data
        // Reset
        resetAll();
        // Expectations
        // Replay
        replayAll();
        currencyService.getByCode(null);
        // Run test scenario
        // Verify
        verifyAll();
    }

    @Test
    public void testGetCurrencyByCodeNoCurrencyFound() throws Exception {
        // Test data
        final String code = "USD";
        // Reset
        resetAll();
        // Expectations
        expect(currencyRepository.findByCode(code)).andReturn(null);
        // Replay
        replayAll();
        final Optional<Currency> currency = currencyService.getByCode(code);
        // Run test scenario
        Assert.assertFalse(currency.isPresent());
        // Verify
        verifyAll();
    }

    @Test
    public void testGetCurrencyByCodeCurrencyFound() throws Exception {
        // Test data
        final String code = "USD";
        final Currency expectedCurrency = getHelper().createCurrency();
        // Reset
        resetAll();
        // Expectations
        expect(currencyRepository.findByCode(code)).andReturn(expectedCurrency);
        // Replay
        replayAll();
        final Optional<Currency> currency = currencyService.getByCode(code);
        // Run test scenario
        Assert.assertTrue(currency.isPresent());
        Assert.assertEquals(currency.get(), expectedCurrency);
        // Verify
        verifyAll();
    }
}
