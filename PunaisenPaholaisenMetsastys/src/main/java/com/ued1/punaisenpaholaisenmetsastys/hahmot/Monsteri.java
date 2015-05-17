
package com.ued1.punaisenpaholaisenmetsastys.hahmot;

import java.util.Random;

public class Monsteri extends Hahmo {
        
    private int voima;
    private int puolustus;
            
    public Monsteri(int maxVointi, int voima, int puolustus) {
        super(null, maxVointi, maxVointi);
        this.voima = voima;
        this.puolustus = puolustus;
        super.setNimi(arvoNimi());
    }
    
    private String arvoNimi() {
        // TODO: KEKSI NIMET!!!!!!!!!!!!!!!!!!!!!!!
        String[] nimet = {"nimi0", "nimi1", "jne"};
        Random randomluku = new Random();
        return nimet[randomluku.nextInt(nimet.length)];
    }
    
    @Override
    public int lyo() {
        return voima;
    }
    
    @Override
    public int suojaa() {
        return puolustus;
    }
    
}
