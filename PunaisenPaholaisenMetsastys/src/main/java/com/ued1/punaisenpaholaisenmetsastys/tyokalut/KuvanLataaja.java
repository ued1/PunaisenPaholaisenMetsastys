package com.ued1.punaisenpaholaisenmetsastys.tyokalut;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 * Luokan tehtävänä on ladata pelin tarvitsevat kuvat ja ikonit.
 */
public class KuvanLataaja {

    private Map<String, BufferedImage> kuvat;

    public KuvanLataaja() {
        kuvat = new HashMap<>();
    }

    /**
     * Lataa pelaajatietopaneelissa ikonit ja palauttaa ne Map-oliona.
     *
     * @return ladatut ikonit map-oliona
     */
    public Map lataaIkonit() {
        lisaaIkonit();
        return kuvat;
    }

    /**
     * Lataa pelissa näytettävät kuvat ja palauttaa ne Map-oliona.
     * 
     * @return ladatus kuvat map-oliona
     */
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
        lisaa("/kuvat/voima.png", "Voima");
        lisaa("/kuvat/puolustus.png", "Puolustus");
        lisaa("/kuvat/potion.png", "VointiPotion");
        lisaa("/kuvat/pupu.png", "Pupu");
        lisaa("/kuvat/olut.png", "OhraPotion");
        lisaa("/kuvat/avain.png", "Ruosteinen avain");
    }

    private void lisaaKuvat() {
        kuvat.clear();
        lisaa("/kuvat/metsa.png", "Metsä");
        lisaa("/kuvat/kyla.png", "Kylä");
        lisaa("/kuvat/areena.png", "Taisteluareena");
        lisaa("/kuvat/tappio.png", "Taistelutappio");
        lisaa("/kuvat/victory.png", "Taisteluvoitto");
        lisaa("/kuvat/asepaja.png", "Asepaja");
        lisaa("/kuvat/tavern.png", "Kapakka");
        lisaa("/kuvat/luola.png", "Luola");
        lisaa("/kuvat/paholainen.png", "Paholainen");
        lisaa("/kuvat/drunk.png", "Känni");
        lisaa("/kuvat/hkauppa.png", "Haarniskakauppa");
        lisaa("/kuvat/doctor.png", "Parantaja");
        lisaa("/kuvat/casino.png", "Casino");
        lisaa("/kuvat/peukkualas.png", "Peukku alas");
        lisaa("/kuvat/peukkuylos.png", "Peukku ylös");
        lisaa("/kuvat/peukkupeli.png", "Peukkupeli");
        lisaa("/kuvat/pupu.png", "Pupu");
        lisaa("/kuvat/olut.png", "OhraPotion");
        lisaa("/kuvat/avain.png", "Ruosteinen avain");
        lisaa("/kuvat/evilpupu.png", "Ilkeä pupu");
        lisaa("/kuvat/ovi.png", "Hauska ovi");
        lisaa("/kuvat/areenataistelu.png", "AreenaTaistelu");
        lisaa("/kuvat/paholainen2.png", "LopetusLyönti");
        lisaa("/kuvat/loppu.png", "Loppukuva");
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
