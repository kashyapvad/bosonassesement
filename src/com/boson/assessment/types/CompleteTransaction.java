package com.boson.assessment.types;

import com.boson.assessment.Constants;
import com.boson.assessment.items.ItemCatalog;
import com.boson.assessment.transactions.TradeTransactionImpl;
import com.boson.assessment.transactions.Transaction;
import com.boson.assessment.users.EscrowManager;
import com.boson.assessment.users.UserManager;

public class CompleteTransaction implements Type {
    public void processTransaction(Transaction transaction) {
        String userId = transaction.getMakerId();
        if (transaction.getStringType() == Constants.TRADE_KIND.Complete.toString()) {
            String itemId = ((TradeTransactionImpl) transaction).getItemId();
            String sellerId = ItemCatalog.getInstance().getSellerId(itemId);
            UserManager.getInstance().removeItem(sellerId, itemId);
            UserManager.getInstance().addItem(userId, itemId);
            EscrowManager.getInstance().transferToSeller(sellerId, ItemCatalog.getInstance().getPrice(itemId));
        }

    }
}
