
package com.ued1.punaisenpaholaisenmetsastys.tyokalut;

import java.io.File;
import java.util.Scanner;

/**
 * Luokka tiedoston lukemista varten. Luokka saattaa heittää poikkeuksen,
 * joka pitää käsitellä.
 */
public class TiedostonLukija {
    
    private File tiedosto;

    public TiedostonLukija(String tiedostonNimi) throws Exception {
        this.tiedosto = new File(tiedostonNimi);
    }
        
    /**
     * Metodi lukee TiedostonLukijalle konstruktorissa annetun merkkijonoa
     * vastaavan tiedoston sisällön ja palauttaa sen merkkijonona.
     * 
     * @return Tiedoston sisältö merkkijonona.
     * @throws Exception Heittää mahdollisesti poikkeuksen mikä pitää käsitellä.
     */
    public String lueTiedosto() throws Exception {
        
        Scanner lukija = new Scanner(tiedosto);
        String teksti = "";
        
        while(lukija.hasNextLine()) {
            teksti += lukija.nextLine();
            teksti += "\n";
        }
        lukija.close();
        return teksti;
    }
    
    
     
}
