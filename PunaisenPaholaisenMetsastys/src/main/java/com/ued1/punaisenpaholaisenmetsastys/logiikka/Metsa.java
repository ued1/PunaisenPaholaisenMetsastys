
package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Monsteri;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.util.Random;

public class Metsa {
           
    private Pelaaja pelaaja;
    private Taistelu taistelu;
    private int[] tasollaRahaaTarjolla = {0, 5, 10, 50, 100, 500, 5000, 10000, 50000, 100000, 500000};
    private int[] tasollaKokemustaTarjolla = {0, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000};
    
    public Metsa(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.taistelu = null;
    }
    
    public void aloitaUusiTaistelu() {
        taistelu = new Taistelu(pelaaja, etsiUusiMonsteriTaisteluun());
    }
    
    public void asetaTaistelunTulos() {
        if(pelaaja.onkoElossa()) {
            pelaaja.muutaRahoja(tasollaRahaaTarjolla[pelaaja.getTaso()]);
            pelaaja.muutaKokemusta(tasollaKokemustaTarjolla[pelaaja.getTaso()]);
        } else {
            // TODO: korjaa tai muuta aihemäärittely
            pelaaja.muutaRahoja(-99999);
            pelaaja.paranna();
        }
    }
        
    private int arvoPositiivinenLuku(int korkeintaan) {
        Random arpoja = new Random();
        return (1 + arpoja.nextInt(korkeintaan));
    }
    
    private Monsteri etsiUusiMonsteriTaisteluun() {
        int monsterinVointi = arvoPositiivinenLuku(2 * pelaaja.getMaxVointi());
        int monsterinVoima = arvoPositiivinenLuku(pelaaja.lyo());
        int monsterinPuolustus = arvoPositiivinenLuku(pelaaja.suojaa());
        Monsteri monsteri = new Monsteri(monsterinVointi, monsterinVoima, monsterinPuolustus);
        return monsteri;
    }
    
    public Taistelu getTaistelu() {
        return taistelu;
    }
    
}
