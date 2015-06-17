package com.ued1.punaisenpaholaisenmetsastys.tyokalut;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NimenValidoijaTest {

    private NimenValidoija validoija;

    public NimenValidoijaTest() {
    }

    @Before
    public void setUp() {
        this.validoija = new NimenValidoija();
    }

    @Test
    public void liianLyhyttaNimeaEiHyvaksyta() {
        assertFalse(validoija.tarkista("Q"));
    }

    @Test
    public void liianPitkaaNimeaEiHyvaksyta() {
        String pitka = "aaaaabbbbbcccccd";
        assertTrue(pitka.length() == 16);
        assertFalse(validoija.tarkista(pitka));
    }

    @Test
    public void sopivanPituinenNimiHyvaksytaan() {
        assertTrue(validoija.tarkista("aaaaabbbbbccccc"));
        assertTrue(validoija.tarkista("AA"));
    }

    @Test
    public void valejaEiLasketa() {
        assertFalse(validoija.tarkista("a c"));
        assertTrue(validoija.tarkista("     aaaaabbbbbccccc     "));
    }

    @Test
    public void eiVoiOllaNumeroa() {
        assertFalse(validoija.tarkista("asor2sefh"));
    }

    @Test
    public void eiVoiOllaErikoisMerkkeja() {
        assertFalse(validoija.tarkista("aaa!"));
        assertFalse(validoija.tarkista("aso\brefh"));
        assertFalse(validoija.tarkista("asor\"sefh"));
        assertFalse(validoija.tarkista("asor\\fh"));
        assertFalse(validoija.tarkista("asor@sefh"));
    }

    @Test
    public void skanditHyvaksytaan() {
        assertTrue(validoija.tarkista("ÅÄÖåäö"));
    }

    @Test
    public void tyhjaMerkkijonoPalauttaaFalse() {
        assertFalse(validoija.tarkista(""));
    }

    @Test
    public void nullPalauttaaFalse() {
        assertFalse(validoija.tarkista(null));
    }

}
