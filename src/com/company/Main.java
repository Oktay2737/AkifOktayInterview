package com.company;
interface MyOperation {
    int execute(int a, int b);
    void yaz(String ad);
}

interface MyCombiner {
    int combine(int x, int y);
}


class MyAdder implements MyOperation, MyCombiner {
    public int execute(int a, int b) { return a + b; }

    @Override
    public void yaz(String ad) {
        System.out.println(ad);
    }

    public int combine(int x, int y) { return execute(x, y); }
}

public class Main {

    public static void main(String[] args) {

        MyCombiner mc = new MyAdder();	 // MyCombiner <- IS-A <- MyAdder
        int combination = mc.combine(5, 7);
        System.out.println("combination = " + combination);
    }


}
