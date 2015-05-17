
package com.ued1.punaisenpaholaisenmetsastys.hahmot;

import java.util.Random;

public class Monsteri {
    
    // TODO: abstract class Hahmo!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // Monsteri extends Hahmo
    // Pelaaja extends Hahmo
    
    private String nimi;
    private int voima;
    private int puolustus;
    
    
    public Monsteri(int voima, int puolustus) {
        this.voima = voima;
        this.puolustus = puolustus;
        this.nimi = arvoNimi();        
    }
    
    private String arvoNimi() {
        // TODO: KEKSI NIMET!!!!!!!!!!!!!!!!!!!!!!!
        String[] nimet = {"nimi0", "nimi1", "jne"};
        Random randomluku = new Random();
        return nimet[randomluku.nextInt(nimet.length)];
    }
    
    public int lyo() {
        return voima;
    }
    
    public int suojaa() {
        return puolustus;
    }
    
    public String getNimi() {
        return nimi;
    }
    
}
