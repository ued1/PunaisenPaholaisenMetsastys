package com.ued1.punaisenpaholaisenmetsastys.peli.aseet;

/**
 * Excalibur on pelin paras Ase, jonka lyöntivoima on 140 ja hinta 100000000.
 */
public class Excalibur implements Ase {

    @Override
    public int lyo() {
        return 140;
    }

    @Override
    public String toString() {
        return "Excalibur";
    }

    @Override
    public int arvo() {
        return 100000000;
    }

}
