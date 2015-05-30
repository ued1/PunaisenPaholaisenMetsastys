package com.ued1.punaisenpaholaisenmetsastys.aseet;

/**
 * Katana on Ase, jonka lyöntivoima on 130 ja hinta 50000000.
 */
public class Katana implements Ase {

    @Override
    public int lyo() {
        return 130;
    }

    @Override
    public String toString() {
        return "Katana";
    }

    @Override
    public int arvo() {
        return 50000000;
    }

}
