package com.trade.facade.trade;

import com.trade.api.model.common.ResponseListModel;
import com.trade.api.model.trade.TradeValidationRequestModel;
import com.trade.api.model.trade.TradeValidationResponseModel;

import java.util.List;

public interface TradeFacade {

    ResponseListModel<TradeValidationResponseModel> validateTradeList(final List<TradeValidationRequestModel> tradeValidationRequestModelList);

}
