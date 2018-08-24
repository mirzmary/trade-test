package com.trade.service.trade.enums;

public enum Direction {
    SELL,
    BUY;

    public static boolean contains(final String directionString) {
        for (final Direction direction : Direction.values()) {
            if (direction.name().equals(directionString)) {
                return true;
            }
        }
        return false;
    }
}
