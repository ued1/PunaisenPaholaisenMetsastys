package com.ued1.punaisenpaholaisenmetsastys.peli.haarniskat;

/**
 * Vaatteet on Haarniska, jonka puolustusvoima on 10 ja arvo 100.
 */
public class Vaatteet implements Haarniska {

    @Override
    public String toString() {
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
