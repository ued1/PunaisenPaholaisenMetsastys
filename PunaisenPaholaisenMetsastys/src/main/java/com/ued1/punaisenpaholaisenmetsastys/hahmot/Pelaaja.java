package com.ued1.punaisenpaholaisenmetsastys.hahmot;

import com.ued1.punaisenpaholaisenmetsastys.aseet.Ase;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Nyrkki;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Haarniska;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Riepu;

public class Pelaaja extends Hahmo {
        
    private int taso;
    private Ase ase;
    private Haarniska haarniska;
    private int rahat;

    public Pelaaja(String nimi) {
        super(nimi, 10, 10);
        this.taso = 1;
        this.ase = new Nyrkki();
        this.haarniska = new Riepu();
        this.rahat = 0;
    }

    public int getTaso() {
        return taso;
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
    
    @Override
    public int lyo() {
        return ase.lyo();
    }

    @Override
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
    
    public String tiedotMerkkijonona() {
        String tiedot = "Nimi: " + super.getNimi();
        tiedot += "\nTaso: " + taso;
        tiedot += "\nVointi: " + super.getVointi() + "/" + super.getMaxVointi();
        tiedot += "\nAse: " + ase.nimi();
        tiedot += "\nHaarniska: " + haarniska.nimi();
        tiedot += "\nRahat: " + rahat;
        return tiedot;
    }

}
