
package com.ued1.punaisenpaholaisenmetsastys.gui.logiikka;

import java.awt.image.BufferedImage;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Luokan tehtävänä on asettaa kuvia ja ikoneita JLabel-olioihin.
 */
public class KuvanAsettaja {

    private Map<String, BufferedImage> kuvat;
    private Map<String, BufferedImage> ikonit;
    
    public KuvanAsettaja() {
        kuvat = new KuvanLataaja().lataaKuvat();
        ikonit = new KuvanLataaja().lataaIkonit();
    }
        
    /**
     * Metodi asettaa kuvausta (kuvia talletettavan Map-olion key) vastaavan 
     * kuvan JLabeliin ja palauttaa sen kutsujalle. Kuvaus asetetaan kuvan 
     * ToolTip-tekstiksi. Mikäli kuvaa ei löydy, asettaa metodi kuvauksen 
     * JLabeliin ilman kuvaa.
     * 
     * @param kuvaus kuvan map-key ja ToolTip-teksti
     * @return JLabel joko kuvalla tai tekstillä
     */
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
    
    /**
     * Metodi asettaa kuvan parametrina saatuun JLabel-olioon mikäli kuva
     * löytyy Map-oliosta kuvausta vastaavalla key:llä. Mikäli kuva löytyy,
     * asetetaan kuvaus ToolTip-tekstiksi. Mikäli kuvausta ei löydy, palautetaan
     * JLabel kuvausta vastaavalla tekstillä ilman kuvaa.
     * 
     * @param label JLabel-olio, johon kuva halutaan asettaa
     * @param kuvaus 
     */
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
