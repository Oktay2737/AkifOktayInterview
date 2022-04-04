package com.company;
class Basisklasse<G>{
    G m(G param){return  param;}
}
class TuretilmisSinif1<N> extends  Basisklasse<String >{}
class TuretilmisSinif2<N> extends  Basisklasse<N >{}
public class GenericClasse {
    public static void main(String[] args) {
        TuretilmisSinif1<Integer> v1 = new TuretilmisSinif1<>();
        String  s = v1.m("Hallo");
        System.out.println("s = " + s);
        TuretilmisSinif2<Integer> v2 = new TuretilmisSinif2<>();
        int i = v2.m(2);
        System.out.println("i = " + i);
    }
}
