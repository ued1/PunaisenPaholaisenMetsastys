
package com.ued1.punaisenpaholaisenmetsastys.hahmot;

import java.util.Random;

public class Monsteri {
    
    // TODO: abstract class Hahmo!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // Monsteri extends Hahmo
    // Pelaaja extends Hahmo
    
    private String nimi;
    private int voima;
    private int puolustus;
    private int vointi;
        
    public Monsteri(int maxVointi, int voima, int puolustus) {
        this.voima = voima;
        this.puolustus = puolustus;
        this.nimi = arvoNimi();
        this.vointi = maxVointi;
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
    
    public boolean onkoElossa() {
        if(vointi > 0) {
            return true;
        }
        return false;
    }
    
    public void laskeVointia() {
        vointi--;
        if(vointi < 0) {
            vointi = 0;
        }
    }
        
    public int getVointi() {
        return vointi;
    }
    
    
}
