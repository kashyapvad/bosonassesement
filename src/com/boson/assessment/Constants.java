package com.boson.assessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Constants {

    private Constants() {
    }

    public static final List<String> TRANSACTION_CLASSES = Collections.unmodifiableList(
            new ArrayList<>() {{
                add("com.boson.assessment.types.CreditTransaction");
                add("com.boson.assessment.types.OrderTransaction");
                add("com.boson.assessment.types.OfferTransaction");
                add("com.boson.assessment.types.ComplainTransaction");
                add("com.boson.assessment.types.CompleteTransaction");
            }});


    public enum TRADE_KIND {
        Offer,
        Order,
        Complete,
        Complain
    }

    public enum FINANCIAL_KIND {
        Credit
    }

    public static boolean isTrade(String type) {
        for (TRADE_KIND t : TRADE_KIND.values()) {
            if (t.name().equals(type)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isFinancial(String type) {
        for (FINANCIAL_KIND t : FINANCIAL_KIND.values()) {
            if (t.name().equals(type)) {
                return true;
            }
        }

        return false;
    }
}
