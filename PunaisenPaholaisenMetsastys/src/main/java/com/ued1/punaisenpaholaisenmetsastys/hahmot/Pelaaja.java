package com.ued1.punaisenpaholaisenmetsastys.hahmot;

import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.Apu;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Ase;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Nyrkki;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Haarniska;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Riepu;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Vaikeus;
import java.util.ArrayList;

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
    private int potionit;
    private ArrayList<Apu> avut;
    private Vaikeus vaikeus;

    public Pelaaja(String nimi) {
        this(nimi, Vaikeus.NORMAALI);
    }
    
    public Pelaaja(String nimi, Vaikeus vaikeus) {
        super(nimi, 20, 20);
        this.taso = 1;
        this.ase = new Nyrkki();
        this.haarniska = new Riepu();
        this.rahat = 0;
        this.paikka = Paikka.KYLA;
        this.kokemus = 0;
        if(vaikeus == Vaikeus.HELPPO) {
            this.potionit = 10;
        } else {
            this.potionit = 5;
        }
        this.avut = new ArrayList();
        this.vaikeus = vaikeus;
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
     * Metodi palauttaa pelaajan maksimilyöntivoiman.
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
     * Palauttaa pelaajalla olevien potionien määrän.
     * 
     * @return potionien määrä, kokonaisluku 0..5.
     */
    public int getPotionit() {
        return potionit;
    }
    
    /**
     * Metodi asettaa potionien määrän. Potioneja voi olla 0-10.
     * 
     * @param maara potionien uusi määrä, pakotetaan välille 0-10.
     */
    public void setPotionit(int maara) {
        potionit = maara;
        if(potionit < 0) {
            potionit = 0;
        } else if(potionit > 10) {
            potionit = 10;
        }
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
    
    /**
     * Metodi antaa pelaajalle vointibuustin lisäämällä pelaajan vointia
     * hetkellisesti. Uusi vointi on vähintään maxVointi ja enintään
     * maxVointi * 1.5.
     */
    public void vointiBuusti() {
        if(getVointi() < getMaxVointi()/2) {
            paranna();
        } else {
            setVointi(Math.min(getVointi()*2, (int)(getMaxVointi()*1.5)));
        }
    }
    
    /**
     * Metodi lisää pelaajalle avun jos pelaajalla ei kyseistä apua ole.
     * 
     * @param apu Apu joka lisätään
     * @return totuusarvo, true jos lisääminen onnistui
     */
    public boolean lisaaApu(Apu apu) {
        if(!onkoPelaajallaApu(apu)) {
            avut.add(apu);
            return true;
        }
        return false;
    }
    
    /**
     * Metodi tarkistaa onko pelaajalla kyseistä apua.
     * 
     * @param apu Apu joka tarkistetaan.
     * @return totuusarvo, true jos pelaajalla on apu
     */
    public boolean onkoPelaajallaApu(Apu apu) {
        return avut.contains(apu);
    }
    
    /**
     * Metodi palauttaa pelaajan avut.
     * 
     * @return Pelaajan avut ArrayList-oliona
     */
    public ArrayList<Apu> getAvut() {
        return avut;
    }
    
    /**
     * Metodi poistaa pelaajalta avun.
     * 
     * @param apu Apu joka poistetaan.
     * @return totuusarvo, true jos poisto onnistui.
     */
    public boolean poistaApu(Apu apu) {
        if(onkoPelaajallaApu(apu)) {
            avut.remove(apu);
            return true;
        }
        return false;
    }
    
    public Vaikeus getVaikeus() {
        return vaikeus;
    }
    
    public void setVaikeus(Vaikeus uusiVaikeus) {
        vaikeus = uusiVaikeus;
    }
    
}
