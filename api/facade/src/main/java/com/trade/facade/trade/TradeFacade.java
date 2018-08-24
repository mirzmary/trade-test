package com.trade.facade.trade;

import com.trade.api.model.common.ResponseListModel;
import com.trade.api.model.trade.TradeValidationRequestModelList;
import com.trade.api.model.trade.TradeValidationResponseModel;

public interface TradeFacade {

    ResponseListModel<TradeValidationResponseModel> validateTradeList(final TradeValidationRequestModelList tradeValidationRequestModelList);

}
