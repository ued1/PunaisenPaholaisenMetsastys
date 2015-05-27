
package com.ued1.punaisenpaholaisenmetsastys.hahmot;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MonsteriTest {
    
    Monsteri ekaMonsteri;
    Monsteri tokaMonsteri;
    private String[] nimet = {"Käärmefasaani", "Mörköläinen", "Jättiläinen",
            "Kaksipäinen Haamu", "Mörrimöykky", "Pöllökarhu", "Innostunut Sonni",
            "Hyytelöhirvi", "Röllipeikko", "Kaljamahainen Örkki", "Perkele",
            "Karvaperse", "Mörköpeikko", "Hymyilevä Kummitus", "Kiimainen Hirvi",
            "Yksisarvinen Krokotiili", "Isojalka", "Päätön Kana", "Kutistunut Jätti",
            "Isoperseinen Lehmä", "Hullu Muurahainen", "Kolmijalkainen Torakka"};
    
    
    public MonsteriTest() {
    }
   
    @Before
    public void setUp() {
        ekaMonsteri = new Monsteri(1, 10, 5);
        tokaMonsteri = new Monsteri(2, 12, 11);
    }
    
    @Test
    public void monsterillaOnNimi() {
        assertFalse(ekaMonsteri.getNimi() == null);
    }
    
    @Test
    public void monsterinNimiLoytyyListalta() {
        List<String> nimiLista = Arrays.asList(nimet);
        assertTrue(nimiLista.contains(ekaMonsteri.getNimi()));
        assertTrue(nimiLista.contains(tokaMonsteri.getNimi()));
    }
    
    @Test
    public void vointiAsetettuOikein() {
        assertEquals(1, ekaMonsteri.getVointi());
        assertEquals(2, tokaMonsteri.getVointi());
    }
        
    @Test
    public void monsteriOsaaLyodaOikein() {
        assertEquals(10, ekaMonsteri.lyo());
        assertEquals(12, tokaMonsteri.lyo());
    }
    
    @Test
    public void monsteriOsaaSuojataOikein() {
        assertEquals(5, ekaMonsteri.suojaa());
        assertEquals(11, tokaMonsteri.suojaa());
    }
        
    @Test
    public void monsterinVointiLaskeeLaskiessa() {
        assertEquals(2, tokaMonsteri.getVointi());
        tokaMonsteri.laskeVointia();
        assertEquals(1, tokaMonsteri.getVointi());
    }
    
    @Test
    public void monsteriKuoleeKunVointiNolla() {
        assertTrue(ekaMonsteri.onkoElossa());
        ekaMonsteri.laskeVointia();
        assertFalse(ekaMonsteri.onkoElossa());
        ekaMonsteri.laskeVointia();
        assertFalse(ekaMonsteri.onkoElossa());
    }

}
