package com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko.kuuntelijat;

import com.ued1.punaisenpaholaisenmetsastys.gui.Kyla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Kuuntelee ja hoitaa LoppuPanel-olion JButtonit.
 */
public class LoppuPaneelinKuuntelija implements ActionListener {

    private JButton alkuun;
    private JButton lopetus;
    private Kyla kyla;

    public LoppuPaneelinKuuntelija(Kyla kyla, JButton alkuun, JButton lopetus) {
        this.alkuun = alkuun;
        this.lopetus = lopetus;
        this.kyla = kyla;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == alkuun) {
            kyla.poistaPelaaja();
            kyla.asetaAlkuvalikko();
        } else if (e.getSource() == lopetus) {
            System.exit(0);
        }
    }

}
