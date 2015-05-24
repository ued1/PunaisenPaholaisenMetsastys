
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;

public class PelaajanLiikuttaja {

    private Pelaaja pelaaja;
    private TarinaPanel tarinaPanel;
    private PelaajaTietoPanel pelaajaTietoPanel;
    
    public PelaajanLiikuttaja(Pelaaja pelaaja, TarinaPanel tarinaPanel, PelaajaTietoPanel pelaajaTietoPanel) {
        this.pelaaja = pelaaja;
        this.tarinaPanel = tarinaPanel;
        this.pelaajaTietoPanel = pelaajaTietoPanel;
    }
    
    public void liikuta(Paikka uusiPaikka) {
        pelaaja.setPaikka(uusiPaikka);
        tarinaPanel.setPaikka(uusiPaikka);
        pelaajaTietoPanel.repaint();
    }
    
}
