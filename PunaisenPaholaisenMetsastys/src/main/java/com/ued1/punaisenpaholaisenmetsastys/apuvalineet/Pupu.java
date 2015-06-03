
package com.ued1.punaisenpaholaisenmetsastys.apuvalineet;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;

/**
 * Pupu on Apu, joka ...
 */
public class Pupu implements Apu {
    
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
        
        // TODO
        
        return false;
    }

    @Override
    public String kuvaus() {
        // TODO
        return "";
    }

    @Override
    public int arvo() {
        return 100;
    }
    
    
    
}
