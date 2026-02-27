package org.quantity.management.ucs;

public class Observer2 implements IObserver {
    @Override
    public void onDataUpdate() {
        System.out.println("Obs 2" + getClass().getSimpleName());
    }
}
