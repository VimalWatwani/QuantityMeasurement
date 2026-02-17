package org.quantity.management.enums;

public enum LengthUnit {

    FEET(12.0),
    INCHES(1.0),
    YARDS(36),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}
