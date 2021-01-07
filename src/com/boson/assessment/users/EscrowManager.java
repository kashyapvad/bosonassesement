package com.boson.assessment.users;

import com.boson.assessment.exceptions.BadParameterException;
import com.boson.assessment.exceptions.NullParameterException;

public class EscrowManager {
    private Float balance = 0f;
    private static EscrowManager ourInstance;

    static {
        try {
            ourInstance = new EscrowManager();
        } catch (NullParameterException e) {
            e.printStackTrace();
        } catch (BadParameterException e) {
            e.printStackTrace();
        }
    }

    public static EscrowManager getInstance() {
        return ourInstance;
    }

    private EscrowManager() throws NullParameterException, BadParameterException {
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public void transferToEscrow(User buyer, Float amount) {
        buyer.removeBalance(amount);
        setBalance(balance + amount);
    }

    public void transferToBuyer(String buyerId, Float amount) {
        setBalance(getBalance() - amount);
        UserManager.getInstance().addBalance(buyerId, amount);
    }

    public void transferToSeller(String sellerId, Float amount) {
        setBalance(getBalance() - amount);
        UserManager.getInstance().addBalance(sellerId, amount);
    }
}
