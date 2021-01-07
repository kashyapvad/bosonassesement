package com.boson.assessment.transactions;

import com.boson.assessment.Constants;
import com.boson.assessment.exceptions.BadParameterException;
import com.boson.assessment.exceptions.NullParameterException;

public class FinancialTransactionImpl implements Transaction {

    private Integer id;
    private Constants.FINANCIAL_TYPE type;
    private Float amount;
    private String makerId;

    public FinancialTransactionImpl(Integer id, Float amount, String makerId, Constants.FINANCIAL_TYPE type) throws NullParameterException, BadParameterException {

        setId(id);
        setType(type);
        setMakerId(makerId);
        setAmount(amount);
    }

    public Integer getId() {
        return this.id;
    }

    public Float getAmount() {
        return this.amount;
    }

    public String getMakerId() {
        return this.makerId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setMakerId(String makerId) {
        this.makerId = makerId;
    }

    public void setType(Constants.FINANCIAL_TYPE type) {
        this.type = type;
    }

    public String getStringType(){
        return type.toString();
    }
}
