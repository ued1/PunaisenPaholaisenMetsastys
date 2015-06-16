
package com.ued1.punaisenpaholaisenmetsastys.peli.apuvalineet;

import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;
import java.util.Random;

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
    
    /**
     * Pupu "auttaa" pelaajaa varastamalla pelaajan rahat 1/15 todennäköisyydellä.
     * Pupu ei "auta" mikäli pelaajalla ei ole rahaa.
     * 
     * @return totuusarvo, true jos pupu vie rahat
     */
    @Override
    public boolean auta() {
        Random arpoja = new Random();
        if(pelaaja.getRahat() > 0 && arpoja.nextInt(16) == 5) {
            pelaaja.muutaRahoja(-pelaaja.getRahat());
            pelaaja.poistaApu(this);
            return true;
        }
        return false;
    }

    @Override
    public String kuvaus() {
        return "\nPupu varasti kaikki rahasi\nja loikki tiehensä!";
    }

    @Override
    public int arvo() {
        return 10;
    }
    
}
