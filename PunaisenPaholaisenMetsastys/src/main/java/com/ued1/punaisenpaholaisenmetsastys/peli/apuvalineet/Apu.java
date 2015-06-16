
package com.ued1.punaisenpaholaisenmetsastys.peli.apuvalineet;

/**
 * Apuvälineet auttavat pelaajaa taisteluissa.
 */
public abstract class Apu {
    
    /**
     * Palauttaa avun nimen.
     * 
     * @return avun nimi merkkijonona
     */
    @Override
    public abstract String toString();
    
    /**
     * Metodi auta auttaa pelaajaa. Jokainen apu määrittelee itse miten
     * pelaajaa autetaan. Metodi pelauttaa totuusarvon jos auttaminen onnistui.
     * 
     * @return totuusarvo true jos auttaminen onnistui
     */
    public abstract boolean auta();
    
    /**
     * Metodi palauttaa tarinapaneeliin sopivan kuvauksen siitä mitä tapahtuu.
     * 
     * @return tarinapaneeliin kuvaus merkkijonona
     */
    public abstract String kuvaus();
    
    /**
     * Metodi palauttaa avun arvon, mitä tarvitaan kapakassa apuja ostaessa.
     * 
     * @return avun arvo
     */
    public abstract int arvo();
    
    @Override
    public boolean equals(Object olio) {
        return this.toString().equals(((Apu)olio).toString());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    
}
