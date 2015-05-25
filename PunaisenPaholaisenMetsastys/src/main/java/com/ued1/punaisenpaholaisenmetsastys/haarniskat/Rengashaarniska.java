
package com.ued1.punaisenpaholaisenmetsastys.haarniskat;

public class Rengashaarniska implements Haarniska {

    @Override
    public int suojaa() {
        return 25;
    }

    @Override
    public String nimi() {
        return "Rengashaarniska";
    }

    @Override
    public int arvo() {
        return 5000;
    }
    
}
