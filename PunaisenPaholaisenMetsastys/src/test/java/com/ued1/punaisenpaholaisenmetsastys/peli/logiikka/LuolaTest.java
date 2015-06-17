package com.ued1.punaisenpaholaisenmetsastys.peli.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Luola;
import com.ued1.punaisenpaholaisenmetsastys.peli.Vaikeus;
import com.ued1.punaisenpaholaisenmetsastys.peli.haarniskat.Riepu;
import com.ued1.punaisenpaholaisenmetsastys.peli.haarniskat.Vaatteet;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;
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
    public void metodiHaastaPaholainenAlustaaTaistelunOikein() {
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
        for (int i = 0; i < vointi; i++) {
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
        assertEquals(pelaaja.getVointi(), pelaaja.getMaxVointi());
    }

    @Test
    public void helppoPaholainenOnHelpompi() {
        Pelaaja helppoPelaaja = new Pelaaja("Helppo", Vaikeus.HELPPO);
        Luola helppoLuola = new Luola(helppoPelaaja);
        luola.haastaPaholainen();
        helppoLuola.haastaPaholainen();
        assertTrue(luola.getTaistelu().vastustaja().getVointi() > helppoLuola.getTaistelu().vastustaja().getVointi());
    }

    @Test
    public void paholainenParantuuVoittaessa() {
        haastaJaHaviaPaholaiselle();
        assertEquals(luola.getTaistelu().vastustaja().getVointi(), luola.getTaistelu().vastustaja().getMaxVointi());
    }

    private void haastaJaHaviaPaholaiselle() {
        luola.haastaPaholainen();
        while (!luola.getTaistelu().taistele()) {
        }
        luola.asetaTulos();
    }

    @Test
    public void asetaPotionitAsettaaOikein() {
        assertEquals(0, luola.getMustaPotion());
        assertEquals(0, luola.getPunainenPotion());
        luola.asetaPotionit();
        assertEquals(5, luola.getMustaPotion());
        assertEquals(5, luola.getPunainenPotion());
    }

    @Test
    public void potionitNollataanPaholaisenVoittaessa() {
        luola.asetaPotionit();
        haastaJaHaviaPaholaiselle();
        assertEquals(0, luola.getMustaPotion());
        assertEquals(0, luola.getPunainenPotion());
    }

    @Test
    public void punainenPotionToimiiOikein() {
        luola.asetaPotionit();
        int potionitAlussa = luola.getPunainenPotion();
        pelaaja.laskeVointia();
        luola.kaytaPunainenPotion();
        assertEquals(potionitAlussa - 1, luola.getPunainenPotion());
        assertEquals(pelaaja.getVointi(), pelaaja.getMaxVointi());
    }

    @Test
    public void mustaPotionToimiiOikein() {
        luola.asetaPotionit();
        int potionitAlussa = luola.getMustaPotion();
        pelaaja.setVointi(200);
        luola.kaytaMustaPotion();
        assertEquals(potionitAlussa - 1, luola.getMustaPotion());
        assertEquals(200 - 100 - 10 - 1, pelaaja.getVointi());
    }

}
