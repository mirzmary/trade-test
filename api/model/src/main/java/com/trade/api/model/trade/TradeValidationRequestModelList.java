package com.trade.api.model.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trade.api.model.common.RequestModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class TradeValidationRequestModelList extends RequestModel {

    private static final long serialVersionUID = 1420526269482416966L;

    @JsonProperty("list")
    private List<TradeValidationRequestModel> tradeValidationRequestModelList;

    public List<TradeValidationRequestModel> getTradeValidationRequestModelList() {
        return tradeValidationRequestModelList;
    }

    public void setTradeValidationRequestModelList(final List<TradeValidationRequestModel> tradeValidationRequestModelList) {
        this.tradeValidationRequestModelList = tradeValidationRequestModelList;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        TradeValidationRequestModelList rhs = (TradeValidationRequestModelList) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.tradeValidationRequestModelList, rhs.tradeValidationRequestModelList)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(tradeValidationRequestModelList)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("tradeValidationRequestModelList", tradeValidationRequestModelList)
                .toString();
    }
}
