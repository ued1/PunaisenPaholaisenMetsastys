
package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.aseet.*;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.util.ArrayList;

public class Asepaja {
    
    private ArrayList<Ase> aseet;
    
    public Asepaja() {
        lisaaAseetValikoimaan();
    }
    
    private void lisaaAseetValikoimaan() {
        aseet.add(new Keppi());
    }
    
    public boolean ostaAse(Pelaaja pelaaja, int aseenNumero) {
        // ...
        return true;
    }
    
    public boolean myyAse(Pelaaja pelaaja, int aseenNumero) {
        // ...
        return true;
    }
    
}
