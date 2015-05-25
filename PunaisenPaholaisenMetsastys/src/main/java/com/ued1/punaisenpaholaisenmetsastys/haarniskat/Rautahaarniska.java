
package com.ued1.punaisenpaholaisenmetsastys.haarniskat;

public class Rautahaarniska implements Haarniska {

    @Override
    public int suojaa() {
        return 35;
    }

    @Override
    public String nimi() {
        return "Rautahaarniska";
    }

    @Override
    public int arvo() {
        return 50000;
    }
    
}
