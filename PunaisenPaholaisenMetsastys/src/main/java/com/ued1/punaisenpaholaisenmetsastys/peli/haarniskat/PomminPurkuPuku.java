package com.ued1.punaisenpaholaisenmetsastys.peli.haarniskat;

/**
 * PomminPurkuPuku on Haarniska, jonka puolustusvoima on 60 ja arvo 10000000.
 */
public class PomminPurkuPuku implements Haarniska {

    @Override
    public int suojaa() {
        return 60;
    }

    @Override
    public String toString() {
        return "PomminPurkuPuku";
    }

    @Override
    public int arvo() {
        return 10000000;
    }

}
