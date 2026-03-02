package org.quantity.management.enums;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Double.NaN;

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

    public double convertToBaseUnit(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new NumberFormatException("The Length value is Invalid");
        } else {
                return value * this.conversionFactor;
        }
    }
    public double convertFromBaseToTargetUnit(double baseValue) {
        Double targetLength = BigDecimal.valueOf(baseValue / this.conversionFactor)
                .setScale(3, RoundingMode.HALF_UP)
                .doubleValue();
        return targetLength;
    }
}