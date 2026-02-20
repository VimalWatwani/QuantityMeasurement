package org.quantity.management.ucs;

import java.util.Scanner;

public class QuantityMeasurementApp {

    public static class Feet {

        private final double feet;

        public Feet(Double feet) {
            this.feet = feet;
        }

        public double getFeet() {
            return feet;
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
            return (Double.compare(this.feet, feetObject.getFeet()) == 0);
        }
    }

    public static class Inches {
        private final double inches;

        public Inches(Double inches) {
            this.inches = inches;
        }

        public double getInches() {
            return inches;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }
            if(this.getClass() != obj.getClass()) {
                return false;
            }
            Inches inchesObject = (Inches) obj;
            return (Double.compare(this.inches, inchesObject.getInches()) == 0);
        }
    }

    public static void demonstrateFeetEquality() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Feet1 value : ");
        Double feet1 = scanner.nextDouble();

        System.out.println("Enter Feet2 value : ");
        Double feet2 = scanner.nextDouble();

        Feet feetObject1 = new Feet(feet1);
        Feet feetObject2 = new Feet(feet2);

        if(feetObject1.equals(feetObject2)) {
            System.out.println("Feet 1 and Feet 2 are equal.");
        } else {
            System.out.println("Feet 1 and Feet 2 are not equal.");
        }
        scanner.close();
    }

    public static void demonstrateInchesEquality() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Inches1 value : ");
        Double inches1 = scanner.nextDouble();

        System.out.println("Enter Inches2 value : ");
        Double inches2 = scanner.nextDouble();

        Inches inchesObject1 = new Inches(inches1);
        Inches inchesObject2 = new Inches(inches2);

        if(inchesObject1.equals(inchesObject2)) {
            System.out.println("Inches 1 and Inches 2 are equal.");
        } else {
            System.out.println("Inches 1 and Inches 2 are not equal");
        }
        scanner.close();
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}