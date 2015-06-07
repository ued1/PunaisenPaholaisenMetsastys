package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.VihannesPotion;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ParantajaTest {

    private Parantaja parantaja;
    private Pelaaja pelaaja;

    public ParantajaTest() {
    }

    @Before
    public void setUp() {
        this.parantaja = new Parantaja();
        this.pelaaja = new Pelaaja("Testaaja");
    }

    @Test
    public void metodiParannaParantaaPelaajan() {
        pelaaja.laskeVointia();
        assertTrue(pelaaja.getVointi() < pelaaja.getMaxVointi());
        parantaja.paranna(pelaaja);
        assertEquals(pelaaja.getVointi(), pelaaja.getMaxVointi());
    }

    @Test
    public void pelaajaEiVoiOstaaVihannesPotioniaKunEiRahaa() {
        assertFalse(parantaja.voikoOstaa(pelaaja));
    }

    @Test
    public void pelaajaVoiOstaaVihannesPotioninKunRahaa() {
        pelaaja.muutaRahoja(149);
        assertFalse(parantaja.voikoOstaa(pelaaja));
        assertFalse(parantaja.ostaPotion(pelaaja));
        pelaaja.muutaRahoja(1);
        assertTrue(parantaja.voikoOstaa(pelaaja));
        assertTrue(parantaja.ostaPotion(pelaaja));
        pelaaja.muutaRahoja(-1);
        assertFalse(parantaja.voikoOstaa(pelaaja));
        assertFalse(parantaja.ostaPotion(pelaaja));
    }
    
    @Test
    public void pelaajaVoiOstaaKorkeintaanViisiPotionia() {
        pelaaja.muutaRahoja(99999);
        for(int i = 0; i < 4; i++) {
            parantaja.ostaPotion(pelaaja);
        }
        assertTrue(parantaja.ostaPotion(pelaaja));
        assertFalse(parantaja.ostaPotion(pelaaja));
        
    }
    
    @Test
    public void korkeammallaTasollaMaksaaPotionEnemman() {
        pelaaja.muutaRahoja(299);
        pelaaja.nostaTasoa();
        assertFalse(parantaja.ostaPotion(pelaaja));
        pelaaja.muutaRahoja(1);
        assertTrue(parantaja.ostaPotion(pelaaja));
    }
    
    @Test
    public void potioniaEiVoiOstaaJosOnViisi() {
        pelaaja.muutaRahoja(99999);
        pelaaja.setPotionit(4);
        assertTrue(parantaja.voikoOstaa(pelaaja));
        pelaaja.setPotionit(5);
        assertFalse(parantaja.voikoOstaa(pelaaja));
    }
    
    @Test
    public void kuvauksessaSanotaanJosEiRahaaPotioniin() {
        pelaaja.muutaRahoja(149);
        assertTrue(parantaja.getKuvaus(pelaaja).contains("ei ole tarpeeksi"));
        pelaaja.muutaRahoja(1);
        assertFalse(parantaja.getKuvaus(pelaaja).contains("ei ole tarpeeksi"));
        pelaaja.muutaRahoja(1);
        assertFalse(parantaja.getKuvaus(pelaaja).contains("ei ole tarpeeksi"));
    }
    
    @Test
    public void potioninOstaminenMuuttaaPelaajanRahojaOikein() {
        pelaaja.muutaRahoja(151);
        parantaja.ostaPotion(pelaaja);
        assertEquals(1, pelaaja.getRahat());
    }

}
