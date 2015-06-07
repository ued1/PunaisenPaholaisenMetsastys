
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.logiikka.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Areena;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Luola;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Metsa;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Parantaja;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * TarinaPanel on JPanel, joka koostuu komento- ja tarinaosasta. Tarinaosassa
 * kerrotaan pelin tarinaa kuvilla ja teksteillä. Komento-osassa listataan
 * komennot, jotka ovat käytettävissä kullakin hetkellä.
 */
public class TarinaPanel extends JPanel {
    
    private Pelaaja pelaaja;
    private KomentoOsa komentoOsa;
    private TarinaOsa tarinaOsa;
        
    public TarinaPanel(Pelaaja pelaaja, Metsa metsa, Areena areena, Luola luola, Parantaja parantaja) {
        this.pelaaja = pelaaja;
        this.komentoOsa = new KomentoOsa(pelaaja);
        this.tarinaOsa = new TarinaOsa(pelaaja, metsa, areena, luola, parantaja);
        luoKomponentit();
    }
    
    private void luoKomponentit() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        tarinaOsa.setPreferredSize(new Dimension(300,450));
        tarinaOsa.setMinimumSize(new Dimension(300,450));
        tarinaOsa.setMaximumSize(new Dimension(300,450));
        komentoOsa.setPreferredSize(new Dimension(300,150));
        komentoOsa.setMinimumSize(new Dimension(300,150));
        komentoOsa.setMaximumSize(new Dimension(300,150));
        add(tarinaOsa);
        add(komentoOsa);
    }
    
    /**
     * Metodi antaa päivityskäskyn komento- ja tarinaosalle. Uusi paikka
     * asetetaan näkyville ja uuden paikan komennot listataan.
     * 
     * @param uusiPaikka uusi paikka, joka asetetaan näkyviin
     */
    public void paivita(Paikka uusiPaikka) {
        tarinaOsa.paivita();
        komentoOsa.paivita(uusiPaikka);
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
        
}
