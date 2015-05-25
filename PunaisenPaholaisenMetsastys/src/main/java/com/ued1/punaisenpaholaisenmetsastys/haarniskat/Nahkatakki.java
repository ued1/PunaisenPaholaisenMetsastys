
package com.ued1.punaisenpaholaisenmetsastys.haarniskat;

public class Nahkatakki implements Haarniska {

    @Override
    public int suojaa() {
        return 20;
    }

    @Override
    public String nimi() {
        return "Nahkatakki";
    }

    @Override
    public int arvo() {
        return 1000;
    }
    
}
