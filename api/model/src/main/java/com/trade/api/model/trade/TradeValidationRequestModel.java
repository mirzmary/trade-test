package com.trade.api.model.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trade.api.model.common.RequestModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TradeValidationRequestModel extends RequestModel {

    private static final long serialVersionUID = -1603625220237178044L;

    @JsonProperty("customer")
    private String customer;

    @JsonProperty("ccyPair")
    private String ccyPair;

    @JsonProperty("type")
    private String type;

    @JsonProperty("direction")
    private String direction;

    @JsonProperty("legalEntity")
    private String legalEntity;

    @JsonProperty("trader")
    private String trader;

    @JsonProperty("amount1")
    private BigDecimal amount1;

    @JsonProperty("amount2")
    private BigDecimal amount2;

    @JsonProperty("rate")
    private BigDecimal rate;

    @JsonProperty("tradeDate")
    private LocalDate tradeDate;

    @JsonProperty("valueDate")
    private LocalDate valueDate;

    @JsonProperty("style")
    private String style;

    @JsonProperty("strategy")
    private String strategy;

    @JsonProperty("payCcy")
    private String payCcy;

    @JsonProperty("premiumCcy")
    private String premiumCcy;

    @JsonProperty("premiumType")
    private String premiumType;

    @JsonProperty("deliveryDate")
    private LocalDate deliveryDate;

    @JsonProperty("expiryDate")
    private LocalDate expiryDate;

    @JsonProperty("excerciseStartDate")
    private LocalDate exerciseStartDate;

    @JsonProperty("premiumDate")
    private LocalDate premiumDate;

    @JsonProperty("premium")
    private BigDecimal premium;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(final String customer) {
        this.customer = customer;
    }

    public String getCcyPair() {
        return ccyPair;
    }

    public void setCcyPair(final String ccyPair) {
        this.ccyPair = ccyPair;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(final String direction) {
        this.direction = direction;
    }

    public String getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(final String legalEntity) {
        this.legalEntity = legalEntity;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(final String trader) {
        this.trader = trader;
    }

    public BigDecimal getAmount1() {
        return amount1;
    }

    public void setAmount1(final BigDecimal amount1) {
        this.amount1 = amount1;
    }

    public BigDecimal getAmount2() {
        return amount2;
    }

    public void setAmount2(final BigDecimal amount2) {
        this.amount2 = amount2;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(final BigDecimal rate) {
        this.rate = rate;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(final LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(final LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(final String style) {
        this.style = style;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(final String strategy) {
        this.strategy = strategy;
    }

    public String getPayCcy() {
        return payCcy;
    }

    public void setPayCcy(final String payCcy) {
        this.payCcy = payCcy;
    }

    public String getPremiumCcy() {
        return premiumCcy;
    }

    public void setPremiumCcy(final String premiumCcy) {
        this.premiumCcy = premiumCcy;
    }

    public String getPremiumType() {
        return premiumType;
    }

    public void setPremiumType(final String premiumType) {
        this.premiumType = premiumType;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(final LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(final LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getExerciseStartDate() {
        return exerciseStartDate;
    }

    public void setExerciseStartDate(final LocalDate exerciseStartDate) {
        this.exerciseStartDate = exerciseStartDate;
    }

    public LocalDate getPremiumDate() {
        return premiumDate;
    }

    public void setPremiumDate(final LocalDate premiumDate) {
        this.premiumDate = premiumDate;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(final BigDecimal premium) {
        this.premium = premium;
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
        TradeValidationRequestModel rhs = (TradeValidationRequestModel) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.customer, rhs.customer)
                .append(this.ccyPair, rhs.ccyPair)
                .append(this.type, rhs.type)
                .append(this.direction, rhs.direction)
                .append(this.legalEntity, rhs.legalEntity)
                .append(this.trader, rhs.trader)
                .append(this.amount1, rhs.amount1)
                .append(this.amount2, rhs.amount2)
                .append(this.rate, rhs.rate)
                .append(this.tradeDate, rhs.tradeDate)
                .append(this.valueDate, rhs.valueDate)
                .append(this.style, rhs.style)
                .append(this.strategy, rhs.strategy)
                .append(this.payCcy, rhs.payCcy)
                .append(this.premiumCcy, rhs.premiumCcy)
                .append(this.premiumType, rhs.premiumType)
                .append(this.deliveryDate, rhs.deliveryDate)
                .append(this.expiryDate, rhs.expiryDate)
                .append(this.exerciseStartDate, rhs.exerciseStartDate)
                .append(this.premiumDate, rhs.premiumDate)
                .append(this.premium, rhs.premium)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(customer)
                .append(ccyPair)
                .append(type)
                .append(direction)
                .append(legalEntity)
                .append(trader)
                .append(amount1)
                .append(amount2)
                .append(rate)
                .append(tradeDate)
                .append(valueDate)
                .append(style)
                .append(strategy)
                .append(payCcy)
                .append(premiumCcy)
                .append(premiumType)
                .append(deliveryDate)
                .append(expiryDate)
                .append(exerciseStartDate)
                .append(premiumDate)
                .append(premium)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("customer", customer)
                .append("ccyPair", ccyPair)
                .append("type", type)
                .append("direction", direction)
                .append("legalEntity", legalEntity)
                .append("trader", trader)
                .append("amount1", amount1)
                .append("amount2", amount2)
                .append("rate", rate)
                .append("tradeDate", tradeDate)
                .append("valueDate", valueDate)
                .append("style", style)
                .append("strategy", strategy)
                .append("payCcy", payCcy)
                .append("premiumCcy", premiumCcy)
                .append("premiumType", premiumType)
                .append("deliveryDate", deliveryDate)
                .append("expiryDate", expiryDate)
                .append("exerciseStartDate", exerciseStartDate)
                .append("premiumDate", premiumDate)
                .append("premium", premium)
                .toString();
    }
}
