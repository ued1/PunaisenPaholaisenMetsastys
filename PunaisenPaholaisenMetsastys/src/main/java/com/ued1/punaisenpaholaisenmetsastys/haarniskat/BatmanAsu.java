package com.ued1.punaisenpaholaisenmetsastys.haarniskat;

/**
 * BatmanAsu on Haarniska, jonka puolustusvoima on 50 ja arvo 1000000.
 */
public class BatmanAsu implements Haarniska {

    @Override
    public int suojaa() {
        return 50;
    }

    @Override
    public String toString() {
        return "BatmanAsu";
    }

    @Override
    public int arvo() {
        return 1000000;
    }

}
