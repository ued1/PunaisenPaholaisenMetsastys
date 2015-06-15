package com.ued1.punaisenpaholaisenmetsastys.gui.logiikka;

import com.sun.glass.events.KeyEvent;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.OhraPotion;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.Pupu;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.RuosteinenAvain;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.gui.PelaajaTietoPanel;
import com.ued1.punaisenpaholaisenmetsastys.gui.TarinaPanel;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Areena;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Asepaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Haarniskakauppa;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Kapakka;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Luola;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Metsa;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Parantaja;

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
    private Haarniskakauppa haarniskaKauppa;
    private Metsa metsa;
    private Areena areena;
    private Luola luola;
    private Parantaja parantaja;

    public KomennonKasittelija(Pelaaja pelaaja, TarinaPanel tarinaPanel, PelaajaTietoPanel pelaajaTietoPanel, Metsa metsa, Areena areena, Luola luola, Parantaja parantaja) {
        this.pelaaja = pelaaja;
        this.tarinaPanel = tarinaPanel;
        this.pelaajaTietoPanel = pelaajaTietoPanel;
        this.paivittaja = new PelitilanteenPaivittaja(pelaaja, tarinaPanel, pelaajaTietoPanel);
        this.asepaja = new Asepaja();
        this.haarniskaKauppa = new Haarniskakauppa();
        this.metsa = metsa;
        this.areena = areena;
        this.luola = luola;
        this.parantaja = parantaja;
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
        } else if(paikka == Paikka.KAPAKKA) {
            kasitteleKapakkaKomento(komentoKoodi);
        } else if(paikka == Paikka.LUOLA) {
            kasitteleLuolaKomento(komentoKoodi);
        } else if(paikka == Paikka.PAHOLAINEN) {
            kasittelePaholainenKomento(komentoKoodi);
        } else if(paikka == Paikka.PAHOLAINENTAPPIO) {
            kasittelePaholainenTappio(komentoKoodi);
        } else if(paikka == Paikka.KAPAKKAOSTO) {
            kasitteleAvunOstoKomento(komentoKoodi);
        } else if(paikka == Paikka.PARANTAJA) {
            kasitteleParantajaKomento(komentoKoodi);
        } else if(paikka == Paikka.CASINO) {
            kasitteleCasinoKomento(komentoKoodi);
        } else if(paikka == Paikka.PEUKKUPELI) {
            kasittelePeukkupeliKomento(komentoKoodi);
        } else if(paikka == Paikka.PEUKKUTULOS) {
            kasittelePeukkuTulosKomento(komentoKoodi);
        } else if(paikka == Paikka.METSAPUPU) {
            kasitteleMetsaPupuKomento(komentoKoodi);
        }
    }
    
    private void kasitteleKylaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_M) {
            paivittaja.paivita(Paikka.METSA);
        } else if(komentoKoodi == KeyEvent.VK_A) {
            paivittaja.paivita(Paikka.ASEPAJA);
        } else if(komentoKoodi == KeyEvent.VK_H) {
            paivittaja.paivita(Paikka.HAARNISKAKAUPPA);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            if(areena.onkoPelaajaValmisAreenaan()) {
                paivittaja.paivita(Paikka.TAISTELUAREENA);
            } else {
                paivittaja.paivita(Paikka.TAISTELUAREENAEI);
            }
        } else if(komentoKoodi == KeyEvent.VK_K) {
            paivittaja.paivita(Paikka.KAPAKKA);
        } else if(komentoKoodi == KeyEvent.VK_P) {
            paivittaja.paivita(Paikka.PARANTAJA);
        } else if(komentoKoodi == KeyEvent.VK_C) {
            paivittaja.paivita(Paikka.CASINO);
        }
    }
    
    private void kasitteleMetsaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_E) {
            if(pelaaja.onkoPelaajallaApu(new Pupu(pelaaja)) && new Pupu(pelaaja).auta()) {
                paivittaja.paivita(Paikka.METSAPUPU);
            } else {
                metsa.aloitaUusiTaistelu();
                paivittaja.paivita(Paikka.MONSTERITAISTELU);
            }
        } else if(komentoKoodi == KeyEvent.VK_V) {
            new Parantaja().parannaPotionilla(pelaaja);
            paivittaja.paivita(Paikka.METSA);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.paivita(Paikka.KYLA);
        } else if(pelaaja.getTaso() == 10 && komentoKoodi == KeyEvent.VK_P) {
            paivittaja.paivita(Paikka.LUOLA);
        }
    }
    
    private void kasitteleMetsaPupuKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_J) {
            paivittaja.paivita(Paikka.METSA);
        }
    }
        
    private void kasitteleAsepajaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_O) {
            paivittaja.paivita(Paikka.ASEENOSTO);
        } else if(komentoKoodi == KeyEvent.VK_M) {
            paivittaja.paivita(Paikka.ASEENMYYNTI);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.paivita(Paikka.KYLA);
        }
    }
    
    private void kasitteleHaarniskaKauppaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_O) {
            paivittaja.paivita(Paikka.HAARNISKANOSTO);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.paivita(Paikka.KYLA);
        }
    }
    
    // TODO: yhtistä ylä ja alapuoli
        
    private void kasitteleKapakkaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_O) {
            paivittaja.paivita(Paikka.KAPAKKAOSTO);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.paivita(Paikka.KYLA);
        }
    }
    
    private void kasitteleCasinoKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_P) {
            paivittaja.paivita(Paikka.PEUKKUPELI);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.paivita(Paikka.KYLA);
        }
    }
    
    private void kasittelePeukkupeliKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_A) {
            paivittaja.paivita(Paikka.PEUKKUTULOS);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.paivita(Paikka.CASINO);
        }
    }
    
    private void kasitteleLuolaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_E) {
            luola.haastaPaholainen();
            paivittaja.paivita(Paikka.PAHOLAINEN);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.paivita(Paikka.METSA);
        }
        
    }
    
    private void kasitteleParantajaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_P) {
            parantaja.paranna(pelaaja);
            paivittaja.paivita(Paikka.PARANTAJA);
        } else if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.paivita(Paikka.KYLA);
        } else if(komentoKoodi == KeyEvent.VK_O && parantaja.voikoOstaa(pelaaja)) {
            // TODO: K/E ja viesti ostetusta potionista
            parantaja.ostaPotion(pelaaja);
            paivittaja.paivita(Paikka.PARANTAJA);
        }
    }
    
    private void kasitteleAseenOstoKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.paivita(Paikka.ASEPAJA);
        } else if(komentoKoodi >= KeyEvent.VK_A && komentoKoodi <= KeyEvent.VK_E) {
            ostaPelaajalleAseJaLiiku(komentoKoodi-55);
        } else if(asepaja.voikoPelaajaOstaaOstoksen(pelaaja, komentoKoodi-48)) {
            ostaPelaajalleAseJaLiiku(komentoKoodi-48);
        }
    }
    
    private void ostaPelaajalleAseJaLiiku(int aseenNumero) {
        if(asepaja.osta(pelaaja, aseenNumero)) {
            // TODO: ilmoitus uudesta aseesta
        }
        paivittaja.paivita(Paikka.ASEPAJA); // fix
    }
    
    private void kasitteleAvunOstoKomento(int komentoKoodi) {
        Kapakka kapakka = new Kapakka(pelaaja);
        if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.paivita(Paikka.KAPAKKA);
        } else if(komentoKoodi == KeyEvent.VK_1) {
            kapakka.osta(pelaaja, 1);
            paivittaja.paivita(Paikka.KANNI);
            pelaaja.setPaikka(Paikka.KAPAKKA);
        } else if(kapakka.voikoPelaajaOstaaOstoksen(pelaaja, komentoKoodi-48)) {
            kapakka.osta(pelaaja, komentoKoodi-48);
            paivittaja.paivita(Paikka.KAPAKKA);
        }
        
    }
        
    private void kasitteleAseenMyyntiKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_T || komentoKoodi == KeyEvent.VK_E) {
            paivittaja.paivita(Paikka.ASEPAJA);
        } else if(komentoKoodi == KeyEvent.VK_K) {
            asepaja.myy(pelaaja);
            paivittaja.paivita(Paikka.ASEPAJA);
        }
    }
    
    private void kasitteleHaarniskanOstoKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.paivita(Paikka.HAARNISKAKAUPPA);
        } else if(komentoKoodi >= KeyEvent.VK_A && komentoKoodi <= KeyEvent.VK_C) {
            ostaPelaajalleHaarniskaJaLiiku(komentoKoodi-55);
        } else if(haarniskaKauppa.voikoPelaajaOstaaOstoksen(pelaaja, komentoKoodi-48)) {
            ostaPelaajalleHaarniskaJaLiiku(komentoKoodi-48);
        } 
    }
    
    private void ostaPelaajalleHaarniskaJaLiiku(int haarniskanNumero) {
        if(haarniskaKauppa.osta(pelaaja, haarniskanNumero)) {
            // TODO: ilmoitus uudesta haarniskasta
        }
        paivittaja.paivita(Paikka.HAARNISKAKAUPPA);
    }
    
    private void kasitteleMonsteriTaisteluKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_L) {
            if(metsa.getTaistelu().taistele()) {
                if(pelaaja.onkoElossa()) {
                    paivittaja.paivita(Paikka.METSA);
                    metsa.asetaTaistelunTulos();
                } else {
                    paivittaja.paivita(Paikka.MONSTERITAISTELUTAPPIO);
                }
            } else {
                paivittaja.paivita(Paikka.MONSTERITAISTELU);
            }
            
        } else if(komentoKoodi == KeyEvent.VK_J) {
            paivittaja.paivita(Paikka.METSA);
        }
    }
    
    private void kasittelePaholainenKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_L) {
            if(luola.getTaistelu().taistele()) {
                if(pelaaja.onkoElossa()) {
                    paivittaja.paivita(Paikka.LOPPU);
                } else {
                    paivittaja.paivita(Paikka.PAHOLAINENTAPPIO);
                }
            } else {
                luola.asetaTulos();
                paivittaja.paivita(Paikka.PAHOLAINEN);
            }
        } else if(komentoKoodi == KeyEvent.VK_R || pelaaja.onkoPelaajallaApu(new RuosteinenAvain())) {
            paivittaja.paivita(Paikka.RUOSTEINENAVAIN);
        }
        
    }
    
    private void kasitteleAreenaTaistelu(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_L) {
            if(areena.getTaistelu().taistele()) {
                paivittaja.paivita(Paikka.TAISTELUAREENATULOS);
            } else {
                paivittaja.paivita(Paikka.AREENATAISTELU);
            }
        } else if(komentoKoodi == KeyEvent.VK_O && pelaaja.onkoPelaajallaApu(new OhraPotion(pelaaja))) {
            new OhraPotion(pelaaja).auta();
            paivittaja.paivita(Paikka.AREENATAISTELU);
        }
    }
    
    private void kasitteleMonsteriTaisteluTappioKomento(int komentoKoodi) {
                
        if(komentoKoodi == KeyEvent.VK_J) {
            metsa.asetaTaistelunTulos();
            paivittaja.paivita(Paikka.METSA);
        }
    }
    
    private void kasittelePaholainenTappio(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_J) {
            luola.asetaTulos();
            paivittaja.paivita(Paikka.METSA);
        }
    }
    
    private void kasitteleTaisteluAreenaKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.paivita(Paikka.KYLA);
        } else if(komentoKoodi == KeyEvent.VK_A) {
            areena.aloitaUusiTaistelu();
            paivittaja.paivita(Paikka.AREENATAISTELU);
        }
        
    }
    
    private void kasitteleTaisteluAreenaEi(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.paivita(Paikka.KYLA);
        }
    }
    
    private void kasitteleTaisteluAreenaTulos(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_J) {
            paivittaja.paivita(Paikka.KYLA);
        }
    }
    
    private void kasittelePeukkuTulosKomento(int komentoKoodi) {
        if(komentoKoodi == KeyEvent.VK_T) {
            paivittaja.paivita(Paikka.CASINO);
        }
    }
    
    
}
