package com.ued1.punaisenpaholaisenmetsastys.aseet;

/**
 * Gladius on Ase, jonka lyöntivoima on 100 ja hinta 1000000.
 */
public class Gladius implements Ase {

    @Override
    public int lyo() {
        return 100;
    }

    @Override
    public String toString() {
        return "Gladius";
    }

    @Override
    public int arvo() {
        return 1000000;
    }

}
