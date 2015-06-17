package com.ued1.punaisenpaholaisenmetsastys.peli.hahmot;

import java.util.Random;

/**
 * Luokka Monsteri määrittelee ja ylläpitää monsteria.
 */
public class Monsteri extends Hahmo {

    private int voima;
    private int puolustus;

    /**
     * Monsterin konstruktorille annetaan maksimivointi, voima ja puolustus.
     * Monsterin nimi arvotaan ennalta valittujen nimien joukosta.
     *
     * @param maxVointi maksimivointi
     * @param voima lyöntivoima
     * @param puolustus puolustusvoima
     */
    public Monsteri(int maxVointi, int voima, int puolustus) {
        super(null, maxVointi, maxVointi);
        this.voima = voima;
        this.puolustus = puolustus;
        super.setNimi(arvoNimi());
    }

    public Monsteri(int maxVointi, int voima, int puolustus, String nimi) {
        super(nimi, maxVointi, maxVointi);
        this.voima = voima;
        this.puolustus = puolustus;
    }

    private String arvoNimi() {
        String[] nimet = {"Käärmefasaani", "Mörköläinen", "Jättiläinen",
            "Kaksipäinen Haamu", "Mörrimöykky", "Pöllökarhu", "Innostunut Sonni",
            "Hyytelöhirvi", "Röllipeikko", "Iso Paha Susi", "Perkele",
            "Karvaperse", "Mörköpeikko", "Hymyilevä Kummitus", "Kiimainen Hirvi",
            "Hampaaton Krokotiili", "Isojalka", "Päätön Kana", "Kutistunut Jätti",
            "Isoperseinen Punkki", "Hullu Muurahainen", "Jalaton Torakka"};
        Random randomluku = new Random();
        return nimet[randomluku.nextInt(nimet.length)];
    }

    /**
     * Palauttaa monsterin lyöntivoiman. Monsterin lyöntivoima on ennalta
     * valittu, monstereilla ei ole aseita kuten pelaajalla.
     *
     * @return monsterin lyöntivoima
     */
    @Override
    public int lyo() {
        return voima;
    }

    /**
     * Palauttaa monsterin puolustusvoiman. Monsterin puolustusvoima on ennalta
     * valittu, monstereilla ei ole haarniskoja kuten pelaajalla.
     *
     * @return monsterin puolustusvoima
     */
    @Override
    public int suojaa() {
        return puolustus;
    }

    /**
     * Metodi palauttaa monsterin tiedot merkkijona. Tiedot ovat muotoiltu
     * sopiviksi tarinapaneelia varten.
     *
     * @return monsterin tiedot merkkijonona
     */
    @Override
    public String tiedotMerkkijonona() {
        String tiedot = "\nMonsteri: " + getNimi();
        tiedot += "\n\nVointi: " + getVointi() + "/" + getMaxVointi();
        tiedot += "\nVoima: " + voima;
        tiedot += "\nPuolustus: " + puolustus;
        return tiedot;
    }

}
