
package com.ued1.punaisenpaholaisenmetsastys.haarniskat;

public class Takki implements Haarniska {

    @Override
    public int suojaa() {
        return 15;
    }

    @Override
    public String nimi() {
        return "Nahkatakki";
    }

    @Override
    public int arvo() {
        return 500;
    }
    
}
