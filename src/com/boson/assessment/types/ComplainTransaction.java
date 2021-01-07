package com.boson.assessment.types;

import com.boson.assessment.Constants;
import com.boson.assessment.items.ItemCatalog;
import com.boson.assessment.transactions.TradeTransactionImpl;
import com.boson.assessment.transactions.Transaction;
import com.boson.assessment.users.EscrowManager;

public class ComplainTransaction implements Type {
    public void processTransaction(Transaction transaction) {
        String userId = transaction.getMakerId();
        if (transaction.getStringType() == Constants.TRADE_KIND.Complain.toString()) {
            String itemId = ((TradeTransactionImpl) transaction).getItemId();
            EscrowManager.getInstance().transferToBuyer(userId, ItemCatalog.getInstance().getPrice(itemId));
        }

    }
}
