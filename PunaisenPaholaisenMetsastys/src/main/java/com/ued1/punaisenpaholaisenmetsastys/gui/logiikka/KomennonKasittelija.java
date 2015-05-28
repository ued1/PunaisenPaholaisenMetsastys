package com.ued1.punaisenpaholaisenmetsastys.gui.logiikka;

import com.sun.glass.events.KeyEvent;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.gui.PelaajaTietoPanel;
import com.ued1.punaisenpaholaisenmetsastys.gui.TarinaPanel;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Areena;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Asepaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.HaarniskaKauppa;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Metsa;

public class KomennonKasittelija {
    
    private Pelaaja pelaaja;
    private TarinaPanel tarinaPanel;
    private PelaajaTietoPanel pelaajaTietoPanel;
    private PelitilanteenPaivittaja liikuttaja;
    private Asepaja asepaja;
    private HaarniskaKauppa haarniskaKauppa;
    private Metsa metsa;
    private Areena areena;

    public KomennonKasittelija(Pelaaja pelaaja, TarinaPanel tarinaPanel, PelaajaTietoPanel pelaajaTietoPanel, Metsa metsa, Areena areena) {
        this.pelaaja = pelaaja;
        this.tarinaPanel = tarinaPanel;
        this.pelaajaTietoPanel = pelaajaTietoPanel;
        this.liikuttaja = new PelitilanteenPaivittaja(pelaaja, tarinaPanel, pelaajaTietoPanel);
        this.asepaja = new Asepaja();
        this.haarniskaKauppa = new HaarniskaKauppa();
        this.metsa = metsa;
        this.areena = areena;
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
        } else if(paikka == Paikka.MONSTERITAISTELUTAPPIO) {
            kasitteleMonsteriTaisteluTappioKomento(komentoKoodi);
        } else if(paikka == Paikka.TAISTELUAREENAEI) {
            kasitteleTaisteluAreenaEi(komentoKoodi);
        } else if(paikka == Paikka.AREENATAISTELU) {
            kasitteleAreenaTaistelu(komentoKoodi);
        } else if(paikka == Paikka.TAISTELUAREENATULOS) {
            kasitteleTaisteluAreenaTulos(komentoKoodi);
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
            if(areena.onkoPelaajaValmisAreenaan()) {
                liikuttaja.liikuta(Paikka.TAISTELUAREENA);
            } else {
                liikuttaja.liikuta(Paikka.TAISTELUAREENAEI);
            }
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
                if(pelaaja.onkoElossa()) {
                    liikuttaja.liikuta(Paikka.METSA);
                    metsa.asetaTaistelunTulos();
                } else {
                    liikuttaja.liikuta(Paikka.MONSTERITAISTELUTAPPIO);
                }
            } else {
                liikuttaja.liikuta(Paikka.MONSTERITAISTELU);
            }
            
        } else if(komentoKoodi == KeyEvent.VK_J) {
            liikuttaja.liikuta(Paikka.METSA);
        }
    }
    
    private void kasitteleAreenaTaistelu(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_L) {
            if(areena.getTaistelu().taistele()) {
                liikuttaja.liikuta(Paikka.TAISTELUAREENATULOS);
                
            } else {
                liikuttaja.liikuta(Paikka.AREENATAISTELU);
            }
        }
    }
    
    private void kasitteleMonsteriTaisteluTappioKomento(int komentoKoodi) {
        
        // TODO: [Q] Lopeta peli

        if(komentoKoodi == KeyEvent.VK_J) {
            metsa.asetaTaistelunTulos();
            liikuttaja.liikuta(Paikka.METSA);
        }
    }
    
    private void kasitteleTaisteluAreenaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_T) {
            liikuttaja.liikuta(Paikka.KYLA);
        } else if(komentoKoodi == KeyEvent.VK_A) {
            areena.aloitaUusiTaistelu();
            liikuttaja.liikuta(Paikka.AREENATAISTELU);
        }
        
    }
    
    private void kasitteleTaisteluAreenaEi(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_T) {
            liikuttaja.liikuta(Paikka.KYLA);
        }
    }
    
    private void kasitteleTaisteluAreenaTulos(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_J) {
            liikuttaja.liikuta(Paikka.KYLA);
        }
    }
    
    
}
