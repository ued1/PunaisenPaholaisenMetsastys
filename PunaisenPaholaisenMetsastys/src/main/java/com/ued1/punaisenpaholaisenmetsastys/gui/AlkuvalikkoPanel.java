
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.AlkuvalikonKuuntelija;
import com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.KuvanAsettaja;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sun.swing.FilePane;

/**
 * AlkuvalikkoPanel on pelin alkuvalikko, jossa voi valita uuden pelin,
 * jatkaa aikaisempaa peliä, lukea ohjeen ja lopettaa pelin.
 */
public class AlkuvalikkoPanel extends JPanel {
    
    private JButton aloita;
    private JButton jatka;
    private JButton ohje;
    private JButton lopeta;
    private AlkuvalikonKuuntelija kuuntelija;
    private JLabel paholainen;
    
    public AlkuvalikkoPanel(Kyla kyla) {
        aloita = new JButton("Aloita uusi peli");
        jatka = new JButton("Jatka aikaisempaa peliä");
        ohje = new JButton("Pelin ohjeet");
        lopeta = new JButton("Lopeta peli");
        kuuntelija = new AlkuvalikonKuuntelija(kyla, aloita, jatka, ohje, lopeta);
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
        aloita.addActionListener(kuuntelija);
        jatka.addActionListener(kuuntelija);
        ohje.addActionListener(kuuntelija);
        lopeta.addActionListener(kuuntelija);
    }
    
    private void asetaSuuntaus() {
        paholainen.setAlignmentX(CENTER_ALIGNMENT);
        aloita.setAlignmentX(CENTER_ALIGNMENT);
        jatka.setAlignmentX(CENTER_ALIGNMENT);
        ohje.setAlignmentX(CENTER_ALIGNMENT);
        lopeta.setAlignmentX(CENTER_ALIGNMENT);
    }
    
    private void lisaaOsat() {
        add(paholainen);
        add(aloita);
        add(new JLabel(" "));
        add(jatka);
        add(new JLabel(" "));
        add(ohje);
        add(new JLabel(" "));
        add(lopeta);
    }
    
}

