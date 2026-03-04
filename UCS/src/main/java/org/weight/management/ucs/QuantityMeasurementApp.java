package org.weight.management.ucs;

import org.weight.management.enums.WeightUnit;
import org.weight.management.ucs.domain.Weight;

public class QuantityMeasurementApp {

    public static boolean demonstrateWeightEquality(Weight weight1, Weight weight2) {
        return weight1.equals(weight2);
    }

    public static void demonstrateWeightComparison(Double weight1, WeightUnit weightUnit1, Double weight2, WeightUnit weightUnit2) {
        Weight weightObject1 = new Weight(weight1, weightUnit1);
        Weight weightObject2 = new Weight(weight2, weightUnit2);
        if(demonstrateWeightEquality(weightObject1, weightObject2)) {
            System.out.println("Weight 1 with values : " + weight1 + " " + weightUnit1 + " and Weight 2 with values : " +
                    weight2 + " " + weightUnit2 + " are equal.");
        }
    }

    public static void demonstrateWeightConversion(Double weight1, WeightUnit weightUnit1, WeightUnit weightUnit2) throws Exception {
        Weight weightObject1 = new Weight(weight1, weightUnit1);
        Weight weightObject2 = weightObject1.convertTo(weightUnit2);
        System.out.println("Weight 1 with values : " + weightObject1.toString() + " and Weight 2 with values : "
                + weightObject2.toString());
    }

    public static void demonstrateWeightAddition(Double weight1, WeightUnit weightUnit1, Double weight2, WeightUnit weightUnit2, WeightUnit targetUnit) throws Exception {
        Weight weightObject1 = new Weight(weight1, weightUnit1);
        Weight weightObject2 = new Weight(weight2, weightUnit2);
        Weight resultObject2 = weightObject1.addAndConvert(weightObject2, targetUnit);
        System.out.println("Weight 1 with values : " + weightObject1.toString() + " and Weight 2 with values : "
                + weightObject2.toString() + " and result object "+resultObject2.toString());
    }

    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println("-----------------------Weight Comparison output-----------------------------------");
        System.out.println();
        demonstrateWeightComparison(1.0, WeightUnit.KILOGRAM, 1.0, WeightUnit.KILOGRAM);
        demonstrateWeightComparison(1.0, WeightUnit.KILOGRAM, 1000.0, WeightUnit.GRAM);
        demonstrateWeightComparison(2.0, WeightUnit.POUND, 2.0, WeightUnit.POUND);
        demonstrateWeightComparison(1.0, WeightUnit.KILOGRAM, 2.20462, WeightUnit.POUND);
        demonstrateWeightComparison(500.0, WeightUnit.GRAM, 0.5, WeightUnit.KILOGRAM);
        demonstrateWeightComparison(1.0, WeightUnit.POUND, 453.592, WeightUnit.GRAM);
        System.out.println();
        System.out.println("------------------------Weight Conversion output----------------------------------");
        System.out.println();
        demonstrateWeightConversion(1.0, WeightUnit.KILOGRAM, WeightUnit.GRAM);
        demonstrateWeightConversion(2.0, WeightUnit.POUND, WeightUnit.KILOGRAM);
        demonstrateWeightConversion(500.0, WeightUnit.GRAM, WeightUnit.POUND);
        demonstrateWeightConversion(0.0, WeightUnit.KILOGRAM, WeightUnit.GRAM);
        System.out.println();
        System.out.println("-------------------------Weight Addition output--------------------------------");
        System.out.println();
        demonstrateWeightAddition(1.0, WeightUnit.KILOGRAM, 1000.0, WeightUnit.GRAM, WeightUnit.GRAM);
        demonstrateWeightAddition(1.0, WeightUnit.POUND, 453.592, WeightUnit.GRAM, WeightUnit.POUND);
        demonstrateWeightAddition(2.0, WeightUnit.KILOGRAM, 4.0, WeightUnit.POUND, WeightUnit.KILOGRAM);
    }
}
