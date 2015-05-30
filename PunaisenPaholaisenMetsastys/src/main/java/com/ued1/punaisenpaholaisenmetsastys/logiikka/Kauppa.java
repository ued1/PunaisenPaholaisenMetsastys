
package com.ued1.punaisenpaholaisenmetsastys.logiikka;

// Yläluokka kaupoille: Asepaja, Haarniskakauppa, Välinekauppa(TODO)

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.util.ArrayList;

public abstract class Kauppa {
    
    
    private ArrayList<Object> valikoima; // TODO: Object --> Ostos
    
    public Kauppa() {
        valikoima = new ArrayList<>();
    }
    
    public abstract boolean voikoPelaajaOstaaOstoksen(Pelaaja pelaaja, int ostoksenNumero);
    
    
    public String ostoKomennot(Pelaaja pelaaja, int ostoksenNumero) {
        String ostettavatOstokset = "";
        for(int i = 1; i < valikoima.size(); i++) {
            if(voikoPelaajaOstaaOstoksen(pelaaja, i)) {
                if(i > 9) {
                    ostettavatOstokset += "["; // + valikoima.get(i).nimi().charAt(0); // FIX --> A B C D E F
                } else {
                    ostettavatOstokset += "[" + i;
                }
                ostettavatOstokset += "] "; // + valikoima.get(i).nimi();
                if(i%2==0) {
                    ostettavatOstokset += "\n";
                } else {
                    ostettavatOstokset += "\t";
                }
            }
        }
        ostettavatOstokset += "[T]akaisin";
        return ostettavatOstokset;
    }
    
}


