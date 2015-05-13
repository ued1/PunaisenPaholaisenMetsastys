
package com.ued1.punaisenpaholaisenmetsastys.hahmot;

import com.ued1.punaisenpaholaisenmetsastys.aseet.Ase;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Haarniska;

public class Monsteri {

    private String nimi;
    private int taso;
    private Ase ase;
    private Haarniska haarniska;
    
    public Monsteri(int taso) {
        // arpoo nimen
        this.taso = taso;
        // arpoo aseen, korkeintaan tasoa vastaava ase
        // arpoo haarniskan, korkeintaan tasoa vastaava haarniska
    }
    
    public int getVoima() {
        // määräytyy aseen ja tason mukaan
        return -1;
    }
    
    public int getPuolustus() {
        // määräytyy haarniskan ja tason mukaan
        return -1;
    }
    
    public String getNimi() {
        return nimi;
    }
    
}
