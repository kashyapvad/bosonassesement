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

    public void setId(Integer id) throws NullParameterException {
        if (id == null) {
            throw new NullParameterException("Null value passed in for Item Name");
        }
        this.id = id;
    }

    public void setAmount(Float amount) throws NullParameterException {
        if (amount == null) {
            throw new NullParameterException("Null value passed in for Item Name");
        }
        this.amount = amount;
    }

    public void setMakerId(String makerId) throws NullParameterException {
        if (makerId == null) {
            throw new NullParameterException("Null value passed in for Item Name");
        }
        this.makerId = makerId;
    }

    public void setType(Constants.FINANCIAL_TYPE type) throws NullParameterException, BadParameterException {
        if (type == null) {
            throw new NullParameterException("Null value passed in for Item Name");
        }
        if(!Constants.isFinancial(type.toString())) {
            throw new BadParameterException("Bad value passed in for Item Name: " + id);
        }
        this.type = type;
    }

    public String getStringType(){
        return type.toString();
    }
}
