package com.ued1.punaisenpaholaisenmetsastys.aseet;

/**
 * Floretti on Ase, jonka lyöntivoima on 80 ja hinta 100000.
 */
public class Floretti implements Ase {

    @Override
    public int lyo() {
        return 80;
    }

    @Override
    public String toString() {
        return "Floretti";
    }

    @Override
    public int arvo() {
        return 100000;
    }

}
