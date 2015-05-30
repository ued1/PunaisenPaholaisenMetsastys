package com.ued1.punaisenpaholaisenmetsastys.haarniskat;

/**
 * Kylpytakki on Haarniska, jonka puolustusvoima on 5 ja arvo 50.
 */
public class Kylpytakki implements Haarniska {

    @Override
    public int suojaa() {
        return 5;
    }

    @Override
    public String toString() {
        return "Kylpytakki";
    }

    @Override
    public int arvo() {
        return 50;
    }

}
