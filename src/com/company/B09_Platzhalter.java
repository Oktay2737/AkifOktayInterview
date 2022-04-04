package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Tier {}

class Katze extends Tier {}

class Hund extends Tier {}
class Wildhund extends Hund {}

public class B09_Platzhalter {

    /*
     * Plathalter (englisch wildcards)
     */
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add(2);
        list.add("Oktay");

        int[] s1 = new int[5];
        Integer[] s2 = new Integer[5];
        List<Integer> s3 = new ArrayList<>();
    //    List<int> s4 = new ArrayList<>();

        List<Hund> listHunde = new ArrayList<Hund>();
        listHunde.add(new Hund());
        listHunde.add(new Wildhund()); // Hund param = new Wildhund(): IS-A ist OK

        /*
         * Referenzenzuweisung beim Aufruf der Methode -
         * das Argument in den Parameter kopieren.
         *
         * Collection<? extends Tier> coll = listHunde
         *
         * 1. Kontrolle:  	Collection <- IS-A <- List			: OK
         * 2. Kontrolle:	<? extends Tier> <- passt <- <Hund>	: cf
         */
        System.out.println("1-----------------");
        print(listHunde);

        /*
         * Collection<? super Hund> coll = listHunde
         *
         * 1. Kontrolle:  	Collection <- IS-A <- List			: OK
         * 2. Kontrolle:	<? super Hund> <- passt <- <Hund>	: OK
         */
        addZweiHunde(listHunde); // ok

        Set<Katze> setKatzen = new HashSet<Katze>();
        setKatzen.add(new Katze());
        setKatzen.add(new Katze());

        /*
         * 1. Kontrolle:	Collection <- IS-A <- Set		: OK
         * 2. Kontrolle:	<? extends Tier> passt <Katze>	: cf
         */
        System.out.println("2-----------------");
        print(setKatzen);

        /*
         * 1. Kontrolle:  	Collection <- IS-A <- Set		: OK
         * 2. Kontrolle:	<? super Hund> <- passt NICHT <- <Katze>	: cf
         */
        // addZweiHunde(setKatze); // cf

        Collection<Tier> collTiere = new ArrayDeque<Tier>();
        collTiere.add(new Hund());
        collTiere.add(new Wildhund());
        collTiere.add(new Katze());

        /*
         * 1. Kontrolle:	Collection <- IS-A <- Collection	: OK
         * 2. Kontrolle:	<? extends Tier> passt <Tier>		: OK
         */
        System.out.println("3-----------------");
        print(collTiere);

        /*
         * 1. Kontrolle:  	Collection <- IS-A <- Collection	: OK
         * 2. Kontrolle:	<? super Hund> <- passt <- <Tier>	: OK
         */
        addZweiHunde(collTiere); // ok
    }

    /*
     * <? super Hund> bedeutet, dass bei der Zuweisung in die
     * Referenz coll die andere Referenz mit Hund oder mit einem
     * Basistyp parametrisiert werden darf.
     */
    static void addZweiHunde(Collection<? super Hund> coll) {
        coll.add(new Hund());
        coll.add(new Wildhund());
        System.out.println("------> "+coll);
//		coll.add(new Katze());
//		coll.add(new Tier());
    }

    /*
     * <? extends Tier> bedeutet, dass bei der Zuweisung in die
     * Referenz coll die andere Referenz mit Tier oder mit einem von
     * Tier abgeleiteten Typ parametrisiert werden darf.
     *
     * Das mach die Variable coll universeller (und damit auch die print-Methode)
     *
     * Nicht in der Prüfung, aber wichtig:
     *
     * Wenn eine Referenz mit '? extends' parametrisiert wurde,
     * kann mit dieser Referenz keine Methode aufgerufen werden,
     * die einen generischen Parameter hat.
     *
     *
     * Notiz: <?> und <? extends Object> ist dasselbe
     */
    static void print(Collection<? extends Tier> coll) {
        System.out.println("Collection: " + coll.getClass().getName());
        for(Tier t : coll) {
            System.out.println(t);
        }
        // add hat generischen Parameter:
//		coll.add(new Tier());
//		coll.add(new Hund());
//		coll.add(new Wildhund());
//		coll.add(new Katze());

        // folgende Methoden haben Object als Parameter:
        coll.contains(new Hund()); // evtl. sinnlos, aber keine Typsicherheitverletzung
        coll.remove(new Hund()); // evtl. sinnlos, aber keine Typsicherheitverletzung
    }

}
