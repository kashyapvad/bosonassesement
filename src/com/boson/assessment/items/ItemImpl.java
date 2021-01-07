package com.boson.assessment.items;

import com.boson.assessment.exceptions.BadParameterException;
import com.boson.assessment.exceptions.NullParameterException;

public class ItemImpl implements Item {

    private String id;
    private Float price;
    private String sellerId;

    public ItemImpl(String id, Float price, String sellerId) throws NullParameterException, BadParameterException {
        setId(id);
        setPrice(price);
        setSellerId(sellerId);
    }

    public void setId(String id) throws NullParameterException, BadParameterException {
        if (id == null) {
            throw new NullParameterException("Null value passed in for Item Name");
        }
        if (id.length() > 50) {
            throw new BadParameterException("Bad value passed in for Item Name: " + id);
        }
        this.id = id;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public void setPrice(Float price) throws NullParameterException, BadParameterException {
        if (price == null) {
            throw new NullParameterException("Null value passed in for price");
        }
        if (price > Integer.MAX_VALUE || price.getClass() != Float.class) {
            throw new BadParameterException("Bad value passed in for the value of price: " + price);
        }
        this.price = price;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getId() {
        return id;
    }

    public Float getPrice() {
        return price;
    }
}
