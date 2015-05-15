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
        aseet.add(new Tikari());
        aseet.add(new Kirves());
        aseet.add(new Miekka());
    }

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

}
