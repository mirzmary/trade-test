package com.trade.service.trade.enums;

public enum  Type {
    Spot,
    Forward,
    VanillaOption;

    public static boolean contains(final String typeString) {
        for (final Type type : Type.values()) {
            if (type.name().equals(typeString)) {
                return true;
            }
        }
        return false;
    }
}
