package org.quantity.management.ucs.domain;

import org.quantity.management.enums.LengthUnit;

import static java.lang.Double.NaN;

public class Length {

    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double convertToBaseUnit() {
        if(this.unit != null) {
            return this.value * this.unit.getConversionFactor();
        }
        return NaN;
    }

    public boolean compare(Length thatLength) {
        return this.equals(thatLength);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Length thatLength = (Length) obj;
        return this.convertToBaseUnit() == (thatLength.convertToBaseUnit());
    }

    public static void main(String[] args) {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        System.out.println("Are lengths equal ? " + length1.equals(length2));

        Length length3 = new Length(1.0, LengthUnit.YARDS);
        Length length4 = new Length(36.0, LengthUnit.INCHES);
        System.out.println("Are lengths equal ? " + length3.equals(length4));

        Length length5 = new Length(100.0, LengthUnit.CENTIMETERS);
        Length length6 = new Length(39.3701, LengthUnit.INCHES);
        System.out.println("Are lengths equal ? " + length5.equals(length6));
    }
}
