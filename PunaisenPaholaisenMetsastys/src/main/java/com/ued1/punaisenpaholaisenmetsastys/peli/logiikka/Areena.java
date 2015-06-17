package com.ued1.punaisenpaholaisenmetsastys.peli.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.peli.Vaikeus;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Hahmo;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Kilpailija;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;

/**
 * Luokka Areena hoitaa taisteluareenan logiikan. Taisteluareenalla on tehtävänä
 * voittaa vastustajia ja nousta seuraavalle tasolle.
 */
public class Areena {

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

    /**
     * Metodi tarkistaa onko pelaaja valmis areenataisteluun. Pelaajalla täytyy
     * tarvittava määrä kokemusta aloittaakseen areenataistelun.
     *
     * @return totuusarvo true jos valmis, false jos ei tarpeeksi kokemusta
     */
    public boolean onkoPelaajaValmisAreenaan() {
        if (pelaaja.getTaso() > 9 || pelaaja.getKokemus() < tarvittavaKokemus[pelaaja.getTaso()]) {
            return false;
        }
        return true;
    }

    /**
     * Metodi kertoo kuinka paljon pelaajalla on oltava kokemusta aloittaakseen
     * areenataistelun.
     *
     * @return tarvittava kokemus kokonaislukuna
     */
    public int seuraavanTasonKokemus() {
        if (pelaaja.getTaso() > 0 && pelaaja.getTaso() < 10) {
            return tarvittavaKokemus[pelaaja.getTaso()];
        } else {
            return -1;
        }
    }

    /**
     * Metodi kertoo kuinka monta ottelua pelaajan tulee vielä voittaa
     * noustaakseen seuraavalle tasolle. Otteluita on voitettava seuraavan tason
     * numeron verran, esimerkiksi 5 ottelua noustaakseen tasolle 5.
     *
     * @return tarvittavien voittojen määrä kokonaislukuna
     */
    public int getOtteluitaJaljella() {
        return pelaaja.getTaso() + 1 - voitetut;
    }

    /**
     * Metodi asettaa taistelun tuloksen taistelun. Jos pelaaja on voittanut,
     * nousee voittojen määrä tai pelaaja pääsee seuraavalle tasolle. Muussa
     * tapauksessa sekä pelaaja, että vastustaja parantuvat.
     */
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
            heikennaVastustajaa();
            pelaaja.paranna();
        }
    }

    /**
     * Metodi alustaa uuden taistelun. Vastustaja arvotaan sopivaksi perustuen
     * pelaajan vahvuuteen. Mikäli pelaaja hävisi edellisen taistelun, on
     * vastustaja sama. Vastustajan lyönti- ja puolustusvoimaa on kuitenkin
     * laskettu.
     */
    public void aloitaUusiTaistelu() {
        if (vastustaja == null) {
            vastustaja = generoiUusiVastustaja();
        }
        vastustaja.paranna();
        pelaaja.paranna();
        taistelu = new Taistelu(pelaaja, vastustaja);
    }

    private void heikennaVastustajaa() {
        if (pelaaja.getVaikeus() == Vaikeus.HELPPO) {
            ((Kilpailija) vastustaja).heikenna();
            ((Kilpailija) vastustaja).heikenna();
        } else {
            ((Kilpailija) vastustaja).heikenna();
        }
    }

    private Hahmo generoiUusiVastustaja() {
        int maxVointi = pelaaja.getMaxVointi() + 5;
        int voima = pelaaja.lyo() + 2;
        int puolustus = pelaaja.suojaa() + 1;
        if (pelaaja.getVaikeus() == Vaikeus.HELPPO) {
            maxVointi -= 5;
            voima -= 2;
            puolustus -= 1;
        }
        Hahmo kilpailija = new Kilpailija(maxVointi, voima, puolustus);
        return kilpailija;
    }

    /**
     * Metodi palauttaa meneillään olevan taistelun tai null-arvon mikäli
     * taistelua ei ole käynnissä.
     *
     * @return taistelu joka on käynnissä
     */
    public Taistelu getTaistelu() {
        return taistelu;
    }

    /**
     * Palauttaa tarinapaneelin tarinaosaan sopivan merkkijonon joko vastustajan
     * tiedoista, mikäli taistelu on alustettu, tai kerrotaan vastustajan
     * tietojen selviävän myöhemmin.
     *
     * @return tilanteeseen sopiva merkkijono tarinapaneeliin
     */
    public String getVastustajanTiedot() {
        if (vastustaja == null) {
            return "Seuraava vastustajasi selviää kun\naloitat taistelun ensimmäisen kerran";
        } else {
            return vastustaja.tiedotMerkkijonona();
        }
    }

}
