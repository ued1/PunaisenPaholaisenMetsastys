
package com.ued1.punaisenpaholaisenmetsastys.haarniskat;

public class Vaatteet implements Haarniska {

    @Override
    public String nimi() {
        return "Vaatteet";
    }

    @Override
    public int suojaa() {
        return 10;
    }

    @Override
    public int arvo() {
        return 100;
    }
    
}
