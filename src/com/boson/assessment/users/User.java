package com.boson.assessment.users;


public interface User {
    String getId();

    Float getBalance();

    void addBalance(Float balance);

    void removeBalance(Float balance);

    void addItem(String itemId);

    void removeItem(String itemId);
}
