package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Riepu;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Vaatteet;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HaarniskaKauppaTest {

    private HaarniskaKauppa kauppa;
    private Pelaaja pelaaja;

    public HaarniskaKauppaTest() {
    }

    @Before
    public void setUp() {
        kauppa = new HaarniskaKauppa();
        pelaaja = new Pelaaja("Testipelaaja");
        pelaaja.muutaRahoja(-10000);
    }

    @Test
    public void riepuJaVaatteetLoytyvatValikoimasta() {
        assertTrue(kauppa.hinnastoMerkkijonona().contains(new Riepu().nimi()));
        assertTrue(kauppa.hinnastoMerkkijonona().contains(new Vaatteet().nimi()));
    }

    @Test
    public void haarniskaaEiVoiOstaaJosEiVaraa() {
        pelaaja.muutaRahoja(new Vaatteet().arvo() - 1);
        assertFalse(kauppa.voikoOstaaHaarniskan(pelaaja, new Vaatteet()));
    }

    @Test
    public void haarniskanVoiOstaaKunTarpeeksiRahaa() {
        pelaaja.muutaRahoja(new Vaatteet().arvo());
        assertTrue(kauppa.voikoOstaaHaarniskan(pelaaja, new Vaatteet()));
    }

    @Test
    public void metodiOstaHaarniskaPalauttaaFalseJosEiVoiOstaa() {
        assertFalse(kauppa.ostaHaarniska(pelaaja, 1)); // TODO: equals tms numeroinnin sijaan
    }

    @Test
    public void haarniskaEiVaihduJosEiVoiOstaa() {
        kauppa.ostaHaarniska(pelaaja, 1); // TODO: fix
        assertEquals(new Riepu().nimi(), pelaaja.getHaarniska().nimi());
    }

    @Test
    public void metodiOstaHaarniskaPalauttaaTrueJosVoiOstaa() {
        pelaaja.muutaRahoja(new Vaatteet().arvo());
        assertTrue(kauppa.ostaHaarniska(pelaaja, 1));
    }

    @Test
    public void haarniskaVaihtuuKunOstoOnnistuu() {
        pelaaja.muutaRahoja(new Vaatteet().arvo());
        kauppa.ostaHaarniska(pelaaja, 1); // TODO: fix
        assertEquals(new Vaatteet().nimi(), pelaaja.getHaarniska().nimi());
    }

    @Test
    public void rahatVahenevatOikein() {
        int rahamaara = 666;
        pelaaja.muutaRahoja(rahamaara);
        kauppa.ostaHaarniska(pelaaja, 1); // TODO: fix
        assertEquals(rahamaara - new Vaatteet().arvo(), pelaaja.getRahat());
    }

    @Test
    public void vaatteetjaRiepuLoytyvatHinnastosta() {
        assertTrue(kauppa.hinnastoMerkkijonona().contains(new Riepu().nimi()));
        assertTrue(kauppa.hinnastoMerkkijonona().contains(new Vaatteet().nimi()));
    }

}
