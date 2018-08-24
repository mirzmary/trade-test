package com.trade.service.common.validationcomponent;

import com.trade.service.common.AbstractServiceImplTest;
import com.trade.service.common.validationcomponent.impl.CommonValidationComponentImpl;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class CommonValidationComponentImplTest extends AbstractServiceImplTest {

    @TestSubject
    private CommonValidationComponent commonValidationComponent = new CommonValidationComponentImpl();

    // region validateString

    @Test
    public void testValidateStringWhenNull() throws Exception {
        // Test data
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateString(null);
        // Verify
        Assert.assertFalse(result);
        verifyAll();
    }

    // endregion

    // region validateAmount

    @Test
    public void testValidateAmountWhenNull() throws Exception {
        // Test data
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateAmount(null);
        // Verify
        Assert.assertFalse(result);
        verifyAll();
    }

    @Test
    public void testValidateAmountWhenNegative() throws Exception {
        // Test data
        final BigDecimal amount = BigDecimal.valueOf(-1000);
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateAmount(amount);
        // Verify
        Assert.assertFalse(result);
        verifyAll();
    }

    @Test
    public void testValidateAmountWhenZero() throws Exception {
        // Test data
        final BigDecimal amount = BigDecimal.ZERO;
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateAmount(amount);
        // Verify
        Assert.assertFalse(result);
        verifyAll();
    }

    @Test
    public void testValidateAmountWhenPositive() throws Exception {
        // Test data
        final BigDecimal amount = BigDecimal.valueOf(8560);
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateAmount(amount);
        // Verify
        Assert.assertTrue(result);
        verifyAll();
    }

    // endregion

    // region validateDateAfter
    @Test
    public void testValidateDateAfterWithNullFirstDate() throws Exception {
        // Test data
        final LocalDate firstDate = null;
        final LocalDate lastDate = LocalDate.now();
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateDateAfter(firstDate, lastDate);

        // Verify
        Assert.assertFalse(result);
        verifyAll();
    }

    @Test
    public void testValidateDateAfterWithNullLastDate() throws Exception {
        // Test data
        final LocalDate firstDate = LocalDate.now();
        final LocalDate lastDate = null;
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateDateAfter(firstDate, lastDate);

        // Verify
        Assert.assertFalse(result);
        verifyAll();
    }

    @Test
    public void testValidateDateAfterFirstDateAfterLastDate() throws Exception {
        // Test data
        final LocalDate firstDate = LocalDate.now();
        final LocalDate lastDate = LocalDate.now().minusDays(1);
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateDateAfter(firstDate, lastDate);

        // Verify
        Assert.assertFalse(result);
        verifyAll();
    }

    @Test
    public void testValidateDateAfterFirstDateBeforeLastDate() throws Exception {
        // Test data
        final LocalDate firstDate = LocalDate.now().minusDays(1);
        final LocalDate lastDate = LocalDate.now();
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateDateAfter(firstDate, lastDate);

        // Verify
        Assert.assertTrue(result);
        verifyAll();
    }

    // endregion

    // region validateDateBetween

    @Test
    public void testValidateDateBetweenWithNullDate() throws Exception {
        // Test data
        final LocalDate date = null;
        final LocalDate firstDate = LocalDate.now();
        final LocalDate lastDate = LocalDate.now();
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateDateBetween(date, firstDate, lastDate);

        // Verify
        Assert.assertFalse(result);
        verifyAll();
    }

    @Test
    public void testValidateDateBetweenWithNullFirstDate() throws Exception {
        // Test data
        final LocalDate date = LocalDate.now();
        final LocalDate firstDate = null;
        final LocalDate lastDate = LocalDate.now();
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateDateBetween(date, firstDate, lastDate);

        // Verify
        Assert.assertFalse(result);
        verifyAll();
    }

    @Test
    public void testValidateDateBetweenWithNullLastDate() throws Exception {
        // Test data
        final LocalDate date = LocalDate.now();
        final LocalDate firstDate = LocalDate.now();
        final LocalDate lastDate = null;
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateDateBetween(date, firstDate, lastDate);

        // Verify
        Assert.assertFalse(result);
        verifyAll();
    }

    @Test
    public void testValidateDateBetweenDateAfterLastDate() throws Exception {
        // Test data
        final LocalDate date = LocalDate.now();
        final LocalDate firstDate = LocalDate.now().minusDays(2);
        final LocalDate lastDate = LocalDate.now().minusDays(1);
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateDateBetween(date, firstDate, lastDate);

        // Verify
        Assert.assertFalse(result);
        verifyAll();
    }

    @Test
    public void testValidateDateBetweenFirstDateBeforeFirstDate() throws Exception {
        // Test data
        final LocalDate date = LocalDate.now();
        final LocalDate firstDate = LocalDate.now().plusDays(1);
        final LocalDate lastDate = LocalDate.now().plusDays(2);
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateDateBetween(date, firstDate, lastDate);

        // Verify
        Assert.assertFalse(result);
        verifyAll();
    }

    @Test
    public void testValidateDateBetweenFirstDateAfterFirstDateAndBeforeLastDate() throws Exception {
        // Test data
        final LocalDate date = LocalDate.now();
        final LocalDate firstDate = LocalDate.now().minusDays(1);
        final LocalDate lastDate = LocalDate.now().plusDays(2);
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateDateBetween(date, firstDate, lastDate);

        // Verify
        Assert.assertTrue(result);
        verifyAll();
    }

    // endregion

    // region validateWeekday

    @Test
    public void testValidateWeekdayNull() throws Exception {
        // Test data
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateWeekday(null);
        // Verify
        Assert.assertFalse(result);
        verifyAll();
    }

    @Test
    public void testValidateWeekdaySunday() throws Exception {
        // Test data
        final LocalDate date = LocalDate.of(2018, 8, 19);
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateWeekday(date);
        // Verify
        Assert.assertFalse(result);
        verifyAll();
    }

    @Test
    public void testValidateWeekdaySaturday() throws Exception {
        // Test data
        final LocalDate date = LocalDate.of(2018, 8, 18);
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateWeekday(date);
        // Verify
        Assert.assertFalse(result);
        verifyAll();
    }

    @Test
    public void testValidateWeekdayFriday() throws Exception {
        // Test data
        final LocalDate date = LocalDate.of(2018, 8, 17);
        // Reset
        resetAll();
        // Expectations

        // Replay
        replayAll();

        // Run test scenario
        final boolean result = commonValidationComponent.validateWeekday(date);
        // Verify
        Assert.assertTrue(result);
        verifyAll();
    }

    // endregion
}
