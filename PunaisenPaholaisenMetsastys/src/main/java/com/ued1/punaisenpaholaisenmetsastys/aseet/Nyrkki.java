package com.ued1.punaisenpaholaisenmetsastys.aseet;

/**
 * Nyrkki on pelaajan oletusase, jonka lyöntivoima on 6. Nyrkkiä ei voi myydä.
 */
public class Nyrkki implements Ase {

    @Override
    public int lyo() {
        return 6;
    }

    @Override
    public String toString() {
        return "Nyrkki";
    }

    @Override
    public int arvo() {
        return 0;
    }

}
