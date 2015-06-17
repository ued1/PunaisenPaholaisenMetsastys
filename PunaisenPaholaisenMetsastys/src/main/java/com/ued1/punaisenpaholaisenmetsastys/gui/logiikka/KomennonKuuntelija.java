package com.ued1.punaisenpaholaisenmetsastys.gui.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.gui.Kyla;
import com.ued1.punaisenpaholaisenmetsastys.peli.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.gui.PelaajaTietoPanel;
import com.ued1.punaisenpaholaisenmetsastys.gui.TarinaPanel;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Areena;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Luola;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Metsa;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Parantaja;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KomennonKuuntelija kuuntelee pelaajan antamia komentoja näppäimistöltä.
 */
public class KomennonKuuntelija implements KeyListener {

    private KomennonKasittelija kasittelija;
    private KomennonValidoija validoija;
    private Pelaaja pelaaja;
    private Kyla kyla;

    public KomennonKuuntelija(Kyla kyla, Pelaaja pelaaja, TarinaPanel tarinaPanel, PelaajaTietoPanel pelaajaTietoPanel, Metsa metsa, Areena areena, Luola luola, Parantaja parantaja) {
        this.pelaaja = pelaaja;
        this.kasittelija = new KomennonKasittelija(kyla, pelaaja, tarinaPanel, pelaajaTietoPanel, metsa, areena, luola, parantaja);
        this.validoija = new KomennonValidoija(pelaaja);
        this.kyla = kyla;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (validoija.onkoKomento(pelaaja.getPaikka(), e.getKeyCode())) {
            kasittelija.kasitteleKomento(pelaaja.getPaikka(), e.getKeyCode());
        } else if (pelaaja.getPaikka() == Paikka.KYLA && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            kyla.pelistaValikkoon();
        }
    }

    

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
