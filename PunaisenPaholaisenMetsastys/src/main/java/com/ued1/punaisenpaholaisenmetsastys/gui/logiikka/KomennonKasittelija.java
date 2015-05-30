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

/**
 * KomennonKasittelija käsittelee käyttäjän antamat komennot ja antaa
 * komennon pohjalta sopivan käskyn PelitilanteenPaivittajalle.
 */
public class KomennonKasittelija {
    
    private Pelaaja pelaaja;
    private TarinaPanel tarinaPanel;
    private PelaajaTietoPanel pelaajaTietoPanel;
    private PelitilanteenPaivittaja paivittaja;
    private Asepaja asepaja;
    private HaarniskaKauppa haarniskaKauppa;
    private Metsa metsa;
    private Areena areena;

    public KomennonKasittelija(Pelaaja pelaaja, TarinaPanel tarinaPanel, PelaajaTietoPanel pelaajaTietoPanel, Metsa metsa, Areena areena) {
        this.pelaaja = pelaaja;
        this.tarinaPanel = tarinaPanel;
        this.pelaajaTietoPanel = pelaajaTietoPanel;
        this.paivittaja = new PelitilanteenPaivittaja(pelaaja, tarinaPanel, pelaajaTietoPanel);
        this.asepaja = new Asepaja();
        this.haarniskaKauppa = new HaarniskaKauppa();
        this.metsa = metsa;
        this.areena = areena;
    }
    
    /**
     * Metodi käsittelee käyttäjän antaman komennon ja antaa sopivan
     * päivityskäskyn PelitilanteenPaivittajalle.
     * @param paikka Paikka tai tilanne, jossa ollaan
     * @param komentoKoodi Käyttäjän antaman komennon keyevent-koodi
     */
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
            paivittaja.liikuta(Paikka.METSA);
        } else if(komentoKoodi == KeyEvent.VK_A) {
            paivittaja.liikuta(Paikka.ASEPAJA);
        } else if(komentoKoodi == KeyEvent.VK_H) {
            paivittaja.liikuta(Paikka.HAARNISKAKAUPPA);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            if(areena.onkoPelaajaValmisAreenaan()) {
                paivittaja.liikuta(Paikka.TAISTELUAREENA);
            } else {
                paivittaja.liikuta(Paikka.TAISTELUAREENAEI);
            }
        }
    }
    
    private void kasitteleMetsaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_E) {
            metsa.aloitaUusiTaistelu();
            paivittaja.liikuta(Paikka.MONSTERITAISTELU);
        } else if(komentoKoodi == KeyEvent.VK_L) {
            pelaaja.paranna();
            paivittaja.liikuta(Paikka.METSA);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.liikuta(Paikka.KYLA);
        }
    }
        
    private void kasitteleAsepajaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_O) {
            paivittaja.liikuta(Paikka.ASEENOSTO);
        } else if(komentoKoodi == KeyEvent.VK_M) {
            paivittaja.liikuta(Paikka.ASEENMYYNTI);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.liikuta(Paikka.KYLA);
        }
    }
    
    private void kasitteleHaarniskaKauppaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_O) {
            paivittaja.liikuta(Paikka.HAARNISKANOSTO);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.liikuta(Paikka.KYLA);
        }
    }
        
    private void kasitteleAseenOstoKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.liikuta(Paikka.ASEPAJA);
        } else if(komentoKoodi == KeyEvent.VK_A) {
            ostaPelaajalleAseJaLiiku(10);
        } else if(komentoKoodi == KeyEvent.VK_B) {
            ostaPelaajalleAseJaLiiku(11);
        } else if(komentoKoodi == KeyEvent.VK_C) {
            ostaPelaajalleAseJaLiiku(12);
        } else if(komentoKoodi == KeyEvent.VK_D) {
            ostaPelaajalleAseJaLiiku(13);
        } else if(komentoKoodi == KeyEvent.VK_E) {
            ostaPelaajalleAseJaLiiku(14);
        } else if(asepaja.voikoPelaajaOstaaOstoksen(pelaaja, komentoKoodi-48)) {
            ostaPelaajalleAseJaLiiku(komentoKoodi-48);
        }
    }
    
    private void ostaPelaajalleAseJaLiiku(int aseenNumero) {
        if(asepaja.osta(pelaaja, aseenNumero)) {
            // TODO: ilmoitus uudesta aseesta
        }
        paivittaja.liikuta(Paikka.ASEPAJA); // fix
    }
        
    private void kasitteleAseenMyyntiKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_T || komentoKoodi == KeyEvent.VK_E) {
            paivittaja.liikuta(Paikka.ASEPAJA);
        } else if(komentoKoodi == KeyEvent.VK_K) {
            asepaja.myy(pelaaja);
            paivittaja.liikuta(Paikka.ASEPAJA);
        }
    }
    
    private void kasitteleHaarniskanOstoKomento(int komentoKoodi) {
        if(haarniskaKauppa.voikoPelaajaOstaaOstoksen(pelaaja, komentoKoodi-48)) {
            haarniskaKauppa.osta(pelaaja, komentoKoodi-48);
            paivittaja.liikuta(Paikka.HAARNISKAKAUPPA);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.liikuta(Paikka.HAARNISKAKAUPPA);
        }
    }
    
    private void kasitteleMonsteriTaisteluKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_L) {
            if(metsa.getTaistelu().taistele()) {
                if(pelaaja.onkoElossa()) {
                    paivittaja.liikuta(Paikka.METSA);
                    metsa.asetaTaistelunTulos();
                } else {
                    paivittaja.liikuta(Paikka.MONSTERITAISTELUTAPPIO);
                }
            } else {
                paivittaja.liikuta(Paikka.MONSTERITAISTELU);
            }
            
        } else if(komentoKoodi == KeyEvent.VK_J) {
            paivittaja.liikuta(Paikka.METSA);
        }
    }
    
    private void kasitteleAreenaTaistelu(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_L) {
            if(areena.getTaistelu().taistele()) {
                paivittaja.liikuta(Paikka.TAISTELUAREENATULOS);
                
            } else {
                paivittaja.liikuta(Paikka.AREENATAISTELU);
            }
        }
    }
    
    private void kasitteleMonsteriTaisteluTappioKomento(int komentoKoodi) {
                
        if(komentoKoodi == KeyEvent.VK_J) {
            metsa.asetaTaistelunTulos();
            paivittaja.liikuta(Paikka.METSA);
        }
    }
    
    private void kasitteleTaisteluAreenaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.liikuta(Paikka.KYLA);
        } else if(komentoKoodi == KeyEvent.VK_A) {
            areena.aloitaUusiTaistelu();
            paivittaja.liikuta(Paikka.AREENATAISTELU);
        }
        
    }
    
    private void kasitteleTaisteluAreenaEi(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.liikuta(Paikka.KYLA);
        }
    }
    
    private void kasitteleTaisteluAreenaTulos(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_J) {
            paivittaja.liikuta(Paikka.KYLA);
        }
    }
    
    
}
