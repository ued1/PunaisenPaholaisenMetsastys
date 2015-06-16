package com.ued1.punaisenpaholaisenmetsastys.peli.aseet;

/**
 * Keppi on Ase, jonka lyöntivoima 10 on ja hinta 50.
 */
public class Keppi implements Ase {

    @Override
    public int lyo() {
        return 10;
    }

    @Override
    public String toString() {
        return "Keppi";
    }

    @Override
    public int arvo() {
        return 50;
    }

}
