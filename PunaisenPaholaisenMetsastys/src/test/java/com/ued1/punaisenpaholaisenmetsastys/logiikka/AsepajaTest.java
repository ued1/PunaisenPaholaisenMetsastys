package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.aseet.Keppi;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Maila;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Nyrkki;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Tikari;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class AsepajaTest {

    Pelaaja pelaaja;
    Asepaja asepaja;
    String nyrkkiString;
    String keppiString;
    String tikariString;

    public AsepajaTest() {
        nyrkkiString = new Nyrkki().toString();
        keppiString = new Keppi().toString();
        tikariString = new Tikari().toString();
    }

    private void lahjoitaPelaajalleKeppi(Pelaaja pelaaja) {
        pelaaja.setAse(new Keppi());
    }

    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Testipelaaja");
        pelaaja.muutaRahoja(-10000);
        asepaja = new Asepaja();
    }

    @Test
    public void keppiJaTikariLoytyvatValikoimasta() {
        assertTrue(asepaja.hinnastoMerkkijonona().contains(keppiString));
        assertTrue(asepaja.hinnastoMerkkijonona().contains(tikariString));
    }

    @Test
    public void omaaNyrkkiaEiVoiMyyda() {
        assertTrue(!asepaja.voikoMyydaAseen(pelaaja));
        assertTrue(!asepaja.myy(pelaaja));
        assertEquals(nyrkkiString, pelaaja.getAse().toString());
    }

    @Test
    public void aseenVoiMyyda() {
        lahjoitaPelaajalleKeppi(pelaaja);
        assertTrue(asepaja.voikoMyydaAseen(pelaaja));
        assertTrue(asepaja.myy(pelaaja));
        assertEquals(nyrkkiString, pelaaja.getAse().toString());
    }

    @Test
    public void toistaAsettaEiVoiOstaa() {
        lahjoitaPelaajalleKeppi(pelaaja);
        pelaaja.muutaRahoja(1000);
        assertTrue(!asepaja.osta(pelaaja, 2)); // TODO: fix
        assertEquals(keppiString, pelaaja.getAse().toString());
    }

    @Test
    public void aseenVoiOstaaKunOnNyrkki() {
        assertEquals(nyrkkiString, pelaaja.getAse().toString());
        pelaaja.muutaRahoja(1000);
        assertTrue(asepaja.osta(pelaaja, 1)); // TODO: fix
        assertEquals(keppiString, pelaaja.getAse().toString());
    }

    @Test
    public void aseenMyydessaSaaRahaaOikein() {
        int rahaaAlussa = pelaaja.getRahat();
        lahjoitaPelaajalleKeppi(pelaaja);
        asepaja.myy(pelaaja);
        assertEquals(rahaaAlussa + (new Keppi()).arvo() / 2, pelaaja.getRahat());
    }

    @Test
    public void asettaEiVoiOstaaJosEiTarpeeksiRahaa() {
        pelaaja.muutaRahoja((new Keppi()).arvo() - 1);
        assertTrue(!asepaja.osta(pelaaja, 1)); // TODO: fix
    }

    @Test
    public void aseenVoiOstaaKunTarpeeksiRahaa() {
        pelaaja.muutaRahoja((new Keppi()).arvo());
        assertTrue(asepaja.osta(pelaaja, 1)); // TODO: fix
    }

    @Test
    public void aseenOstaessaRahatVahenevatOikein() {
        int alkuraha = 10000;
        pelaaja.muutaRahoja(alkuraha);
        asepaja.osta(pelaaja, 2);
        assertEquals(alkuraha - new Maila().arvo(), pelaaja.getRahat());
    }

}
