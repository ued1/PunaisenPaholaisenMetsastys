
package com.ued1.punaisenpaholaisenmetsastys.hahmot;

public class Kilpailija extends Hahmo {

    private int voima;
    private int puolustus;
    
    public Kilpailija(int maxVointi, int voima, int puolustus, String nimi) {
        super(null, maxVointi, maxVointi);
        this.voima = voima;
        this.puolustus = puolustus;
        super.setNimi(nimi);
    }
        
    @Override
    public int lyo() {
        return voima;
    }

    @Override
    public int suojaa() {
        return puolustus;
    }

    @Override
    public String tiedotMerkkijonona() {
        String tiedot = "Vastustajasi on " + getNimi();
        tiedot += "\n  Vointi: " + getVointi() + "/" + getMaxVointi();
        tiedot += "\n  Voima: " + voima;
        tiedot += "\n  Puolustus: " + puolustus;
        return tiedot;
    }

    
    
}
