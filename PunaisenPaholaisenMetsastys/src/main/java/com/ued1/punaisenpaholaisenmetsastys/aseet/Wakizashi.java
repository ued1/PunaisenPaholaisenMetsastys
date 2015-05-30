package com.ued1.punaisenpaholaisenmetsastys.aseet;

/**
 * Wakizashi on Ase, jonka lyöntivoima on 90 ja hinta 500000.
 */
public class Wakizashi implements Ase {

    @Override
    public int lyo() {
        return 90;
    }

    @Override
    public String toString() {
        return "Wakizashi";
    }

    @Override
    public int arvo() {
        return 500000;
    }

}
