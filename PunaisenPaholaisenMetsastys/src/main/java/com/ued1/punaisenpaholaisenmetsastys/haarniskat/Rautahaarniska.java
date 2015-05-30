package com.ued1.punaisenpaholaisenmetsastys.haarniskat;

/**
 * Rautahaarniska on Haarniska, jonka puolustusvoima on 35 ja arvo 50000.
 */
public class Rautahaarniska implements Haarniska {

    @Override
    public int suojaa() {
        return 35;
    }

    @Override
    public String toString() {
        return "Rautahaarniska";
    }

    @Override
    public int arvo() {
        return 50000;
    }

}
