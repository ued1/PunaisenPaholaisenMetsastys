package com.ued1.punaisenpaholaisenmetsastys.hahmot;

import com.ued1.punaisenpaholaisenmetsastys.aseet.Ase;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Nyrkki;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Haarniska;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Riepu;

public class Pelaaja {

    private final String nimi;
    private int vointi;
    private int maxVointi;
    private int taso;
    private Ase ase;
    private Haarniska haarniska;
    private int rahat;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.vointi = 10;
        this.maxVointi = 10;
        this.taso = 1;
        this.ase = new Nyrkki();
        this.haarniska = new Riepu();
        this.rahat = 0;
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
    
    public void paranna() {
        vointi = maxVointi;
    }

    public int getTaso() {
        return taso;
    }
    
    public int getMaxVointi() {
        return maxVointi;
    }
    
    public int getVointi() {
        return vointi;
    }

    public void nostaTasoa() {
        taso++;
        // nosta maxVointi
    }

    public Ase getAse() {
        return ase;
    }

    public void setAse(Ase uusiAse) {
        ase = uusiAse;
    }
    
    public int lyo() {
        return ase.lyo();
    }

    public int suojaa() {
        return haarniska.suojaa();
    }

    public Haarniska getHaarniska() {
        return haarniska;
    }
    
    public void setHaarniska(Haarniska uusiHaarniska) {
        haarniska = uusiHaarniska;
    }

    public int getRahat() {
        return rahat;
    }

    public void muutaRahoja(int muutos) {
        if (rahat + muutos < 0) {
            rahat = 0;
        } else {
            rahat += muutos;
        }
    }

}
