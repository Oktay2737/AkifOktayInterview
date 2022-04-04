package com.company;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Collection;

public class B05_RawType {
    public static void main(String[] args) {
        Collection<Integer> collInt = new ArrayDeque<>();

        /*
         * Das Versprechen der Generics:
         *
         * Collection hat garantiert NUR Integer-Elemente.
         */
        fillCollection(collInt);
        // ...
        System.out.println(collInt); // 12, 13

        /*
         * Wenn im Code nicht-parametrisierte generische
         * Typen auftauchen (raw type), verschwindet
         * das Versprechen von Generics:
         *
         * Collection kann alles mögliche haben.
         */
        legacyFillCollection(collInt);
        System.out.println(collInt); // [12, 13, 14, Bin kein Integer, 2022-02-07]


    } // end of main

    static void fillCollection(Collection<Integer> coll) {
        coll.add(12);
        coll.add(13);
//		coll.add("string");			// cf
//		coll.add(LocalDate.now());	// cf
    }

    /*
     * Achtung! Bitte niemals mit raw type programmieren:
     */
    static void legacyFillCollection(Collection coll) {
        coll.add(14);
        coll.add("Bin kein Integer");
        coll.add(LocalDate.now());
    }
}
