
package com.ued1.punaisenpaholaisenmetsastys.peli.hahmot;

/**
 * Luokka Hahmo on pelin hahmojen yläluokka. Luokka on abstrakti ja 
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
     * Metodi asettaa hahmon voinnin. Vointi voi hetkellisesti olla myös 
     * suurempi kuin maxVointi.
     * 
     * @param uusiVointi Vointi, joka asetetaan
     */
    public void setVointi(int uusiVointi) {
        vointi = Math.max(0, uusiVointi);
    }
    
    /**
     * Parantaa hahmon. Hahmon vointi asetetaan yhtäsuureksi kuin maksimivointi.
     */
    public void paranna() {
        vointi = maxVointi;
    }
        
    /**
     * Metodi palauttaa hahmon lyöntivoiman.
     * 
     * @return lyöntivoima kokonaislukuna
     */
    public abstract int lyo();
    
    /**
     * Metodi palauttaa hahmon puolustusvoiman.
     * 
     * @return puolustusvoima kokonaislukuna
     */
    public abstract int suojaa();
    
    /**
     * Metodi palauttaa hahmon tiedot merkkijonona tarinapaneelin
     * tarinaosaan sopivassa muodossa.
     * 
     * @return hahmon tiedot merkkijonona
     */
    public abstract String tiedotMerkkijonona();
            
}
