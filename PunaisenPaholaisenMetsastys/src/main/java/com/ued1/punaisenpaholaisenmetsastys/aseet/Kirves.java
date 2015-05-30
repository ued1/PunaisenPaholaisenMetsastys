package com.ued1.punaisenpaholaisenmetsastys.aseet;

/**
 * Kirves on Ase, jonka lyöntivoima on 60 ja hinta 10000.
 */
public class Kirves implements Ase {

    @Override
    public int lyo() {
        return 60;
    }

    @Override
    public String toString() {
        return "Kirves";
    }

    @Override
    public int arvo() {
        return 10000;
    }

}
