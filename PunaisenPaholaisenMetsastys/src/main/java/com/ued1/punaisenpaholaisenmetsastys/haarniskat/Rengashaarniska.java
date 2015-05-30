package com.ued1.punaisenpaholaisenmetsastys.haarniskat;

/**
 * Rengashaarniska on Haarniska, jonka puolustusvoima on 25 ja arvo 5000.
 */
public class Rengashaarniska implements Haarniska {

    @Override
    public int suojaa() {
        return 25;
    }

    @Override
    public String toString() {
        return "Rengashaarniska";
    }

    @Override
    public int arvo() {
        return 5000;
    }

}
