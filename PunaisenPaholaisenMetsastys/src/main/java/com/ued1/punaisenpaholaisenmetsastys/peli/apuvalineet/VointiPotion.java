package com.ued1.punaisenpaholaisenmetsastys.peli.apuvalineet;

import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;

/**
 * VointoPotion parantaa pelaaja.
 */
public class VointiPotion extends Apu {

    private Pelaaja pelaaja;

    public VointiPotion(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }

    @Override
    public String toString() {
        return "VointiPotion";
    }

    @Override
    public boolean auta() {
        return true;
    }

    @Override
    public String kuvaus() {
        return "VointiPotion";
    }

    @Override
    public int arvo() {
        return 0;
    }

}
