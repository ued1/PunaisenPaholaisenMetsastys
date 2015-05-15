
package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;

public class Metsa {
    // taistellaan monstereita vastaan
    // monsterit luodaan lennosta, arvotaan pelaajan tasolle sopiva vastus
    // monsterin voittaessa pelaajan rahat kasvavat
       
    private Pelaaja pelaaja;
    
    public Metsa(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }
    
    public boolean taistele() {
        // Monsteri monsteri = new Monsteri(taso?????)
        
        while(true) {
            // monsteri.puolusta(pelaaja.lyo());
            // monsteri !elossa? - break
            // pelaaja.puolusta(monsteri.lyo
            if(!pelaaja.onkoElossa()) {
                break;
            }
            // taistelun pitää jotenkin päättyä
        }
        if(pelaaja.onkoElossa()) {
            // nosta rahaa
            return true;
        } else {
            // jotain
            return false;
        }
        
        
    }
    
    
}
