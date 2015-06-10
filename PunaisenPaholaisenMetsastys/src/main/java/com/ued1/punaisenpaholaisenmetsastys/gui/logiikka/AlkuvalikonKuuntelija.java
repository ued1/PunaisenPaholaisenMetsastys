
package com.ued1.punaisenpaholaisenmetsastys.gui.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.gui.Kyla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Luokka hoitaa alkuvalikon nappien toiminnallisuuden.
 */
public class AlkuvalikonKuuntelija implements ActionListener {
    
    private JButton aloita;
    private JButton jatka;
    private JButton ohje;
    private JButton lopeta;
    private Kyla kyla;

    public AlkuvalikonKuuntelija(Kyla kyla, JButton aloita, JButton jatka, JButton ohje, JButton lopeta) {
        this.kyla = kyla;
        this.aloita = aloita;
        this.jatka = jatka;
        this.ohje = ohje;
        this.lopeta = lopeta;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == aloita) {
            hoidaAloita();
        } else if(e.getSource() == jatka) {
            hoidaJatka();
        } else if(e.getSource() == ohje) {
            hoidaOhje();
        } else if(e.getSource() == lopeta) {
            hoidaLopeta();
        } 
    }
    
    // Aloittaa uuden pelin
    private void hoidaAloita() {
        kyla.asetaNimenValinta();
    }
    
    // Jatkaa aikaisempaa peliä
    private void hoidaJatka() {
        
    }
    
    // Näyttää ohjeen
    private void hoidaOhje() {
        kyla.asetaOhje();
    }

    // Lopettaa pelin
    private void hoidaLopeta() {
        System.exit(0);
    }
    
    
}
