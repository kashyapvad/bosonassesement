package com.boson.assessment.users;

import com.boson.assessment.exceptions.BadParameterException;
import com.boson.assessment.exceptions.NullParameterException;

import java.util.Map;

public class BuyerImpl implements User {

    private String id;
    private Account account;
    private Map<String, Integer> itemsBought;

    public String getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setItemsBought(Map<String, Integer> itemsBought) {
        this.itemsBought = itemsBought;
    }

    public void setAccount(Float balance) {
        this.account = new Account(id, balance);
    }

    public BuyerImpl(String id, Float balance, Map<String, Integer> itemsBought) {
        setId(id);
        setItemsBought(itemsBought);
        setAccount(balance);
    }

    public Float getBalance() {
        return account.getBalance();
    }

    public void addBalance(Float amount) {
        this.account.addBalance(amount);
    }

    public void removeBalance(Float amount) {
        this.account.removeBalance(amount);
    }

    public void addItem(String itemId) {
        if (itemsBought.keySet().contains(itemId)) {
            Integer count = itemsBought.get(itemId) + 1;
            itemsBought.put(itemId, count);
        } else {
            itemsBought.put(itemId, 0);
        }
    }

    public void removeItem(String itemId) {
        if (itemsBought.keySet().contains(itemId)) {
            Integer count = itemsBought.get(itemId) - 1;
            itemsBought.put(itemId, count);
        }
    }
}
