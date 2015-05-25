package com.ued1.punaisenpaholaisenmetsastys.hahmot;

import java.util.Random;

public class Monsteri extends Hahmo {

    private int voima;
    private int puolustus;

    public Monsteri(int maxVointi, int voima, int puolustus) {
        super(null, maxVointi, maxVointi);
        this.voima = voima;
        this.puolustus = puolustus;
        super.setNimi(arvoNimi());
    }

    private String arvoNimi() {

        String[] nimet = {"Käärmefasaani", "Mörköläinen", "Jättiläinen",
            "Kaksipäinen Haamu", "Mörrimöykky", "Pöllökarhu", "Innostunut Sonni",
            "Hyytelöhirvi", "Röllipeikko", "Kaljamahainen Örkki", "Perkele",
            "Karvaperse", "Mörköpeikko", "Hymyilevä Kummitus", "Kiimainen Hirvi",
            "Yksisarvinen Krokotiili", "Isojalka", "Päätön Kana", "Kutistunut Jätti",
            "Isoperseinen Lehmä", "Hullu Muurahainen", "Kolmijalkainen Torakka"};
        Random randomluku = new Random();
        return nimet[randomluku.nextInt(nimet.length)];
    }

    @Override
    public int lyo() {
        return voima;
    }

    @Override
    public int suojaa() {
        return puolustus;
    }

    @Override
    public String tiedotMerkkijonona() {
        String tiedot = "Monsteri: " + getNimi();
        tiedot += "\nVointi: " + getVointi() + "/" + getMaxVointi();
        tiedot += "\nVoima: " + voima;
        tiedot += "\nPuolustus: " + puolustus;
        return tiedot;
    }

}
