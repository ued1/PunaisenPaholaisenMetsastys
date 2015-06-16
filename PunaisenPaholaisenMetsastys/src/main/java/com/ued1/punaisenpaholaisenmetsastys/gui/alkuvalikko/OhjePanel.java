package com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko;

import com.ued1.punaisenpaholaisenmetsastys.gui.Kyla;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Luokka näyttää alkuvalikon ohjeen.
 */
public class OhjePanel extends JPanel {

    private JTextArea ohjeet;
    private JButton takaisin;
    private Kyla kyla;

    public OhjePanel(Kyla kyla) {
        this.ohjeet = new JTextArea();
        this.kyla = kyla;
        luoKomponentit();
    }

    private void luoKomponentit() {
        takaisin = new JButton("Takaisin");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);
        ohjeet.setText(ohjeString());
        ohjeet.setForeground(Color.RED);
        ohjeet.setBackground(Color.BLACK);
        ohjeet.setPreferredSize(new Dimension(600, 450));
        ohjeet.setMaximumSize(new Dimension(600, 450));
        ohjeet.setMinimumSize(new Dimension(600, 450));
        ohjeet.setAlignmentX(CENTER_ALIGNMENT);
        takaisin.setAlignmentX(CENTER_ALIGNMENT);
        lisaaTakaisinKuuntelija();
        add(ohjeet);
        add(takaisin);
    }

    private String ohjeString() {
        String merkkijono = "PunaisenPaholaisenMetsästys - ohjeet..";

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
