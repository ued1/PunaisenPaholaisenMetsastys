package com.ued1.punaisenpaholaisenmetsastys.haarniskat;

/**
 * Takki on Haarniska, jonka puolustusvoima on 15 ja arvo 500.
 */
public class Takki implements Haarniska {

    @Override
    public int suojaa() {
        return 15;
    }

    @Override
    public String toString() {
        return "Nahkatakki";
    }

    @Override
    public int arvo() {
        return 500;
    }

}
