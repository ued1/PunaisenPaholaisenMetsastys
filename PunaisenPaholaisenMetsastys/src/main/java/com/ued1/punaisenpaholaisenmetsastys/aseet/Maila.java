package com.ued1.punaisenpaholaisenmetsastys.aseet;

/**
 * Maila on Ase, jonka lyöntivoima on 20 ja hinta 100.
 */
public class Maila implements Ase {

    @Override
    public int lyo() {
        return 20;
    }

    @Override
    public String toString() {
        return "Maila";
    }

    @Override
    public int arvo() {
        return 100;
    }

}
