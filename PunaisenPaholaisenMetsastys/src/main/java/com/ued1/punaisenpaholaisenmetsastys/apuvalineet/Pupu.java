
package com.ued1.punaisenpaholaisenmetsastys.apuvalineet;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;

/**
 * Pupu on "Apu", joka varastaa pelaajan rahat.
 */
public class Pupu extends Apu {
    
    private Pelaaja pelaaja;
    
    public Pupu(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }
    
    @Override
    public String toString() {
        return "Pupu";
    }
    
    @Override
    public boolean auta() {
        pelaaja.muutaRahoja(-pelaaja.getRahat());
        return true;
    }

    @Override
    public String kuvaus() {
        return "Pupu varastaa kaikki rahasi\nja loikkii tiehensä!";
    }

    @Override
    public int arvo() {
        return 10;
    }
    
}
