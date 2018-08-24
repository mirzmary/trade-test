package com.trade.crosscutting.currencyholiday;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.trade.crosscutting.serialization.LocalDateDeserializer;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.time.LocalDate;

public class CurrencyHolidayResponseModel implements Serializable {

    private static final long serialVersionUID = 4246826061811178495L;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("localName")
    private String localName;

    @JsonProperty("name")
    private String name;

    @JsonProperty("countryCode")
    private String countryCode;

    @JsonProperty("fixed")
    private Boolean fixed;

    @JsonProperty("countyOfficialHoliday")
    private Boolean countyOfficialHoliday;

    @JsonProperty("countyAdministrationHoliday")
    private Boolean countyAdministrationHoliday;

    @JsonProperty("global")
    private Boolean global;

    @JsonProperty("counties")
    private String countries;

    @JsonProperty("launchYear")
    private Integer launchYear;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(final String localName) {
        this.localName = localName;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    public Boolean getFixed() {
        return fixed;
    }

    public void setFixed(final Boolean fixed) {
        this.fixed = fixed;
    }

    public Boolean getCountyOfficialHoliday() {
        return countyOfficialHoliday;
    }

    public void setCountyOfficialHoliday(final Boolean countyOfficialHoliday) {
        this.countyOfficialHoliday = countyOfficialHoliday;
    }

    public Boolean getCountyAdministrationHoliday() {
        return countyAdministrationHoliday;
    }

    public void setCountyAdministrationHoliday(final Boolean countyAdministrationHoliday) {
        this.countyAdministrationHoliday = countyAdministrationHoliday;
    }

    public Boolean getGlobal() {
        return global;
    }

    public void setGlobal(final Boolean global) {
        this.global = global;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(final String countries) {
        this.countries = countries;
    }

    public Integer getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(final Integer launchYear) {
        this.launchYear = launchYear;
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
        final CurrencyHolidayResponseModel rhs = (CurrencyHolidayResponseModel) obj;
        return new EqualsBuilder()
                .append(this.date, rhs.date)
                .append(this.localName, rhs.localName)
                .append(this.name, rhs.name)
                .append(this.countryCode, rhs.countryCode)
                .append(this.fixed, rhs.fixed)
                .append(this.countyOfficialHoliday, rhs.countyOfficialHoliday)
                .append(this.countyAdministrationHoliday, rhs.countyAdministrationHoliday)
                .append(this.global, rhs.global)
                .append(this.countries, rhs.countries)
                .append(this.launchYear, rhs.launchYear)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(date)
                .append(localName)
                .append(name)
                .append(countryCode)
                .append(fixed)
                .append(countyOfficialHoliday)
                .append(countyAdministrationHoliday)
                .append(global)
                .append(countries)
                .append(launchYear)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("date", date)
                .append("localName", localName)
                .append("name", name)
                .append("countryCode", countryCode)
                .append("fixed", fixed)
                .append("countyOfficialHoliday", countyOfficialHoliday)
                .append("countyAdministrationHoliday", countyAdministrationHoliday)
                .append("global", global)
                .append("countries", countries)
                .append("launchYear", launchYear)
                .toString();
    }
}
