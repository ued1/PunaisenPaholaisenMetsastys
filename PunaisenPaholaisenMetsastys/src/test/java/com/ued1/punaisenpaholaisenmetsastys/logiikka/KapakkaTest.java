
package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.KossuPotion;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
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
        assertTrue(kapakka.hinnastoMerkkijonona().contains(kossu.toString()));
    }
    
    
    
        
}
