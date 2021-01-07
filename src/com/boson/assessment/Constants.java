package com.boson.assessment;

public final class Constants {

    private Constants() {
    }


    public enum TRADE_TYPE {
        Offer,
        Order,
        Complete,
        Complain
    }

    public enum FINANCIAL_TYPE {
        Credit
    }

    public static boolean isTrade(String type) {
        for (TRADE_TYPE t : TRADE_TYPE.values()) {
            if (t.name().equals(type)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isFinancial(String type) {
        for (FINANCIAL_TYPE t : FINANCIAL_TYPE.values()) {
            if (t.name().equals(type)) {
                return true;
            }
        }

        return false;
    }
}
