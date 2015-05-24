package com.ued1.punaisenpaholaisenmetsastys.gui.logiikka;

import com.sun.glass.events.KeyEvent;
import com.ued1.punaisenpaholaisenmetsastys.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.gui.PelaajaTietoPanel;
import com.ued1.punaisenpaholaisenmetsastys.gui.TarinaPanel;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Asepaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.HaarniskaKauppa;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Metsa;

public class KomennonKasittelija {
    
    private Pelaaja pelaaja;
    private TarinaPanel tarinaPanel;
    private PelaajaTietoPanel pelaajaTietoPanel;
    private PelaajanLiikuttaja liikuttaja;
    private Asepaja asepaja;
    private HaarniskaKauppa haarniskaKauppa;
    private Metsa metsa;

    public KomennonKasittelija(Pelaaja pelaaja, TarinaPanel tarinaPanel, PelaajaTietoPanel pelaajaTietoPanel, Metsa metsa) {
        this.pelaaja = pelaaja;
        this.tarinaPanel = tarinaPanel;
        this.pelaajaTietoPanel = pelaajaTietoPanel;
        this.liikuttaja = new PelaajanLiikuttaja(pelaaja, tarinaPanel, pelaajaTietoPanel);
        this.asepaja = new Asepaja();
        this.haarniskaKauppa = new HaarniskaKauppa();
        this.metsa = metsa;
    }
        
    public void kasitteleKomento(Paikka paikka, int komentoKoodi) {
        if(paikka == Paikka.KYLA) {
            kasitteleKylaKomento(komentoKoodi);
        } else if(paikka == Paikka.METSA || paikka == Paikka.MONSTERITAISTELUOHI) {
            kasitteleMetsaKomento(komentoKoodi);
        } else if(paikka == Paikka.ASEPAJA) {
            kasitteleAsepajaKomento(komentoKoodi);
        } else if(paikka == Paikka.HAARNISKAKAUPPA) {
            kasitteleHaarniskaKauppaKomento(komentoKoodi);
        } else if(paikka == Paikka.MONSTERITAISTELU) {
            kasitteleMonsteriTaisteluKomento(komentoKoodi);
        } else if(paikka == Paikka.TAISTELUAREENA) {
            kasitteleTaisteluAreenaKomento(komentoKoodi);
        } else if(paikka == Paikka.ASEENOSTO) {
            kasitteleAseenOstoKomento(komentoKoodi);
        } else if(paikka == Paikka.ASEENMYYNTI) {
            kasitteleAseenMyyntiKomento(komentoKoodi);
        } else if(paikka == Paikka.HAARNISKANOSTO) {
            kasitteleHaarniskanOstoKomento(komentoKoodi);
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
            metsa.aloitaUusiTaistelu();
            liikuttaja.liikuta(Paikka.MONSTERITAISTELU);
        } else if(komentoKoodi == KeyEvent.VK_L) {
            pelaaja.paranna();
            liikuttaja.liikuta(Paikka.METSA);
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
            liikuttaja.liikuta(Paikka.HAARNISKANOSTO);
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
    
    private void kasitteleHaarniskanOstoKomento(int komentoKoodi) {
        if(haarniskaKauppa.voikoOstaaHaarniskanNumero(pelaaja, komentoKoodi-48)) {
            haarniskaKauppa.ostaHaarniska(pelaaja, komentoKoodi-48);
            liikuttaja.liikuta(Paikka.HAARNISKAKAUPPA);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            liikuttaja.liikuta(Paikka.HAARNISKAKAUPPA);
        }
    }
    
    private void kasitteleMonsteriTaisteluKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_L) {
            if(metsa.getTaistelu().taistele()) {
                liikuttaja.liikuta(Paikka.MONSTERITAISTELUOHI);
                metsa.asetaTaistelunTulos();
            } else {
                liikuttaja.liikuta(Paikka.MONSTERITAISTELU);
            }
            
        } else if(komentoKoodi == KeyEvent.VK_J) {
            liikuttaja.liikuta(Paikka.METSA);
        }
    }
    
    private void kasitteleTaisteluAreenaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_T) {
            liikuttaja.liikuta(Paikka.KYLA);
        }
    }
    
    
}
