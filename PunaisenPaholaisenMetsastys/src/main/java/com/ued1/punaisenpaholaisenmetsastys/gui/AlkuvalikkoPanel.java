
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.AlkuvalikonKuuntelija;
import com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.KuvanAsettaja;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * AlkuvalikkoPanel on pelin alkuvalikko, jossa voi valita uuden pelin,
 * jatkaa aikaisempaa peliä, lukea ohjeen ja lopettaa pelin.
 */
public class AlkuvalikkoPanel extends JPanel {
    
    private JButton jatka;
    private JButton aloita;
    private JButton lataa;
    private JButton ohje;
    private JButton lopeta;
    private AlkuvalikonKuuntelija kuuntelija;
    private JLabel paholainen;
    private Kyla kyla;
    
    public AlkuvalikkoPanel(Kyla kyla) {
        jatka = new JButton("Takaisin peliin");
        aloita = new JButton("Aloita uusi peli");
        lataa = new JButton("Lataa tallennettu peli");
        ohje = new JButton("Pelin ohjeet");
        lopeta = new JButton("Lopeta peli");
        this.kyla = kyla;
        kuuntelija = new AlkuvalikonKuuntelija(kyla, jatka, aloita, lataa, ohje, lopeta);
        paholainen = new JLabel();
        luoKomponentit();
    }
    
    private void luoKomponentit() {
        
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
        lataa.addActionListener(kuuntelija);
        ohje.addActionListener(kuuntelija);
        lopeta.addActionListener(kuuntelija);
    }
    
    private void asetaSuuntaus() {
        paholainen.setAlignmentX(CENTER_ALIGNMENT);
        jatka.setAlignmentX(CENTER_ALIGNMENT);
        aloita.setAlignmentX(CENTER_ALIGNMENT);
        lataa.setAlignmentX(CENTER_ALIGNMENT);
        ohje.setAlignmentX(CENTER_ALIGNMENT);
        lopeta.setAlignmentX(CENTER_ALIGNMENT);
    }
    
    private void lisaaOsat() {
        add(paholainen);
        if(kyla.onkoPeliKaynnissa()) {
            add(jatka);
            add(new JLabel(" "));
        }
        add(aloita);
        add(new JLabel(" "));
        add(lataa);
        add(new JLabel(" "));
        add(ohje);
        add(new JLabel(" "));
        add(lopeta);
    }
    
}

