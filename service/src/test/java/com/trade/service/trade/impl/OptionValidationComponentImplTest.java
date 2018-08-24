package com.trade.service.trade.impl;

import com.trade.crosscutting.common.ValidationResult;
import com.trade.crosscutting.common.enums.ErrorEnum;
import com.trade.service.common.AbstractServiceImplTest;
import com.trade.service.currencyholiday.CurrencyHolidayService;
import com.trade.service.helper.CommonTestHelper;
import com.trade.service.trade.OptionTradeValidationService;
import com.trade.service.trade.dto.OptionTradeDto;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;

import static org.easymock.EasyMock.anyInt;
import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.expect;

public class OptionValidationComponentImplTest extends AbstractServiceImplTest {

    @TestSubject
    private OptionTradeValidationService optionTradeValidationService = new OptionTradeValidationServiceImpl();

    @Mock
    private CurrencyHolidayService currencyHolidayService;

    @Before
    public void beforeTestStart() {
        ReflectionTestUtils.setField(optionTradeValidationService, "currentDate", CommonTestHelper.CURRENT_DATE);
    }


    @Test
    public void testValidateTradeWhenInvalid() throws Exception {
        // Test data
        final OptionTradeDto optionTradeDto = new OptionTradeDto();
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final ValidationResult validationResult = optionTradeValidationService.validateTrade(optionTradeDto);
        // Verify
        Assert.assertFalse(validationResult.isValid());
        Assert.assertEquals(validationResult.getValidationErrorCodeList().size(), 14);
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_TRADE_DATE));
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
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_STYLE));
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_EXPIRY_DATE));
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_PREMIUM_DATE));

        verifyAll();
    }

    @Test
    public void testValidateTradeWhenInvalidExerciseDateForAmericanStyle() throws Exception {
        // Test data
        final OptionTradeDto optionTradeDto = getHelper().createOptionTradeDto();
        optionTradeDto.setExerciseStartDate(optionTradeDto.getExpiryDate().plusDays(1));
        // Reset
        resetAll();
        // Expectations
        expect(currencyHolidayService.getCurrencyHolidays(anyString(), anyInt())).andReturn(new ArrayList<>()).times(2);
        // Replay
        replayAll();

        // Run test scenario
        final ValidationResult validationResult = optionTradeValidationService.validateTrade(optionTradeDto);
        // Verify
        Assert.assertFalse(validationResult.isValid());
        Assert.assertEquals(validationResult.getValidationErrorCodeList().size(), 1);
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_PREMIUM_DATE));

        verifyAll();
    }

    @Test
    public void testValidateTradeWhenInvalidExpiryDate() throws Exception {
        // Test data
        final OptionTradeDto optionTradeDto = getHelper().createOptionTradeDto();
        optionTradeDto.setExpiryDate(optionTradeDto.getDeliveryDate().plusDays(1));
        // Reset
        resetAll();
        // Expectations
        expect(currencyHolidayService.getCurrencyHolidays(anyString(), anyInt())).andReturn(new ArrayList<>()).times(2);
        // Replay
        replayAll();

        // Run test scenario
        final ValidationResult validationResult = optionTradeValidationService.validateTrade(optionTradeDto);
        // Verify
        Assert.assertFalse(validationResult.isValid());
        Assert.assertEquals(validationResult.getValidationErrorCodeList().size(), 1);
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_EXPIRY_DATE));

        verifyAll();
    }

    @Test
    public void testValidateTradeWhenInvalidPremiumDate() throws Exception {
        // Test data
        final OptionTradeDto optionTradeDto = getHelper().createOptionTradeDto();
        optionTradeDto.setPremiumDate(optionTradeDto.getDeliveryDate().plusDays(1));
        // Reset
        resetAll();
        // Expectations
        expect(currencyHolidayService.getCurrencyHolidays(anyString(), anyInt())).andReturn(new ArrayList<>()).times(2);
        // Replay
        replayAll();

        // Run test scenario
        final ValidationResult validationResult = optionTradeValidationService.validateTrade(optionTradeDto);
        // Verify
        Assert.assertFalse(validationResult.isValid());
        Assert.assertEquals(validationResult.getValidationErrorCodeList().size(), 1);
        Assert.assertTrue(validationResult.getValidationErrorCodeList().contains(ErrorEnum.INVALID_PREMIUM_DATE));

        verifyAll();
    }

    @Test
    public void testValidateTradeWhenValid() throws Exception {
        // Test data
        final OptionTradeDto optionTradeDto = getHelper().createOptionTradeDto();
        // Reset
        resetAll();
        // Expectations
        expect(currencyHolidayService.getCurrencyHolidays(anyString(), anyInt())).andReturn(new ArrayList<>()).times(2);
        // Replay
        replayAll();

        // Run test scenario
        final ValidationResult validationResult = optionTradeValidationService.validateTrade(optionTradeDto);
        // Verify
        Assert.assertTrue(validationResult.isValid());

        verifyAll();
    }
}
