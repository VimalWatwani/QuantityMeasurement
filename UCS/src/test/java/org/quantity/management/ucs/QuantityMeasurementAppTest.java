package org.quantity.management.ucs;

import org.junit.Assert;
import org.junit.Test;
import org.quantity.management.enums.LengthUnit;
import org.quantity.management.ucs.domain.Length;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_YardToYard_SameValue() {
        Length length1 = new Length(Double.valueOf(10), LengthUnit.YARDS);
        Length length2 = new Length(Double.valueOf(10), LengthUnit.YARDS);
        Assert.assertTrue(length1.equals(length2));
    }
    @Test
    public void testEquality_YardToYard_DifferentValue() {
        Length length1 = new Length(Double.valueOf(11), LengthUnit.YARDS);
        Length length2 = new Length(Double.valueOf(10), LengthUnit.YARDS);
        Assert.assertFalse(length1.equals(length2));
    }
    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        Length length1 = new Length(Double.valueOf(1), LengthUnit.YARDS);
        Length length2 = new Length(Double.valueOf(3), LengthUnit.FEET);
        Assert.assertTrue(length1.equals(length2));
    }
    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        Length length2 = new Length(Double.valueOf(3), LengthUnit.FEET);
        Length length1 = new Length(Double.valueOf(1), LengthUnit.YARDS);
        Assert.assertTrue(length1.equals(length2));
    }
    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        Length length1 = new Length(Double.valueOf(1), LengthUnit.YARDS);
        Length length2 = new Length(Double.valueOf(36), LengthUnit.INCHES);
        Assert.assertTrue(length1.equals(length2));
    }
    @Test
    public void testEquality_InchesToYard_EquivalentValue() {
        Length length2 = new Length(Double.valueOf(36), LengthUnit.INCHES);
        Length length1 = new Length(Double.valueOf(1), LengthUnit.YARDS);
        Assert.assertTrue(length1.equals(length2));
    }
    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {
        Length length1 = new Length(Double.valueOf(1.0), LengthUnit.YARDS);
        Length length2 = new Length(Double.valueOf(2.0), LengthUnit.FEET);
        Assert.assertFalse(length1.equals(length2));
    }
    @Test
    public void testEquality_CentimetersToFeet_NonEquivalentValue() {
        Length length1 = new Length(Double.valueOf(1.0), LengthUnit.CENTIMETERS);
        Length length2 = new Length(Double.valueOf(1.0), LengthUnit.FEET);
        Assert.assertFalse(length1.equals(length2));
    }
    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        Length length1 = new Length(Double.valueOf(1.0), LengthUnit.YARDS);
        Length length2 = new Length(Double.valueOf(36.0), LengthUnit.INCHES);
        Assert.assertTrue(length1.equals(length2));
    }
    @Test
    public void testEquality_YardWithNullUnit() {
        Length length1 = new Length(Double.valueOf(1.0), LengthUnit.YARDS);
        Assert.assertFalse(length1.equals(new Length(Double.valueOf(1.0), null)));
    }
    @Test
    public void testEquality_YardSameReference() {
        Length length1 = new Length(Double.valueOf(1.0), LengthUnit.YARDS);
        Assert.assertTrue(length1.equals(length1));
    }
    @Test
    public void testEquality_YardNullComparison() {
        Length length1 = new Length(Double.valueOf(1.0), LengthUnit.YARDS);
        Assert.assertFalse(length1.equals(null));
    }
    @Test
    public void testEquality_CentimetersWithNullUnit() {
        Length length1 = new Length(Double.valueOf(1.0), LengthUnit.CENTIMETERS);
        Assert.assertFalse(length1.equals(new Length(Double.valueOf(1.0), null)));
    }
    @Test
    public void testEquality_CentimetersSameReference() {
        Length length1 = new Length(Double.valueOf(1.0), LengthUnit.CENTIMETERS);
        Assert.assertTrue(length1.equals(length1));
    }
    @Test
    public void testEquality_CentimetersNullComparison() {
        Length length1 = new Length(Double.valueOf(1.0), LengthUnit.CENTIMETERS);
        Assert.assertFalse(length1.equals(null));
    }
    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        Length length1 = new Length(Double.valueOf(2.0), LengthUnit.YARDS);
        Length length2 = new Length(Double.valueOf(6.0), LengthUnit.FEET);
        Length length3 = new Length(Double.valueOf(72.0), LengthUnit.INCHES);
        Assert.assertTrue(length1.equals(length2));
        Assert.assertTrue(length1.equals(length3));
        Assert.assertTrue(length2.equals(length3));
    }
}
