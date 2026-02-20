package org.quantity.management.ucs;

import org.quantity.management.enums.LengthUnit;
import org.quantity.management.ucs.domain.Length;

import java.util.Scanner;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    public static void demonstrateFeetEquality() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(1.00, LengthUnit.FEET);
        if(demonstrateLengthEquality(length1, length2)) {
            System.out.println("Feet 1 and Feet 2 are equal.");
        }
    }

    public static void demonstrateInchesEquality() {
        Length inchesObject1 = new Length(12.0, LengthUnit.INCHES);
        Length inchesObject2 = new Length(12.00, LengthUnit.INCHES);
        if(demonstrateLengthEquality(inchesObject1, inchesObject2)) {
            System.out.println("Inches 1 and Inches 2 are equal.");
        }
    }

    public static void demonstrateFeetInchesComparison() {
        Length feetObject1 = new Length(1.0, LengthUnit.FEET);
        Length inchesObject2 = new Length(12.00, LengthUnit.INCHES);
        if(demonstrateLengthEquality(feetObject1, inchesObject2)) {
            System.out.println("Feet 1 and Inches 2 are equal.");
        }
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}
