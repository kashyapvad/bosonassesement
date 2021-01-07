package com.boson.assessment.items;


import com.boson.assessment.exceptions.BadParameterException;
import com.boson.assessment.exceptions.NullParameterException;

public class ItemFactory {

    public static Item itemBuilder(String id, Float price, String sellerId) throws NullParameterException, BadParameterException {

        ItemImpl item = new ItemImpl(id, price, sellerId);
        return item;

    }
}
