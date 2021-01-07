package com.boson.assessment.types;

import com.boson.assessment.Constants;
import com.boson.assessment.items.ItemCatalog;
import com.boson.assessment.transactions.TradeTransactionImpl;
import com.boson.assessment.transactions.Transaction;
import com.boson.assessment.users.EscrowManager;
import com.boson.assessment.users.User;
import com.boson.assessment.users.UserManager;

public class OrderTransaction implements Type {
    public void processTransaction(Transaction transaction) {
        String userId = transaction.getMakerId();
        if (transaction.getStringType() == Constants.TRADE_KIND.Order.toString()) {
            String itemId = ((TradeTransactionImpl) transaction).getItemId();
            User buyer = UserManager.getInstance().getUser(userId);
            EscrowManager.getInstance().transferToEscrow(buyer, ItemCatalog.getInstance().getPrice(itemId));
        }
    }
}
