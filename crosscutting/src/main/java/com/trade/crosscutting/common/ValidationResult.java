package com.trade.crosscutting.common;

import com.trade.crosscutting.common.enums.ErrorEnum;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    private boolean valid;

    private List<ErrorEnum> validationErrorCodeList;

    private List<String> validationErrorMessageList;

    public ValidationResult(){
        // Empty constructor
        valid = true;
        validationErrorCodeList = new ArrayList<>();
        validationErrorMessageList = new ArrayList<>();
    }

    public ValidationResult(final boolean valid){
        this.valid = valid;
        validationErrorCodeList = new ArrayList<>();
        validationErrorMessageList = new ArrayList<>();
    }

    public void put(final ErrorEnum code, final String message){
        this.valid = false;
        this.validationErrorCodeList.add(code);
        this.validationErrorMessageList.add(message);
    }

    public void put(final List<ErrorEnum> apiErrorCodes){
        this.valid = false;
        this.validationErrorCodeList.addAll(apiErrorCodes);
    }

    public void merge(final ValidationResult validationResult){
        if(!validationResult.valid){
            for(int i = 0; i < validationResult.validationErrorCodeList.size(); i++) {
                this.put(validationResult.validationErrorCodeList.get(i), validationResult.validationErrorMessageList.get(i));
            }
        }
    }

    public boolean isValid(){
        return valid;
    }

    public void setValid(boolean valid){
        this.valid = valid;
    }

    public List<ErrorEnum> getValidationErrorCodeList(){
        return validationErrorCodeList;
    }

    public void setValidationErrorCodeList(List<ErrorEnum> validationErrorCodeList){
        this.validationErrorCodeList = validationErrorCodeList;
    }

    public List<String> getValidationErrorMessageList(){
        return validationErrorMessageList;
    }

    public void setValidationErrorMessageList(List<String> validationErrorMessageList){
        this.validationErrorMessageList = validationErrorMessageList;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj == this){
            return true;
        }
        if(obj.getClass() != getClass()){
            return false;
        }
        ValidationResult rhs = (ValidationResult) obj;
        return new EqualsBuilder()
                .append(this.valid, rhs.valid)
                .append(this.validationErrorCodeList, rhs.validationErrorCodeList)
                .append(this.validationErrorMessageList, rhs.validationErrorMessageList)
                .isEquals();
    }

    @Override
    public int hashCode(){
        return new HashCodeBuilder()
                .append(valid)
                .append(validationErrorCodeList)
                .append(validationErrorMessageList)
                .toHashCode();
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("valid", valid)
                .append("validationErrorCodeList", validationErrorCodeList)
                .append("validationErrorMessageList", validationErrorMessageList)
                .toString();
    }
}
