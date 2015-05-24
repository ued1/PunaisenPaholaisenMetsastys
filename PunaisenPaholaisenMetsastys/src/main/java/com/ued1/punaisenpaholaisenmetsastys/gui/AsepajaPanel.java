
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Asepaja;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AsepajaPanel extends JPanel {
    
    private Pelaaja pelaaja;
    private Asepaja asepaja;
    private JTextArea hinnasto;
    private JTextArea ongelmaTilanne;
    
    public AsepajaPanel(Pelaaja pelaaja) {
        super(new FlowLayout());
        this.pelaaja = pelaaja;
        asepaja = new Asepaja();
        hinnasto = new JTextArea();
        ongelmaTilanne = new JTextArea();
        luoKomponentit();
    }
    
    private void luoKomponentit() {
        add(new JLabel("Asepaja - hinnasto"));
        hinnasto.setText(asepaja.hinnastoMerkkijonona());
        hinnasto.setFocusable(false);
        add(hinnasto);
        ongelmaTilanne.setFocusable(false);
        add(ongelmaTilanne);
    }
    
    public void asetaNormaaliTila() {
        ongelmaTilanne.setText("");
    }
    
    public void asetaTilaNyrkkiaEiVoiMyyda() {
        ongelmaTilanne.setText("Et voi myydä omaa nyrkkiäsi!");
    }
    
    public void asetaTilaVarmistusMyyntiin() {
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    
    
}
