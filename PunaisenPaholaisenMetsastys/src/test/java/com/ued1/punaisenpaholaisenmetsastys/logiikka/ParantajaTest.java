
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
        pelaaja.muutaRahoja(new VihannesPotion(pelaaja).arvo());
        assertTrue(parantaja.voikoOstaa(pelaaja));
        pelaaja.muutaRahoja(1);
        assertTrue(parantaja.voikoOstaa(pelaaja));
    }

}
