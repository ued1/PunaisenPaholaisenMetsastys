package com.ued1.punaisenpaholaisenmetsastys.peli.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;
import java.util.Random;

/**
 * Kylän Casinolla voi pelata rahojaan ja tavoitella voittoa.
 */
public class Casino {
    
    
    public Casino() {
    }
    
    /**
     * Metodi palauttaa TarinaOsaan sopivan kuvauksen Casinosta.
     * Kuvaukseen valittaa pelaajan varallisuus.
     * 
     * @param pelaaja Pelaaja, joka on casinolla
     * @return kuvaus merkkijonona
     */
    public String getCasinoKuvaus(Pelaaja pelaaja) {
        String kuvaus = "\nCasinolla voit pelata uhkapelejä.";
        kuvaus += "\nTarjolla ovat seuraavat pelit:";
        kuvaus += "\n\nPeukkupeli - tuplaa tai häviä rahasi";
        if(pelaaja.getRahat() < 1) {
            kuvaus += "\n\nSinulla pitää olla rahaa,";
            kuvaus += "\njotta voit pelata!";
        }
        return kuvaus;
    }
    
    /**
     * Metodi palauttaa TarinaOsaan sopivan kuvauksen Peukkupelistä.
     * 
     * @return peukkupelin kuvaus merkkijonona
     */
    public String getPeukkupeliKuvaus() {
        String kuvaus = "\n[P]eukkupelissä heitetään kolikko ilmaan.";
        kuvaus += "\nTuplaat rahasi jos kolikossa oleva peukku";
        kuvaus += "\nosoittaa ylös. Peukun osoittaessa alas";
        kuvaus += "\nhäviät kaikki rahasi.";
        kuvaus += "\n\nKolikko heitetään komennolla [A]loita.";
        kuvaus += "\nTämän jälkeen joko rikastut tai köyhdyt.";
        return kuvaus;
    }
    
    /**
     * Casinon peli, missä on 50% voittomahdollisuus. Arvolla true voittaa
     * ja arvolla false häviää.
     * 
     * @param pelaaja Pelaaja joka on pelaamassa
     * @return totuusarvo, true jos pelaaja voittaa
     */
    public boolean pelaaPeukkua(Pelaaja pelaaja) {
        int pelaajanRahat = pelaaja.getRahat();
        if(arvoTrueTaiFalse()) {
            pelaaja.muutaRahoja(pelaajanRahat);
            return true;
        } else {
            pelaaja.muutaRahoja(-pelaajanRahat);
            return false;
        }
    }
    
    /**
     * Metodi palauttaa KomentoOsaan sopivan komentovalikon. Pelaajan
     * varallisuus vaikuttaa komentoihin.
     * 
     * @param pelaaja Pelaaja joka on casinolla
     * @return KomentoOsaan sopiva merkkijono
     */
    public String getKomennot(Pelaaja pelaaja) {
        String komennot = "";
        if(pelaaja.getRahat() > 0) {
            komennot += "[P]eukkupeli\n";
        }
        return komennot += "[T]akaisin";
    }
    
    private boolean arvoTrueTaiFalse() {
        Random arpoja = new Random();
        return (arpoja.nextInt(2) == 1);
    }
    
    
    
    
}
