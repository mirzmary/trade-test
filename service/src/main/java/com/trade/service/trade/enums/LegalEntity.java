package com.trade.service.trade.enums;

public enum LegalEntity {
    CS_ZURICH("CS Zurich");

    private String displayName;

    LegalEntity(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    @Override public String toString() { return displayName; }

    public static boolean contains(final String legalEntityString) {
        for (final LegalEntity legalEntity : LegalEntity.values()) {
            if (legalEntity.displayName().equals(legalEntityString)) {
                return true;
            }
        }
        return false;
    }
}
