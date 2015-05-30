package com.ued1.punaisenpaholaisenmetsastys.aseet;

/**
 * Leka on Ase, jonka lyöntivoima on 40 ja hinta 1000.
 */
public class Leka implements Ase {

    @Override
    public int lyo() {
        return 40;
    }

    @Override
    public String toString() {
        return "Leka";
    }

    @Override
    public int arvo() {
        return 1000;
    }

}
