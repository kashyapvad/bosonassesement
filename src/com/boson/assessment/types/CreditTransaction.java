package com.boson.assessment.types;

import com.boson.assessment.Constants;
import com.boson.assessment.transactions.FinancialTransactionImpl;
import com.boson.assessment.transactions.Transaction;
import com.boson.assessment.users.UserManager;

public class CreditTransaction implements Type {
    public void processTransaction(Transaction transaction){
        String userId = transaction.getMakerId();
        if (transaction.getStringType() == Constants.FINANCIAL_KIND.Credit.toString()) {
            Float amount = ((FinancialTransactionImpl) transaction).getAmount();
            if (UserManager.getInstance().getIdSet().contains(userId)) {
                UserManager.getInstance().getUser(userId).addBalance(amount);
            } else {
                UserManager.getInstance().addUser(userId, amount, "Buyer");
            }
        }
    }
}
