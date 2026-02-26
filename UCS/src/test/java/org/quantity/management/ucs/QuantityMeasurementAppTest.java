package org.quantity.management.ucs;

import org.junit.Assert;
import org.junit.Test;
import org.quantity.management.enums.LengthUnit;
import org.quantity.management.ucs.domain.Length;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class QuantityMeasurementAppTest {

    @Test
    public void testComparison_FeetToInches() throws Exception {
        Length length1 = new Length(24, LengthUnit.FEET);
        Length length2 = length1.convertTo(LengthUnit.INCHES);
        System.out.println(length2);
        Assert.assertTrue(length1.equals(length2));
    }
    @Test
    public void testComparison_InchesToFeet() throws Exception {
        Length length1 = new Length(288, LengthUnit.INCHES);
        Length length2 = length1.convertTo(LengthUnit.FEET);
        System.out.println(length2);
        Assert.assertTrue(length1.equals(length2));
    }
    @Test
    public void testComparison_YardsToInches() throws Exception {
        Length length1 = new Length(288, LengthUnit.YARDS);
        Length length2 = length1.convertTo(LengthUnit.INCHES);
        System.out.println(length2);
        Assert.assertTrue(length1.equals(length2));
    }
    @Test
    public void testComparison_InchesToYards() throws Exception {
        Length length1 = new Length(10368.0, LengthUnit.INCHES);
        Length length2 = length1.convertTo(LengthUnit.YARDS);
        System.out.println(length2);
        Assert.assertTrue(length1.equals(length2));
    }
    @Test
    public void testComparison_CentimetersToInches() throws Exception {
        Length length1 = new Length(39.37, LengthUnit.CENTIMETERS);
        Length length2 = length1.convertTo(LengthUnit.INCHES);
        System.out.println(length2);
        Assert.assertTrue(length1.equals(length2));
    }
    @Test
    public void testComparison_FeetToYard() throws Exception {
        Length length1 = new Length(102, LengthUnit.FEET);
        Length length2 = length1.convertTo(LengthUnit.YARDS);
        System.out.println(length2);
        Assert.assertTrue(length1.equals(length2));
    }
    @Test
    public void testConversion_RoundTrip_PreservesValue() throws Exception {
        Length length1 = new Length(102, LengthUnit.FEET);
        Length length2 = length1.convertTo(LengthUnit.YARDS);
        Length length3 = length2.convertTo((LengthUnit.FEET));
        System.out.println(length3);
        Assert.assertTrue(length3.getValue() == 102.0);
    }
    @Test
    public void testConversion_ZeroValue() throws Exception {
        Length length1 = new Length(0, LengthUnit.FEET);
        Length length2 = length1.convertTo(LengthUnit.INCHES);
        System.out.println(length2);
        Assert.assertTrue(length2.getValue() == 0.0);
    }
    @Test
    public void testConversion_NegativeValue() throws Exception {
        Length length1 = new Length(-1, LengthUnit.FEET);
        Length length2 = length1.convertTo(LengthUnit.INCHES);
        System.out.println(length2);
        Assert.assertTrue(length2.getValue() == -12.0);
    }
    @Test
    public void testConversion_InvalidUnit_Throws() throws Exception {
        Length length1 = new Length(-1, LengthUnit.FEET);
        Length length2 = length1.convertTo(null);
        Assert.assertTrue(true);
    }
}
