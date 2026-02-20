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
}
