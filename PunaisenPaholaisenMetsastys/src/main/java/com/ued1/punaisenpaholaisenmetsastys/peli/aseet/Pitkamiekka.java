package com.ued1.punaisenpaholaisenmetsastys.peli.aseet;

/**
 * Pitkamiekka on Ase, jonka lyöntivoima on 120 ja hinta 10000000.
 */
public class Pitkamiekka implements Ase {

    @Override
    public int lyo() {
        return 120;
    }

    @Override
    public String toString() {
        return "Pitkamiekka";
    }

    @Override
    public int arvo() {
        return 10000000;
    }

}
