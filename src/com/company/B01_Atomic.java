package com.company;
import java.util.concurrent.atomic.AtomicInteger;

public class B01_Atomic {


    /*
     * AtomicInteger, AtomicLong...
     */
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger count = new AtomicInteger();

        Runnable target = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                // AtomicInteger ist threadsafe.
                // Synchronisieren ist nicht nötig.
                count.incrementAndGet();
            }
        };

        Thread t1 = new Thread(target);
        Thread t2 = new Thread(target);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count); // 2 Mio.
    }

}
