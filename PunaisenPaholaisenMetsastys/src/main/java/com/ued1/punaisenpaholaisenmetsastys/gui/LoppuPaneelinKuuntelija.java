
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
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
    private Pelaaja pelaaja;
    
    public LoppuPaneelinKuuntelija(Kyla kyla, Pelaaja pelaaja, JButton alkuun, JButton lopetus) {
        this.alkuun = alkuun;
        this.lopetus = lopetus;
        this.kyla = kyla;
        this.pelaaja = pelaaja;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == alkuun) {
            pelaaja = null;
            kyla.asetaAlkuvalikko();
        } else if(e.getSource() == lopetus) {
            System.exit(0);
        }
        
    }
    
}
