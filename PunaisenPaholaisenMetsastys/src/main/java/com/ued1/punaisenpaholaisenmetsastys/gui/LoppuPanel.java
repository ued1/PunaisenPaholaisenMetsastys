
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * LoppuPanel näytetään pelin lopussa kun pelaaja on voittanut Punaisen Paholaisen.
 */
public class LoppuPanel extends JPanel {
        
    private Pelaaja pelaaja;
    private JButton lopeta;
    private JButton alkuvalikkoon;
    private LoppuPaneelinKuuntelija loppuPaneelinKuuntelija;
    
    public LoppuPanel(Kyla kyla, Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        luoNapit();
        loppuPaneelinKuuntelija = new LoppuPaneelinKuuntelija(kyla, pelaaja, alkuvalikkoon, lopeta);
        alusta();
    }
    
    private void alusta() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);
        lisaaKuuntelijat();
        add(new JLabel(""));
        add(new JLabel("Lopetusteksti"));
        add(new JLabel(""));
        add(alkuvalikkoon);
        add(new JLabel(""));
        add(lopeta);
    }
    
    private void luoNapit() {
        lopeta = new JButton("Lopeta peli");
        alkuvalikkoon = new JButton("Alkuvalikkoon");
        lopeta.setAlignmentX(CENTER_ALIGNMENT);
        alkuvalikkoon.setAlignmentX(CENTER_ALIGNMENT);
        
    }
    
    private void lisaaKuuntelijat() {
        lopeta.addActionListener(loppuPaneelinKuuntelija);
        alkuvalikkoon.addActionListener(loppuPaneelinKuuntelija);
    }
    
}
