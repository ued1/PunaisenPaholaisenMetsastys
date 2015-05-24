package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.sun.glass.events.KeyEvent;
import com.ued1.punaisenpaholaisenmetsastys.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;

public class KomennonKasittelija {
    
    private Pelaaja pelaaja;
    private TarinaPanel tarinaPanel;
    private PelaajaTietoPanel pelaajaTietoPanel;
    private PelaajanLiikuttaja liikuttaja;

    public KomennonKasittelija(Pelaaja pelaaja, TarinaPanel tarinaPanel, PelaajaTietoPanel pelaajaTietoPanel) {
        this.pelaaja = pelaaja;
        this.tarinaPanel = tarinaPanel;
        this.pelaajaTietoPanel = pelaajaTietoPanel;
        this.liikuttaja = new PelaajanLiikuttaja(pelaaja, tarinaPanel, pelaajaTietoPanel);
    }
        
    public void kasitteleKomento(Paikka paikka, int komentoKoodi) {
        if(paikka == Paikka.KYLA) {
            kasitteleKylaKomento(komentoKoodi);
        } else if(paikka == Paikka.METSA) {
            kasitteleMetsaKomento(komentoKoodi);
        } else if(paikka == Paikka.ASEPAJA) {
            kasitteleAsepajaKomento(komentoKoodi);
        } else if(paikka == Paikka.HAARNISKAKAUPPA) {
            kasitteleHaarniskaKauppaKomento(komentoKoodi);
        } else if(paikka == Paikka.TAISTELU) {
            kasitteleTaisteluKomento(komentoKoodi);
        } else if(paikka == Paikka.TAISTELUAREENA) {
            kasitteleTaisteluAreenaKomento(komentoKoodi);
        }
    }
    
    private void kasitteleKylaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_M) {
            liikuttaja.liikuta(Paikka.METSA);
        } else if(komentoKoodi == KeyEvent.VK_A) {
            liikuttaja.liikuta(Paikka.ASEPAJA);
        } else if(komentoKoodi == KeyEvent.VK_H) {
            liikuttaja.liikuta(Paikka.HAARNISKAKAUPPA);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            liikuttaja.liikuta(Paikka.TAISTELUAREENA);
        }
        
    }
    
    private void kasitteleMetsaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_E) {
            // etsi monsteri
        } else if(komentoKoodi == KeyEvent.VK_L) {
            // lepää
        } else if(komentoKoodi == KeyEvent.VK_T) {
            liikuttaja.liikuta(Paikka.KYLA);
        }
    }
    
    private void kasitteleAsepajaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_O) {
            // osta
        } else if(komentoKoodi == KeyEvent.VK_M) {
            // myy
        } else if(komentoKoodi == KeyEvent.VK_T) {
            liikuttaja.liikuta(Paikka.KYLA);
        }
    }
    
    private void kasitteleHaarniskaKauppaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_O) {
            // osta
        } else if(komentoKoodi == KeyEvent.VK_T) {
            liikuttaja.liikuta(Paikka.KYLA);
        }
    }
    
    private void kasitteleTaisteluKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_L) {
            // lyö
        } else if(komentoKoodi == KeyEvent.VK_J) {
            // juokse
        }
    }
    
    private void kasitteleTaisteluAreenaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_T) {
            liikuttaja.liikuta(Paikka.KYLA);
        }
    }
    
    
}

/*
        
        main:       [M]etsä
                    [T]aisteluAreena
                    [A]sekauppa
                    [H]aarniskakauppa
                
        metsä:      [E]tsi monsteri
                    [L]epää
                    [T]akaisin
        
        taistelu:   [L]yö
                    [J]uokse
        
        asekauppa:  [O]sta
                    [M]yy
                    [T]akaisin
        
        haarniska:  [O]sta
                    [T]akaisin
        
                
        */