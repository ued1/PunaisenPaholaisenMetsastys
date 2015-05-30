package com.ued1.punaisenpaholaisenmetsastys.aseet;

/**
 * Hukari on Ase, jonka lyöntivoima on 70 ja hinta 50000.
 */
public class Hukari implements Ase {

    @Override
    public int lyo() {
        return 70;
    }

    @Override
    public String toString() {
        return "Hukari";
    }

    @Override
    public int arvo() {
        return 50000;
    }

}
