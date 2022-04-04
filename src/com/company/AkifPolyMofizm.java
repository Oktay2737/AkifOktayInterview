package com.company;

import java.util.ArrayList;
import java.util.List;

class Personel{
    public  String ad;
}

class Ogretmen extends Personel{
    public String ders;
}
class Ogrenci extends Personel {
    public int numarası;
}
class Temizlikci extends  Personel {

}
public class AkifPolyMofizm {
    public static void main(String[] args) {
        Temizlikci tem1 = new Temizlikci();

        Ogrenci og1 = new Ogrenci();
        og1.ad= "akif";

        Ogretmen ogt1 = new Ogretmen();
        ogt1.ad ="Cemil";

        List<Personel> per1  = new ArrayList<>();
        per1.add(og1);
        per1.add(ogt1);

        List<Ogrenci> per2 = new ArrayList<>();
        per2.add(og1);



    }
}
