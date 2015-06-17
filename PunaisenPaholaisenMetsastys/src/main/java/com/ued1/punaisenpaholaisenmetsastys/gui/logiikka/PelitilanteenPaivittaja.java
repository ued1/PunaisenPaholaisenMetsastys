package com.ued1.punaisenpaholaisenmetsastys.gui.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.peli.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.gui.PelaajaTietoPanel;
import com.ued1.punaisenpaholaisenmetsastys.gui.TarinaPanel;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;

/**
 * Luokan tehtävänä on antaa päivityskäsky paneeleille ja asettaa pelaajan
 * paikkatieto vastaamaan uutta paikkaa.
 */
public class PelitilanteenPaivittaja {

    private Pelaaja pelaaja;
    private TarinaPanel tarinaPanel;
    private PelaajaTietoPanel pelaajaTietoPanel;

    public PelitilanteenPaivittaja(Pelaaja pelaaja, TarinaPanel tarinaPanel, PelaajaTietoPanel pelaajaTietoPanel) {
        this.pelaaja = pelaaja;
        this.tarinaPanel = tarinaPanel;
        this.pelaajaTietoPanel = pelaajaTietoPanel;
    }

    /**
     * Metodi asettaa pelaajalle uuden paikan ja antaa päivityskäskyn
     * paneeleille.
     *
     * @param uusiPaikka uusi paikka, joka asetetaan
     */
    public void paivita(Paikka uusiPaikka) {
        pelaaja.setPaikka(uusiPaikka);
        tarinaPanel.paivita(uusiPaikka);
        pelaajaTietoPanel.repaint();
    }

}
