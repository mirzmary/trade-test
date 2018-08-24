package com.trade.service.trade.impl;

import com.trade.crosscutting.common.ValidationResult;
import com.trade.crosscutting.common.enums.ErrorEnum;
import com.trade.crosscutting.currencyholiday.CurrencyHolidayResponseModel;
import com.trade.service.common.AbstractServiceImplTest;
import com.trade.service.currencyholiday.CurrencyHolidayService;
import com.trade.service.helper.CommonTestHelper;
import com.trade.service.trade.BaseTradeValidationService;
import com.trade.service.trade.dto.BaseTradeDto;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.easymock.EasyMock.anyInt;
import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.expect;

public class BaseTradeValidationServiceImplTest extends AbstractServiceImplTest {

    @TestSubject
    private BaseTradeValidationService baseTradeValidationService = new BaseTradeValidationServiceImpl();


    @Mock
    private CurrencyHolidayService currencyHolidayService;

    @Before
    public void beforeTestStart() {
        ReflectionTestUtils.setField(baseTradeValidationService, "currentDate", CommonTestHelper.CURRENT_DATE);
    }

    @Test
    public void testValidateBaseTradeDtoWithInvalidData() throws Exception {
        // Test data
        final BaseTradeDto baseTradeDto = new BaseTradeDto();
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final ValidationResult validationResult = baseTradeValidationService.validateTrade(baseTradeDto);
        // Verify
        Assert.assertFalse(validationResult.isValid());
        Assert.assertEquals(validationResult.getValidationErrorCodeList().size(), 10);
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_AMOUNT1));
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_AMOUNT2));
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_RATE));
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_COUNTERPARTY));
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_CURRENCY_PAIR));
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_DIRECTION));
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_TYPE));
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_VALUE_DATE));
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_TRADE_DATE));
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_LEGAL_ENTITY));
        verifyAll();
    }

    @Test
    public void testValidateBaseTradeDtoWithInvalidCurrency() throws Exception {
        // Test data
        final BaseTradeDto baseTradeDto = getHelper().createBaseTradeDto();
        baseTradeDto.setCcyPair("USDEAR");
        // Reset
        resetAll();
        // Expectations
        expect(currencyHolidayService.getCurrencyHolidays(anyString(), anyInt())).andReturn(new ArrayList<>());
        // Replay
        replayAll();

        // Run test scenario
        final ValidationResult validationResult = baseTradeValidationService.validateTrade(baseTradeDto);
        // Verify
        Assert.assertFalse(validationResult.isValid());
        Assert.assertEquals(validationResult.getValidationErrorCodeList().size(), 1);
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_CURRENCY));

        verifyAll();
    }

    @Test
    public void testValidateBaseTradeDtoWithInvalidDates() throws Exception {
        // Test data
        final BaseTradeDto baseTradeDto = getHelper().createBaseTradeDto();
        baseTradeDto.setTradeDate(CommonTestHelper.CURRENT_DATE_STRING.plusDays(1));
        baseTradeDto.setCcyPair("USDEUR");
        // Reset
        resetAll();
        // Expectations
        expect(currencyHolidayService.getCurrencyHolidays(anyString(), anyInt())).andReturn(new ArrayList<>()).times(2);
        // Replay
        replayAll();

        // Run test scenario
        final ValidationResult validationResult = baseTradeValidationService.validateTrade(baseTradeDto);
        // Verify
        Assert.assertFalse(validationResult.isValid());
        Assert.assertEquals(validationResult.getValidationErrorCodeList().size(), 2);
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_TRADE_DATE));
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_VALUE_DATE));
        verifyAll();
    }

    @Test
    public void testValidateBaseTradeDtoWithWeekendValueDate() throws Exception {
        // Test data
        final BaseTradeDto baseTradeDto = getHelper().createBaseTradeDto();
        baseTradeDto.setValueDate(baseTradeDto.getValueDate().plusDays(2));
        // Reset
        resetAll();
        // Expectations
        // Replay
        replayAll();

        // Run test scenario
        final ValidationResult validationResult = baseTradeValidationService.validateTrade(baseTradeDto);
        // Verify
        Assert.assertFalse(validationResult.isValid());
        Assert.assertEquals(validationResult.getValidationErrorCodeList().size(), 1);
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_VALUE_DATE_WEEKEND));
        verifyAll();
    }

    @Test
    public void testValidateBaseTradeDtoHolidayForCurrency() throws Exception {
        // Test data
        final BaseTradeDto baseTradeDto = getHelper().createBaseTradeDto();
        baseTradeDto.setCcyPair("USDEUR");
        final CurrencyHolidayResponseModel currencyHolidayResponseModel = getHelper().createCurrencyHolidayResponseModel();
        // Reset
        resetAll();
        // Expectations
        expect(currencyHolidayService.getCurrencyHolidays(anyString(), anyInt())).andReturn(Collections.singletonList(currencyHolidayResponseModel));
        expect(currencyHolidayService.getCurrencyHolidays(anyString(), anyInt())).andReturn(new ArrayList<>());
        // Replay
        replayAll();

        // Run test scenario
        final ValidationResult validationResult = baseTradeValidationService.validateTrade(baseTradeDto);
        // Verify
        Assert.assertFalse(validationResult.isValid());
        Assert.assertEquals(validationResult.getValidationErrorCodeList().size(), 1);
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_CURRENCY_VALUE_DATE));
        verifyAll();
    }

    @Test
    public void testValidateBaseTradeDtoValid() throws Exception {
        // Test data
        final BaseTradeDto baseTradeDto = getHelper().createBaseTradeDto();
        baseTradeDto.setCcyPair("USDEUR");
        // Reset
        resetAll();
        // Expectations
        expect(currencyHolidayService.getCurrencyHolidays(anyString(), anyInt())).andReturn(new ArrayList<>()).times(2);
        // Replay
        replayAll();

        // Run test scenario
        final ValidationResult validationResult = baseTradeValidationService.validateTrade(baseTradeDto);
        // Verify
        Assert.assertTrue(validationResult.isValid());

        verifyAll();
    }
}
