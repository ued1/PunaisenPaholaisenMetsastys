
package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.haarniskat.*;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.util.ArrayList;

public class HaarniskaKauppa {
    
    private ArrayList<Haarniska> haarniskat;
    
    public HaarniskaKauppa() {
        haarniskat = new ArrayList<>();
        lisaaHaarniskatValikoimaan();
        // lajittele haarniskat arvojärjestykseen
    }
    
    private void lisaaHaarniskatValikoimaan() {
        haarniskat.add(new Riepu());
        haarniskat.add(new Vaatteet());
    }
    
    public boolean voikoOstaaHaarniskan(Pelaaja pelaaja, Haarniska haarniska) {
        if(pelaaja.getRahat() < haarniska.arvo()) {
            return false;
        }
        return true;
    }
    
    public boolean voikoOstaaHaarniskanNumero(Pelaaja pelaaja, int numero) {
        if(numero > 0 && numero < haarniskat.size() && pelaaja.getRahat() >= haarniskat.get(numero).arvo()) {
            return true;
        }
        return false;
    }
    
    // aseista poiketen vanhaa haarniskaa ei myydä eikä siitä saa rahaa takaisin
    public boolean ostaHaarniska(Pelaaja pelaaja, int haarniskanNumero) { // TODO: equals tms numeroinnin sijaan
        if(voikoOstaaHaarniskan(pelaaja, haarniskat.get(haarniskanNumero))) {
            pelaaja.setHaarniska(haarniskat.get(haarniskanNumero));
            pelaaja.muutaRahoja(0-haarniskat.get(haarniskanNumero).arvo());
            return true;
        }
        return false;
    }
        
    public String hinnastoMerkkijonona() {
        String hinnasto = "";
        for (int i = 0; i < haarniskat.size(); i++) {
            hinnasto += "" + i + " " + haarniskat.get(i).nimi() + "  \t" + haarniskat.get(i).arvo() + "\n";
        }
        return hinnasto;
    }
    
    public String ostettavissaOlevatHaarniskatMerkkijonona(Pelaaja pelaaja) {
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
