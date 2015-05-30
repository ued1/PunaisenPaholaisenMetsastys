package com.ued1.punaisenpaholaisenmetsastys.hahmot;

import com.ued1.punaisenpaholaisenmetsastys.logiikka.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Ase;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Nyrkki;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Haarniska;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Riepu;

/**
 * Luokka pelaaja määrittelee pelin pelaajan ja ylläpitää pelaajan ominaisuuksia.
 */
public class Pelaaja extends Hahmo {
        
    private int taso;
    private Ase ase;
    private Haarniska haarniska;
    private int rahat;
    private Paikka paikka;
    private int kokemus;

    public Pelaaja(String nimi) {
        super(nimi, 20, 20);
        this.taso = 1;
        this.ase = new Nyrkki();
        this.haarniska = new Riepu();
        this.rahat = 0;
        this.paikka = Paikka.KYLA;
        this.kokemus = 0;
    }

    public int getTaso() {
        return taso;
    }
        
    /**
     * Metodi nostaa pelaajan tasoa ja parantaa tarvittaessa pelaajan, ellei
     * pelaaja ole maksimitasolla 10.
     */
    public void nostaTasoa() {
        if(taso < 10) {
            setMaxVointi(20 + 40 * taso);
            taso++;
            paranna();
        }
    }

    public Ase getAse() {
        return ase;
    }

    public void setAse(Ase uusiAse) {
        ase = uusiAse;
    }
    
    /**
     * Metodi palauttaa pelaajan lyöntivoiman.
     * 
     * @return lyöntivoima kokonaislukuna
     */
    @Override
    public int lyo() {
        return ase.lyo();
    }

    /**
     * Metodi palauttaa pelaajan puolustusvoiman.
     * 
     * @return puolustusvoima kokonaislukuna
     */
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

    /**
     * Metodi muuttaa pelaajan rahoja. Pelaajan rahat voiva olla väliltä
     * 0..200000000.
     * 
     * @param muutos kokonaisluku joka lisätään pelaajan rahoihin 
     */
    public void muutaRahoja(int muutos) {
        rahat += muutos;
        if (rahat < 0) {
            rahat = 0;
        } else if (rahat > 200000000) {
            rahat = 200000000;
        }
    }
    
    /**
     * Metodi asettaa pelaajan rahat nollaan.
     */
    public void nollaaRahat() {
        muutaRahoja(-rahat);
    }
    
    /**
     * Metodi palauttaa pelaajan tiedot merkkijonona.
     * 
     * @return pelaajan tiedot merkkijonona
     */
    @Override
    public String tiedotMerkkijonona() {
        String tiedot = "Nimi: " + super.getNimi();
        tiedot += "\nTaso: " + taso;
        tiedot += "\nKokemus: " + kokemus;
        tiedot += "\nVointi: " + super.getVointi() + "/" + super.getMaxVointi();
        tiedot += "\nAse: " + ase.toString();
        tiedot += "\nHaarniska: " + haarniska.toString();
        tiedot += "\nRahat: " + rahat;
        return tiedot;
    }
    
    /**
     * Metodi palauttaa pelaajan paikan (tilanteen).
     * 
     * @return pelaajan paikka tai tilanne
     */
    public Paikka getPaikka() {
        return paikka;
    }
    
    public void setPaikka(Paikka uusiPaikka) {
        paikka = uusiPaikka;
    }
    
    public int getKokemus() {
        return kokemus;
    }
    
    /**
     * Metodi muuttaa pelaajan kokemusta. Kokemus on aina vähintään nolla.
     * 
     * @param muutos kokonaisluku joka lisätään pelaajan kokemukseen
     */
    public void muutaKokemusta(int muutos) {
        kokemus = Math.max(0, kokemus+muutos);
    }

}
