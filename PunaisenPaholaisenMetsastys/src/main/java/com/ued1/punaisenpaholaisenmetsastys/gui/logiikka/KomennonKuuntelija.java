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
    private PelaajaTietoPanel pelaajaTietoPanel; // rivin voi poistaa kun CHEAT poistetaan

    public KomennonKuuntelija(Kyla kyla, Pelaaja pelaaja, TarinaPanel tarinaPanel, PelaajaTietoPanel pelaajaTietoPanel, Metsa metsa, Areena areena, Luola luola, Parantaja parantaja) {
        this.pelaaja = pelaaja;
        this.pelaajaTietoPanel = pelaajaTietoPanel; // rivin voi poistaa kun CHEAT poistetaan
        this.kasittelija = new KomennonKasittelija(kyla, pelaaja, tarinaPanel, pelaajaTietoPanel, metsa, areena, luola, parantaja);
        this.validoija = new KomennonValidoija(pelaaja);
        this.kyla = kyla;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // CHEAT
        if (pelaaja.getNimi().equals("Assari") && pelaaja.getPaikka() == Paikka.KYLA) {
            huijaa(e);
        } // CHEAT END

        if (validoija.onkoKomento(pelaaja.getPaikka(), e.getKeyCode())) {
            kasittelija.kasitteleKomento(pelaaja.getPaikka(), e.getKeyCode());
        } else if (pelaaja.getPaikka() == Paikka.KYLA && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            kyla.pelistaValikkoon();
        }
    }

    // CHEAT
    private void huijaa(KeyEvent e) {
        int[] tarvittavaKokemus = {0, 100, 500, 1000, 5000, 10000, 50000, 100000, 500000, 1000000};
        if (e.getKeyCode() == KeyEvent.VK_X) {
            pelaaja.muutaRahoja(1000000);
        } else if (e.getKeyCode() == KeyEvent.VK_PAGE_UP && pelaaja.getTaso() < 10) {
            pelaaja.setKokemus(tarvittavaKokemus[pelaaja.getTaso()]);
            pelaaja.nostaTasoa();
        } else if(e.getKeyCode() == KeyEvent.VK_END && pelaaja.getTaso() < 10) {
            pelaaja.setKokemus(tarvittavaKokemus[pelaaja.getTaso()]);
        }
        pelaajaTietoPanel.repaint();
    } // CHEAT END

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
