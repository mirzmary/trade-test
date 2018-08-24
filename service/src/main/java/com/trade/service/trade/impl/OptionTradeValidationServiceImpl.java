package com.trade.service.trade.impl;

import com.trade.crosscutting.common.ValidationResult;
import com.trade.crosscutting.common.enums.ErrorEnum;
import com.trade.service.trade.dto.OptionTradeDto;
import com.trade.service.trade.enums.Strategy;
import com.trade.service.trade.enums.Style;
import com.trade.service.trade.OptionTradeValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("optionTradeValidationServiceImpl")
public class OptionTradeValidationServiceImpl extends BaseTradeValidationServiceImpl implements OptionTradeValidationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OptionTradeValidationServiceImpl.class);

    @Override
    public ValidationResult validateTrade(final OptionTradeDto optionTradeDto) {
        final ValidationResult validationResult = super.validateTrade(optionTradeDto);
        if (!Style.contains(optionTradeDto.getStyle())) {
            LOGGER.info("Invalid Style - {}", optionTradeDto.getStyle());
            validationResult.put(ErrorEnum.INVALID_STYLE, String.format("Invalid Style - %s ", optionTradeDto.getStyle()));
        }
        else if(Style.AMERICAN.name().equals(optionTradeDto.getStyle())) {
            if (!validateDateBetween(optionTradeDto.getExerciseStartDate(), optionTradeDto.getTradeDate(), optionTradeDto.getExpiryDate())) {
                LOGGER.info("Exercise start date - {} should be between Trade date - {} and Expiry date - {}", optionTradeDto.getExerciseStartDate(), optionTradeDto.getTradeDate(), optionTradeDto.getExpiryDate());
                validationResult.put(ErrorEnum.INVALID_PREMIUM_DATE, String.format("Exercise start date - %s should be between Trade date - %s and Expiry date - %s", optionTradeDto.getExerciseStartDate(), optionTradeDto.getTradeDate(), optionTradeDto.getExpiryDate()));
            }
        }
        if (!Strategy.contains(optionTradeDto.getStrategy())) {
            LOGGER.info("Invalid Strategy - {}", optionTradeDto.getStrategy());
            validationResult.put(ErrorEnum.INVALID_STRATEGY, String.format("Invalid Strategy - %s ", optionTradeDto.getStrategy()));
        }
        if (!validateDateAfter(optionTradeDto.getExpiryDate(), optionTradeDto.getDeliveryDate())) {
            LOGGER.info("Expiry date - {} should be before delivery date - {}", optionTradeDto.getExpiryDate(), optionTradeDto.getDeliveryDate());
            validationResult.put(ErrorEnum.INVALID_EXPIRY_DATE, String.format("Expiry date - %s should be before delivery date - %s", optionTradeDto.getExpiryDate(), optionTradeDto.getDeliveryDate()));
        }
        if (!validateDateAfter(optionTradeDto.getPremiumDate(), optionTradeDto.getDeliveryDate())) {
            LOGGER.info("Premium date - {} should be before delivery date - {}", optionTradeDto.getPremiumDate(), optionTradeDto.getDeliveryDate());
            validationResult.put(ErrorEnum.INVALID_PREMIUM_DATE, String.format("Premium date - %s should be before delivery date - %s", optionTradeDto.getPremiumDate(), optionTradeDto.getDeliveryDate()));
        }
        return validationResult;
    }
}
