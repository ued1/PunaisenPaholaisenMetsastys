
package com.ued1.punaisenpaholaisenmetsastys.hahmot;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MonsteriTest {
    
    Monsteri ekaMonsteri;
    Monsteri tokaMonsteri;
    
    public MonsteriTest() {
    }
   
    @Before
    public void setUp() {
        ekaMonsteri = new Monsteri(1, 10, 5);
        tokaMonsteri = new Monsteri(2, 12, 11);
    }
    
    @Test
    public void monstellaOnNimi() {
        assertFalse(ekaMonsteri.getNimi() == null);
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
    public void vointiAsetettuOikein() {
        assertEquals(1, ekaMonsteri.getVointi());
        assertEquals(2, tokaMonsteri.getVointi());
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
    }

}
