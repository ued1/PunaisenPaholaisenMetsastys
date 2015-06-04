
package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.Apu;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.VihannesPotion;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;

/**
 * Kylän parantajalta saa apuja tilanteisiin, missä vointi ei ole paras mahdollinen.
 */
public class Parantaja {
    
    public Parantaja() {
    }
    
    /**
     * Metodi parantaa pelaajan.
     * 
     * @param pelaaja Pelaaja, joka parannetaan
     */
    public void paranna(Pelaaja pelaaja) {
        pelaaja.paranna();
    }
    
    public boolean voikoOstaa(Pelaaja pelaaja) {
        Apu vihannesPotion = new VihannesPotion(pelaaja);
        if(vihannesPotion.arvo() <= pelaaja.getRahat()) { // TODO: lisää tarkistus onko pelaajalla liikaa potioneja
            return true;
        }
        return false;
    }
    
    // TODO: myy potioneja
    // TODO: potionit pelaajatietopaneeliin
    // TODO: pelaajalle vastaava muuttuja
    
}
