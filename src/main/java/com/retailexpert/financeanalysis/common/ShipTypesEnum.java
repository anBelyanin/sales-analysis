package com.retailexpert.financeanalysis.common;

public enum ShipTypesEnum {

    REGULAR_SHIP_TYPE("Regular"),
    PROMO_SHIP_TYPE("Promo");

    public final String shipType;

    ShipTypesEnum(String shipType) {
        this.shipType = shipType;
    }
}
