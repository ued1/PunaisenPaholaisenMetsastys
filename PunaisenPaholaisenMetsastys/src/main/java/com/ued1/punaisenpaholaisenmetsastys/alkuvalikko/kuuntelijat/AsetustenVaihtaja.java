package com.ued1.punaisenpaholaisenmetsastys.alkuvalikko.kuuntelijat;

import com.ued1.punaisenpaholaisenmetsastys.gui.Kyla;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Vaikeus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JRadioButton;

/**
 * Luokka kuuntelee AsetuksetPanel-olion nappeja ja hoitaa niiden
 * toiminnallisuuden.
 */
public class AsetustenVaihtaja implements ActionListener {

    private JButton takaisin;
    private JRadioButton normaali;
    private JRadioButton helppo;
    private Kyla kyla;
    private Pelaaja pelaaja;

    public AsetustenVaihtaja(Kyla kyla, Pelaaja pelaaja, JButton takaisin, JRadioButton normaali, JRadioButton helppo) {
        this.kyla = kyla;
        this.pelaaja = pelaaja;
        this.takaisin = takaisin;
        this.normaali = normaali;
        this.helppo = helppo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == takaisin) {
            kyla.asetaAlkuvalikko();
        } else if (e.getSource() == normaali) {
            pelaaja.setVaikeus(Vaikeus.NORMAALI);
        } else if (e.getSource() == helppo) {
            pelaaja.setVaikeus(Vaikeus.HELPPO);
        }
    }
}
