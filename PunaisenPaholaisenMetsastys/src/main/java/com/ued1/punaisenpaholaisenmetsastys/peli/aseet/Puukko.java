package com.ued1.punaisenpaholaisenmetsastys.peli.aseet;

/**
 * Puukko on Ase, jonka lyöntivoima on 30 ja hinta 500.
 */
public class Puukko implements Ase {

    @Override
    public int lyo() {
        return 30;
    }

    @Override
    public String toString() {
        return "Puukko";
    }

    @Override
    public int arvo() {
        return 500;
    }

}
