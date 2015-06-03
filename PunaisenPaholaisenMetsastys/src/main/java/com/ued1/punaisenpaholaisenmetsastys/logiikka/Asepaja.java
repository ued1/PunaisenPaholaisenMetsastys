package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.aseet.*;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.util.ArrayList;

/**
 * Luokka hoitaa pelin asepajan logiikan.
 */
public class Asepaja extends Kauppa {
    
    /**
     * Konstruktori antaa valmiin hinnaston yläluokalle (Kauppa) kutsuessaan
     * yläluokan konstruktoria.
     */
    public Asepaja() {
        super(lisaaAseetValikoimaan());
    }

    private static ArrayList<Ase> lisaaAseetValikoimaan() {
        ArrayList<Ase> aseet = new ArrayList<>();
        aseet.add(new Nyrkki()); // oletusase, ei näy valikoimassa
        aseet.add(new Keppi());
        aseet.add(new Maila());
        aseet.add(new Puukko());
        aseet.add(new Leka());
        aseet.add(new Tikari());
        aseet.add(new Kirves());
        aseet.add(new Hukari());
        aseet.add(new Floretti());
        aseet.add(new Wakizashi());
        aseet.add(new Gladius());
        aseet.add(new Sapeli());
        aseet.add(new Pitkamiekka());
        aseet.add(new Katana());
        aseet.add(new Excalibur());
        return aseet;
    }
        
    /**
     * Metodia käytetään aseen ostamiseen. 
     * @param pelaaja Pelaaja, jolle ase ostetaan
     * @param aseenNumero Asevalikoimassa näkyvän aseen numero
     * @return oston onnistumisesta kertova totuusarvo, true jos osto onnistui 
     */
    public boolean osta(Pelaaja pelaaja, int aseenNumero) {
        if(aseenNumero >= getValikoima().size() || aseenNumero < 0) {
            return false;
        } else if(voikoOstaaAseen(pelaaja, (Ase)getValikoima().get(aseenNumero))) {
            pelaaja.setAse((Ase)getValikoima().get(aseenNumero));
            pelaaja.muutaRahoja(0 - (((Ase)getValikoima().get(aseenNumero)).arvo()));
            return true;
        }
        return false;
    }

    /**
     * Metodia käytetään aseen myymiseen.
     * @param pelaaja Pelaaja, jonka ase halutaan myydä
     * @return myynnin onnistumisesta kertova totuusarvo, true jos myynti onnistui
     */
    public boolean myy(Pelaaja pelaaja) {
        if (voikoMyydaAseen(pelaaja)) {
            pelaaja.muutaRahoja(pelaaja.getAse().arvo() / 2); // 50% takaisin vanhasta aseesta
            pelaaja.setAse(new Nyrkki());
            return true;
        }
        return false;
    }

    /**
     * Metodi tarkistaa voiko pelaaja myydä aseensa. Myynti on mahdollista
     * kun pelaajan aseena on mikä tahansa muu ase kuin nyrkki.
     * @param pelaaja Pelaaja, jonka asetta ollaan myymässä
     * @return totuusarvo, true jos myynti on mahdollinen
     */
    public boolean voikoMyydaAseen(Pelaaja pelaaja) {
        if (pelaaja.getAse().toString().equals("Nyrkki")) {
            return false;
        }
        return true;
    }
    
    /**
     * Metodi tarkistaa voiko pelaaja ostaa tietyn aseen. Osto on mahdollinen
     * jos pelaajalla on riittävästi rahaa ja hänellä on aseena nyrkki.
     * @param pelaaja Pelaaja, jonka ostokyky tarkistetaan
     * @param ase Ase, jota ollaan ostamassa
     * @return totuusarvo, true jos osto on mahdollinen
     */
    public boolean voikoOstaaAseen(Pelaaja pelaaja, Ase ase) {
        if (pelaaja.getRahat() >= ase.arvo() && (pelaaja.getAse().toString().equals("Nyrkki"))) {
            return true;
        }
        return false;
    }

    /**
     * Metodi palauttaa asepajan hinnaston otsikoineen. Aseet ovat numeroituina
     * ja hinnoiteltuina.
     * @return asepajan hinnasto merkkijonona
     */
    @Override
    public String hinnastoMerkkijonona() {
        return "Myynnissä oleva ase\tVoima\n" + super.hinnastoMerkkijonona();
    }
    
}
