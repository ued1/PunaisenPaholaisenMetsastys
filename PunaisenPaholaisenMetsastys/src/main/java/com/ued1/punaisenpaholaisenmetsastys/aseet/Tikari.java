package com.ued1.punaisenpaholaisenmetsastys.aseet;

/**
 * Tikari on Ase, jonka lyöntivoima on 50 ja hinta 5000.
 */
public class Tikari implements Ase {

    @Override
    public int lyo() {
        return 50;
    }

    @Override
    public String toString() {
        return "Tikari";
    }

    @Override
    public int arvo() {
        return 5000;
    }

}
