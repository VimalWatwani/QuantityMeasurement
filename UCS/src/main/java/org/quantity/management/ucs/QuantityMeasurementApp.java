package org.quantity.management.ucs;

import java.util.Scanner;

public class QuantityMeasurementApp {

    public static class Feet {

        private final double value;

        public Feet(Double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }
            if(this.getClass() != obj.getClass()) {
                return false;
            }
            Feet feetObject = (Feet) obj;
            return (Double.compare(this.value,feetObject.getValue()) == 0);
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Double feet1 = scanner.nextDouble();
        Double feet2 = scanner.nextDouble();

        Feet feetObject1 = new Feet(feet1);
        Feet feetObject2 = new Feet(feet2);

        if(feetObject1.equals(feetObject2)) {
            System.out.println("Feet 1 and Feet 2 are equal.");
        } else {
            System.out.println("Feet 1 and Feet 2 are not equal");
        }
    }
}
