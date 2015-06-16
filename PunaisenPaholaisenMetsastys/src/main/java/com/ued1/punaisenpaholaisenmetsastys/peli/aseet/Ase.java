package com.ued1.punaisenpaholaisenmetsastys.peli.aseet;

/**
 * Rajapinta, joka määrittelee pelin aseille tarvittavan toiminnallisuuden.
 */
public interface Ase {

    /**
     * Metodi palauttaa aseen lyöntivoiman, mitä tarvitaan taistelussa
     * laskemaan vastustajaan kohdistuva vahinko. Mitä suurempi arvo sitä
     * parempi ase.
     * 
     * @return aseen lyöntivoima kokonaislukuna
     */
    public int lyo();

    /**
     * Palauttaa aseen nimen.
     * 
     * @return aseen nimi merkkijonona
     */
    @Override
    public String toString();
    
    /**
     * Metodi palauttaa aseen arvon, mitä tarvitaan asepajassa aseita ostaessa
     * ja myydessä.
     * 
     * @return aseen arvo
     */
    public int arvo();
    

}
