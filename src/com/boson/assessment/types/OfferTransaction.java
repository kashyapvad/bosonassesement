package com.boson.assessment.types;

import com.boson.assessment.Constants;
import com.boson.assessment.transactions.TradeTransactionImpl;
import com.boson.assessment.transactions.Transaction;
import com.boson.assessment.users.User;
import com.boson.assessment.users.UserManager;

public class OfferTransaction implements Type {
    public void processTransaction(Transaction transaction) {
        String userId = transaction.getMakerId();
        if (transaction.getStringType() == Constants.TRADE_KIND.Offer.toString()) {
            if (UserManager.getInstance().getIdSet().contains(userId)) {
                String itemId = ((TradeTransactionImpl) transaction).getItemId();
                UserManager.getInstance().getUser(userId).addItem(itemId);
            } else {
                String itemId = ((TradeTransactionImpl) transaction).getItemId();
                User seller = UserManager.getInstance().addUser(userId, 0f, "Seller");
                seller.addItem(itemId);
            }
        }
    }
}
