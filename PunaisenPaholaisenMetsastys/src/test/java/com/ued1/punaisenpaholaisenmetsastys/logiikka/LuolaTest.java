package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Riepu;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Vaatteet;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class LuolaTest {
    
    private Pelaaja pelaaja;
    private Luola luola;
    
    public LuolaTest() {
        pelaaja = new Pelaaja("Testaaja");
    }
    
    @Before
    public void setUp() {
        luola = new Luola(pelaaja);
        luola.haastaPaholainen();
    }
    
    @Test 
    public void taisteluaEiOleAsetettuAlussa() {
        Luola uusiLuola = new Luola(pelaaja);
        assertTrue(uusiLuola.getTaistelu() == null);
    }
    
    @Test
    public void metodiHastaPaholainenAlustaaTaistelunOikein() {
        assertTrue(luola.getTaistelu() != null);
    }
    
    @Test
    public void taisteluEiAlaItsestaan() {
        assertFalse(luola.getTaistelu().onkoKaynnissa());
    }
    
    @Test
    public void luolassaTaistelussaVastassaPunainenPaholainen() {
        assertEquals("Punainen Paholainen", luola.getTaistelu().vastustaja().getNimi());
    }
    
    private void tapaPelaaja() {
        int vointi = pelaaja.getVointi();
        for(int i = 0; i < vointi; i++) {
            pelaaja.laskeVointia();
        }
    }
    
    @Test
    public void pelaajanHavitessaPelaajanRahatNollaan() {
        pelaaja.muutaRahoja(10);
        tapaPelaaja();
        assertFalse(pelaaja.onkoElossa());
        luola.asetaTulos();
        assertEquals(0, pelaaja.getRahat());
    }
    
    private void tapaPelaajaJaAsetaTulos() {
        tapaPelaaja();
        luola.asetaTulos();
    }
    
    @Test
    public void pelaajanHavitessaPelaajaMenettaaHaarniskan() {
        pelaaja.setHaarniska(new Vaatteet());
        tapaPelaajaJaAsetaTulos();
        assertEquals(new Riepu().toString(), pelaaja.getHaarniska().toString());
    }
    
    @Test
    public void pelaajanHavitessaPelaajaParantuu() {
        tapaPelaajaJaAsetaTulos();
        assertEquals(pelaaja.getVointi(),pelaaja.getMaxVointi());
    }
    
}
