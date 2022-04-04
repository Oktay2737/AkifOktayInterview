package com.company;

    @FunctionalInterface
    interface AritmetikIslem{
        int islemYap(int a, int b);
    }
    class Topla implements AritmetikIslem{
        @Override
        public int islemYap(int a, int b) {
            return a+b;
        }
    }

    class Carp implements AritmetikIslem{
    @Override
    public int islemYap(int a, int b) {
        return a*b;
    }
}

public class FuncInterfaceKendiCalismam {
    public static void main(String[] args) {

        int a = 2;
        int b = 4;
        System.out.println("normal sınıf örnegi ve metodu kullanalım");
        Topla t = new Topla();
        int sonuc = t.islemYap(2,4);
        System.out.println(sonuc);
        Carp c = new Carp();
        sonuc = c.islemYap(2,4);
        System.out.println(sonuc);

        System.out.println("interface parameteresi alan bir metot kullanarak yapalım");
        toplaCarp(a,b, new Topla());
        toplaCarp(a,b, new Carp());

        System.out.println("lambda ile topla böl");
        toplaCarp(50,2,(int x, int y)-> x/y);

        System.out.println("doğrudan lamda ifadeleri ile yapalım");

       AritmetikIslem topla = (int x ,int y)->{return  x+y;} ;
       int toplam = topla.islemYap(2,4);
        System.out.println(toplam);

        AritmetikIslem carp = (int x ,int y)->{return (x*y);} ;
        int çarpim = carp.islemYap(2,4);
        System.out.println(çarpim);

    }

    public static void toplaCarp(int a, int b, AritmetikIslem aritmetikIslem) {
        System.out.println(aritmetikIslem.islemYap(a,b));
    }
}

