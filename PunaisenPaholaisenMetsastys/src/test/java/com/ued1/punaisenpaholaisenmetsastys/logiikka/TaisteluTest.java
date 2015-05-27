package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Hahmo;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Monsteri;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TaisteluTest {
    
    private Hahmo pelaaja;
    private Hahmo kovisMonsteri;
    private Hahmo tasainenMonsteri;
    private Hahmo hutiMonsteri;
    private Hahmo eiTaisteluaMonsteri;
    private Hahmo kuoleeHetiMonsteri;
    private Taistelu kovisTaistelu;
    private Taistelu tasainenTaistelu;
    private Taistelu hutiTaistelu;
    private Taistelu eiTaistelua;
    private Taistelu paattyyHeti;

    public TaisteluTest() {
    }

    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Taistelija"); // vointi:10 lyo:5 suojaa:1
        kovisMonsteri = new Monsteri(20, 11, 0); // vointi:20 lyo:11 suojaa:0
        tasainenMonsteri = new Monsteri(17, 4, 1);
        hutiMonsteri = new Monsteri(21, 0, 0);
        eiTaisteluaMonsteri = new Monsteri(1, 1, 5);
        kuoleeHetiMonsteri = new Monsteri(1, 999, 1);
        kovisTaistelu = new Taistelu(pelaaja, kovisMonsteri);
        tasainenTaistelu = new Taistelu(pelaaja, tasainenMonsteri);
        hutiTaistelu = new Taistelu(pelaaja, hutiMonsteri);
        eiTaistelua = new Taistelu(pelaaja, eiTaisteluaMonsteri);
        paattyyHeti = new Taistelu(pelaaja, kuoleeHetiMonsteri);
    }

    /*  // taistelun logiikkaa muutettu, taistelu ei enää etene näin, TODO: korvaava testi
    @Test
    public void taistelunIskujenVoimatOnLaskettuOikein() {
        int pelaajanIsku = Math.max(0, pelaaja.lyo() - tasainenMonsteri.suojaa());
        int monsterinIsku = Math.max(0, tasainenMonsteri.lyo() - pelaaja.suojaa());
        tasainenTaistelu.taistele();
        assertEquals(pelaajanIsku, tasainenTaistelu.getEkaIsku());
        assertEquals(monsterinIsku, tasainenTaistelu.getTokaIsku());
    }
    */

    
    @Test
    public void taistelussaVointiLaskeeOikein() {
        hutiTaistelu.taistele();
        assertEquals(hutiTaistelu.getEkaIsku(), hutiMonsteri.getMaxVointi() - hutiMonsteri.getVointi());
        assertEquals(hutiTaistelu.getTokaIsku(), pelaaja.getMaxVointi() - pelaaja.getVointi());
        pelaaja.paranna();
        tasainenTaistelu.taistele();
        assertEquals(tasainenTaistelu.getEkaIsku(), tasainenMonsteri.getMaxVointi() - tasainenMonsteri.getVointi());
        assertEquals(tasainenTaistelu.getTokaIsku(), pelaaja.getMaxVointi() - pelaaja.getVointi());
    }

    /* // TODO: taistelu ei enää etene näin, korvaava testi
    @Test
    public void molempienLyodessaHutejaEiKummankaanVointiLaske() {
        taisteleMontaKertaa(eiTaistelua, 10);
        assertEquals(pelaaja.getVointi(), pelaaja.getMaxVointi());
        assertEquals(eiTaisteluaMonsteri.getVointi(), eiTaisteluaMonsteri.getMaxVointi());
        assertEquals(0, eiTaistelua.getEkaIsku());
        assertEquals(0, eiTaistelua.getTokaIsku());
    }
    */

    /* // TODI: uusi testi, taistelulogiikka vaihtunut
    @Test
    public void metodiPalauttaaTrueJosToinenKuolee() {
        assertTrue(kovisTaistelu.taistele());
        pelaaja.paranna();
        assertFalse(hutiTaistelu.taistele());
    }
    */

    @Test
    public void toinenTaistelijaEiLyoJosEnsimmainenVoittaaHeti() {
        assertTrue(paattyyHeti.taistele());
        assertEquals(-999, paattyyHeti.getTokaIsku());
        assertEquals(pelaaja.getMaxVointi(), pelaaja.getVointi());
        assertFalse(kuoleeHetiMonsteri.onkoElossa());
    }
    
    /* lyöntivoima muutettu max --> max/2..max
    @Test
    public void taisteluEteneeJaPaattyyOikein() {
        // 10 5 1 vs 17 4 1
        tasainenTaistelu.taistele();
        assertEquals(13, tasainenMonsteri.getVointi());
        assertEquals(7, pelaaja.getVointi());
        taisteleMontaKertaa(tasainenTaistelu, 2);
        assertEquals(5, tasainenMonsteri.getVointi());
        assertEquals(1, pelaaja.getVointi());
        assertTrue(tasainenTaistelu.taistele());
        assertEquals(1,tasainenMonsteri.getVointi());
        assertFalse(pelaaja.onkoElossa());
        assertTrue(tasainenMonsteri.onkoElossa());
    }
    */

    private void taisteleMontaKertaa(Taistelu taistelu, int kerrat) {
        for (int i = 0; i < kerrat; i++) {
            taistelu.taistele();
        }
    }

}
