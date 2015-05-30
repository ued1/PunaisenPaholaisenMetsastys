package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.aseet.*;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.util.ArrayList;

/**
 * Luokka hoitaa pelin asepajan logiikan.
 */
public class Asepaja {

    private ArrayList<Ase> aseet;

    public Asepaja() {
        aseet = new ArrayList<>();
        lisaaAseetValikoimaan();
    }

    private void lisaaAseetValikoimaan() {
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
    }
    
    // TODO: BUGI, ei voi ostaa kaikkia aseita koska numeroa >9 ei voi painaa yhdellä napilla
    /**
     * Metodia käytetään aseen ostamiseen. 
     * @param pelaaja Pelaaja, jolle ase ostetaan
     * @param aseenNumero Asevalikoimassa näkyvän aseen numero
     * @return oston onnistumisesta kertova totuusarvo, true jos osto onnistui 
     */
    public boolean ostaAse(Pelaaja pelaaja, int aseenNumero) {
        if(aseenNumero >= aseet.size() || aseenNumero < 0) {
            return false;
        } else if(voikoOstaaAseen(pelaaja, aseet.get(aseenNumero))) {
            pelaaja.setAse(aseet.get(aseenNumero));
            pelaaja.muutaRahoja(0 - (aseet.get(aseenNumero).arvo()));
            return true;
        }
        return false;
    }

    /**
     * Metodia käytetään aseen myymiseen.
     * @param pelaaja Pelaaja, jonka ase halutaan myydä
     * @return myynnin onnistumisesta kertova totuusarvo, true jos myynti onnistui
     */
    public boolean myyAse(Pelaaja pelaaja) {
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
        if (pelaaja.getAse().nimi().equals("Nyrkki")) {
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
        // asetta ei voi ostaa jos kädessä on jo ase
        if (pelaaja.getRahat() >= ase.arvo() && (pelaaja.getAse().nimi().equals("Nyrkki"))) {
            return true;
        }
        return false;
    }

    /**
     * Metodi palauttaa asepajan hinnaston otsikoineen. Aseet ovat numeroituina
     * ja hinnoiteltuina.
     * @return asepajan hinnasto merkkijonona
     */
    public String hinnastoMerkkijonona() {
        String hinnasto = "Myynnissä oleva ase\tHinta\n";
        for (int i = 1; i < aseet.size(); i++) {
            hinnasto += "" + i + ". " + aseet.get(i).nimi() + "           \t" + aseet.get(i).arvo() + "\n";
        }
        return hinnasto;
    }
    
    /**
     * Metodi tarkistaa voiko pelaaja ostaa hinnastosta aseen.
     * @param pelaaja Pelaaja, jolle ollaan asetta ostamassa
     * @param numero Hinnastossa olevan aseen numero
     * @return totuusarvo, joka kertoo onko osto mahdollinen, true jos on
     */
    public boolean voikoPelaajaOstaaAseenNumero(Pelaaja pelaaja, int numero) {
        if(numero > 0 && numero < aseet.size()) {
            if(pelaaja.getRahat() >= aseet.get(numero).arvo() && pelaaja.getAse().nimi().equals("Nyrkki")) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi palauttaa komentovalikkoon sopivan merkkijonon ostettavissa
     * olevista aseista, sekä [T]akaisin komennon listan lopussa.
     * @param pelaaja Pelaaja, joka on aseita ostamassa
     * @return aseenostokomennot merkkijonona
     */
    public String aseenOstoKomennot(Pelaaja pelaaja) {
        String ostettavatAseet = "";
        for(int i = 1; i < aseet.size(); i++) {
            if(voikoPelaajaOstaaAseenNumero(pelaaja, i)) {
                if(i > 9) {
                    ostettavatAseet += "[" + aseet.get(i).nimi().charAt(0);
                } else {
                    ostettavatAseet += "[" + i;
                }
                ostettavatAseet += "] " + aseet.get(i).nimi();
                if(i%2==0) {
                    ostettavatAseet += "\n";
                } else {
                    ostettavatAseet += "\t";
                }
            }
        }
        ostettavatAseet += "[T]akaisin";
        return ostettavatAseet;
    }

}
