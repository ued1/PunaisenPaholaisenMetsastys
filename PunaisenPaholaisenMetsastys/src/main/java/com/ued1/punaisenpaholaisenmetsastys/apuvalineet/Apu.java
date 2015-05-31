
package com.ued1.punaisenpaholaisenmetsastys.apuvalineet;

/**
 * Apuvälineet auttavat pelaajaa taisteluissa.
 */
public interface Apu {
    
    /**
     * Palauttaa avun nimen.
     * 
     * @return avun nimi merkkijonona
     */
    @Override
    public String toString();
    
    /**
     * Metodi auta auttaa pelaajaa. Jokainen apu määrittelee itse miten
     * pelaajaa autetaan. Metodi pelauttaa totuusarvon jos auttaminen onnistui.
     * 
     * @return totuusarvo true jos auttaminen onnistui
     */
    public boolean auta();
    
    /**
     * Metodi palauttaa tarinapaneeliin sopivan kuvauksen siitä mitä tapahtuu.
     * 
     * @return tarinapaneeliin kuvaus merkkijonona
     */
    public String kuvaus();
    
    /**
     * Metodi palauttaa avun arvon, mitä tarvitaan kapakassa apuja ostaessa.
     * 
     * @return avun arvo
     */
    public int arvo();
    
}
