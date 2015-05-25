
package com.ued1.punaisenpaholaisenmetsastys.hahmot;

public abstract class Hahmo {
    
    private String nimi;
    private int vointi;
    private int maxVointi;
    
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
    
    public void laskeVointia() {
        vointi--;
        if(vointi < 0) {
            vointi = 0;
        }
    }
    
    public void paranna() {
        vointi = maxVointi;
    }
        
    public abstract int lyo();
    
    public abstract int suojaa();
    
    public abstract String tiedotMerkkijonona();
            
}
