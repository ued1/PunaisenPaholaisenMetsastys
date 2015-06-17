package com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko;

import com.ued1.punaisenpaholaisenmetsastys.gui.Kyla;
import com.ued1.punaisenpaholaisenmetsastys.tyokalut.TiedostonLukija;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Luokka näyttää alkuvalikon ohjeen.
 */
public class OhjePanel extends JPanel {

    private JTextArea ohjeet;
    private JScrollPane skrollattava;
    private JButton takaisin;
    private Kyla kyla;

    public OhjePanel(Kyla kyla) {
        this.ohjeet = new JTextArea();
        this.skrollattava = new JScrollPane(ohjeet, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.kyla = kyla;
        alusta();
    }

    private void alusta() {
        takaisin = new JButton("Takaisin");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);
        ohjeet.setText(ohjeString());
        ohjeet.setForeground(Color.WHITE);
        ohjeet.setBackground(Color.BLACK);
        ohjeet.setFont(new Font("Monospaced", Font.PLAIN, 12));
        skrollattava.setPreferredSize(new Dimension(550, 600));
        skrollattava.setMaximumSize(new Dimension(550, 600));
        skrollattava.setMinimumSize(new Dimension(550, 600));
        skrollattava.setAlignmentX(CENTER_ALIGNMENT);
        ohjeet.setAlignmentX(CENTER_ALIGNMENT);
        takaisin.setAlignmentX(CENTER_ALIGNMENT);
        ohjeet.setCaretPosition(0);
        lisaaTakaisinKuuntelija();
        
        add(new JLabel(" "));
        add(new JLabel(" "));
        add(skrollattava);
        add(new JLabel(" "));
        add(takaisin);
    }

    private String ohjeString() {
        String merkkijono = "";
        try {
            merkkijono = new TiedostonLukija().lueTiedosto("/tekstit/ohjeet.txt");
        } catch (Exception e) {
            merkkijono += "\nTosimies ei ohjeita tarvitse!";
            merkkijono += "\nAloita peli ja mene itse kokeilemaan!";
        }
        return merkkijono;
    }

    private void lisaaTakaisinKuuntelija() {
        takaisin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                kyla.asetaAlkuvalikko();
            }
        });
    }

}
