package org.quantity.management.ucs.threads;

public class ThreadUsingRunnable implements Runnable{

    private Thread threadB;

    public ThreadUsingRunnable(Thread thread) {
        this.threadB = thread;
    }

    public ThreadUsingRunnable() {

    }

    @Override
    public void run() {
        for(char c = 'a'; c <= 'z'; c++) {
            System.out.println(c + " ");
        }
        System.out.println();
        try {
            this.threadB.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
