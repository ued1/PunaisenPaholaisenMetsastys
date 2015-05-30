package com.ued1.punaisenpaholaisenmetsastys.haarniskat;

/**
 * Timanttihaarniska on Haarniska, jonka puolustusvoima on 45 ja arvo 500000.
 */
public class Timanttihaarniska implements Haarniska {

    @Override
    public int suojaa() {
        return 45;
    }

    @Override
    public String toString() {
        return "Timanttihaarniska";
    }

    @Override
    public int arvo() {
        return 500000;
    }

}
