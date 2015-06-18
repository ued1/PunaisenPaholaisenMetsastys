package com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko;

import com.ued1.punaisenpaholaisenmetsastys.gui.Kyla;
import com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko.kuuntelijat.AlkuvalikonKuuntelija;
import com.ued1.punaisenpaholaisenmetsastys.tyokalut.KuvanAsettaja;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * AlkuvalikkoPanel on pelin alkuvalikko, jossa voi valita uuden pelin, jatkaa
 * käynnissä olevaa peliä, lukea ohjeen, muuttaa asetuksia tai lopettaa pelin.
 */
public class AlkuvalikkoPanel extends JPanel {

    private JButton jatka;
    private JButton aloita;
    private JButton asetukset;
    private JButton ohje;
    private JButton lopeta;
    private AlkuvalikonKuuntelija kuuntelija;
    private JLabel paholainen;
    private Kyla kyla;

    public AlkuvalikkoPanel(Kyla kyla) {
        jatka = new JButton("Takaisin peliin");
        aloita = new JButton("Aloita uusi peli");
        asetukset = new JButton("Asetukset");
        ohje = new JButton("Pelin ohjeet");
        lopeta = new JButton("Lopeta peli");
        this.kyla = kyla;
        kuuntelija = new AlkuvalikonKuuntelija(kyla, jatka, aloita, ohje, lopeta, asetukset);
        paholainen = new JLabel();
        alusta();
    }

    private void alusta() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);

        new KuvanAsettaja().asetaKuva(paholainen, "Paholainen");

        asetaSuuntaus();
        lisaaKuuntelijat();
        lisaaOsat();
    }

    private void lisaaKuuntelijat() {
        jatka.addActionListener(kuuntelija);
        aloita.addActionListener(kuuntelija);
        ohje.addActionListener(kuuntelija);
        lopeta.addActionListener(kuuntelija);
        asetukset.addActionListener(kuuntelija);
    }

    private void asetaSuuntaus() {
        paholainen.setAlignmentX(CENTER_ALIGNMENT);
        jatka.setAlignmentX(CENTER_ALIGNMENT);
        aloita.setAlignmentX(CENTER_ALIGNMENT);
        ohje.setAlignmentX(CENTER_ALIGNMENT);
        lopeta.setAlignmentX(CENTER_ALIGNMENT);
        asetukset.setAlignmentX(CENTER_ALIGNMENT);
    }

    private void lisaaOsat() {
        add(paholainen);
        if (kyla.onkoPeliKaynnissa()) {
            add(jatka);
            add(new JLabel(" "));
        }
        add(aloita);
        add(new JLabel(" "));
        if (kyla.onkoPeliKaynnissa()) {
            add(asetukset);
            add(new JLabel(" "));
        }
        add(ohje);
        add(new JLabel(" "));
        add(lopeta);
    }

}
