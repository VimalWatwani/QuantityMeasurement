package org.weight.management.ucs;

import org.junit.Assert;
import org.junit.Test;
import org.weight.management.enums.WeightUnit;
import org.weight.management.ucs.domain.Weight;

public class QuantityMeasurementAppTest {
    double EPSILON = 2e0; // Choose an appropriate tolerance for your application

    @Test
    public void testEquality_KilogramToKilogram_SameValue() {
        Weight weight1 = new Weight(Double.valueOf(1), WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(Double.valueOf(1), WeightUnit.KILOGRAM);
        Assert.assertTrue(weight1.equals(weight2));
    }
    @Test
    public void testEquality_KilogramToKilogram_DifferentValue() {
        Weight weight1 = new Weight(Double.valueOf(11), WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(Double.valueOf(10), WeightUnit.KILOGRAM);
        Assert.assertFalse(weight1.equals(weight2));
    }
    @Test
    public void testEquality_KilogramToGram_EquivalentValue() {
        Weight weight1 = new Weight(Double.valueOf(1), WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(Double.valueOf(1000), WeightUnit.GRAM);
        Assert.assertTrue(weight1.equals(weight2));
    }
    @Test
    public void testEquality_GramToKilogram_EquivalentValue() {
        Weight weight2 = new Weight(Double.valueOf(1000), WeightUnit.GRAM);
        Weight weight1 = new Weight(Double.valueOf(1), WeightUnit.KILOGRAM);
        Assert.assertTrue(weight1.equals(weight2));
    }
    @Test
    public void testEquality_SameReference() {
        Weight weight1 = new Weight(Double.valueOf(1.0), WeightUnit.KILOGRAM);
        Assert.assertTrue(weight1.equals(weight1));
    }
    @Test
    public void testEquality_NullComparison() {
        Weight weight1 = new Weight(Double.valueOf(1.0), WeightUnit.KILOGRAM);
        Assert.assertFalse(weight1.equals(null));
    }
    @Test
    public void testEquality_TransitiveProperty() {
        Weight weight1 = new Weight(Double.valueOf(1.0), WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(Double.valueOf(1000.0), WeightUnit.GRAM);
        Assert.assertTrue(weight1.equals(weight2));
        Weight weight3 = new Weight(Double.valueOf(1000000.0), WeightUnit.MILLIGRAM);
        Assert.assertTrue(weight2.equals(weight3));
        Assert.assertTrue(weight1.equals(weight3));
    }
    @Test
    public void testEquality_NegativeWeight() {
        Weight weight1 = new Weight(Double.valueOf(-1.0), WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(Double.valueOf(-1000.0), WeightUnit.GRAM);
        Assert.assertTrue(weight1.equals(weight2));
    }
    @Test
    public void testEquality_LargeWeightValue() {
        Weight weight1 = new Weight(Double.valueOf(1000000.0), WeightUnit.GRAM);
        Weight weight2 = new Weight(Double.valueOf(1000.0), WeightUnit.KILOGRAM);
        Assert.assertTrue(weight1.equals(weight2));
    }
    @Test
    public void testEquality_SmallWeightValue() {
        Weight weight1 = new Weight(Double.valueOf(0.001), WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(Double.valueOf(1.0), WeightUnit.GRAM);
        Assert.assertTrue(weight1.equals(weight2));
    }
    @Test
    public void testConversion_PoundToKilogram() throws Exception {
        Weight weight1 = new Weight(2.20462, WeightUnit.POUND);
        Weight weight2 = weight1.convertTo(WeightUnit.KILOGRAM);
        Assert.assertTrue(Math.abs(weight1.getValue() - weight2.getValue()) < EPSILON);
    }
    @Test
    public void testConversion_KilogramToPound() throws Exception {
        Weight weight1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight weight2 = weight1.convertTo(WeightUnit.POUND);
        Assert.assertTrue(Math.abs(weight1.getValue() - weight2.getValue()) < EPSILON);
    }
    @Test
    public void testConversion_SameUnit() throws Exception {
        Weight weight1 = new Weight(5.0, WeightUnit.KILOGRAM);
        Weight weight2 = weight1.convertTo(WeightUnit.KILOGRAM);
        System.out.println(weight2);
        Assert.assertTrue(weight2.getValue() == 5.0 && weight2.getUnit() == WeightUnit.KILOGRAM);
    }
    @Test
    public void testConversion_ZeroValue() throws Exception {
        Weight weight1 = new Weight(0, WeightUnit.KILOGRAM);
        Weight weight2 = weight1.convertTo(WeightUnit.GRAM);
        System.out.println(weight2);
        Assert.assertTrue(weight2.getValue() == 0.0);
    }
    @Test
    public void testConversion_NegativeValue() throws Exception {
        Weight weight1 = new Weight(-1, WeightUnit.KILOGRAM);
        Weight weight2 = weight1.convertTo(WeightUnit.GRAM);
        System.out.println(weight2);
        Assert.assertTrue(weight2.getValue() == -1000.0);
    }
    @Test
    public void testConversion_RoundTrip() throws Exception {
        Weight weight1 = new Weight(1.5, WeightUnit.KILOGRAM);
        Weight weight2 = weight1.convertTo(WeightUnit.GRAM);
        Weight weight3 = weight2.convertTo(WeightUnit.KILOGRAM);
        Assert.assertTrue(weight1.getValue() == weight3.getValue());
    }
    @Test
    public void testAddition_SameUnit_KilogramPlusKilogram() throws Exception {
        Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(2.0, WeightUnit.KILOGRAM);
        Weight result = weight1.addAndConvert(weight2, WeightUnit.KILOGRAM);
        Assert.assertTrue(result.getValue() == 3.0 && result.getUnit()== WeightUnit.KILOGRAM);
    }
    @Test
    public void testAddition_CrossUnit_KilogramPlusGram() throws Exception {
        Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1000.0, WeightUnit.GRAM);
        Weight result = weight1.addAndConvert(weight2, WeightUnit.KILOGRAM);
        Assert.assertTrue(result.getValue() == 2.0 && result.getUnit()== WeightUnit.KILOGRAM);
    }
    @Test
    public void testAddition_CrossUnit_PoundPlusKilogram() throws Exception {
        Weight weight1 = new Weight(2.20462, WeightUnit.POUND);
        Weight weight2 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight result = weight1.addAndConvert(weight2, WeightUnit.POUND);
        System.out.println(result.getValue());
        Assert.assertTrue(result.getValue() == 4.409 && result.getUnit()== WeightUnit.POUND);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_Kilogram() throws Exception {
        Weight weight1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1000.0, WeightUnit.GRAM);
        Weight result = weight1.addAndConvert(weight2, WeightUnit.GRAM);
        Assert.assertTrue(result.getValue() == 2000.0 && result.getUnit()== WeightUnit.GRAM);
    }
    @Test
    public void testAddition_Commutativity() throws Exception {
        Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1000.0, WeightUnit.GRAM);
        Weight result1 = weight1.addAndConvert(weight2, WeightUnit.GRAM);
        Weight result2 = weight2.addAndConvert(weight1, WeightUnit.GRAM);
        Assert.assertTrue(result1.getValue() == result2.getValue() && result1.getUnit()==result2.getUnit());
    }
    @Test
    public void testAddition_withZero() throws Exception {
        Weight weight1 = new Weight(5.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(0.0, WeightUnit.GRAM);
        Weight result = weight1.addAndConvert(weight2, WeightUnit.KILOGRAM);
        Assert.assertTrue(result.getValue() == 5.0 && result.getUnit()== WeightUnit.KILOGRAM);
    }
    @Test
    public void testAddition_NegativeValue() throws Exception {
        Weight weight1 = new Weight(5.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(-2000.0, WeightUnit.GRAM);
        Weight result = weight1.addAndConvert(weight2, WeightUnit.KILOGRAM);
        Assert.assertTrue(result.getValue() == 3.0 && result.getUnit() == WeightUnit.KILOGRAM);
    }
    @Test
    public void testAddition_LargeValues() throws Exception {
        Weight weight1 = new Weight(1e6, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1e6, WeightUnit.KILOGRAM);
        Weight result = weight1.addAndConvert(weight2, WeightUnit.KILOGRAM);
        Assert.assertTrue(result.getValue() == 2e6 && result.getUnit()== WeightUnit.KILOGRAM);
    }
}