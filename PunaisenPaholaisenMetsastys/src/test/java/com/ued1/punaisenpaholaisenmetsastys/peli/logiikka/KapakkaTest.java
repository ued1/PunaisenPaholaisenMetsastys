package com.ued1.punaisenpaholaisenmetsastys.peli.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Kapakka;
import com.ued1.punaisenpaholaisenmetsastys.peli.apuvalineet.KossuPotion;
import com.ued1.punaisenpaholaisenmetsastys.peli.apuvalineet.Pupu;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class KapakkaTest {

    public Pelaaja pelaaja;
    public KossuPotion kossu;
    public Kapakka kapakka;

    public KapakkaTest() {
        pelaaja = new Pelaaja("Testaaja");
        kossu = new KossuPotion(pelaaja);
    }

    @Before
    public void setUp() {
        kapakka = new Kapakka(pelaaja);
    }

    @Test
    public void KossuPotionLoytyyValikoimasta() {
        assertTrue(kapakka.valikoimaMerkkijonona().contains(kossu.toString()));
    }

    @Test
    public void PupuListattuOstettavissaKunRahaa() {
        assertTrue(kapakka.getValikoima().get(2).toString().contains("Pupu"));
        assertFalse(kapakka.ostettavissaOlevat(pelaaja).contains("Pupu"));
        pelaaja.muutaRahoja(new Pupu(pelaaja).arvo());
        assertTrue(kapakka.ostettavissaOlevat(pelaaja).contains("Pupu"));
    }

    @Test
    public void metodiOstettavissaOlevatIlmoittaaJosEiRahaa() {
        pelaaja.muutaRahoja(-200000000);
        assertTrue(kapakka.ostettavissaOlevat(pelaaja).contains("Sinulla ei ole yhtään rahaa"));
    }

    @Test
    public void pelaajaVoiOstaaPupunKunTarpeeksiRahaa() {
        assertTrue(kapakka.getValikoima().get(2).toString().contains("Pupu"));
        assertFalse(kapakka.voikoPelaajaOstaaOstoksen(pelaaja, 2));
        pelaaja.muutaRahoja(new Pupu(pelaaja).arvo());
        assertTrue(kapakka.voikoPelaajaOstaaOstoksen(pelaaja, 2));
    }

    @Test
    public void pelaajaEiVoiOstaaValikoimanUlkopuolelta() {
        assertFalse(kapakka.osta(pelaaja, -1));
        assertFalse(kapakka.osta(pelaaja, 444));
    }

    @Test
    public void pelaajaVoiOstaaKossunKunRahaa() {
        assertFalse(kapakka.osta(pelaaja, 1));
        pelaaja.muutaRahoja(3);
        assertTrue(kapakka.osta(pelaaja, 1));
        pelaaja.muutaRahoja(1);
        assertTrue(kapakka.osta(pelaaja, 1));
    }

    @Test
    public void eiVoiOstaaKahtaPupua() {
        pelaaja.muutaRahoja(new Pupu(pelaaja).arvo() * 2);
        assertTrue(kapakka.voikoPelaajaOstaaOstoksen(pelaaja, 2));
        assertTrue(kapakka.osta(pelaaja, 2));
        assertFalse(kapakka.osta(pelaaja, 2));
    }

    @Test
    public void voiOstaaKaksiEriApua() {
        pelaaja.muutaRahoja(99999999);
        assertTrue(kapakka.osta(pelaaja, 2));
        assertTrue(kapakka.osta(pelaaja, 3));
        assertFalse(kapakka.osta(pelaaja, 3));
    }

    @Test
    public void valikoimassaAvunHinta() {
        assertTrue(kapakka.valikoimaMerkkijonona().contains("" + new Pupu(pelaaja).arvo()));
    }

}
