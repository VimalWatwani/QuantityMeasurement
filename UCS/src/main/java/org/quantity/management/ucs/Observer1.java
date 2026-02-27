package org.quantity.management.ucs;

public class Observer1 implements IObserver {
    @Override
    public void onDataUpdate() {
        System.out.println("Obs 1"+getClass().getSimpleName());
    }
}
