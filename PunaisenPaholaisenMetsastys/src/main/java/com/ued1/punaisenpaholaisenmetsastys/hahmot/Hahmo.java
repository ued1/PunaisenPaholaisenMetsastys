
package com.ued1.punaisenpaholaisenmetsastys.hahmot;

/**
 * Luokka Hahmo on pelin hahmojen yläluokka. Luokka on abstracti ja 
 * määrittelee ja ylläpitää hahmoilta vaadittuja toimintoja ja ominaisuuksia.
 */
public abstract class Hahmo {
    
    private String nimi;
    private int vointi;
    private int maxVointi;
    
    /**
     * Hahmon konstruktorille annetaan nimi, vointi ja maksimivointi. Lyöminen
     * ja suojaaminen on annettu alaluokkien toteutettavaksi.
     * 
     * @param nimi Hahmon nimi
     * @param vointi Hahmon vointi
     * @param maxVointi Hahmon maksimiVointi
     */
    public Hahmo(String nimi, int vointi, int maxVointi) {
        this.nimi = nimi;
        this.vointi = vointi;
        this.maxVointi = maxVointi;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public void setNimi(String uusiNimi) {
        nimi = uusiNimi;
    }
    
    /**
     * Metodi tarkistaa onko hahmo elossa. Hahmo on elossa kun sen
     * vointi on enemmän kuin nolla.
     * 
     * @return totuusarvo joka kertoo onko hahmo elossa
     */
    public boolean onkoElossa() {
        if(vointi > 0) {
            return true;
        }
        return false;
    }
    
    public int getVointi() {
        return vointi;
    }
    
    public int getMaxVointi() {
        return maxVointi;
    }
    
    public void setMaxVointi(int uusiMaxVointi) {
        maxVointi = uusiMaxVointi;
    }
    
    /**
     * Metodi laskee vointia yhdellä, jos vointi on enemmän kuin nolla.
     */
    public void laskeVointia() {
        vointi--;
        if(vointi < 0) {
            vointi = 0;
        }
    }
    
    /**
     * Parantaa hahmon. Hahmon vointi asetetaan yhtäsuureksi kuin maksimivointi.
     */
    public void paranna() {
        vointi = maxVointi;
    }
        
    public abstract int lyo();
    
    public abstract int suojaa();
    
    public abstract String tiedotMerkkijonona();
            
}
