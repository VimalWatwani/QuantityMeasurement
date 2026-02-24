package org.quantity.management.ucs.threads;

public class ThreadsMain {

    public static void main(String[] args) throws InterruptedException {
        ThreadUsingClass thread1 = new ThreadUsingClass();
        Thread thread3 = new Thread(new ThreadUsingRunnable(thread1));

        thread1.start();
        thread3.start();
//        ThreadUsingRunnable thread2 = new ThreadUsingRunnable();
//        thread2.run();
    }
}
