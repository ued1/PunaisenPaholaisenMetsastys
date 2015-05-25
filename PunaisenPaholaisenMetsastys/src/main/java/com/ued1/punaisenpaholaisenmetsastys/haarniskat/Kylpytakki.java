
package com.ued1.punaisenpaholaisenmetsastys.haarniskat;

public class Kylpytakki implements Haarniska {

    @Override
    public int suojaa() {
        return 5;
    }

    @Override
    public String nimi() {
        return "Kylpytakki";
    }

    @Override
    public int arvo() {
        return 50;
    }
    
}
