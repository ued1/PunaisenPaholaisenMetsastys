package com.ued1.punaisenpaholaisenmetsastys.hahmot;

import java.util.Random;

public class Kilpailija extends Hahmo {

    private int voima;
    private int puolustus;

    public Kilpailija(int maxVointi, int voima, int puolustus) {
        super(null, maxVointi, maxVointi);
        this.voima = voima;
        this.puolustus = puolustus;
        super.setNimi(arvoNimi());
    }

    private String arvoNimi() {
        String[] nimet = {"Ajeltu Luolamies", "Pillastunut Assari", "Pasi Puunhalaaja",
            "Alaston Anoppi", "Usko Eevertti", "Kenraali Kalsareissa", "Parraton Gandalf",
            "Karannut Vanki", "Kapteeni Koukku", "Tekstaileva Ministeri", "Batman Valeasussa",
            "Per Saukko", "Veli Sikiö", "Raitis Juoppo", "Karvainen Munkki",
            "Isoperseinen Anorektikko", "Kuntoileva Pyhimys", "Pullisteleva Putin"};
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
        String tiedot = "Vastustajasi on " + getNimi();
        tiedot += "\n  Vointi: " + getVointi() + "/" + getMaxVointi();
        tiedot += "\n  Voima: " + voima;
        tiedot += "\n  Puolustus: " + puolustus;
        return tiedot;
    }

}
