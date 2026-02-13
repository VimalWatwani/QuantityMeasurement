package org.quantity.management.ucs;

import org.junit.Assert;
import org.junit.Test;
import org.quantity.management.ucs.QuantityMeasurementApp.Feet;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue() {
        Feet feet1 = new Feet(Double.valueOf(10));
        Feet feet2 = new Feet(Double.valueOf(10));
        Assert.assertTrue(feet1.equals(feet2));
    }
    @Test
    public void testFeetEquality_DifferentValue() {
        Feet feet1 = new Feet(Double.valueOf(10));
        Feet feet2 = new Feet(Double.valueOf(11));
        Assert.assertFalse(feet1.equals(feet2));
    }
    @Test
    public void testFeetEquality_NullComparison() {
        Feet feet1 = new Feet(Double.NaN);
        Feet feet2 = new Feet(Double.NaN);
        Assert.assertTrue(feet1.equals(feet2));
    }
    @Test
    public void testFeetEquality_DifferentClass() {
        Feet feet1 = new Feet(Double.valueOf(10));
        QuantityMeasurementApp feet2 = new QuantityMeasurementApp();
        Assert.assertFalse(feet1.equals(feet2));
    }
    @Test
    public void testFeetEquality_SameReference() {
        Feet feet1 = new Feet(Double.valueOf(10));
        Assert.assertTrue(feet1.equals(feet1));
    }
}
