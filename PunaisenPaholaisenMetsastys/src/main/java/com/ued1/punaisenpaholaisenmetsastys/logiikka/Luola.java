
package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Riepu;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Hahmo;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Monsteri;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;

/**
 * Luokka Luola määrittelee luolan toiminnallisuuden. Luola on pelin loppu
 * ja ilmestyy metsään kun pelaaja on korkeimmalla mahdollisella tasolla.
 */
public class Luola {

    private Pelaaja pelaaja;
    private Taistelu taistelu;
    private Hahmo paholainen;
    
    public Luola(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.taistelu = null;
        this.paholainen = new Monsteri(1000,150,65, "Punainen Paholainen");
    }
    
    /**
     * Metodi alustaa taistelun Punaista Paholaista vastaan.
     */
    public void haastaPaholainen() {
        taistelu = new Taistelu(pelaaja, paholainen);
    }
    
    /**
     * Metodi palauttaa meneillään olevan taistelun.
     * 
     * @return meneillään oleva Taistelu
     */
    public Taistelu getTaistelu() {
        return taistelu;
    }
    
    /**
     * Metodi asettaa taistelun tuloksen. Pelaajan hävitessä rahat laskevat
     * nollaan ja pelaaja menettää haarniskan. Pelaaja kuitenkin parantuu ja
     * voi jatkaa peliä. Pelaajan voittessa peli loppuu.
     */
    public void asetaTulos() {
        if(pelaaja.onkoElossa()) {
            //TODO
        } else {
            pelaaja.setHaarniska(new Riepu());
            pelaaja.muutaRahoja(-pelaaja.getRahat());
            pelaaja.paranna();
        }
    }
    
    
}
