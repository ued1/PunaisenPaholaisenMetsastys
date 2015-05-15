package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.aseet.Keppi;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Tikari;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class AsepajaTest {

    Pelaaja pelaaja;
    Asepaja asepaja;
    
    public AsepajaTest() {
    }
    
    private void lahjoitaPelaajalleKeppi(Pelaaja pelaaja) {
        pelaaja.setAse(new Keppi());
    }
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Testipelaaja");
        asepaja = new Asepaja();
    }
    
    @Test
    public void keppiJaTikariLoytyvatValikoimasta() {
        assertTrue(asepaja.hinnastoMerkkijonona().contains("Keppi"));
        assertTrue(asepaja.hinnastoMerkkijonona().contains("Tikari"));
    }
    
    @Test
    public void omaaNyrkkiaEiVoiMyyda() {
        assertTrue(!asepaja.voikoMyydaAseen(pelaaja));
        assertTrue(!asepaja.myyAse(pelaaja));
        assertEquals("Nyrkki", pelaaja.getAse().nimi());
    }
    
    @Test
    public void aseenVoiMyyda() {
        lahjoitaPelaajalleKeppi(pelaaja);
        assertTrue(asepaja.voikoMyydaAseen(pelaaja));
        assertTrue(asepaja.myyAse(pelaaja));
        assertEquals("Nyrkki", pelaaja.getAse().nimi());
    }
    
    @Test
    public void toistaAsettaEiVoiOstaa() {
        lahjoitaPelaajalleKeppi(pelaaja);
        pelaaja.muutaRahoja(1000);
        assertTrue(!asepaja.ostaAse(pelaaja, 2));
        assertEquals("Keppi", pelaaja.getAse().nimi());
    }
    
    @Test
    public void aseenVoiOstaaKunOnNyrkki() {
        assertEquals("Nyrkki", pelaaja.getAse().nimi());
        pelaaja.muutaRahoja(1000);
        assertTrue(asepaja.ostaAse(pelaaja, 1));
        assertEquals("Keppi", pelaaja.getAse().nimi());
    }
    
    @Test
    public void aseenMyydessaSaaRahaaOikein() {
        int rahaaAlussa = pelaaja.getRahat();
        lahjoitaPelaajalleKeppi(pelaaja);
        asepaja.myyAse(pelaaja);
        assertEquals(rahaaAlussa + (new Keppi()).arvo() / 2, pelaaja.getRahat());
    }
    
    @Test
    public void asettaEiVoiOstaaJosEiTarpeeksiRahaa() {
        pelaaja.muutaRahoja(-100000);
        pelaaja.muutaRahoja((new Keppi()).arvo() - 1);
        assertTrue(!asepaja.ostaAse(pelaaja, 1));
    }
    
    @Test
    public void aseenVoiOstaaKunTarpeeksiRahaa() {
        pelaaja.muutaRahoja(-100000);
        pelaaja.muutaRahoja((new Keppi()).arvo());
        assertTrue(asepaja.ostaAse(pelaaja, 1));
    }
    
}
