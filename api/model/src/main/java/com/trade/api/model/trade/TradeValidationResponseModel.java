package com.trade.api.model.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trade.api.model.common.FacadeModel;
import com.trade.crosscutting.common.ValidationResult;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class TradeValidationResponseModel extends FacadeModel {

    private static final long serialVersionUID = -6096237915102687308L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("validationResult")
    private ValidationResult validationResult;

    public TradeValidationResponseModel(final Long id, final ValidationResult validationResult) {
        this.id = id;
        this.validationResult = validationResult;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public ValidationResult getValidationResult() {
        return validationResult;
    }

    public void setValidationResult(final ValidationResult validationResult) {
        this.validationResult = validationResult;
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
        TradeValidationResponseModel rhs = (TradeValidationResponseModel) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.id, rhs.id)
                .append(this.validationResult, rhs.validationResult)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(id)
                .append(validationResult)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("id", id)
                .append("validationResult", validationResult)
                .toString();
    }
}
