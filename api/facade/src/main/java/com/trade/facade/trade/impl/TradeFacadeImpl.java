package com.trade.facade.trade.impl;

import com.trade.api.model.common.ResponseListModel;
import com.trade.api.model.trade.TradeValidationRequestModel;
import com.trade.api.model.trade.TradeValidationRequestModelList;
import com.trade.api.model.trade.TradeValidationResponseModel;
import com.trade.facade.trade.TradeFacade;
import com.trade.service.trade.BaseTradeValidationService;
import com.trade.service.trade.OptionTradeValidationService;
import com.trade.service.trade.dto.BaseTradeDto;
import com.trade.service.trade.dto.OptionTradeDto;
import com.trade.service.trade.enums.Style;
import com.trade.service.trade.enums.Type;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class TradeFacadeImpl implements TradeFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeFacadeImpl.class);

    @Autowired
    @Qualifier("baseTradeValidationServiceImpl")
    private BaseTradeValidationService baseTradeValidationService;

    @Autowired
    @Qualifier("optionTradeValidationServiceImpl")
    private OptionTradeValidationService optionTradeValidationService;

    @Autowired
    private MapperFacade mapperFacade;

    @Override
    public ResponseListModel<TradeValidationResponseModel> validateTradeList(final TradeValidationRequestModelList tradeValidationRequestModelList) {
        Assert.notNull(tradeValidationRequestModelList, "tradeValidationRequestModelList can not be null when validating trade list");
        Assert.notNull(tradeValidationRequestModelList.getTradeValidationRequestModelList(), "tradeValidationRequestModelList models can not be null when validating trade list");
        Assert.isTrue(!tradeValidationRequestModelList.getTradeValidationRequestModelList().isEmpty(), "tradeValidationRequestModelList models can not be empty when validating trade list");
        final List<TradeValidationResponseModel> validationList = Collections.synchronizedList(new ArrayList<>());
        final AtomicLong i = new AtomicLong(0L);
        for (TradeValidationRequestModel model : tradeValidationRequestModelList.getTradeValidationRequestModelList()) {
            if (model.getType().equals(Type.VanillaOption.name())) {
                final OptionTradeDto optionTradeDto = mapperFacade.map(model, OptionTradeDto.class);
                optionTradeDto.setValueDate(model.getStyle().equals(Style.AMERICAN.name()) ? model.getExerciseStartDate() : model.getExpiryDate());
                validationList.add(new TradeValidationResponseModel(i.get(), optionTradeValidationService.validateTrade(optionTradeDto)));
            } else {
                validationList.add(new TradeValidationResponseModel(i.get(), baseTradeValidationService.validateTrade(mapperFacade.map(model, BaseTradeDto.class))));
            }
            i.incrementAndGet();
        }
        return new ResponseListModel<>(validationList);
    }


}
