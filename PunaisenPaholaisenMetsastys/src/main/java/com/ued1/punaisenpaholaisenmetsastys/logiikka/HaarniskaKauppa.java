
package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.haarniskat.*;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.util.ArrayList;

/**
 * Luokka hoitaa pelin haarniskakaupan logiikan.
 */
public class HaarniskaKauppa {
    
    private ArrayList<Haarniska> haarniskat;
    
    public HaarniskaKauppa() {
        haarniskat = new ArrayList<>();
        lisaaHaarniskatValikoimaan();
        // lajittele haarniskat arvojärjestykseen
    }
    
    private void lisaaHaarniskatValikoimaan() {
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
    }
    
    // TODO: BUGI, ei voi ostaa kaikkia haarniskoita koska ei voi painaa nappia 10 tai suurempi
    
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
     * Metodi tarkistaa voiko pelaaja ostaa hinnastossa numeroidun haarniskan.
     * Osto on mahdollinen jos pelaajalla on riittävästi rahaa ja numero löytyy
     * hinnastosta.
     * 
     * @param pelaaja Pelaaja, joka on haarniskaa ostamassa
     * @param numero Haarniskan numero hinnastossa
     * @return totuusarvo, true jos osto on mahdollinen
     */
    public boolean voikoOstaaHaarniskanNumero(Pelaaja pelaaja, int numero) {
        if(numero > 0 && numero < haarniskat.size() && pelaaja.getRahat() >= haarniskat.get(numero).arvo()) {
            return true;
        }
        return false;
    }
    
    /**
     * Haarniskan ostamiseen tarkoitettu metodi.
     * @param pelaaja Pelaaja, jolle haarniska ostetaan
     * @param haarniskanNumero Ostettavan haarniskan numero hinnastosta
     * @return totuusarvo, true jos osto onnistui
     */
    public boolean ostaHaarniska(Pelaaja pelaaja, int haarniskanNumero) {
        if(voikoOstaaHaarniskan(pelaaja, haarniskat.get(haarniskanNumero))) {
            pelaaja.setHaarniska(haarniskat.get(haarniskanNumero));
            pelaaja.muutaRahoja(0-haarniskat.get(haarniskanNumero).arvo());
            return true;
        }
        return false;
    }
        
    /**
     * Metodi palauttaa haarniskakaupan hinnaston merkkijonona, haarniskat
     * numeroituina ja hinnoiteltuina.
     * @return hinnasto merkkijonona
     */
    public String hinnastoMerkkijonona() {
        String hinnasto = "";
        for (int i = 1; i < haarniskat.size(); i++) {
            hinnasto += "" + i + " " + haarniskat.get(i).nimi() + "\t" + haarniskat.get(i).arvo() + "\n";
        }
        return hinnasto;
    }
    
    /**
     * Metodi palauttaa komentovalikkoon sopivan merkkijonon ostettavissa
     * olevista haarniskoista, sekä [T]akaisin komennon.
     * @param pelaaja Pelaaja, joka on haarniskoja ostamassa
     * @return haarniskanostokomennot merkkijonona
     */
    public String haarniskanOstoKomennot(Pelaaja pelaaja) {
        String ostettavatHaarniskat = "";
        for(int i = 1; i < haarniskat.size(); i++) {
            if(voikoOstaaHaarniskanNumero(pelaaja, i)) {
                ostettavatHaarniskat += "[" + i + "] " + haarniskat.get(i).nimi() + "\n";
            }
        }
        ostettavatHaarniskat += "[T]akaisin";
        return ostettavatHaarniskat;
    }
    
        
    
}
