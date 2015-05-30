
package com.ued1.punaisenpaholaisenmetsastys.haarniskat;

/**
 * Rajapinta, joka määrittelee pelin haarniskoille tarvittavan toiminnallisuuden.
 */
public interface Haarniska {
    
    /**
     * Metodi palauttaa haarniskan puolustusvoiman, mitä tarvitaan taistelussa
     * pienentämään vastustajan tekemää vahinkoa. Mitä suurempi arvo sen parempi
     * haarniska.
     * 
     * @return haarniskan puolustusvoima kokonaislukuna
     */
    public int suojaa();
    
    /**
     * Palauttaa haarniskan nimen.
     * 
     * @return haarniskan nimi merkkijonona
     */
    @Override
    public String toString();
    
    /**
     * Metodi palauttaa haarniskan arvon, mitä tarvitaan asepajassa aseita ostaessa
     * ja myydessä.
     * 
     * @return haarniskan arvo
     */
    public int arvo();
    // piirra
    // kulu
    // onko ehjä
    
}
