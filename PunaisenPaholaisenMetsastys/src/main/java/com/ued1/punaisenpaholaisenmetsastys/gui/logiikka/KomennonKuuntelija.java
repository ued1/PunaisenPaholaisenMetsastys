package com.ued1.punaisenpaholaisenmetsastys.gui.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.logiikka.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.gui.PelaajaTietoPanel;
import com.ued1.punaisenpaholaisenmetsastys.gui.TarinaPanel;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Areena;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Luola;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Metsa;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KomennonKuuntelija kuuntelee näppämistön näppien painelua.
 */
public class KomennonKuuntelija implements KeyListener {

    private KomennonKasittelija kasittelija;
    private KomennonValidoija validoija;
    private Pelaaja pelaaja;
    private PelaajaTietoPanel pelaajaTietoPanel; // rivin voi poistaa kun CHEAT poistetaan

    public KomennonKuuntelija(Pelaaja pelaaja, TarinaPanel tarinaPanel, PelaajaTietoPanel pelaajaTietoPanel, Metsa metsa, Areena areena, Luola luola) {
        this.pelaaja = pelaaja;
        this.pelaajaTietoPanel = pelaajaTietoPanel; // rivin voi poistaa kun CHEAT poistetaan
        this.kasittelija = new KomennonKasittelija(pelaaja, tarinaPanel, pelaajaTietoPanel, metsa, areena, luola);
        this.validoija = new KomennonValidoija(pelaaja);
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // väliaikainen CHEAT kehityksen tueksi, +5000 rahaa kun painaa kylässä [x]
        if(pelaaja.getPaikka() == Paikka.KYLA && e.getKeyCode() == KeyEvent.VK_X) {
            pelaaja.muutaRahoja(500000);
            pelaajaTietoPanel.repaint();
        // väliaikainen CHEAT kehityksen tueksi, levelille 10 kun painaa kylässä [end]
        } else if(pelaaja.getPaikka() == Paikka.KYLA && e.getKeyCode() == KeyEvent.VK_END) {
            for(int i = 0; i < 10; i++) {
                pelaaja.nostaTasoa();
            }
            pelaajaTietoPanel.repaint();
        }
        
        if (validoija.onkoKomento(pelaaja.getPaikka(), e.getKeyCode())) {
            kasittelija.kasitteleKomento(pelaaja.getPaikka(), e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
