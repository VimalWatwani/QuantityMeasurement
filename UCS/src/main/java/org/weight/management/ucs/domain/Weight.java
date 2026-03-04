package org.weight.management.ucs.domain;

import org.weight.management.enums.WeightUnit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Weight {

    private double value;
    private WeightUnit unit;

    public Weight(double value, WeightUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public boolean compare(Weight thatWeight) {
        Double value1 = BigDecimal.valueOf(this.unit.convertToBaseUnit(this.value))
                .setScale(3, RoundingMode.HALF_UP)
                .doubleValue();
        Double value2 = BigDecimal.valueOf(thatWeight.unit.convertToBaseUnit(thatWeight.value))
                .setScale(3, RoundingMode.HALF_UP)
                .doubleValue();
        return Math.abs(value1 - value2) < 1e-9;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Weight weight = (Weight) obj;
        return compare(weight);
    }

    public Weight convertTo(WeightUnit targetUnit) throws Exception {
        try {
            if (targetUnit == null) {
                throw new IllegalArgumentException();
            } else {
                Double targetWeight = convertFromBaseToTargetUnit(this.unit.convertToBaseUnit(this.value), targetUnit);
                Weight result = new Weight(targetWeight, targetUnit);
                return result;
            }
        } catch(NumberFormatException e) {
            System.out.println("The Weight value is Invalid");;
        } catch(IllegalArgumentException e) {
            System.out.println("Invalid WeightUnit");;
        }
        return null;
    }

    private double convertFromBaseToTargetUnit(double weightInGrams, WeightUnit targetUnit) {
        return targetUnit.convertFromBaseToTargetUnit(weightInGrams);
    }

    public Weight addAndConvert(Weight thatWeight, WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException();
        } else {
            Double weight1Grams = this.unit.convertToBaseUnit(this.value);
            Double weight2Grams = thatWeight.unit.convertToBaseUnit(thatWeight.value);
            Double sum = Double.sum(weight1Grams, weight2Grams);
            Double resultWeight = convertFromBaseToTargetUnit(sum, targetUnit);
            return new Weight(resultWeight, targetUnit);
        }
    }

    @Override
    public String toString() {
        return "Weight{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }
}
