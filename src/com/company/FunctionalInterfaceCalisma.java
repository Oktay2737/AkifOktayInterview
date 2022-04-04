package com.company;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class dene implements Consumer{

    @Override
    public void accept(Object o) {
        System.out.println(o);
    }
}
public class FunctionalInterfaceCalisma {
    public static void main(String[] args) {
//1. yontem
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);
        dene d = new dene();
        System.out.println("BİRİNCİ YONTEM");
        values.forEach(d);
//2. yontem
        Consumer<Integer> c = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        System.out.println("İKİNCİ YONTEM");
        values.forEach(c);
//3. YONTEM
        Consumer<Integer> c2 =(Integer i)-> System.out.println(i);
        System.out.println("ÜÇÜNCÜ YONTEM");
        values.forEach(c2);
//4 DAHA KISA YAZIM
        Consumer c3 =i-> System.out.println(i);
        System.out.println("4. yontem");
        values.forEach(c3);

    }
}
