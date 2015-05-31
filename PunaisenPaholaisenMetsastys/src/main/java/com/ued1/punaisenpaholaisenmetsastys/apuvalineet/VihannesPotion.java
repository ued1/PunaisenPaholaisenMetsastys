
package com.ued1.punaisenpaholaisenmetsastys.apuvalineet;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;

/**
 * VihannesPotion parantaa pelaajan taistelun aikana
 */
public class VihannesPotion implements Apu {
    
    private Pelaaja pelaaja;
    
    public VihannesPotion(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }
    
    @Override
    public String toString() {
        return "VihannesPotion";
    }

    @Override
    public boolean auta() {
        if(pelaaja.getVointi() < pelaaja.getMaxVointi()) {
            pelaaja.paranna();
            return true;
        }
        return false;
    }

    @Override
    public String kuvaus() {
        return "VihannesPotion parantaa sinut ja olet taas voimissasi!";
    }

    @Override
    public int arvo() {
        return 50;
    }
    
    
}
