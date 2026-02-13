package org.quantity.management.ucs;

import org.quantity.management.enums.LengthUnit;
import org.quantity.management.ucs.domain.Length;
import org.w3c.dom.ls.LSOutput;

public class Ucs3Main {

    public static void main(String[] args) {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        System.out.println("Are Lengths equal ? + " + length1.equals(length2));
    }
}
