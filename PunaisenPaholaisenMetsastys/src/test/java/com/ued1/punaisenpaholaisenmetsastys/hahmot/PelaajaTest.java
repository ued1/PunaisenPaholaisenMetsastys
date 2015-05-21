
package com.ued1.punaisenpaholaisenmetsastys.hahmot;

import com.ued1.punaisenpaholaisenmetsastys.aseet.Keppi;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Nyrkki;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Tikari;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {
    
    Pelaaja pelaaja;
    
    public PelaajaTest() {
    }
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Testipelaaja");
        pelaaja.muutaRahoja(-10000);
    }
    
    @Test
    public void konstruktoriAsettaaNimenOikein() {
        assertEquals("Testipelaaja", pelaaja.getNimi());
        Pelaaja toinenPelaaja = new Pelaaja("Kilpailija");
        assertEquals("Kilpailija", toinenPelaaja.getNimi());
    }
    
    @Test
    public void pelaajanTasoOnAlussaYksi() {
        assertEquals(1, pelaaja.getTaso());
    }
    
    @Test
    public void pelaajanTasoNouseeNostaessa() {
        pelaaja.nostaTasoa();
        pelaaja.nostaTasoa();
        assertEquals(3, pelaaja.getTaso());
    }
    
    @Test
    public void pelaajanAseenaAluksiNyrkki() {
        assertEquals(new Nyrkki().nimi(), pelaaja.getAse().nimi());
    }
    
    @Test
    public void pelaajalleVoiAsettaaUudenAseen() {
        pelaaja.setAse(new Tikari());
        assertEquals(new Tikari().nimi(), pelaaja.getAse().nimi());
        pelaaja.setAse(new Keppi());
        assertEquals(new Keppi().nimi(), pelaaja.getAse().nimi());
    }
    
    @Test
    public void pelaajanRahatOvatAluksiNolla() {
        assertEquals(0, pelaaja.getRahat());
    }
    
    @Test
    public void rahatMuuttuvatOikein() {
        pelaaja.muutaRahoja(10);
        pelaaja.muutaRahoja(-3);
        assertEquals(7, pelaaja.getRahat());
    }
    
    @Test
    public void rahatEivatMeneNegatiiviseksi() {
        pelaaja.muutaRahoja(5);
        pelaaja.muutaRahoja(-999);
        assertEquals(0, pelaaja.getRahat());
    }
    
    @Test
    public void pelaajaAlussaElossaJaVointi10() {
        assertEquals(10, pelaaja.getVointi());
        assertEquals(10, pelaaja.getMaxVointi());
        assertTrue(pelaaja.onkoElossa());
    }
    
    private void laskeVointiaYhdeksalla() {
        for(int i = 0; i < 9; i++) {
            pelaaja.laskeVointia();
        }
    }
    
    @Test
    public void vointiLaskeeOikein() {
        laskeVointiaYhdeksalla();
        assertEquals(1, pelaaja.getVointi());
        assertEquals(10, pelaaja.getMaxVointi());
        assertTrue(pelaaja.onkoElossa());
        laskeVointiaYhdeksalla();
        assertEquals(0, pelaaja.getVointi());
        assertEquals(10, pelaaja.getMaxVointi());
        assertFalse(pelaaja.onkoElossa());
    }
    
    @Test
    public void pelaajaParantuuOikein() {
        laskeVointiaYhdeksalla();
        pelaaja.paranna();
        assertEquals(10, pelaaja.getVointi());
        assertEquals(10, pelaaja.getMaxVointi());
    }
    
    @Test
    public void parantuneenPelaajanParantaminenEiMuutaVointia() {
        pelaaja.paranna();
        assertEquals(pelaaja.getVointi(), pelaaja.getMaxVointi());
    }
    
    @Test
    public void pelaajaHeraaKuolleistaParantaessa() {
        laskeVointiaYhdeksalla();
        laskeVointiaYhdeksalla();
        assertFalse(pelaaja.onkoElossa());
        pelaaja.paranna();
        assertTrue(pelaaja.onkoElossa());
    }
    
    @Test
    public void aseLyoPelaajanPuolesta() {
        pelaaja.setAse(new Tikari());
        assertEquals(new Tikari().lyo(), pelaaja.lyo());
    }
            
}
