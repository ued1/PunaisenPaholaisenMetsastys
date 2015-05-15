
package com.ued1.punaisenpaholaisenmetsastys;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Asepaja;

public class Main {
    
    public static void main(String[] args) {
        Pelaaja pelajaa = new Pelaaja("Testipelajaa");
        Asepaja asepaja = new Asepaja();
        System.out.println(asepaja.hinnastoMerkkijonona());
        
    }
    
}
