package com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko;

import com.ued1.punaisenpaholaisenmetsastys.gui.Kyla;
import com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko.kuuntelijat.LoppuPaneelinKuuntelija;
import com.ued1.punaisenpaholaisenmetsastys.tyokalut.KuvanAsettaja;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * LoppuPanel näytetään pelin lopussa kun pelaaja on voittanut Punaisen
 * Paholaisen.
 */
public class LoppuPanel extends JPanel {

    private JButton lopeta;
    private JButton alkuvalikkoon;
    private Pelaaja pelaaja;
    private JLabel loppukuva;
    private JTextArea lopputeksti;
    private LoppuPaneelinKuuntelija loppuPaneelinKuuntelija;

    public LoppuPanel(Kyla kyla, Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.lopputeksti = new JTextArea(luoLopputeksti());
        this.loppukuva = new JLabel();
        luoNapit();
        loppuPaneelinKuuntelija = new LoppuPaneelinKuuntelija(kyla, alkuvalikkoon, lopeta);
        alusta();
    }

    private void alusta() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);
        new KuvanAsettaja().asetaKuva(loppukuva, "Loppukuva");

        lopputeksti.setEditable(false);
        lopputeksti.setPreferredSize(new Dimension(300, 75));
        lopputeksti.setMaximumSize(new Dimension(300, 75));
        lopputeksti.setMinimumSize(new Dimension(300, 75));
        lopputeksti.setAlignmentX(CENTER_ALIGNMENT);
        lopputeksti.setBackground(Color.BLACK);
        lopputeksti.setForeground(Color.WHITE);
        loppukuva.setBackground(Color.BLACK);
        loppukuva.setAlignmentX(CENTER_ALIGNMENT);

        lisaaKuuntelijat();
        lisaaKomponentit();
    }

    private void luoNapit() {
        lopeta = new JButton("Lopeta peli");
        alkuvalikkoon = new JButton("Alkuvalikkoon");
        lopeta.setAlignmentX(CENTER_ALIGNMENT);
        alkuvalikkoon.setAlignmentX(CENTER_ALIGNMENT);
    }

    private void lisaaKomponentit() {
        add(loppukuva);
        add(new JLabel(" "));
        add(lopputeksti);
        add(new JLabel(" "));
        add(alkuvalikkoon);
        add(new JLabel(" "));
        add(lopeta);
    }

    private void lisaaKuuntelijat() {
        lopeta.addActionListener(loppuPaneelinKuuntelija);
        alkuvalikkoon.addActionListener(loppuPaneelinKuuntelija);
    }

    private String luoLopputeksti() {
        String teksti = "\nOnneksi olkoon " + pelaaja.getNimi() + ",";
        teksti += "\nolet selvinnyt pelin loppuun!";
        return teksti;
    }

}
