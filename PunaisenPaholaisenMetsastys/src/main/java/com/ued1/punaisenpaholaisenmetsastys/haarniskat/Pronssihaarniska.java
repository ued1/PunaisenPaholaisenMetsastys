
package com.ued1.punaisenpaholaisenmetsastys.haarniskat;

public class Pronssihaarniska implements Haarniska {

    @Override
    public int suojaa() {
        return 30;
    }

    @Override
    public String nimi() {
        return "Pronssihaarniska";
    }

    @Override
    public int arvo() {
        return 10000;
    }
    
}
