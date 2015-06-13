
package com.ued1.punaisenpaholaisenmetsastys.apuvalineet;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;

/**
 * KossuPotion on Apu, joka laskee pelaajan vointia yhdellä.
 */
public class KossuPotion extends Apu {
    
    private Pelaaja pelaaja;
    
    public KossuPotion(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }
    
    @Override
    public String toString() {
        return "KossuPotion";
    }

    @Override
    public boolean auta() {
        if(pelaaja.getVointi()>1) {
            pelaaja.laskeVointia();
            return true;
        }
        return false;
    }

    @Override
    public String kuvaus() {
        return "Humaltuminen laskee vointiasi yhdellä.";
    }

    @Override
    public int arvo() {
        return 2;
    }
    
}
