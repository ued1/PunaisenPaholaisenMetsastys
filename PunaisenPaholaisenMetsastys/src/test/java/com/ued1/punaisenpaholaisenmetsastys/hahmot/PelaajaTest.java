
package com.ued1.punaisenpaholaisenmetsastys.hahmot;

import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.OhraPotion;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.Pupu;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Keppi;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Nyrkki;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Tikari;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Riepu;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Vaatteet;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Vaikeus;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {
    
    Pelaaja pelaaja;
    Pelaaja helppoPelaaja;
    
    public PelaajaTest() {
    }
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Testipelaaja");
        helppoPelaaja = new Pelaaja("Helppotestaaja", Vaikeus.HELPPO);
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
    public void pelaajallaAlussaPotioneja() {
        assertEquals(5, pelaaja.getPotionit());
        assertEquals(10, helppoPelaaja.getPotionit());
    }
        
    @Test
    public void pelaajanPotionitAsetetaanOikein() {
        pelaaja.setPotionit(-1);
        assertEquals(0, pelaaja.getPotionit());
        pelaaja.setPotionit(0);
        assertEquals(0, pelaaja.getPotionit());
        pelaaja.setPotionit(10);
        assertEquals(10, pelaaja.getPotionit());
        pelaaja.setPotionit(11);
        assertEquals(10, pelaaja.getPotionit());
    }
    
    @Test
    public void pelaajallaEiAlussaOlePupua() {
        pelaaja.onkoPelaajallaApu(new Pupu(pelaaja));
    }
    
    @Test
    public void pelaajallaOnPupuKunPupuLisataan() {
        assertTrue(pelaaja.lisaaApu(new Pupu(pelaaja)));
        assertTrue(pelaaja.onkoPelaajallaApu(new Pupu(pelaaja)));
    }
    
    @Test
    public void pelaajallaEiVoiOllaKahtaSamaaApua() {
        assertTrue(pelaaja.lisaaApu(new Pupu(pelaaja)));
        assertFalse(pelaaja.lisaaApu(new Pupu(pelaaja)));
    }
    
    @Test
    public void pelaajallaVoiOllaKaksiEriApua() {
        assertTrue(pelaaja.lisaaApu(new Pupu(pelaaja)));
        assertTrue(pelaaja.lisaaApu(new OhraPotion(pelaaja)));
        assertTrue(pelaaja.onkoPelaajallaApu(new Pupu(pelaaja)));
        assertTrue(pelaaja.onkoPelaajallaApu(new OhraPotion(pelaaja)));
    }
    
    @Test
    public void metodiSetVointiAsettaaVoinninOikein() {
        pelaaja.setVointi(0);
        assertEquals(0,pelaaja.getVointi());
        pelaaja.setVointi(-1);
        assertEquals(0,pelaaja.getVointi());
        pelaaja.setVointi(99);
        assertEquals(99,pelaaja.getVointi());
    }
    
    @Test
    public void parantaminenLaskeeVoinninMaxVointiin() {
        pelaaja.setVointi(99);
        assertTrue(pelaaja.getVointi() > pelaaja.getMaxVointi());
        pelaaja.paranna();
        assertEquals(pelaaja.getVointi(), pelaaja.getMaxVointi());
    }
    
    @Test
    public void vointiBuustiParantaaJosVointiAllePuolet() {
        pelaaja.setVointi(pelaaja.getMaxVointi() / 2 - 1);
        pelaaja.vointiBuusti();
        assertEquals(pelaaja.getVointi(), pelaaja.getMaxVointi());
    }
    
    @Test
    public void vointiBuustiNostaaVoinninOikein() {
        pelaaja.vointiBuusti();
        assertTrue(pelaaja.getVointi() <= pelaaja.getMaxVointi()*1.5);
        int vointi = pelaaja.getMaxVointi() / 2 + 1;
        pelaaja.setVointi(vointi);
        pelaaja.vointiBuusti();
        assertEquals(vointi * 2, pelaaja.getVointi());
    }
    
    @Test
    public void pelaajanVaikeusAsteAsetetaanOikein() {
        assertTrue(pelaaja.getVaikeus() == Vaikeus.NORMAALI);
        assertTrue(helppoPelaaja.getVaikeus() == Vaikeus.HELPPO);
    }
    
    @Test
    public void pelaajanVaikeusAsteenVoiVaihtaa() {
        pelaaja.setVaikeus(Vaikeus.HELPPO);
        helppoPelaaja.setVaikeus(Vaikeus.NORMAALI);
        assertFalse(pelaaja.getVaikeus() == Vaikeus.NORMAALI);
        assertFalse(helppoPelaaja.getVaikeus() == Vaikeus.HELPPO);
    }
    
    @Test
    public void pelaajallaEiAluksiApuja() {
        assertTrue(pelaaja.getAvut().isEmpty());
    }
    
    @Test
    public void avunVoiPoistaaJosPelaajallaSeOn() {
        assertFalse(pelaaja.poistaApu(new Pupu(pelaaja)));
        pelaaja.lisaaApu(new Pupu(pelaaja));
        assertTrue(pelaaja.poistaApu(new Pupu(pelaaja)));
        assertFalse(pelaaja.onkoPelaajallaApu(new Pupu(pelaaja)));
    }
                
}
