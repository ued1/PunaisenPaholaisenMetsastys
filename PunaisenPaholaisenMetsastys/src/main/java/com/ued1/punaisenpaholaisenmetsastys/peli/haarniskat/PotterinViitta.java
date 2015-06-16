package com.ued1.punaisenpaholaisenmetsastys.peli.haarniskat;

/**
 * PotterinViitta on Haarniska, jonka puolustusvoima on 55 ja arvo 5000000.
 */
public class PotterinViitta implements Haarniska {

    @Override
    public int suojaa() {
        return 55;
    }

    @Override
    public String toString() {
        return "Potterin Viitta";
    }

    @Override
    public int arvo() {
        return 5000000;
    }

}
