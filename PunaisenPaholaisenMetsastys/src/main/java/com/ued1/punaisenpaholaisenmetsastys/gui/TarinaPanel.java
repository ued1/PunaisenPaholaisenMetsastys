
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TarinaPanel extends JPanel {
    
    private Pelaaja pelaaja;
    
    public TarinaPanel(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        luoKomponentit();
    }
    
    private void luoKomponentit() {
        JTextArea textArea = new JTextArea("Tarinapaneeli");
        textArea.setFocusable(false);
        add(textArea);
    }
    
    
    
}
