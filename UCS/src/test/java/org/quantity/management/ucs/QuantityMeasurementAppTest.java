package org.quantity.management.ucs;

import org.junit.Assert;
import org.junit.Test;
import org.quantity.management.enums.LengthUnit;
import org.quantity.management.ucs.domain.Length;

public class QuantityMeasurementAppTest {

    @Test
    public void testAddition_ExplicitTargetUnit_Feet() throws Exception {
        Length length1 = new Length(1, LengthUnit.FEET);
        Length length2 = new Length(12, LengthUnit.INCHES);
        Length result = length1.addAndConvert(length2, LengthUnit.FEET);
        Assert.assertTrue(result.getValue() == 2.0 && result.getUnit()==LengthUnit.FEET);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_Inches() throws Exception {
        Length length1 = new Length(1, LengthUnit.FEET);
        Length length2 = new Length(12, LengthUnit.INCHES);
        Length result = length1.addAndConvert(length2, LengthUnit.INCHES);
        Assert.assertTrue(result.getValue() == 24.0 && result.getUnit()==LengthUnit.INCHES);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_Yards() throws Exception {
        Length length1 = new Length(1, LengthUnit.FEET);
        Length length2 = new Length(12, LengthUnit.INCHES);
        Length result = length1.addAndConvert(length2, LengthUnit.YARDS);
        Assert.assertTrue(result.getValue() == 0.667 && result.getUnit()==LengthUnit.YARDS);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() throws Exception {
        Length length1 = new Length(1, LengthUnit.INCHES);
        Length length2 = new Length(1, LengthUnit.INCHES);
        Length result = length1.addAndConvert(length2, LengthUnit.CENTIMETERS);
        Assert.assertTrue(result.getValue() == 5.08 && result.getUnit()==LengthUnit.CENTIMETERS);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_CrossUnit_SameAsFirstOperand() throws Exception {
        Length length1 = new Length(2, LengthUnit.YARDS);
        Length length2 = new Length(3, LengthUnit.FEET);
        Length result = length1.addAndConvert(length2, LengthUnit.YARDS);
        Assert.assertTrue(result.getValue() == 3.0 && result.getUnit()==LengthUnit.YARDS);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() throws Exception {
        Length length1 = new Length(2, LengthUnit.YARDS);
        Length length2 = new Length(3, LengthUnit.FEET);
        Length result = length1.addAndConvert(length2, LengthUnit.FEET);
        Assert.assertTrue(result.getValue() == 9.0 && result.getUnit()==LengthUnit.FEET);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity() throws Exception {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length result1 = length1.addAndConvert(length2, LengthUnit.YARDS);
        Length result2 = length2.addAndConvert(length1, LengthUnit.YARDS);
        Assert.assertTrue(result1.getValue() == result2.getValue() && result1.getUnit()==result2.getUnit());
    }
    @Test
    public void testAddition_ExplicitTargetUnit_ZeroValue() throws Exception {
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(0.0, LengthUnit.INCHES);
        Length result = length1.addAndConvert(length2, LengthUnit.YARDS);
        Assert.assertTrue(result.getValue() == 1.667 && result.getUnit()==LengthUnit.YARDS);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValue() throws Exception {
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(-2.0, LengthUnit.FEET);
        Length result = length1.addAndConvert(length2, LengthUnit.INCHES);
        Assert.assertTrue(result.getValue() == 36.0 && result.getUnit()==LengthUnit.INCHES);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit() throws Exception {
        Length length1 = new Length(1, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Assert.assertThrows(IllegalArgumentException.class,() -> length1.addAndConvert(length2, null));
    }
    @Test
    public void testAddition_ExplicitTargetUnit_LargeToSmallScale() throws Exception {
        Length length1 = new Length(1000, LengthUnit.FEET);
        Length length2 = new Length(500, LengthUnit.FEET);
        Length result = length1.addAndConvert(length2, LengthUnit.INCHES);
        Assert.assertTrue(result.getValue() == 18000.0 && result.getUnit()==LengthUnit.INCHES);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_SmallToLargeScale() throws Exception {
        Length length1 = new Length(12, LengthUnit.INCHES);
        Length length2 = new Length(12, LengthUnit.INCHES);
        Length result = length1.addAndConvert(length2, LengthUnit.YARDS);
        Assert.assertTrue(result.getValue() == 0.667 && result.getUnit()==LengthUnit.YARDS);
    }
}