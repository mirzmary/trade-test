package com.trade.service.trade;

import com.trade.crosscutting.common.ValidationResult;
import com.trade.service.common.validationcomponent.CommonValidationComponent;
import com.trade.service.trade.dto.OptionTradeDto;

public interface OptionTradeValidationService extends CommonValidationComponent {

    ValidationResult validateTrade(final OptionTradeDto optionTradeDto);
}
