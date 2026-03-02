package org.quantity.management.ucs.domain;

import org.quantity.management.enums.LengthUnit;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Double.NaN;

public class Length {

    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public boolean compare(Length thatLength) {
        Double value1 = BigDecimal.valueOf(this.unit.convertToBaseUnit(this.value))
                .setScale(3, RoundingMode.HALF_UP)
                .doubleValue();
        Double value2 = BigDecimal.valueOf(thatLength.unit.convertToBaseUnit(thatLength.value))
                .setScale(3, RoundingMode.HALF_UP)
                .doubleValue();
        return Double.compare(value1,value2) == 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Length length = (Length) obj;
        return compare(length);
    }

    public Length convertTo(LengthUnit targetUnit) throws Exception {
        try {
            if (targetUnit == null) {
                throw new IllegalArgumentException();
            } else {
                Double targetLength = convertFromBaseToTargetUnit(this.unit.convertToBaseUnit(this.value), targetUnit);
                Length result = new Length(targetLength, targetUnit);
                return result;
            }
        } catch(NumberFormatException e) {
            System.out.println("The Length value is Invalid");;
        } catch(IllegalArgumentException e) {
            System.out.println("Invalid LengthUnit");;
        }
        return null;
    }

    private double convertFromBaseToTargetUnit(double lengthInInches, LengthUnit targetUnit) {
        return targetUnit.convertFromBaseToTargetUnit(lengthInInches);
    }

    public Length addAndConvert(Length thatLength, LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException();
        } else {
            Double length1Inches = this.unit.convertToBaseUnit(this.value);
            Double length2Inches = thatLength.unit.convertToBaseUnit(thatLength.value);
            Double sum = Double.sum(length1Inches, length2Inches);
            Double resultLength = convertFromBaseToTargetUnit(sum, targetUnit);
            return new Length(resultLength, targetUnit);
        }
    }

    @Override
    public String toString() {
        return "Length{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }
}
