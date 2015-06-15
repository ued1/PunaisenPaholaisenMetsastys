package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.Apu;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.KossuPotion;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.OhraPotion;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.Pupu;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.RuosteinenAvain;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.VointiPotion;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.util.ArrayList;

/**
 * Luokka hoitaa kylän kapakan toiminnallisuuden. Kapakasta voi ostaa
 * taisteluihin apuvälineitä tai laskea omaa vointia juomalla itsensä humalaan.
 */
public class Kapakka extends Kauppa {

    private Pelaaja pelaaja;

    public Kapakka(Pelaaja pelaaja) {
        super(lisaaAvutValikoimaan(pelaaja));
        this.pelaaja = pelaaja;
    }

    private static ArrayList<Apu> lisaaAvutValikoimaan(Pelaaja pelaaja) {
        ArrayList<Apu> avut = new ArrayList<>();
        Apu vointiPotion = new VointiPotion(pelaaja);
        Apu kossuPotion = new KossuPotion(pelaaja);
        Apu pupu = new Pupu(pelaaja);
        Apu ohraPotion = new OhraPotion(pelaaja);
        Apu ruosteinenAvain = new RuosteinenAvain();
        avut.add(vointiPotion); // ei näy listassa
        avut.add(kossuPotion);
        avut.add(pupu);
        avut.add(ohraPotion);
        avut.add(ruosteinenAvain);
        return avut;
    }

    @Override
    public boolean osta(Pelaaja pelaaja, int ostoksenNumero) {
        if (voikoPelaajaOstaaOstoksen(pelaaja, ostoksenNumero)) {
            if (ostoksenNumero < 2) {
                ((Apu)getValikoima().get(ostoksenNumero)).auta();
            } else if (pelaaja.onkoPelaajallaApu((Apu)getValikoima().get(ostoksenNumero))) {
                return false;
            }
            pelaaja.muutaRahoja(0 - (((Apu)getValikoima().get(ostoksenNumero)).arvo()));
            if(ostoksenNumero > 1) {
                pelaaja.lisaaApu((Apu)getValikoima().get(ostoksenNumero));
            }
            return true;
        }
        return false;
    }

    @Override
    public String valikoimaMerkkijonona() {
        String kuvaus = "Kapakassa voit ostaa hyödyllisiä tai";
        kuvaus += "\nhyödyttömiä asioita.\n\nKokeileminen omalla vastuulla!\n\n";
        kuvaus += String.format("%-30s%-6s", "     Nimi", "Hinta");
        return kuvaus += "\n" + super.valikoimaMerkkijonona();
    }

}
