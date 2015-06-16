package com.ued1.punaisenpaholaisenmetsastys.peli.haarniskat;

/**
 * Nahkatakki on Haarniska, jonka puolustusvoima on 20 ja arvo 1000.
 */
public class Nahkatakki implements Haarniska {

    @Override
    public int suojaa() {
        return 20;
    }

    @Override
    public String toString() {
        return "Nahkatakki";
    }

    @Override
    public int arvo() {
        return 1000;
    }

}
