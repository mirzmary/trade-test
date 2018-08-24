package com.trade.service.helper.currencyhelper;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Locale;

public class LocaleCurrency {

    private Locale locale;

    private String currency;

    private LocaleCurrency(final Locale locale, final String currency) {
        this.locale = locale;
        this.currency = currency;
    }

    public static LocaleCurrency from(final Locale locale, final String currency) {
        return new LocaleCurrency(locale, currency);
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(final Locale locale) {
        this.locale = locale;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(final String currency) {
        this.currency = currency;
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
        LocaleCurrency rhs = (LocaleCurrency) obj;
        return new EqualsBuilder()
                .append(this.locale, rhs.locale)
                .append(this.currency, rhs.currency)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(locale)
                .append(currency)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("locale", locale)
                .append("currency", currency)
                .toString();
    }
}
