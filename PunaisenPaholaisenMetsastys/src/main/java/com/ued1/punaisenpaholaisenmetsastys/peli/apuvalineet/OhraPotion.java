
package com.ued1.punaisenpaholaisenmetsastys.peli.apuvalineet;

import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;

/**
 * OhraPotion on Apu, joka auttaa areenataistelussa nostamalla pelaajan
 * vointia hetkellisesti.
 */
public class OhraPotion extends Apu {
    
    private int[] hinta = {0, 50, 100, 500, 1000, 5000, 50000, 100000, 500000, 1000000, 5000000};
    private Pelaaja pelaaja;
    
    public OhraPotion(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }
    
    @Override
    public String toString() {
        return "OhraPotion";
    }
    
    @Override
    public boolean auta() {
        pelaaja.vointiBuusti();
        pelaaja.poistaApu(this);
        return true;
    }

    @Override
    public String kuvaus() {
        return "OhraPotion nostattaa hetkellisesti vointia";
    }

    @Override
    public int arvo() {
        return hinta[pelaaja.getTaso()];
    }
    
}
