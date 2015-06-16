package com.ued1.punaisenpaholaisenmetsastys.peli.haarniskat;

/**
 * PinkitTrigoot on pelin paras Haarniska, jonka puolustusvoima on 65 ja arvo
 * 50000000.
 */
public class PinkitTrigoot implements Haarniska {

    @Override
    public int suojaa() {
        return 65;
    }

    @Override
    public String toString() {
        return "Pinkit Trigoot";
    }

    @Override
    public int arvo() {
        return 50000000;
    }

}
