package org.quantity.management.ucs.threads;

public class ThreadUsingClass extends Thread {

    @Override
    public void run() {
        for(int i = 1; i <= 100; i++) {
            System.out.println(i + " ");
        }
        System.out.println();
    }
}
