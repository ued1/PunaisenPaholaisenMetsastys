package com.ued1.punaisenpaholaisenmetsastys.alkuvalikko.kuuntelijat;

import com.ued1.punaisenpaholaisenmetsastys.gui.Kyla;
import com.ued1.punaisenpaholaisenmetsastys.alkuvalikko.NimenValintaPanel;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Vaikeus;
import com.ued1.punaisenpaholaisenmetsastys.tyokalut.NimenValidoija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * NimenValinnanKuuntelija hoitaa NimenValintaPaneelin nappien
 * toiminnallisuuden.
 */
public class NimenValinnanKuuntelija implements ActionListener {

    private Kyla kyla;
    private JButton aloita;
    private JButton takaisin;
    private JRadioButton normaali;
    private JRadioButton helppo;
    private JTextField nimikentta;
    private JTextArea virhekentta;
    private NimenValintaPanel nimenValintaPanel;
    private Vaikeus vaikeus;

    public NimenValinnanKuuntelija(NimenValintaPanel nimenValintaPanel, Kyla kyla, JButton aloita, JButton takaisin, JTextField nimikentta, JTextArea virhekentta, JRadioButton normaali, JRadioButton helppo) {
        this.kyla = kyla;
        this.aloita = aloita;
        this.takaisin = takaisin;
        this.normaali = normaali;
        this.helppo = helppo;
        this.nimikentta = nimikentta;
        this.virhekentta = virhekentta;
        this.nimenValintaPanel = nimenValintaPanel;
        this.vaikeus = Vaikeus.NORMAALI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == takaisin) {
            kyla.asetaAlkuvalikko();
        } else if (e.getSource() == aloita) {
            hoidaAloitaNappi();
        } else if (e.getSource() == nimikentta) {
            hoidaEnterNappain();
        } else if (e.getSource() == helppo) {
            vaikeus = Vaikeus.HELPPO;
        } else if (e.getSource() == normaali) {
            vaikeus = Vaikeus.NORMAALI;
        }
    }

    private void hoidaAloitaNappi() {
        NimenValidoija validoija = new NimenValidoija();
        if (!validoija.tarkista(nimikentta.getText())) {
            nimenValintaPanel.asetaVirheTila();
            nimikentta.setText("");
        } else {
            kyla.aloitaUusiPeli(nimikentta.getText(), vaikeus);
        }
    }

    private void hoidaEnterNappain() {
        NimenValidoija validoija = new NimenValidoija();
        if (!validoija.tarkista(nimikentta.getText())) {
            nimenValintaPanel.asetaVirheTila();
            nimikentta.setText("");
        } else {
            nimenValintaPanel.asetaNormaaliTila();
            virhekentta.setText("Nimi on OK, voit aloittaa pelin.");
        }
    }

}
