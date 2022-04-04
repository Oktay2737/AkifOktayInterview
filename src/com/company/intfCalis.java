package com.company;
interface EtwasMitFarbe {
    int getFarbe();
}

interface EtwasMitPreis {
    int getPreis();
}

class Blume {}
class GameObject {}

class Rose extends Blume {} // Blume <- IS-A <- Rose

//class Nelke extends Blume Object {} // cf
//class Nelke extends Blume, Object {} // cf
//class Nelke extends Blume, GameObject {} // cf
//class Nelke extends Blume, extends GameObject {} // cf
//class Nelke extends Blume extends GameObject {} // cf


class Nelke extends Blume implements EtwasMitPreis, EtwasMitFarbe {
    public int getPreis() { return 12; }
    public int getFarbe() { return 1; }
}

//class Melisse implements EtwasMitPreis extends Blume { // cf
//	public int getPreis() { return 12; }
//}

//class Melisse extends Blume implements EtwasMitPreis implements EtwasMitFarbe { // cf
//	public int getPreis() { return 12; }
//	public int getFarbe() { return 1; }
//}
public class intfCalis {
    public static void main(String[] args) {

    }
}
