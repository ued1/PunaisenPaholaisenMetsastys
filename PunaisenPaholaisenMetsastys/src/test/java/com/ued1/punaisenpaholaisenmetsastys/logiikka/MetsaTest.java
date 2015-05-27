
package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class MetsaTest {
    
    private Pelaaja pelaaja;
    private Metsa metsa;
    
    public MetsaTest() {
        pelaaja = new Pelaaja("Testipelaaja");
    }
   
    @Before
    public void setUp() {
        metsa = new Metsa(pelaaja);
        metsa.aloitaUusiTaistelu();
    }

    @Test 
    public void taisteluaEiOleAsetettuAlussa() {
        Metsa uusiMetsa = new Metsa(pelaaja);
        assertTrue(uusiMetsa.getTaistelu() == null);
    }
    
    @Test
    public void metodiAloitaUusiTaisteluAloittaaLuoTaistelun() {
        assertFalse(metsa.getTaistelu() == null);
    }
    
    @Test
    public void pelaajalleRahaaJaKokemustaJosVoittaaTaistelun() {
        int rahatAlussa = pelaaja.getRahat();
        int kokemusAlussa = pelaaja.getKokemus();
        assertTrue(pelaaja.onkoElossa());
        metsa.asetaTaistelunTulos();
        assertTrue(rahatAlussa < pelaaja.getRahat());
        assertTrue(kokemusAlussa < pelaaja.getKokemus());
    }
    
    private void tapaPelaaja() {
        int vointiAlussa = pelaaja.getVointi();
        for(int i = 0; i < vointiAlussa; i++) {
            pelaaja.laskeVointia();
        }
    }
    
    @Test
    public void pelaajaMenettaaRahansaJosHaviaa() {
        pelaaja.muutaRahoja(666);
        assertEquals(666, pelaaja.getRahat());
        tapaPelaaja();
        metsa.asetaTaistelunTulos();
        assertEquals(0, pelaaja.getRahat());
    }
    
    @Test
    public void pelaajaParantuuJosHaviaa() {
        tapaPelaaja();
        assertFalse(pelaaja.onkoElossa());
        metsa.asetaTaistelunTulos();
        assertTrue(pelaaja.onkoElossa());
        assertEquals(pelaaja.getVointi(), pelaaja.getMaxVointi());
    }
    
    @Test
    public void pelaajaEiParannuJosVoittaa() {
        pelaaja.laskeVointia();
        assertTrue(pelaaja.onkoElossa());
        int laskettuVointi = pelaaja.getVointi();
        assertTrue(laskettuVointi < pelaaja.getMaxVointi());
        metsa.asetaTaistelunTulos();
        assertEquals(laskettuVointi, pelaaja.getVointi());
    }
    
    @Test
    public void viimeisellaTasollaNouseeKokemusJaRahat() {
        for(int i = 0; i < 15; i++) {       // viimeinen taso korkeintaan 10
            pelaaja.nostaTasoa();
        }
        int rahatAlussa = pelaaja.getRahat();
        int kokemusAlussa = pelaaja.getKokemus();
        metsa.asetaTaistelunTulos();
        assertTrue(rahatAlussa < pelaaja.getRahat());
        assertTrue(kokemusAlussa < pelaaja.getKokemus());
        
    }

}
