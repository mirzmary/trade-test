package com.trade.persistence.currency.entity;

import com.trade.persistence.common.entity.AbstractDomainEntityModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class Currency extends AbstractDomainEntityModel {

    private static final long serialVersionUID = -7043837632474452354L;

    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    private String name;

    @Column(name = "Number")
    private int number;

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(final int number) {
        this.number = number;
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
        Currency rhs = (Currency) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.code, rhs.code)
                .append(this.name, rhs.name)
                .append(this.number, rhs.number)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(code)
                .append(name)
                .append(number)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("code", code)
                .append("name", name)
                .append("number", number)
                .toString();
    }
}


