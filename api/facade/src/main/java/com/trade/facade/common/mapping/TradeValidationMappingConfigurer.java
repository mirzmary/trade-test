package com.trade.facade.common.mapping;

import com.trade.api.model.trade.TradeValidationRequestModel;
import com.trade.service.trade.dto.BaseTradeDto;
import com.trade.service.trade.dto.OptionTradeDto;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class TradeValidationMappingConfigurer implements MappingConfigurer {

    @Override
    public void configure(final MapperFactory factory) {
            factory.classMap(TradeValidationRequestModel.class, BaseTradeDto.class)
                    .byDefault()
                    .register();
        factory.classMap(TradeValidationRequestModel.class, OptionTradeDto.class)
                .byDefault()
                .register();
    }
}
