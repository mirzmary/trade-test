package com.trade.service.trade.enums;

public enum Style {
    EUROPEAN,
    AMERICAN;

    public static boolean contains(final String styleString) {
        for (final Style style : Style.values()) {
            if (style.name().equals(styleString)) {
                return true;
            }
        }
        return false;
    }
}
