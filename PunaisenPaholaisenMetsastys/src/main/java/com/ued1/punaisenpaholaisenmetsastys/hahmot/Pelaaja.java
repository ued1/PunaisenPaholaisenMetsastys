
package com.ued1.punaisenpaholaisenmetsastys.hahmot;

import com.ued1.punaisenpaholaisenmetsastys.aseet.Ase;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Haarniska;

public class Pelaaja {

    private final String nimi;
    private int taso;
    private Ase ase;
    private Haarniska haarniska;
    private int rahat;
        
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        taso = 1;
        // ase = nyrkki
        // haarniska = riepu
        rahat = 0;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public int getVoima() {
        // määräytyy aseen ja tason mukaan
        return -1;
    }
    
    public int getPuolustus() {
        // määräytyy haarniskan ja tason mukaan
        return -1;
    }
    
    public String getAse() {
        // palauttaa aseen nimen
        return "";
    }
    
    public String getHaarniska() {
        // palauttaa haarniskan nimen
        return "";
    }
    
    public int getRahat() {
        return rahat;
    }
    
    public void setRahat(int muutos) {
        if(rahat + muutos < 0) {
            rahat = 0;
        } else {
            rahat += muutos;
        }
    }
    
    public void nostaTasoa() {
        taso++;
    }
    
    public int getTaso() {
        return taso;
    }
    
    
}
