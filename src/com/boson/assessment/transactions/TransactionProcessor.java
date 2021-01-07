package com.boson.assessment.transactions;

import com.boson.assessment.Constants;
import com.boson.assessment.items.ItemCatalog;
import com.boson.assessment.users.EscrowManager;
import com.boson.assessment.users.User;
import com.boson.assessment.users.UserManager;

public class TransactionProcessor {

    public static void transactionProcessing() {
        Transaction transaction = TransactionManager.getInstance().getTransaction();
        while (transaction != null) {
            processCreditTransaction(transaction);
            processOfferTransaction(transaction);
            processOrderTransaction(transaction);
            processCompleteTransaction(transaction);
            processComplainTransaction(transaction);
            transaction = TransactionManager.getInstance().getTransaction();
        }
    }

    private static void processCreditTransaction(Transaction transaction) {
        String userId = transaction.getMakerId();
        if (transaction.getStringType() == Constants.FINANCIAL_TYPE.Credit.toString()) {
            Float amount = ((FinancialTransactionImpl) transaction).getAmount();
            if (UserManager.getInstance().getIdSet().contains(userId)) {
                UserManager.getInstance().getUser(userId).addBalance(amount);
            } else {
                UserManager.getInstance().addUser(userId, amount, "Buyer");
            }
        }
    }

    private static void processOfferTransaction(Transaction transaction) {
        String userId = transaction.getMakerId();
        if (transaction.getStringType() == Constants.TRADE_TYPE.Offer.toString()) {
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

    private static void processOrderTransaction(Transaction transaction) {
        String userId = transaction.getMakerId();
        if (transaction.getStringType() == Constants.TRADE_TYPE.Order.toString()) {
            String itemId = ((TradeTransactionImpl) transaction).getItemId();
            User buyer = UserManager.getInstance().getUser(userId);
            EscrowManager.getInstance().transferToEscrow(buyer, ItemCatalog.getInstance().getPrice(itemId));
        }
    }

    private static void processCompleteTransaction(Transaction transaction) {
        String userId = transaction.getMakerId();
        if (transaction.getStringType() == Constants.TRADE_TYPE.Complete.toString()) {
            String itemId = ((TradeTransactionImpl) transaction).getItemId();
            String sellerId = ItemCatalog.getInstance().getSellerId(itemId);
            UserManager.getInstance().removeItem(sellerId, itemId);
            UserManager.getInstance().addItem(userId, itemId);
            EscrowManager.getInstance().transferToSeller(sellerId, ItemCatalog.getInstance().getPrice(itemId));
        }
    }

    private static void processComplainTransaction(Transaction transaction) {
        String userId = transaction.getMakerId();
        if (transaction.getStringType() == Constants.TRADE_TYPE.Complain.toString()) {
            String itemId = ((TradeTransactionImpl) transaction).getItemId();
            EscrowManager.getInstance().transferToBuyer(userId, ItemCatalog.getInstance().getPrice(itemId));
        }
    }
}


