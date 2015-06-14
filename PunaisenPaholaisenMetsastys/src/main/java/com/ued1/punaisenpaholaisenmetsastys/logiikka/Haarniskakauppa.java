
package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.haarniskat.*;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.util.ArrayList;

/**
 * Luokka hoitaa pelin haarniskakaupan logiikan.
 */
public class Haarniskakauppa extends Kauppa {
    
    public Haarniskakauppa() {
        super(lisaaHaarniskatValikoimaan());
    }
    
    private static ArrayList<Haarniska> lisaaHaarniskatValikoimaan() {
        ArrayList<Haarniska> haarniskat = new ArrayList<>();
        haarniskat.add(new Riepu());
        haarniskat.add(new Vaatteet()); // 1
        haarniskat.add(new Takki()); // 2
        haarniskat.add(new Nahkatakki());
        haarniskat.add(new Rengashaarniska());
        haarniskat.add(new Pronssihaarniska());
        haarniskat.add(new Rautahaarniska());
        haarniskat.add(new Titanhaarniska());
        haarniskat.add(new Timanttihaarniska());
        haarniskat.add(new BatmanAsu());
        haarniskat.add(new PotterinViitta()); // 10
        haarniskat.add(new PomminPurkuPuku()); // 11
        haarniskat.add(new PinkitTrigoot()); // 12
        return haarniskat;
    }
    
    /**
     * Metodi tarkistaa voiko pelaaja ostaa tietyn haarniskan. 
     * Osto on mahdollinen jos pelaajalla on riittävästi rahaa.
     * 
     * @param pelaaja Pelaaja, joka on haarniskaa ostamassa
     * @param haarniska Haarniska, jota pelaaja on ostamassa
     * @return totuusarvo, true jos osto on mahdollinen
     */
    public boolean voikoOstaaHaarniskan(Pelaaja pelaaja, Haarniska haarniska) {
        if(pelaaja.getRahat() < haarniska.arvo()) {
            return false;
        }
        return true;
    }
            
    /**
     * Haarniskan ostamiseen tarkoitettu metodi.
     * @param pelaaja Pelaaja, jolle haarniska ostetaan
     * @param haarniskanNumero Ostettavan haarniskan numero hinnastosta
     * @return totuusarvo, true jos osto onnistui
     */
    @Override
    public boolean osta(Pelaaja pelaaja, int haarniskanNumero) {
        if(voikoPelaajaOstaaOstoksen(pelaaja, haarniskanNumero)) {
            Haarniska haarniska = (Haarniska)getValikoima().get(haarniskanNumero);
            pelaaja.setHaarniska(haarniska);
            pelaaja.muutaRahoja(0-haarniska.arvo());
            return true;
        }
        return false;
    }
        
    /**
     * Metodi palauttaa haarniskakaupan hinnaston merkkijonona, haarniskat
     * numeroituina ja hinnoiteltuina.
     * @return hinnasto merkkijonona
     */
    @Override
    public String valikoimaMerkkijonona() {
        return "Myynnissä oleva haarniska  Puolustusvoima\n" + super.valikoimaMerkkijonona();
    }
    
        
        
    
}
