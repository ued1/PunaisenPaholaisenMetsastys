package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Hahmo;
import java.util.Random;

/**
 * Luokka Taistelu hoitaa pelin eri taisteluiden logiikan. Luokalle voi antaa
 * kaksi Hahmo-oliota, jotka taistelevat keskenään.
 */
public class Taistelu {

    private final Hahmo ekaTaistelija;
    private final Hahmo tokaTaistelija;
    private int ekaIsku;
    private int tokaIsku;
    private Random random;

    public Taistelu(Hahmo eka, Hahmo toka) {
        ekaTaistelija = eka;
        tokaTaistelija = toka;
        ekaIsku = -999;
        tokaIsku = -999;
        random = new Random();
    }

    /**
     * Metodi hoitaa taistelun logiikan. Molemmat taistelijat lyövät kerran metodia
     * kutsuttaessa. Mikäli ensimmäinen Hahmo tappaa toisen, ei toinen Hahmo 
     * kuitenkaan lyö ollenkaan. Lyöjän lyöntivoima on random-luku väliltä 50% ja 100%
     * maksimilyöntivoimasta. Vahinko lasketaan vähentämällä edellä lasketusta lyöntivoimasta
     * puolustajan puolustusvoima ja puolustajan vointi laskee erotuksen verran.
     * Metodi kertoo kutsujalle onko taistelu ohi.
     * 
     * @return totuusarvo taistelun päättymisestä, true jos taistelu on saatu päätöḱseen
     */
    public boolean taistele() {
        ekaIsku = Math.max(1, laskeVahinko(ekaTaistelija.lyo(), tokaTaistelija.suojaa()));
        laskeVointia(tokaTaistelija, ekaIsku);
        if (!tokaTaistelija.onkoElossa()) {
            ekaIsku = -999;
            tokaIsku = -999;
            return true;
        }
        tokaIsku = Math.max(0, laskeVahinko(tokaTaistelija.lyo(), ekaTaistelija.suojaa()));
        laskeVointia(ekaTaistelija, tokaIsku);
        if (!ekaTaistelija.onkoElossa()) {
            ekaIsku = -999;
            tokaIsku = -999;
            return true;
        }
        return false;
    }
    
    /**
     * Metodi tarkistaa onko taistelu alkanut.
     * 
     * @return totuusarvo true jos taistelu on alkanut, false jos ei
     */
    public boolean onkoAlkanut() {
        if(ekaIsku > -1 && tokaIsku > -1) {
            return true;
        }
        return false;
    }
    
    private int laskeVahinko(int lyonti, int suojaus) {
        int osuma = lyonti/2 + random.nextInt(lyonti/2 + 1) - suojaus;
        return osuma;
    }

    private void laskeVointia(Hahmo kenen, int paljonko) {
        for (int i = 0; i < paljonko; i++) {
            kenen.laskeVointia();
        }
    }

    /**
     * Metodi palauttaa edellisten lyöntien ensimmäisen taistelijan tekemän vahingon
     * kokonaislukuna. Metodi palauttaa negatiivisen luvun mikäli taistelu ei ole käynnissä.
     * 
     * @return ensimmäisen taistelijan edellinen isku kokonaislukuna
     */
    public int getEkaIsku() {
        return ekaIsku;
    }

    /**
     * Metodi palauttaa edellisten lyöntien toisen taistelijan tekemän vahingon
     * kokonaislukuna. Metodi palauttaa negatiivisen luvun mikäli taistelu ei ole käynnissä.
     * 
     * @return toisen taistelijan edellinen isku kokonaislukuna
     */    
    public int getTokaIsku() {
        return tokaIsku;
    }
    
    /**
     * Metodi palauttaa vastustajan (toinen taistelija)
     * 
     * @return vastustajan Hahmon tai null, jos ei taistelu käynnissä
     */
    public Hahmo vastustaja() {
        return tokaTaistelija;
    }

}
