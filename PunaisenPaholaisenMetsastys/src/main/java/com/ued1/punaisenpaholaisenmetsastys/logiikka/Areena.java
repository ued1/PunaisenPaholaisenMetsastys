package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Hahmo;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Kilpailija;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;

public class Areena {

    // TODO: luokassa Metsä samankaltaista toiminnallisuutta
    // TODO:
    // voitettava taisteluita seuraavan tason verran noustaakseen tason
    // korkein taso 10
    // vastustajat vähintään pelaajan vahvuisia
    // yrittää voi niin monta kertaa kuin haluaa
    // hävitessä menettää armorin? vastuksen armori kuitenkin säilyy,
    //   joten täytyy ensin hankkia uusi armori jotta mahdollisuus voittaa
    private Pelaaja pelaaja;
    private Taistelu taistelu;
    private int voitetut;
    private Hahmo vastustaja;
    private int[] tarvittavaKokemus = {0, 100, 500, 1000, 5000, 10000, 50000, 100000, 500000, 1000000};

    public Areena(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.taistelu = null;
        this.voitetut = 0;
    }

    public boolean onkoPelaajaValmisAreenaan() {
        if (pelaaja.getTaso() > 9 || pelaaja.getKokemus() < tarvittavaKokemus[pelaaja.getTaso()]) {
            return false;
        }
        return true;
    }

    public int seuraavanTasonKokemus() {
        if (pelaaja.getTaso() >= 0 && pelaaja.getTaso() < 10) {
            return tarvittavaKokemus[pelaaja.getTaso()];
        } else {
            return -1;
        }
    }

    public int getOtteluitaJaljella() {
        return pelaaja.getTaso() + 1 - voitetut;
    }

    public void asetaTaistelunTulos() {
        if (pelaaja.onkoElossa()) {
            taistelu = null;
            vastustaja = null;
            if (getOtteluitaJaljella() < 2) {
                pelaaja.nostaTasoa();
                voitetut = 0;
            } else {
                voitetut++;
            }
        } else {
            vastustaja.paranna();
            pelaaja.paranna();
        }
    }

    public void aloitaUusiTaistelu() {
        if (vastustaja == null) {
            vastustaja = generoiUusiVastustaja();
        }
        vastustaja.paranna();
        pelaaja.paranna();
        taistelu = new Taistelu(pelaaja, vastustaja);
    }

    private Hahmo generoiUusiVastustaja() {
        int maxVointi = pelaaja.getMaxVointi() + 5; // TODO: muuta sopivaksi
        int voima = pelaaja.lyo() + 2;              // TODO: muuta sopivaksi
        int puolustus = pelaaja.suojaa() + 1;       // TODO: muuta sopivaksi
        Hahmo kilpailija = new Kilpailija(maxVointi, voima, puolustus);
        return kilpailija;
    }

    public Taistelu getTaistelu() {
        return taistelu;
    }

    public String getVastustajanTiedot() {
        if (vastustaja == null) {
            return "Seuraava vastustajasi selviää kun\naloitat taistelun ensimmäisen kerran";
        } else {
            return vastustaja.tiedotMerkkijonona();
        }
    }

}
