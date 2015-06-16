
package com.ued1.punaisenpaholaisenmetsastys.peli.apuvalineet;

/**
 * RuosteinenAvain on Apu, jota tarvitaan taistelussa Punaista Paholaista vastaan.
 */
public class RuosteinenAvain extends Apu {

    public RuosteinenAvain() {
        
    }
    
    @Override
    public String toString() {
        return "Ruosteinen avain";
    }

    @Override
    public boolean auta() {
        return true;
    }

    @Override
    public String kuvaus() {
        return "";
    }

    @Override
    public int arvo() {
        return 100000000;
    }
    
    
    
}
