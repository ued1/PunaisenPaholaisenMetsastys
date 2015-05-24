package com.ued1.punaisenpaholaisenmetsastys.gui.logiikka;

import com.sun.glass.events.KeyEvent;
import com.ued1.punaisenpaholaisenmetsastys.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.gui.PelaajaTietoPanel;
import com.ued1.punaisenpaholaisenmetsastys.gui.TarinaPanel;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Asepaja;

public class KomennonKasittelija {
    
    private Pelaaja pelaaja;
    private TarinaPanel tarinaPanel;
    private PelaajaTietoPanel pelaajaTietoPanel;
    private PelaajanLiikuttaja liikuttaja;
    private Asepaja asepaja;

    public KomennonKasittelija(Pelaaja pelaaja, TarinaPanel tarinaPanel, PelaajaTietoPanel pelaajaTietoPanel) {
        this.pelaaja = pelaaja;
        this.tarinaPanel = tarinaPanel;
        this.pelaajaTietoPanel = pelaajaTietoPanel;
        this.liikuttaja = new PelaajanLiikuttaja(pelaaja, tarinaPanel, pelaajaTietoPanel);
        this.asepaja = new Asepaja();
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
        } else if(paikka == Paikka.ASEENOSTO) {
            kasitteleAseenOstoKomento(komentoKoodi);
        } else if(paikka == Paikka.ASEENMYYNTI) {
            kasitteleAseenMyyntiKomento(komentoKoodi);
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
            liikuttaja.liikuta(Paikka.ASEENOSTO);
        } else if(komentoKoodi == KeyEvent.VK_M) {
            liikuttaja.liikuta(Paikka.ASEENMYYNTI);
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
    
    private void kasitteleAseenOstoKomento(int komentoKoodi) {
        if(asepaja.voikoPelaajaOstaaAseenNumero(pelaaja, komentoKoodi-48)) {
            asepaja.ostaAse(pelaaja, komentoKoodi-48);
            liikuttaja.liikuta(Paikka.ASEPAJA);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            liikuttaja.liikuta(Paikka.ASEPAJA);
        }
    }
    
    private void kasitteleAseenMyyntiKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_T || komentoKoodi == KeyEvent.VK_E) {
            liikuttaja.liikuta(Paikka.ASEPAJA);
        } else if(komentoKoodi == KeyEvent.VK_K) {
            asepaja.myyAse(pelaaja);
            liikuttaja.liikuta(Paikka.ASEPAJA);
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