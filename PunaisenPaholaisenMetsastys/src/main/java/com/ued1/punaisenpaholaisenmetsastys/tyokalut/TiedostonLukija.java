package com.ued1.punaisenpaholaisenmetsastys.tyokalut;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Luokka tiedoston lukemista varten.
 */
public class TiedostonLukija {

    public TiedostonLukija() {
    }

    /**
     * Metodi lukee annettua merkkijonoa vastaavan tiedoston sisällön ja
     * palauttaa sen merkkijonona.
     *
     * @param sijainti tiedoston sijainti merkkijonona
     * @return Tiedoston sisältö merkkijonona.
     * @throws Exception Heittää mahdollisesti poikkeuksen mikä pitää käsitellä.
     */
    public String lueTiedosto(String sijainti) throws Exception {

        InputStream inputStream = getClass().getResourceAsStream(sijainti);
        BufferedReader lukija = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

        String rivi = "";
        String teksti = "";

        while ((rivi = lukija.readLine()) != null) {
            teksti += rivi;
            teksti += "\n";
        }
        lukija.close();

        return teksti;

    }

}
