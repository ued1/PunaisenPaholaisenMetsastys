package com.ued1.punaisenpaholaisenmetsastys.peli.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.peli.Vaikeus;
import com.ued1.punaisenpaholaisenmetsastys.peli.haarniskat.Riepu;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Hahmo;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Monsteri;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;

/**
 * Luokka Luola määrittelee luolan toiminnallisuuden. Luola on pelin loppu ja
 * ilmestyy metsään kun pelaaja on korkeimmalla mahdollisella tasolla.
 */
public class Luola {

    private Pelaaja pelaaja;
    private Taistelu taistelu;
    private Hahmo paholainen;
    private int punainenPotion;
    private int mustaPotion;

    public Luola(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.taistelu = null;
        this.punainenPotion = 0;
        this.mustaPotion = 0;
        if(pelaaja.getVaikeus() == Vaikeus.HELPPO) {
            this.paholainen = new Monsteri(500, 150, 65, "Punainen Paholainen");
        } else {
            this.paholainen = new Monsteri(1000, 150, 65, "Punainen Paholainen");
        }
        
    }

    /**
     * Metodi alustaa taistelun Punaista Paholaista vastaan.
     */
    public void haastaPaholainen() {
        taistelu = new Taistelu(pelaaja, paholainen);
        punainenPotion = 0;
    }

    /**
     * Metodi palauttaa meneillään olevan taistelun.
     *
     * @return meneillään oleva Taistelu
     */
    public Taistelu getTaistelu() {
        return taistelu;
    }

    /**
     * Metodi asettaa taistelun tuloksen. Pelaajan hävitessä rahat laskevat
     * nollaan ja pelaaja menettää haarniskan. Pelaaja kuitenkin parantuu ja voi
     * jatkaa peliä. Pelaajan voittessa peli loppuu.
     */
    public void asetaTulos() {
        if (pelaaja.onkoElossa()) {
            //TODO
        } else {
            pelaaja.setHaarniska(new Riepu());
            pelaaja.muutaRahoja(-pelaaja.getRahat());
            pelaaja.paranna();
            paholainen.paranna();
            mustaPotion = 0;
            punainenPotion = 0;
        }
    }

    /**
     * Asettaa Ruosteisen avaiman avulla löytämien potionien määrän.
     */
    public void asetaPotionit() {
        mustaPotion = 5;
        punainenPotion = 5;
    }

    /**
     * Pelaaja käyttää Ruosteisen avaimen avulla löytämänsä punaisen potionin.
     * Punainen potion parantaa pelaajan.
     */
    public void kaytaPunainenPotion() {
        if (punainenPotion > 0) {
            pelaaja.paranna();
            punainenPotion--;
        }
    }

    /**
     * Pelaaja käyttää Ruosteista avaimen avulla löytämänsä mustan potionin.
     * Musta potion heikentaa pelaajaa.
     */
    public void kaytaMustaPotion() {
        if (mustaPotion > 0) {
            laskePelaajanVointia(100);
            laskePelaajanVointia(10);
            laskePelaajanVointia(1);
            mustaPotion--;
        }

    }

    private void laskePelaajanVointia(int paljonko) {
        if (pelaaja.getVointi() - paljonko > 0) {
            pelaaja.setVointi(pelaaja.getVointi() - paljonko);
        }
    }

    /**
     * Metodi palauttaa Punaista Paholaista vastaan käytettävien punaisten
     * potionien määrän.
     *
     * @return kokonaisluku, punaisten potionien määrä
     */
    public int getPunainenPotion() {
        return punainenPotion;
    }

    /**
     * Metodi palauttaa Punaista Paholaista vastaan käytettävien mustien
     * potionien määrän.
     *
     * @return kokonaisluku, mustien potionien määrä
     */
    public int getMustaPotion() {
        return mustaPotion;
    }

}
