package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.aseet.*;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.util.ArrayList;

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

    public boolean ostaAse(Pelaaja pelaaja, int aseenNumero) {
        if (voikoOstaaAseen(pelaaja, aseet.get(aseenNumero))) {
            pelaaja.setAse(aseet.get(aseenNumero));
            pelaaja.muutaRahoja(0 - (aseet.get(aseenNumero).arvo()));
            return true;
        }
        return false;
    }

    public boolean myyAse(Pelaaja pelaaja) {
        if (voikoMyydaAseen(pelaaja)) {
            pelaaja.muutaRahoja(pelaaja.getAse().arvo() / 2); // 50% takaisin vanhasta aseesta
            pelaaja.setAse(new Nyrkki());
            return true;
        }
        return false;
    }

    public boolean voikoMyydaAseen(Pelaaja pelaaja) {
        if (pelaaja.getAse().nimi().equals("Nyrkki")) {
            return false;
        }
        return true;
    }

    public boolean voikoOstaaAseen(Pelaaja pelaaja, Ase ase) {
        // asetta ei voi ostaa jos kädessä on jo ase
        if (pelaaja.getRahat() >= ase.arvo() && (pelaaja.getAse().nimi().equals("Nyrkki"))) {
            return true;
        }
        return false;
    }

    public String hinnastoMerkkijonona() {
        String hinnasto = "";
        for (int i = 1; i < aseet.size(); i++) {
            hinnasto += "" + i + " " + aseet.get(i).nimi() + "  \t" + aseet.get(i).arvo() + "\n";
        }
        return hinnasto;
    }
    
    public boolean voikoPelaajaOstaaAseenNumero(Pelaaja pelaaja, int numero) {
        if(numero > 0 && numero < aseet.size()) {
            if(pelaaja.getRahat() >= aseet.get(numero).arvo() && pelaaja.getAse().nimi().equals("Nyrkki")) {
                return true;
            }
        }
        return false;
    }
    
    public String ostettavatAseetMerkkijonona(Pelaaja pelaaja) {
        String ostettavatAseet = "";
        for(int i = 1; i < aseet.size(); i++) {
            if(voikoPelaajaOstaaAseenNumero(pelaaja, i)) {
                ostettavatAseet += "[" + i + "] " + aseet.get(i).nimi() + "\n";
            }
            
        }
        ostettavatAseet += "[T]akaisin";
        return ostettavatAseet;
    }

}
