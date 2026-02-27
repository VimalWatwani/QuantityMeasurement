package org.quantity.management.ucs;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private static List<IObserver> observers = new ArrayList<IObserver>();

    public void register(IObserver o1) {
        observers.add(o1);
    }

    public void unRegister(IObserver o1) {
        observers.remove(o1);
    }

    public static void onUpdate() {
        for(IObserver obs : observers) {
            obs.onDataUpdate();
        }
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.register(new Observer1());
        subject.register(new Observer2());
        Subject.onUpdate();
    }
}
