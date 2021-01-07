package com.boson.assessment.users;

public class Account {
    private Float balance;
    private String ownerId;

    public String getOwnerId() {
        return ownerId;
    }

    public Float getBalance() {
        return balance;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Account(String ownerId, Float balance) {
        setOwnerId(ownerId);
        setBalance(balance);
    }

    public void addBalance(Float amount){
        Float balance = this.getBalance() + amount;
        setBalance(balance);
    }

    public void removeBalance(Float amount){
        Float balance = this.getBalance() - amount;
        setBalance(balance);
    }
}
