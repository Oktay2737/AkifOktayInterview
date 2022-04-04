package com.company;
abstract class MyClass {
    public static void staticMethod1Abs() {}
    static void staticMethod2Abs() {}			// implizit public

    // static Attribute
    static int staticVar; // = 0
    static final int staticKonst = 1;

    //static init blocks
    static { }

    // static Methoden
    static void staticMethod() {}

    // Attribute des Objektes (der Instanz)
     int objectVar;
     int objectVar2;

    // init blocks
    {}

    // Konstruktoren
    MyClass() {}

    //public static abstract void staticMethod1();

    // Instanzmethoden
    void m1() {}
    abstract void m2(); // wenn die Klasse abstract ist

    //nicht in der Prüfung: innere Typen
    class MyInnerClass {}
    interface MyInnerInterface {}
    enum MyInnerEnumClass {}
    @interface MyInnerAnnotation {}

} // end of MyClass


/*
 * Alle Elemente in einem Interface sind implizit oder explizit public (Java 8)!!!
 */
interface MyInterface {

    // statische konstanten Attribute
    // int K0;				// cf: muss explizit initialisiert werden
    // static int K1;		// cf: muss explizit initialisiert werden
    // static final int K2;	// cf: muss explizit initialisiert werden
    public static final int K3 = 3;
    public static int K4 = 4;	// implizit: final
    public int K5 = 5;			// implizit: final static
    int K6 = 6;					// implizit: final static public


    // statische Methoden
    public static void staticMethod1() {}
    static void staticMethod2() {}			// implizit public



    // abstrakte Instanzmethoden
    public abstract void m1();
    public void m2();			// implizit abstract
    void m3();					// implizit public abstract
    abstract void m4();			// implizit public
    // void m0() {} 			// cf: 'normale' Methode

    // default Intanzmethoden
    default void dm1() {			// implizit public
        m1();
        m2();
    }
    default void dm2() {
        System.out.println("interface dm2");
    }
    public  default  void  dm3(){
        System.out.println("interface dm3");
    }
    // void dm0() {}				// cf: 'normale' Methode


    //nicht in der Prüfung: innere Typen
    //...

} // end of MyInterface

class evlat extends MyClass implements MyInterface{

    @Override
    public void m1() {
        System.out.println("m1");
    }

    @Override
    public void m2() {
        System.out.println("m2");
    }

    @Override
    public void m3() {
        System.out.println("m3");
    }

    @Override
    public void m4() {
        System.out.println("m4");
    }

    @Override
    public void dm2() {
        System.out.println("overrided dm2");
    }

}
public class B04_Elemente_in_Interface {
    public static void main(String[] args) {
        evlat e = new evlat();
        int k3 = e.K3;
       // e.staticVar=9;
        int staticKonst = e.staticKonst;
        e.dm2();
        e.dm3();
        System.out.println("e.staticVar = " + e.staticVar);
        System.out.println("e.objectVar = " + e.objectVar);
        e.staticMethod2Abs();
        MyInterface e2 = new evlat();
        MyClass e3 = new evlat();

    }
}
