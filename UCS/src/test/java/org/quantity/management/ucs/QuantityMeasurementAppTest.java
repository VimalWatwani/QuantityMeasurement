package org.quantity.management.ucs;

import org.junit.Assert;
import org.junit.Test;
import org.quantity.management.enums.LengthUnit;
import org.quantity.management.ucs.domain.Length;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(1.0,LengthUnit.FEET);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }
    @Test
    public void testEquality_InchToInch_SameValue() {
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(12.0,LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }
    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0,LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }
    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(1.0,LengthUnit.FEET);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }
    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        Length length1 = new Length(2.0, LengthUnit.FEET);
        Length length2 = new Length(1.0,LengthUnit.FEET);
        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }
    @Test
    public void testEquality_InchToInch_DifferentValue() {
        Length length1 = new Length(2.0, LengthUnit.INCHES);
        Length length2 = new Length(1.0,LengthUnit.INCHES);
        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }
    @Test
    public void testEquality_NullUnit() {
        Length length1 = new Length(2.0, LengthUnit.INCHES);
        Length length2 = new Length(1.0,null);
        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }
    @Test
    public void testFeetEquality_NullComparison() {
        Length feet1 = new Length(Double.NaN, LengthUnit.FEET);
        Length feet2 = new Length(1.0, LengthUnit.FEET);
        assertFalse(feet1.equals(feet2));
    }
    @Test
    public void testEquality_SameReference() {
        Length feet1 = new Length(Double.valueOf(10),LengthUnit.FEET);
        Assert.assertTrue(feet1.equals(feet1));
    }
}
