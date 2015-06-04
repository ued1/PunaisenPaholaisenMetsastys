
package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.Apu;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.KossuPotion;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.Pupu;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.util.ArrayList;

/**
 * Luokka hoitaa kylän kapakan toiminnallisuuden. Kapakasta voi ostaa taisteluihin
 * apuvälineitä tai laskea omaa vointia juomalla itsensä humalaan.
 */
public class Kapakka extends Kauppa {
    
    private Pelaaja pelaaja;
    
    public Kapakka(Pelaaja pelaaja) {
        super(lisaaAvutValikoimaan(pelaaja));
        this.pelaaja = pelaaja;
    }
    
    private static ArrayList<Apu> lisaaAvutValikoimaan(Pelaaja pelaaja) {
        ArrayList<Apu> avut = new ArrayList<>();
        avut.add(new KossuPotion(pelaaja)); // ei näy listassa
        avut.add(new KossuPotion(pelaaja));
        avut.add(new Pupu(pelaaja));
        return avut;
    }
    
    
    @Override
    public boolean osta(Pelaaja pelaaja, int ostoksenNumero) {
        return false;
    }
    
    @Override
    public String hinnastoMerkkijonona() {
        String kuvaus = "Kapakassa voit ostaa hyödyllisiä tai hyödyttömiä";
        kuvaus += "\nasioita. Kokeileminen omalla vastuulla!\n\n";
        kuvaus += "Nimi\t\tHinta\n\n";
        return kuvaus += super.hinnastoMerkkijonona();
    }
    
    
    
}
