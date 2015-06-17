package com.ued1.punaisenpaholaisenmetsastys.peli.hahmot;

import java.util.Random;

/**
 * Luokka määrittelee ja ylläpitää taisteluareenalla taistelevia kilpailijoita.
 */
public class Kilpailija extends Hahmo {

    private int voima;
    private int puolustus;

    /**
     * Kilpailijan konstruktorille annetaan maksimivointi, lyöntivoima ja
     * puolustusvoima. Kilpailijan nimi arvotaan ennalta määriteltyjen nimien
     * joukosta.
     *
     * @param maxVointi maksimivointi
     * @param voima lyöntivoima
     * @param puolustus puolustusvoima
     */
    public Kilpailija(int maxVointi, int voima, int puolustus) {
        super(null, maxVointi, maxVointi);
        this.voima = voima;
        this.puolustus = puolustus;
        super.setNimi(arvoNimi());
    }

    private String arvoNimi() {
        String[] nimet = {"Ajeltu Luolamies", "Pillastunut Assari",
            "Alaston Anoppi", "Usko Eevertti", "Kenraali Kalsareissa", "Parraton Gandalf",
            "Karannut Vanki", "Kapteeni Koukku", "Batman Valeasussa",
            "Per Saukko", "Veli Sikiö", "Raitis Juoppo", "Karvainen Munkki",
            "Isoperseinen Anorektikko", "Kuntoileva Pyhimys", "Pullisteleva Putin"};
        Random randomluku = new Random();
        return nimet[randomluku.nextInt(nimet.length)];
    }

    /**
     * Palauttaa kilpailijan lyöntivoiman. Kilpailijan lyöntivoima on ennalta
     * valittu, kilpailijoilla ei ole aseita kuten pelaajalla.
     *
     * @return kilpailijan lyöntivoima
     */
    @Override
    public int lyo() {
        return voima;
    }

    /**
     * Palauttaa kilpailijan puolustusvoiman. Kilpailijan puolustusvoima on
     * ennalta valittu, kilpailijoilla ei ole haarniskoja kuten pelaajalla.
     *
     * @return kilpailijan puolustusvoima
     */
    @Override
    public int suojaa() {
        return puolustus;
    }

    /**
     * Metodi palauttaa kilpailijan tiedot merkkijona. Tiedot ovat muotoiltu
     * sopiviksi tarinapaneelia varten.
     *
     * @return kilpailijan tiedot merkkijonona
     */
    @Override
    public String tiedotMerkkijonona() {
        String tiedot = "Vastustajasi on " + getNimi();
        tiedot += "\n  Vointi: " + getVointi() + "/" + getMaxVointi();
        tiedot += "\n  Voima: " + voima;
        tiedot += "\n  Puolustus: " + puolustus;
        return tiedot;
    }

    /**
     * Metodi heikentää kilpailijaa laskemalla kilpailijan lyönti- ja
     * puolutusvoimaa yhdellä. Voimat eivät voi laskea nollaan.
     */
    public void heikenna() {
        if (voima > 1) {
            voima--;
        }
        if (puolustus > 1) {
            puolustus--;
        }
    }

}
