package com.ued1.punaisenpaholaisenmetsastys.peli.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Asepaja;
import com.ued1.punaisenpaholaisenmetsastys.peli.aseet.Keppi;
import com.ued1.punaisenpaholaisenmetsastys.peli.aseet.Maila;
import com.ued1.punaisenpaholaisenmetsastys.peli.aseet.Nyrkki;
import com.ued1.punaisenpaholaisenmetsastys.peli.aseet.Tikari;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
        assertTrue(asepaja.valikoimaMerkkijonona().contains(keppiString));
        assertTrue(asepaja.valikoimaMerkkijonona().contains(tikariString));
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

    @Test
    public void ostokomennoissaEiNyrkkia() {
        assertFalse(asepaja.ostokomennot(pelaaja).contains(new Nyrkki().toString()));
    }

    @Test
    public void ostokomennoissaEiKeppiaJosEiRahaa() {
        assertFalse(asepaja.ostokomennot(pelaaja).contains(new Keppi().toString()));
    }

    @Test
    public void ostokomennoissaKeppiJosRahaa() {
        pelaaja.muutaRahoja(10000);
        assertTrue(asepaja.ostokomennot(pelaaja).contains(new Keppi().toString()));
    }

    @Test
    public void eiVoiOstaaAsettaTaulukonUlkopuolelta() {
        pelaaja.muutaRahoja(200000000);
        assertFalse(asepaja.osta(pelaaja, asepaja.getValikoima().size()));
        assertFalse(asepaja.osta(pelaaja, asepaja.getValikoima().size() + 1));
        assertFalse(asepaja.osta(pelaaja, -1));
    }

    @Test
    public void taulukonUlkopuoleltaEiVoiOstaaAsetta() {
        pelaaja.muutaRahoja(200000000);
        assertFalse(asepaja.osta(pelaaja, -1));
        assertFalse(asepaja.osta(pelaaja, 666));
        assertFalse(asepaja.osta(pelaaja, asepaja.getValikoima().size()));
    }

    @Test
    public void metodiOstettavissaOlevatIlmoittaaAseenMyynnista() {
        pelaaja.setAse(new Tikari());
        assertTrue(asepaja.ostettavissaOlevat(pelaaja).contains("ensin myydä aseesi"));
    }

}
