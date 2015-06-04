
package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Monsteri;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.util.Random;

/**
 * Luokka Metsa hoitaa metsän toiminnallisuuden. Metsässä voi taistella monstereita
 * vastaan ja ansaita kultarahoja. Pelin lopussa metsään ilmestuu luola.
 */
public class Metsa {
           
    private Pelaaja pelaaja;
    private Taistelu taistelu;
    private int[] tasollaRahaaTarjolla = {0, 5, 10, 50, 100, 500, 5000, 10000, 50000, 100000, 500000};
    private int[] tasollaKokemustaTarjolla = {0, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000};
    
    public Metsa(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.taistelu = null;
    }
    
    /**
     * Metodi alustaa uuden monsteritaistelun. Vastustaja generoidaan sopivaksi
     * perustuen pelaajan ominaisuuksiin.
     */
    public void aloitaUusiTaistelu() {
        taistelu = new Taistelu(pelaaja, generoiUusiMonsteriTaisteluun());
    }
    
    /**
     * Metodi asettaa taistelun tuloksen. Pelaajan voittaessa pelaaja saa lisää
     * rahaa ja kokemusta. Pelaajan hävitessä monsteri varastaa pelaajan rahat,
     * mutta voitosta poiketen pelaaja parantuu.
     */
    public void asetaTaistelunTulos() {
        if(pelaaja.onkoElossa()) {
            pelaaja.muutaRahoja(tasollaRahaaTarjolla[pelaaja.getTaso()]);
            pelaaja.muutaKokemusta(tasollaKokemustaTarjolla[pelaaja.getTaso()]);
        } else {
            pelaaja.nollaaRahat();
            pelaaja.paranna();
        }
    }
        
    private int arvoPositiivinenLuku(int korkeintaan) {
        Random arpoja = new Random();
        return (1 + arpoja.nextInt(korkeintaan));
    }
    
    private Monsteri generoiUusiMonsteriTaisteluun() {
        int monsterinVointi = arvoPositiivinenLuku(2 * pelaaja.getMaxVointi());
        int monsterinVoima = arvoPositiivinenLuku(pelaaja.lyo());
        int monsterinPuolustus = arvoPositiivinenLuku(pelaaja.suojaa());
        Monsteri monsteri = new Monsteri(monsterinVointi, monsterinVoima, monsterinPuolustus);
        return monsteri;
    }
    
    /**
     * Metodi palauttaa meneillään olevan taistelun tai null arvon, mikäli 
     * taistelua ei ole käynnissä.
     * 
     * @return meneillään oleva Taistelu tai null jos taistelua ei ole
     */
    public Taistelu getTaistelu() {
        return taistelu;
    }
    
}
