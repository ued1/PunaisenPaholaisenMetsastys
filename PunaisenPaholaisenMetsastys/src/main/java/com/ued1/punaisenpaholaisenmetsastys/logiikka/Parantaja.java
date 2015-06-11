package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;

/**
 * Kylän parantajalta saa apuja tilanteisiin, missä vointi ei ole paras
 * mahdollinen.
 */
public class Parantaja {

    // Tasokohtainen hinta.
    private final int[] hinta = {0, 150, 300, 1500, 3000, 15000, 150000, 300000, 1500000, 3000000, 15000000};

    public Parantaja() {
    }

    /**
     * Metodi parantaa pelaajan.
     *
     * @param pelaaja Pelaaja, joka parannetaan
     */
    public void paranna(Pelaaja pelaaja) {
        pelaaja.paranna();
    }

    /**
     * Metodi tarkistaa voiko pelaaja ostaa VihannesPotionin. Osto on
     * mahdollinen jos pelaajalla on tarpeeksi rahaa ja pelaajalla on potioneja
     * korkeintaan 4.
     *
     * @param pelaaja Pelaaja, jolle ollaan ostamassa
     * @return totuusarvo, true jos voi ostaa
     */
    public boolean voikoOstaa(Pelaaja pelaaja) {
        if (hinta[pelaaja.getTaso()] <= pelaaja.getRahat() && pelaaja.getPotionit() < 5) {
            return true;
        }
        return false;
    }

    /**
     * Metodi ostaa pelaajalle VihannesPotionin, mikäli osto on mahdollinen.
     *
     * @param pelaaja Pelaaja, jolle ostetaan
     * @return totuusarvo, true jos osto onnistui
     */
    public boolean ostaPotion(Pelaaja pelaaja) {
        if (voikoOstaa(pelaaja)) {
            pelaaja.setPotionit(pelaaja.getPotionit() + 1);
            pelaaja.muutaRahoja(-hinta[pelaaja.getTaso()]);
            return true;
        }
        return false;
    }

    /**
     * Metodi palauttaa TarinaPaneelin TarinaOsaan sopivan kuvauksen Parantajan
     * toiminnoista.
     *
     * @param pelaaja Pelaaja, joka on Parantajalla
     * @return TarinaOsaan sopiva merkkijonona
     */
    public String getKuvaus(Pelaaja pelaaja) {
        int erotus = hinta[pelaaja.getTaso()] - pelaaja.getRahat();
        String kuvaus = "\nParantaja parantaa sinut jos vointisi";
        kuvaus += "\nkaipaa parannusta.";
        kuvaus += "\n\nVoit myös ostaa VihannesPotioneja,";
        kuvaus += "\njoiden avulla voit parantaa myöhemmin itsesi.";
        kuvaus += "\n\nVihannesPotion maksaa " + hinta[pelaaja.getTaso()];
        kuvaus += "\nkultarahaa";
        if (erotus <= 0) {
            kuvaus += " ja hinta vähennetään rahoistasi";
            kuvaus += "\nvälittömäsi ostonappia painaessa.";
        } else {
            kuvaus += " joten sinulla ei ole tarpeeksi";
            kuvaus += "\nrahaa. Tarvitset " + (erotus);
            kuvaus += " lisää.";
        }
        kuvaus += "\n\nVoit kantaa enintään viittä VihannesPotionia";
        kuvaus += "\nsamaan aikaan.";
        return kuvaus;
    }

}
