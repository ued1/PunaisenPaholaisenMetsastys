package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KomennonKuuntelija implements KeyListener {

    private KomennonKasittelija kasittelija;
    private KomennonValidoija validoija;
    private Pelaaja pelaaja;

    public KomennonKuuntelija(Pelaaja pelaaja, TarinaPanel tarinaPanel, PelaajaTietoPanel pelaajaTietoPanel) {
        this.pelaaja = pelaaja;
        this.kasittelija = new KomennonKasittelija(pelaaja, tarinaPanel, pelaajaTietoPanel);
        this.validoija = new KomennonValidoija();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (validoija.onkoKomento(pelaaja.getPaikka(), e.getKeyCode())) {
            kasittelija.kasitteleKomento(pelaaja.getPaikka(), e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
