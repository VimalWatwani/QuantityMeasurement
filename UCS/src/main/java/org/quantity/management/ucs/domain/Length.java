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

    public double convertToBaseUnit() {
        if (Double.isNaN(this.value) || Double.isInfinite(this.value)) {
            throw new NumberFormatException("The Length value is Invalid");
        } else {
            if (this.unit != null) {
                return this.value * this.unit.getConversionFactor();
            }
        }
        return NaN;
    }

    public boolean compare(Length thatLength) {
        Double value1 = BigDecimal.valueOf(this.convertToBaseUnit())
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        Double value2 = BigDecimal.valueOf(thatLength.convertToBaseUnit())
                .setScale(2, RoundingMode.HALF_UP)
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
                Double sourceLength = this.convertToBaseUnit();
                Double sourceBaseLength = BigDecimal.valueOf(sourceLength / targetUnit.getConversionFactor())
                        .setScale(2, RoundingMode.HALF_UP)
                        .doubleValue();
                Length result = new Length(sourceBaseLength, targetUnit);
                return result;
            }
        } catch(NumberFormatException e) {
            System.out.println("The Length value is Invalid");;
        } catch(IllegalArgumentException e) {
            System.out.println("Invalid LengthUnit");;
        }
        return null;
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
}
