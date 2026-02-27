package org.quantity.management.ucs;

import org.junit.Assert;
import org.junit.Test;
import org.quantity.management.enums.LengthUnit;
import org.quantity.management.ucs.domain.Length;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class QuantityMeasurementAppTest {

    @Test
    public void testAddition_SameUnit_FeetPlusFeet() throws Exception {
        Length length1 = new Length(1, LengthUnit.FEET);
        Length length2 = new Length(2, LengthUnit.FEET);
        Length result = length1.add(length2);
        Assert.assertTrue(result.getValue() == 3.0 && result.getUnit()==LengthUnit.FEET);
    }
    @Test
    public void testAddition_SameUnit_InchesPlusInches() throws Exception {
        Length length1 = new Length(6, LengthUnit.INCHES);
        Length length2 = new Length(6, LengthUnit.INCHES);
        Length result = length1.add(length2);
        Assert.assertTrue(result.getValue() == 12.0 && result.getUnit()==LengthUnit.INCHES);
    }
    @Test
    public void testAddition_CrossUnit_FeetPlusInches() throws Exception {
        Length length1 = new Length(1, LengthUnit.FEET);
        Length length2 = new Length(12, LengthUnit.INCHES);
        Length result = length1.add(length2);
        Assert.assertTrue(result.getValue() == 2.0 && result.getUnit()==LengthUnit.FEET);
    }
    @Test
    public void testAddition_CrossUnit_InchesPlusFeet() throws Exception {
        Length length1 = new Length(12, LengthUnit.INCHES);
        Length length2 = new Length(1, LengthUnit.FEET);
        Length result = length1.add(length2);
        Assert.assertTrue(result.getValue() == 24.0 && result.getUnit()==LengthUnit.INCHES);
    }
    @Test
    public void testAddition_CrossUnit_YardsPlusFeet() throws Exception {
        Length length1 = new Length(1, LengthUnit.YARDS);
        Length length2 = new Length(3, LengthUnit.FEET);
        Length result = length1.add(length2);
        Assert.assertTrue(result.getValue() == 2.0 && result.getUnit()==LengthUnit.YARDS);
    }
    @Test
    public void testAddition_FeetToYard() throws Exception {
        Length length1 = new Length(102, LengthUnit.FEET);
        Length length2 = length1.convertTo(LengthUnit.YARDS);
        System.out.println(length2);
        Assert.assertTrue(length1.equals(length2));
    }
    @Test
    public void testAddition_CrossUnit_CentimetersPlusInches() throws Exception {
        Length length1 = new Length(2.54, LengthUnit.CENTIMETERS);
        Length length2 = new Length(1.0, LengthUnit.INCHES);
        Length result = length1.add(length2);
        Assert.assertTrue(result.getValue() == 5.08 && result.getUnit()==LengthUnit.CENTIMETERS);
    }
    @Test
    public void testAddition_Commutativity() throws Exception {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length result1 = length1.add(length2);
        Length result2 = length2.add(length1);
        Assert.assertTrue(result1.getValue() == 2.0 && result1.getUnit()==LengthUnit.FEET);
        Assert.assertTrue(result2.getValue() == 24.0 && result2.getUnit()==LengthUnit.INCHES);
    }
    @Test
    public void testAddition_ZeroValue() throws Exception {
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(0.0, LengthUnit.INCHES);
        Length result = length1.add(length2);
        Assert.assertTrue(result.getValue() == 5.0 && result.getUnit()==LengthUnit.FEET);
    }
    @Test
    public void testAddition_NegativeValue() throws Exception {
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(-2.0, LengthUnit.FEET);
        Length result = length1.add(length2);
        Assert.assertTrue(result.getValue() == 3.0 && result.getUnit()==LengthUnit.FEET);
    }
    @Test
    public void testAddition_NullSecondOperand() throws Exception {
        Length length1 = new Length(1, LengthUnit.FEET);
        Length length2 = new Length(2.0, null);
        Assert.assertThrows(IllegalArgumentException.class,() -> length1.add(length2));
    }
    @Test
    public void testAddition_LargeValues() throws Exception {
        Length length1 = new Length(1e6, LengthUnit.FEET);
        Length length2 = new Length(1e6, LengthUnit.FEET);
        Length result = length1.add(length2);
        Assert.assertTrue(result.getValue() == 2e6 && result.getUnit()==LengthUnit.FEET);
    }
    @Test
    public void testAddition_SmallValues() throws Exception {
        Length length1 = new Length(0.001, LengthUnit.FEET);
        Length length2 = new Length(0.002, LengthUnit.FEET);
        Length result = length1.add(length2);
        Assert.assertTrue(result.getValue() == 0.003 && result.getUnit()==LengthUnit.FEET);
    }
}
