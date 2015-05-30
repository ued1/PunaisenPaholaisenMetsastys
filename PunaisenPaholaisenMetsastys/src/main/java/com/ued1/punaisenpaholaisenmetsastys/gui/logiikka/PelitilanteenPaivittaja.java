
package com.ued1.punaisenpaholaisenmetsastys.gui.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.logiikka.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.gui.PelaajaTietoPanel;
import com.ued1.punaisenpaholaisenmetsastys.gui.TarinaPanel;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;

/**
 * Luokan tehtävänä on antaa päivityskäsky paneeleille ja asettaa pelaajan
 * paikkatieto vastaavaan uutta paikkaa.
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
     * Metodi asettaa pelaajalle uuden paikan ja antaa päivityskäskyn paneeleille.
     * 
     * @param uusiPaikka uusi paikka
     */
    public void liikuta(Paikka uusiPaikka) {
        pelaaja.setPaikka(uusiPaikka);
        tarinaPanel.setPaikka(uusiPaikka);
        pelaajaTietoPanel.repaint();
    }
    
}
