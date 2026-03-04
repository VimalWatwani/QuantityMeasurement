package org.weight.management.enums;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum WeightUnit {

    KILOGRAM(1000.0),
    MILLIGRAM(0.001),
    GRAM(1.0),
    POUND(453.592),
    TONNE(1_000_000.0);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    public double convertToBaseUnit(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new NumberFormatException("The Weight value is Invalid");
        } else {
                return value * this.conversionFactor;
        }
    }
    public double convertFromBaseToTargetUnit(double baseValue) {
        Double targetWeight = BigDecimal.valueOf((baseValue / this.conversionFactor) * 100.0 / 100.0)
                .setScale(3, RoundingMode.HALF_UP)
                .doubleValue();
        return targetWeight;
    }
}