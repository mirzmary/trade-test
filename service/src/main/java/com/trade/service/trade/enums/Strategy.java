package com.trade.service.trade.enums;

public enum Strategy {
    CALL;

    public static boolean contains(final String strategyString) {
        for (final Strategy strategy : Strategy.values()) {
            if (strategy.name().equals(strategyString)) {
                return true;
            }
        }
        return false;
    }
}
