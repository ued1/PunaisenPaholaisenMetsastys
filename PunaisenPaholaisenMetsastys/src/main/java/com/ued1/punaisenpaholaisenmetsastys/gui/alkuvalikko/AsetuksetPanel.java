package com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko;

import com.ued1.punaisenpaholaisenmetsastys.gui.Kyla;
import com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko.kuuntelijat.AsetustenVaihtaja;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.peli.Vaikeus;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Asetusvalikko-paneeli. Asetusten vaihtaminen pelin ollessa käynnissä.
 */
public class AsetuksetPanel extends JPanel {

    private Kyla kyla;
    private Pelaaja pelaaja;
    private JRadioButton normaali;
    private JRadioButton helppo;
    private ButtonGroup valintaNapit;
    private JButton takaisin;
    private JLabel valitseVaikeus;
    private AsetustenVaihtaja asetustenVaihtaja;

    public AsetuksetPanel(Kyla kyla, Pelaaja pelaaja) {
        this.kyla = kyla;
        this.pelaaja = pelaaja;
        luoNapit();
        this.asetustenVaihtaja = new AsetustenVaihtaja(kyla, pelaaja, takaisin, normaali, helppo);
        luoSisalto();
    }

    private void luoNapit() {
        if (pelaaja.getVaikeus() == Vaikeus.HELPPO) {
            normaali = new JRadioButton("Normaali", false);
            helppo = new JRadioButton("Helppo", true);
        } else {
            normaali = new JRadioButton("Normaali", true);
            helppo = new JRadioButton("Helppo", false);
        }
        takaisin = new JButton("Takaisin");
    }

    private void luoSisalto() {
        valintaNapit = new ButtonGroup();
        valitseVaikeus = new JLabel("Vaikeusasteen vaihtaminen");

        komponenttienAsetukset();

        valintaNapit.add(normaali);
        valintaNapit.add(helppo);
        lisaaKuuntelijat();
        lisaaKomponentit();
    }

    private void komponenttienAsetukset() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);

        normaali.setBackground(Color.BLACK);
        normaali.setForeground(Color.WHITE);
        helppo.setBackground(Color.BLACK);
        helppo.setForeground(Color.WHITE);
        normaali.setAlignmentX(CENTER_ALIGNMENT);
        helppo.setAlignmentX(CENTER_ALIGNMENT);
        takaisin.setAlignmentX(CENTER_ALIGNMENT);

        valitseVaikeus.setFont(new Font("Dialog", Font.BOLD, 15));
        valitseVaikeus.setForeground(Color.WHITE);
        valitseVaikeus.setAlignmentX(CENTER_ALIGNMENT);

    }

    private void lisaaKuuntelijat() {
        takaisin.addActionListener(asetustenVaihtaja);
        normaali.addActionListener(asetustenVaihtaja);
        helppo.addActionListener(asetustenVaihtaja);
    }

    private void lisaaKomponentit() {
        add(new JLabel(""));
        add(valitseVaikeus);
        add(new JLabel(""));
        add(normaali);
        add(helppo);
        add(new JLabel(""));
        add(takaisin);
    }

}
