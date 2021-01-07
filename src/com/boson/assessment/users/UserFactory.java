package com.boson.assessment.users;


import com.boson.assessment.exceptions.BadParameterException;
import com.boson.assessment.exceptions.NullParameterException;

import java.util.HashMap;

public class UserFactory {

    public static User userBuilder(String id, Float balance, String type) throws NullParameterException, BadParameterException {
        User user = null;
        if (type.equals("Buyer")){
            user = new BuyerImpl(id, balance, new HashMap<>());
        } else if(type.equals("Seller")) {
            user = new SellerImpl(id, balance, new HashMap<>());
        }
        return user;
    }
}
