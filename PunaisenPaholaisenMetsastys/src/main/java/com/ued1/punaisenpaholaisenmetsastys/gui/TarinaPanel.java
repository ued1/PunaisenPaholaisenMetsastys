
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TarinaPanel extends JPanel {
    
    private Pelaaja pelaaja;
    private KomentoPanel komentoPanel;
    
    public TarinaPanel(Pelaaja pelaaja) {
        super(new GridLayout(2,1));
        this.pelaaja = pelaaja;
        this.komentoPanel = new KomentoPanel();
        luoKomponentit();
    }
    
    private void luoKomponentit() {
        JTextArea textArea = new JTextArea("Tarinapaneeli");
        textArea.setFocusable(false);
        add(textArea);
        add(komentoPanel);
    }
    
    public void setPaikka(Paikka uusiPaikka) {
        komentoPanel.setPaikka(uusiPaikka);
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
        
}
