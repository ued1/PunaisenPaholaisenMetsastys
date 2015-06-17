package com.ued1.punaisenpaholaisenmetsastys.peli.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Casino;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class CasinoTest {

    private Casino casino;
    private Pelaaja pelaaja;

    public CasinoTest() {
    }

    @Before
    public void setUp() {
        casino = new Casino();
        pelaaja = new Pelaaja("Uhkapelaaja");
    }

    @Test
    public void kasinonKuvausOikein() {
        assertTrue(casino.getCasinoKuvaus(pelaaja).contains("Peukkupeli"));
        assertTrue(casino.getCasinoKuvaus(pelaaja).contains("pitää olla rahaa"));
        pelaaja.muutaRahoja(1);
        assertFalse(casino.getCasinoKuvaus(pelaaja).contains("pitää olla rahaa"));
    }

    @Test
    public void peukkuPelinKuvausOikein() {
        assertTrue(casino.getPeukkupeliKuvaus().contains("eukkupelissä"));
    }

    @Test
    public void peukkupelissaPelaajanRahatMuuttuvatOikein() {
        asetaRahatJaPelaaPeukkua(11);
        assertTrue(pelaaja.getRahat() == 22 || pelaaja.getRahat() == 0);
        asetaRahatJaPelaaPeukkua(12);
        assertTrue(pelaaja.getRahat() == 0 || pelaaja.getRahat() == 24);
        asetaRahatJaPelaaPeukkua(0);
        assertTrue(pelaaja.getRahat() == 0 || pelaaja.getRahat() == 0);
        asetaRahatJaPelaaPeukkua(1);
        assertTrue(pelaaja.getRahat() == 0 || pelaaja.getRahat() == 2);
        asetaRahatJaPelaaPeukkua(200);
        assertTrue(pelaaja.getRahat() == 400 || pelaaja.getRahat() == 0);
    }

    @Test
    public void komennoissaPelitJosPelaajallaRahaa() {
        assertFalse(casino.getKomennot(pelaaja).contains("eukkupeli"));
        pelaaja.muutaRahoja(1);
        assertTrue(casino.getKomennot(pelaaja).contains("eukkupeli"));
    }

    private void asetaRahatJaPelaaPeukkua(int panos) {
        pelaaja.nollaaRahat();
        pelaaja.muutaRahoja(panos);
        casino.pelaaPeukkua(pelaaja);
    }

}
