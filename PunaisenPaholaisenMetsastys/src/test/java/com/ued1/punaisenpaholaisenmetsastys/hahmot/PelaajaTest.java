
package com.ued1.punaisenpaholaisenmetsastys.hahmot;

import com.ued1.punaisenpaholaisenmetsastys.logiikka.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Keppi;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Nyrkki;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Tikari;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Riepu;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Vaatteet;
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
    
    // Seuraavat testit testaavat alkutietoja
    
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
    public void pelaajanAseenaAluksiNyrkki() {
        assertEquals(new Nyrkki().toString(), pelaaja.getAse().toString());
    }
    
    @Test
    public void pelaajanHaarniskaOnAluksiRiepu() {
        assertEquals(new Riepu().toString(), pelaaja.getHaarniska().toString());
    }
    
    @Test
    public void pelaajanRahatOvatAluksiNolla() {
        assertEquals(0, pelaaja.getRahat());
    }
    
    @Test
    public void pelaajaAlussaElossaJaVointi20() {
        assertEquals(20, pelaaja.getVointi());
        assertEquals(20, pelaaja.getMaxVointi());
        assertTrue(pelaaja.onkoElossa());
    }
    
    @Test
    public void pelaajanKokemusAluksiNolla() {
        assertEquals(0, pelaaja.getKokemus());
    }
    
    @Test
    public void pelaajaOnAluksiKylassa() {
        assertEquals(Paikka.KYLA, pelaaja.getPaikka());
    }
    
    // public boolean onkoElossa()
    @Test
    public void pelaajaElossaKunVointiPositiivinen() {
        laskeVointia(pelaaja.getVointi() - 1);
        assertTrue(pelaaja.onkoElossa());
        laskeVointia(1);
        assertFalse(pelaaja.onkoElossa());
        laskeVointia(3);
        assertFalse(pelaaja.onkoElossa());
    }
    
    // public void laskeVointia()
    @Test
    public void vointiLaskeeOikein() {
        int maxVointiAlussa = pelaaja.getMaxVointi();
        int vointiAlussa = pelaaja.getVointi();
        laskeVointia(3);
        assertEquals(vointiAlussa - 3, pelaaja.getVointi());
        assertEquals(maxVointiAlussa, pelaaja.getMaxVointi());
        laskeVointia(pelaaja.getVointi());
        assertEquals(0, pelaaja.getVointi());
        assertEquals(maxVointiAlussa, pelaaja.getMaxVointi());
        laskeVointia(1);
        assertEquals(0, pelaaja.getVointi());
        assertEquals(maxVointiAlussa, pelaaja.getMaxVointi());
    }
    
    private void laskeVointia(int paljonko) {
        for(int i = 0; i < paljonko; i++) {
            pelaaja.laskeVointia();
        }
    }
    
    //  public void paranna()
    @Test
    public void pelaajaParantuuOikein() {
        laskeVointia(3);
        int laskettuVointi = pelaaja.getVointi();
        pelaaja.paranna();
        assertEquals(laskettuVointi + 3, pelaaja.getVointi());
        assertEquals(laskettuVointi + 3, pelaaja.getMaxVointi());
    }
    
    @Test
    public void parantuneenPelaajanParantaminenEiMuutaVointia() {
        pelaaja.paranna();
        assertEquals(pelaaja.getVointi(), pelaaja.getMaxVointi());
    }
    
    @Test
    public void pelaajaHeraaKuolleistaParantaessa() {
        laskeVointia(9999);
        assertFalse(pelaaja.onkoElossa());
        pelaaja.paranna();
        assertTrue(pelaaja.onkoElossa());
    }
    
    // public void muutaRahoja(int muutos)
    
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
    public void rahatEivatMeneYliRajojen() {
        int maximi = 200000000;
        pelaaja.muutaRahoja(maximi-10);
        pelaaja.muutaRahoja(10);
        assertEquals(maximi, pelaaja.getRahat());
        pelaaja.muutaRahoja(1);
        assertEquals(maximi, pelaaja.getRahat());
    }
    
    // uusi ase ja haarniska
    
    @Test
    public void pelaajalleVoiAsettaaUudenAseen() {
        pelaaja.setAse(new Tikari());
        assertEquals(new Tikari().toString(), pelaaja.getAse().toString());
        pelaaja.setAse(new Keppi());
        assertEquals(new Keppi().toString(), pelaaja.getAse().toString());
    }
    
    @Test
    public void pelaajanHaarniskanVoiVaihtaa() {
        pelaaja.setHaarniska(new Vaatteet());
        assertEquals(new Vaatteet().toString(), pelaaja.getHaarniska().toString());
    }
        
    // lyominen ja suojaaminen
    
    @Test
    public void aseLyoPelaajanPuolesta() {
        pelaaja.setAse(new Tikari());
        assertEquals(new Tikari().lyo(), pelaaja.lyo());
    }
    
    @Test
    public void haarniskaSuojaaPelaajanPuolesta() {
        pelaaja.setHaarniska(new Vaatteet());
        assertEquals(new Vaatteet().suojaa(), pelaaja.suojaa());
    }
    
    // pelaajan tiedot
    
    @Test
    public void pelaajanTiedoissaOnAseenNimi() {
        assertTrue(pelaaja.tiedotMerkkijonona().contains(pelaaja.getAse().toString()));
    }
       
    // paikan muuttaminen
    
    @Test
    public void pelaajanPaikkaaVoiMuuttaa() {
        pelaaja.setPaikka(Paikka.METSA);
        assertEquals(Paikka.METSA, pelaaja.getPaikka());
        pelaaja.setPaikka(Paikka.ASEPAJA);
        assertEquals(Paikka.ASEPAJA, pelaaja.getPaikka());
    }
        
    // tason nostaminen
    
    @Test
    public void pelaajanTasoNouseeNostaessa() {
        int pelaajanTasoAlussa = pelaaja.getTaso();
        pelaaja.nostaTasoa();
        pelaaja.nostaTasoa();
        assertEquals(pelaajanTasoAlussa + 2, pelaaja.getTaso());
    }
    
    @Test
    public void pelaajanTasoaNostaessaMaxVointiKasvaa() {
        int maxVointi = pelaaja.getMaxVointi();
        pelaaja.nostaTasoa();
        assertTrue(maxVointi < pelaaja.getMaxVointi());
        maxVointi = pelaaja.getMaxVointi();
        pelaaja.nostaTasoa();
        assertTrue(maxVointi < pelaaja.getMaxVointi());
    }
    
    @Test
    public void pelaajanTasonNostaminenParantaaPelaajan() {
        pelaaja.nostaTasoa();
        assertEquals(pelaaja.getVointi(), pelaaja.getMaxVointi());
        pelaaja.nostaTasoa();
        assertEquals(pelaaja.getVointi(), pelaaja.getMaxVointi());
    }
    
    @Test
    public void viimeinenTasoOnKymmenen() {
        for(int i = 0; i < 15; i++) {
            pelaaja.nostaTasoa();
        }
        assertEquals(10, pelaaja.getTaso());
    }
        
    // kokemus
    
    @Test
    public void pelaajanKokemusMuuttuuOikein() {
        int kokemusAlussa = pelaaja.getKokemus();
        pelaaja.muutaKokemusta(-kokemusAlussa);
        assertEquals(0, pelaaja.getKokemus());
        pelaaja.muutaKokemusta(-1);
        assertEquals(0, pelaaja.getKokemus());
        pelaaja.muutaKokemusta(11);
        assertEquals(11, pelaaja.getKokemus());
        pelaaja.muutaKokemusta(-666);
        assertEquals(0, pelaaja.getKokemus());
    }
    
    // rahojen nollaus
    @Test
    public void nollausNollaaRahat() {
        pelaaja.muutaRahoja(11);
        pelaaja.nollaaRahat();
        assertEquals(0, pelaaja.getRahat());
    }
    
    // potionit
    @Test
    public void pelaajallaEiAlussaPotioneja() {
        assertEquals(0, pelaaja.getPotionit());
    }
        
    @Test
    public void pelaajanPotionitAsetetaanOikein() {
        pelaaja.setPotionit(-1);
        assertEquals(0, pelaaja.getPotionit());
        pelaaja.setPotionit(0);
        assertEquals(0, pelaaja.getPotionit());
        pelaaja.setPotionit(5);
        assertEquals(5, pelaaja.getPotionit());
        pelaaja.setPotionit(6);
        assertEquals(5, pelaaja.getPotionit());
    }
                
}
