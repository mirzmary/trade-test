package com.trade.service.trade.enums;

public enum Counterparty{
    PLUTO1,
    PLUTO2;

    public static boolean contains(final String counterpartyString) {
        for (final Counterparty counterparty : Counterparty.values()) {
            if (counterparty.name().equals(counterpartyString)) {
                return true;
            }
        }
        return false;
    }
}
