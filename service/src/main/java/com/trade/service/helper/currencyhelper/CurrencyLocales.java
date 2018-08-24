package com.trade.service.helper.currencyhelper;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;
import java.util.Locale;

public class CurrencyLocales {

    private String currency;

    private List<Locale> localeList;

    public String getCurrency() {
        return currency;
    }

    private CurrencyLocales(final String currency, final List<Locale> localeList) {
        this.currency = currency;
        this.localeList = localeList;
    }

    public static CurrencyLocales from(final String currency, final List<Locale> localeList) {
        return new CurrencyLocales(currency, localeList);
    }

    public void setCurrency(final String currency) {
        this.currency = currency;
    }

    public List<Locale> getLocaleList() {
        return localeList;
    }

    public void setLocaleList(final List<Locale> localeList) {
        this.localeList = localeList;
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
        CurrencyLocales rhs = (CurrencyLocales) obj;
        return new EqualsBuilder()
                .append(this.currency, rhs.currency)
                .append(this.localeList, rhs.localeList)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(currency)
                .append(localeList)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("currency", currency)
                .append("localeList", localeList)
                .toString();
    }
}