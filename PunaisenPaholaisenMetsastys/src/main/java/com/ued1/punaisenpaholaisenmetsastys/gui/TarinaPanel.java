
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Areena;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Metsa;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class TarinaPanel extends JPanel {
    
    private Pelaaja pelaaja;
    private KomentoOsa komentoOsa;
    private TarinaOsa tarinaOsa;
    
    public TarinaPanel(Pelaaja pelaaja, Metsa metsa, Areena areena) {
        super(new GridLayout(2,1));
        this.pelaaja = pelaaja;
        this.komentoOsa = new KomentoOsa(pelaaja);
        this.tarinaOsa = new TarinaOsa(pelaaja, metsa, areena);
        luoKomponentit();
    }
    
    private void luoKomponentit() {
        add(tarinaOsa);
        add(komentoOsa);
    }
    
    public void setPaikka(Paikka uusiPaikka) {
        tarinaOsa.paivita();
        komentoOsa.setPaikka(uusiPaikka);
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
        
}
