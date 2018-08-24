package com.trade.service.trade.dto;

import com.trade.service.common.dto.BaseDTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BaseTradeDto extends BaseDTO {

    private static final long serialVersionUID = 3058357677915156393L;

    private String customer;

    private String ccyPair;

    private String type;

    private String direction;

    private String legalEntity;

    private String trader;

    private BigDecimal amount1;

    private BigDecimal amount2;

    private BigDecimal rate;

    private LocalDate tradeDate;

    private LocalDate valueDate;

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
        final BaseTradeDto rhs = (BaseTradeDto) obj;
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
                .toString();
    }
}
