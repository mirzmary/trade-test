package com.trade.service.trade.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OptionTradeDto extends BaseTradeDto {

    private static final long serialVersionUID = -5348971113381862697L;

    private String style;

    private String strategy;

    private String payCcy;

    private String premiumCcy;

    private String premiumType;

    private LocalDate deliveryDate;

    private LocalDate expiryDate;

    private LocalDate exerciseStartDate;

    private LocalDate premiumDate;

    private BigDecimal premium;

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
        OptionTradeDto rhs = (OptionTradeDto) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
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
