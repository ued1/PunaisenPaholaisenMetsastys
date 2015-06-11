package com.ued1.punaisenpaholaisenmetsastys.gui.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.gui.Kyla;
import com.ued1.punaisenpaholaisenmetsastys.gui.NimenValintaPanel;
import com.ued1.punaisenpaholaisenmetsastys.tyokalut.NimenValidoija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
    private JTextField nimikentta;
    private JTextArea virhekentta;
    private NimenValintaPanel nimenValintaPanel;

    public NimenValinnanKuuntelija(NimenValintaPanel nimenValintaPanel, Kyla kyla, JButton aloita, JButton takaisin, JTextField nimikentta, JTextArea virhekentta) {
        this.kyla = kyla;
        this.aloita = aloita;
        this.takaisin = takaisin;
        this.nimikentta = nimikentta;
        this.virhekentta = virhekentta;
        this.nimenValintaPanel = nimenValintaPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == takaisin) {
            kyla.asetaAlkuvalikko();
        } else if (e.getSource() == aloita) {
            hoidaAloitaNappi();
        } else if(e.getSource() == nimikentta) {
            hoidaEnterNappain();
        }
    }

    private void hoidaAloitaNappi() {
        NimenValidoija validoija = new NimenValidoija();
        if (!validoija.tarkista(nimikentta.getText())) {
            nimenValintaPanel.asetaVirheTila();
            nimikentta.setText("");
        } else {
            kyla.aloitaUusiPeli(nimikentta.getText());
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
