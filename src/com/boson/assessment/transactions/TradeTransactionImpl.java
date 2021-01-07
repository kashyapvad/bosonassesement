package com.boson.assessment.transactions;

import com.boson.assessment.Constants;
import com.boson.assessment.exceptions.BadParameterException;
import com.boson.assessment.exceptions.NullParameterException;

public class TradeTransactionImpl implements Transaction {

    private Integer id;
    private Constants.TRADE_KIND type;
    private String makerId;
    private String itemId;

    public TradeTransactionImpl(Integer id, String makerId, Constants.TRADE_KIND type, String itemId) throws NullParameterException, BadParameterException {
        setId(id);
        setType(type);
        setMakerId(makerId);
        setItemId(itemId);
    }

    public String getItemId() {
        return itemId;
    }

    public Integer getId() {
        return this.id;
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

    public void setItemId(String itemId) throws NullParameterException {
        if (itemId == null) {
            throw new NullParameterException("Null value passed in for Item Name");
        }
        this.itemId = itemId;
    }

    public void setMakerId(String makerId) throws NullParameterException {
        if (makerId == null) {
            throw new NullParameterException("Null value passed in for Item Name");
        }
        this.makerId = makerId;
    }

    public void setType(Constants.TRADE_KIND type) throws NullParameterException, BadParameterException {
        if (type == null) {
            throw new NullParameterException("Null value passed in for Item Name");
        }
        if (!Constants.isTrade(type.toString())) {
            throw new BadParameterException("Bad value passed in for Item Name: " + id);
        }
        this.type = type;
    }

    public String getStringType() {
        return type.toString();
    }
}
