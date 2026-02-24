package org.quantity.management.ucs;

import org.quantity.management.enums.LengthUnit;
import org.quantity.management.ucs.domain.Length;

import java.util.Scanner;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    public static void demonstrateLengthComparison(Double length1, LengthUnit lengthUnit1, Double length2, LengthUnit lengthUnit2) {
        Length lengthObject1 = new Length(length1, lengthUnit1);
        Length lengthObject2 = new Length(length2, lengthUnit2);
        if(demonstrateLengthEquality(lengthObject1, lengthObject2)) {
            System.out.println("Length 1 with values : " + length1 + " " + lengthUnit1 + " and Length 2 with values : " +
                    length2 + " " + lengthUnit2 + " are equal.");
        }
    }

    public static void main(String[] args) {
        demonstrateLengthComparison(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES);
        demonstrateLengthComparison(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES);
        demonstrateLengthComparison(100.0, LengthUnit.CENTIMETERS, 39.3701, LengthUnit.INCHES);
        demonstrateLengthComparison(3.0, LengthUnit.FEET, 1.0, LengthUnit.YARDS);
        demonstrateLengthComparison(30.48, LengthUnit.CENTIMETERS, 1.0, LengthUnit.FEET);
    }
}
