
package com.ued1.punaisenpaholaisenmetsastys.gui.logiikka;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class KuvanLataaja {
    
    private Map<String, BufferedImage> kuvat;

    public KuvanLataaja() {
        kuvat = new HashMap<>();
    }
    
    public Map lataaIkonit() {
        lisaaIkonit();
        return kuvat;
    }
    
    public Map lataaKuvat() {
        lisaaKuvat();
        return kuvat;
    }
    
    private void lisaaIkonit() {
        kuvat.clear();
        lisaa("/kuvat/arrow_up.png", "Taso");
        lisaa("/kuvat/heart.png", "Vointi");
        lisaa("/kuvat/sword.png", "Ase");
        lisaa("/kuvat/armor.png", "Haarniska");
        lisaa("/kuvat/gold.png", "Rahat");
        lisaa("/kuvat/exp.png", "Kokemus");
        
    // TODO: muut ikonit
        
    }
    
    private void lisaaKuvat() {
        kuvat.clear();
        lisaa("/kuvat/metsa.png", "Metsä");
        lisaa("/kuvat/kyla.png", "Kylä");
        lisaa("/kuvat/areena.png", "Taisteluareena");
        lisaa("/kuvat/tappio.png", "Taistelutappio");
        lisaa("/kuvat/asepaja.png", "Asepaja");
    }
    
    private void lisaa(String sijainti, String kuvaus) {
        try {
            BufferedImage kuva = ImageIO.read(this.getClass().getResource(sijainti));
            kuvat.put(kuvaus, kuva);
        } catch (Exception e) {
            // Ei tehdä mitään
        }
    }
    
    
}
