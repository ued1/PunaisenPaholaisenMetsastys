package com.ued1.punaisenpaholaisenmetsastys.haarniskat;

/**
 * Titanhaarniska on Haarniska, jonka puolustusvoima on 40 ja arvo 100000.
 */
public class Titanhaarniska implements Haarniska {

    @Override
    public int suojaa() {
        return 40;
    }

    @Override
    public String toString() {
        return "Titanhaarniska";
    }

    @Override
    public int arvo() {
        return 100000;
    }

}
