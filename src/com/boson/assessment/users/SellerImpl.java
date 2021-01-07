package com.boson.assessment.users;

import java.util.Map;

public class SellerImpl implements User {

    private String id;
    private Account account;
    private Map<String, Integer> itemsToSell;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setItemsToSell(Map<String, Integer> itemsToSell) {
        this.itemsToSell = itemsToSell;
    }

    public void setAccount(Float balance) {
        this.account = new Account(id, balance);
    }

    public SellerImpl(String id, Float balance, Map<String, Integer> itemsToSell) {
        setId(id);
        setItemsToSell(itemsToSell);
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
        if (itemsToSell.keySet().contains(itemId)) {
            Integer count = itemsToSell.get(itemId) + 1;
            itemsToSell.put(itemId, count);
        } else
            itemsToSell.put(itemId, 0);
    }

    public void removeItem(String itemId) {
        if (itemsToSell.keySet().contains(itemId)) {
            Integer count = itemsToSell.get(itemId) - 1;
            itemsToSell.put(itemId, count);
        }
    }
}
