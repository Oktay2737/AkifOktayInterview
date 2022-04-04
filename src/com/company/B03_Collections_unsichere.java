package com.company;
import java.util.*;

public class B03_Collections_unsichere {

    public static void main(String[] args) {

       /* for (int i = 0; i < 3; i++) {
            for (int j = 3; j >= 0; j--) {
                if (i == j)
                    continue;
                System.out.println(i + " " + j);
            }
        }*/

        /*
         * 'normale' Collections sind nicht threadsicher
         */
//		testMitZweiThreads(new ArrayList<>()); // Race Condition
//		testMitZweiThreads(new LinkedList<>()); // Race Condition
//		testMitZweiThreads(new HashSet<>()); // Race Condition
//		testMitZweiThreads(new TreeSet<>()); // Race Condition
//		testMitZweiThreads(new ArrayDeque<>()); // Race Condition

        /*
         * Vector:  - wie ArrayList
         * 			- aber threadsicher
         * 			- trotzdem nicht empfohlen
         */
       testMitZweiThreads(new Vector<>());
    }


    static void testMitZweiThreads(Collection<Integer> coll) {

        Runnable target = () -> {
            for (int i = 0; i < 1000; i++) {
                coll.add(i);
            }
        };

        Thread t1 = new Thread(target);
        Thread t2 = new Thread(target);
        Thread t3 = new Thread(target);
        Thread t4 = new Thread(target);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("size: " + coll.size());
    }
}

