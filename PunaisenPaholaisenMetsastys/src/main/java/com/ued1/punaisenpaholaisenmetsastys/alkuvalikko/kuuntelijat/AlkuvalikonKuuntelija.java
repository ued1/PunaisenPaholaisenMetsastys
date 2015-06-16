package com.ued1.punaisenpaholaisenmetsastys.alkuvalikko.kuuntelijat;

import com.ued1.punaisenpaholaisenmetsastys.gui.Kyla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Luokka hoitaa alkuvalikon nappien toiminnallisuuden.
 */
public class AlkuvalikonKuuntelija implements ActionListener {

    private JButton jatka;
    private JButton aloita;
    private JButton lataa;
    private JButton asetukset;
    private JButton ohje;
    private JButton lopeta;
    private Kyla kyla;

    public AlkuvalikonKuuntelija(Kyla kyla, JButton jatka, JButton aloita, JButton lataa, JButton ohje, JButton lopeta, JButton asetukset) {
        this.jatka = jatka;
        this.kyla = kyla;
        this.aloita = aloita;
        this.lataa = lataa;
        this.asetukset = asetukset;
        this.ohje = ohje;
        this.lopeta = lopeta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aloita) {
            hoidaAloita();
        } else if (e.getSource() == lataa) {
            hoidaLataa();
        } else if (e.getSource() == ohje) {
            hoidaOhje();
        } else if (e.getSource() == lopeta) {
            hoidaLopeta();
        } else if (e.getSource() == jatka && kyla.onkoPeliKaynnissa()) {
            hoidaJatka();
        } else if (e.getSource() == asetukset && kyla.onkoPeliKaynnissa()) {
            hoidaAsetukset();
        }
    }

    // Jatkaa peliä
    private void hoidaJatka() {
        kyla.jatkaPelia();
    }

    // Aloittaa uuden pelin
    private void hoidaAloita() {
        kyla.asetaNimenValinta();
    }

    // Lataa aikaisempaa pelin
    private void hoidaLataa() {

    }

    private void hoidaAsetukset() {
        kyla.asetaAsetusvalikko();
    }

    // Näyttää ohjeen
    private void hoidaOhje() {
        kyla.asetaOhje();
    }

    // Lopettaa pelin
    private void hoidaLopeta() {
        System.exit(0);
    }

}
