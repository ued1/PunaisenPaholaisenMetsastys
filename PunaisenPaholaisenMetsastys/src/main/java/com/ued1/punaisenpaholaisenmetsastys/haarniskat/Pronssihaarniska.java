package com.ued1.punaisenpaholaisenmetsastys.haarniskat;

/**
 * Pronssihaarniska on Haarniska, jonka puolustusvoima on 30 ja arvo 10000.
 */
public class Pronssihaarniska implements Haarniska {

    @Override
    public int suojaa() {
        return 30;
    }

    @Override
    public String toString() {
        return "Pronssihaarniska";
    }

    @Override
    public int arvo() {
        return 10000;
    }

}
