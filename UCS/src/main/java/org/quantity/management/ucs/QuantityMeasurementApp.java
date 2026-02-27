package org.quantity.management.ucs;

import org.quantity.management.enums.LengthUnit;
import org.quantity.management.ucs.domain.Length;

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

    public static void demonstrateLengthConversion(Double length1, LengthUnit lengthUnit1, LengthUnit lengthUnit2) throws Exception {
        Length lengthObject1 = new Length(length1, lengthUnit1);
        Length lengthObject2 = lengthObject1.convertTo(lengthUnit2);
        System.out.println("Length 1 with values : " + lengthObject1.toString() + " and Length 2 with values : "
                + lengthObject2.toString());
    }

    public static void demonstrateLengthAddition(Double length1, LengthUnit lengthUnit1, Double length2, LengthUnit lengthUnit2, LengthUnit targetUnit) throws Exception {
        Length lengthObject1 = new Length(length1, lengthUnit1);
        Length lengthObject2 = new Length(length2, lengthUnit2);
        Length resultObject2 = lengthObject1.addAndConvert(lengthObject2, targetUnit);
        System.out.println("Length 1 with values : " + lengthObject1.toString() + " and Length 2 with values : "
                + lengthObject2.toString() + " and result object "+resultObject2.toString());
    }

    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println("-----------------------Length Comparison output-----------------------------------");
        System.out.println();
        demonstrateLengthComparison(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES);
        demonstrateLengthComparison(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES);
        demonstrateLengthComparison(100.0, LengthUnit.CENTIMETERS, 39.3701, LengthUnit.INCHES);
        demonstrateLengthComparison(3.0, LengthUnit.FEET, 1.0, LengthUnit.YARDS);
        demonstrateLengthComparison(30.48, LengthUnit.CENTIMETERS, 1.0, LengthUnit.FEET);
        System.out.println();
        System.out.println("------------------------Length Conversion output----------------------------------");
        System.out.println();
        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        demonstrateLengthConversion(1.0, LengthUnit.YARDS, LengthUnit.INCHES);
        demonstrateLengthConversion(100.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES);
        demonstrateLengthConversion(3.0, LengthUnit.FEET, LengthUnit.YARDS);
        demonstrateLengthConversion(30.48, LengthUnit.CENTIMETERS, LengthUnit.FEET);
        System.out.println();
        System.out.println("-------------------------Length Addition output--------------------------------");
        System.out.println();
        demonstrateLengthAddition(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES, LengthUnit.FEET);
        demonstrateLengthAddition(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES, LengthUnit.INCHES);
        demonstrateLengthAddition(12.0, LengthUnit.INCHES, 1.0, LengthUnit.FEET, LengthUnit.YARDS);
        demonstrateLengthAddition(1.0, LengthUnit.YARDS, 3.0, LengthUnit.FEET, LengthUnit.YARDS);
        demonstrateLengthAddition(36.0, LengthUnit.INCHES, 1.0, LengthUnit.YARDS, LengthUnit.FEET);
        demonstrateLengthAddition(2.54, LengthUnit.CENTIMETERS, 1.0, LengthUnit.INCHES, LengthUnit.CENTIMETERS);
        demonstrateLengthAddition(5.0, LengthUnit.FEET, 0.0, LengthUnit.INCHES, LengthUnit.YARDS);
        demonstrateLengthAddition(5.0, LengthUnit.FEET, -2.0, LengthUnit.FEET, LengthUnit.INCHES);
    }
}
