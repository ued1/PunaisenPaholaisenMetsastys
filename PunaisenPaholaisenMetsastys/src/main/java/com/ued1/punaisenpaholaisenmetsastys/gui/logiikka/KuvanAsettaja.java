
package com.ued1.punaisenpaholaisenmetsastys.gui.logiikka;

import java.awt.image.BufferedImage;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class KuvanAsettaja {

    private Map<String, BufferedImage> kuvat;
    private Map<String, BufferedImage> ikonit;
    
    public KuvanAsettaja() {
        kuvat = new KuvanLataaja().lataaKuvat();
        ikonit = new KuvanLataaja().lataaIkonit();
    }
        
    public JLabel asetaIkoni(String kuvaus) {
        JLabel label;
        if(ikonit.containsKey(kuvaus)) {
            label = new JLabel(new ImageIcon(ikonit.get(kuvaus)));
            label.setToolTipText(kuvaus);
        } else {
            label = new JLabel(kuvaus + ":");
        }
        return label;
    }
    
    public void asetaKuva(JLabel label, String kuvaus) {
        if(kuvat.containsKey(kuvaus)) {
            label.setIcon(new ImageIcon(kuvat.get(kuvaus)));
            label.setToolTipText(kuvaus);
            label.setText(null);
        } else {
            label.setIcon(null);
            label.setToolTipText(null);
            label.setText(kuvaus);
        }
        
    }
        
}
