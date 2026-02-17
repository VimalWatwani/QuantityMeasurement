package org.quantity.management.ucs;

import org.quantity.management.enums.LengthUnit;
import org.quantity.management.ucs.domain.Length;
import org.w3c.dom.ls.LSOutput;

public class Ucs3Main {

    public static void main(String[] args) {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        System.out.println("Are Lengths equal ? + " + length1.equals(length2));

        Length length3 = new Length(1.0, LengthUnit.YARDS);
        Length length4 = new Length(36.0, LengthUnit.INCHES);
        System.out.println("Are Lengths equal ? + " + length3.equals(length4));

        Length length5 = new Length(100.0, LengthUnit.CENTIMETERS);
        Length length6 = new Length(39.37010, LengthUnit.INCHES);
        System.out.println("Are Lengths equal ? + " + length5.equals(length6));
    }
}
