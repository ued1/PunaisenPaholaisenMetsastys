package com.ued1.punaisenpaholaisenmetsastys.aseet;

/**
 * Sapeli on Ase, jonka lyöntivoima on 110 ja hinta 5000000.
 */
public class Sapeli implements Ase {

    @Override
    public int lyo() {
        return 110;
    }

    @Override
    public String toString() {
        return "Sapeli";
    }

    @Override
    public int arvo() {
        return 5000000;
    }

}
