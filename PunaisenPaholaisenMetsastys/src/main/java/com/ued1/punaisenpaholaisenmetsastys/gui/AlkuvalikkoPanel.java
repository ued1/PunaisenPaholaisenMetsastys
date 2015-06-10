
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.KuvanAsettaja;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * AlkuvalikkoPanel on pelin alkuvalikko, jossa voi valita uuden pelin,
 * jatkaa aikaisempaa peliä tai lopettaa pelin.
 */
public class AlkuvalikkoPanel extends JPanel {
    
    private Kyla kyla;
    private JButton aloita;
    private JButton jatka;
    private JButton ohje;
    private JButton lopeta;
    
    public AlkuvalikkoPanel(Kyla kyla) {
        this.kyla = kyla;
        luoKomponentit();
    }
    
    private void luoKomponentit() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);
        JLabel paholainen = new JLabel();
        paholainen.setAlignmentX(CENTER_ALIGNMENT);
        new KuvanAsettaja().asetaKuva(paholainen, "Paholainen");
        aloita = new JButton("Aloita uusi peli");
        jatka = new JButton("Jatka aikaisempaa peliä");
        ohje = new JButton("Pelin ohjeet");
        lopeta = new JButton("Lopeta peli");
        aloita.setAlignmentX(CENTER_ALIGNMENT);
        jatka.setAlignmentX(CENTER_ALIGNMENT);
        ohje.setAlignmentX(CENTER_ALIGNMENT);
        lopeta.setAlignmentX(CENTER_ALIGNMENT);
        lisaaAloitaKuuntelija();
        add(paholainen);
        add(aloita);
        add(new JLabel(" "));
        add(jatka);
        add(new JLabel(" "));
        add(ohje);
        add(new JLabel(" "));
        add(lopeta);
    }
    
    private void lisaaAloitaKuuntelija() {
        aloita.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        // System.out.println(event.getActionCommand()); // "Aloita uusi peli"
                        //kyla.aloitaUusiPeli();
                        kyla.uusiNimenValinta();
                    }
                });
    }
}

