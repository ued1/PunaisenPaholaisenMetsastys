package com.ued1.punaisenpaholaisenmetsastys.gui.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.logiikka.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Asepaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Haarniskakauppa;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Kapakka;
import java.awt.event.KeyEvent;

/**
 * Luokka määrittelee mitkä napit ovat komentoja eri tilanteissa.
 */
public class KomennonValidoija {

    private Pelaaja pelaaja;
    private Asepaja asepaja;
    private Haarniskakauppa haarniskaKauppa;
    private Kapakka kapakka;

    public KomennonValidoija(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.asepaja = new Asepaja();
        this.haarniskaKauppa = new Haarniskakauppa();
        this.kapakka = new Kapakka(pelaaja);
    }

    /**
     * Metodi tarkastaa onko napinpainallus komento tilanteessa jossa ollaan.
     * 
     * @param paikka Paikka tai tilanne, jossa ollaan
     * @param koodi Käyttäjän painaman napin keyevent-koodi
     * @return totuusarvo, joka kertoo onko napinpainallus komento, true jos on
     */
    public boolean onkoKomento(Paikka paikka, int koodi) {
        
        // Kylä: [M]etsa [A]sepaja [H]aarniskakauppa [T]aisteluareena
        
        if (paikka == Paikka.KYLA) {
            if (koodi == KeyEvent.VK_M || koodi == KeyEvent.VK_A || koodi == KeyEvent.VK_H || koodi == KeyEvent.VK_T || koodi == KeyEvent.VK_K) {
                return true;
            }
        
        // Asepajan päävalikko: [O]sta [M]yy [T]akaisin
        
        } else if (paikka == Paikka.ASEPAJA) {
            if (koodi == KeyEvent.VK_O || koodi == KeyEvent.VK_M || koodi == KeyEvent.VK_T) {
                return true;
            }
        
        // Haarniskakaupan päävalikko: [O]sta [T]akaisin
        
        } else if (paikka == Paikka.HAARNISKAKAUPPA || paikka == Paikka.KAPAKKA) {
            if (koodi == KeyEvent.VK_O || koodi == KeyEvent.VK_T) {
                return true;
            }
            
        // Metsän päävalikko: [E]tsi [L]epää [T]akaisin [P]unainen Paholainen
            
        } else if (paikka == Paikka.METSA) {
            if (koodi == KeyEvent.VK_E || koodi == KeyEvent.VK_L || koodi == KeyEvent.VK_T) {
                return true;
            } else if(pelaaja.getTaso() == 10 && koodi == KeyEvent.VK_P) {
                return true;
            }
            
        // Monsteritaistelu: [L]yö [J]uokse
            
        } else if (paikka == Paikka.MONSTERITAISTELU) {
            if (koodi == KeyEvent.VK_L || koodi == KeyEvent.VK_J) {
                return true;
            }
            
        // Taisteluareena: [A]stu areenaan [T]akaisin
            
        } else if (paikka == Paikka.TAISTELUAREENA) {
            if (koodi == KeyEvent.VK_T || koodi == KeyEvent.VK_A) {
                return true;
            }
            
        // Aseen osto: [aseenNumeroTaiKirjain] [T]akaisin
            
        } else if (paikka == Paikka.ASEENOSTO) {
            if (asepaja.voikoPelaajaOstaaOstoksen(pelaaja, koodi-48) || koodi == KeyEvent.VK_T) {
                return true;
            } else if (koodi == KeyEvent.VK_A) {
                return asepaja.voikoPelaajaOstaaOstoksen(pelaaja, 10);
            } else if (koodi == KeyEvent.VK_B) {
                return asepaja.voikoPelaajaOstaaOstoksen(pelaaja, 11);
            } else if (koodi == KeyEvent.VK_C) {
                return asepaja.voikoPelaajaOstaaOstoksen(pelaaja, 12);
            } else if (koodi == KeyEvent.VK_D) {
                return asepaja.voikoPelaajaOstaaOstoksen(pelaaja, 13);
            } else if (koodi == KeyEvent.VK_E) {
                return asepaja.voikoPelaajaOstaaOstoksen(pelaaja, 14);
            }
            
        // Aseen myynti: [K]yllä [E]i [T]akaisin
            
        } else if(paikka == Paikka.ASEENMYYNTI) {
            if ((koodi == KeyEvent.VK_K || koodi == KeyEvent.VK_E) && asepaja.voikoMyydaAseen(pelaaja)) {
                return true;
            } else if (koodi == KeyEvent.VK_T) {
                return true;
            }
            
        // Haarniskan osto: [haarniskanNumeroTaiKirjain] [T]akaisin
            
        } else if(paikka == Paikka.HAARNISKANOSTO) {
            if(haarniskaKauppa.voikoPelaajaOstaaOstoksen(pelaaja, koodi-48) || koodi == KeyEvent.VK_T) {
                return true;
            } else if (koodi == KeyEvent.VK_A) {
                return haarniskaKauppa.voikoPelaajaOstaaOstoksen(pelaaja, 10);
            } else if (koodi == KeyEvent.VK_B) {
                return haarniskaKauppa.voikoPelaajaOstaaOstoksen(pelaaja, 11);
            } else if (koodi == KeyEvent.VK_C) {
                return haarniskaKauppa.voikoPelaajaOstaaOstoksen(pelaaja, 12);
            }
            
        // Kapakka osto: [numero] [T]akaisin
            
        } else if(paikka == Paikka.KAPAKKAOSTO) {
            if(kapakka.voikoPelaajaOstaaOstoksen(pelaaja, koodi-48) || koodi == KeyEvent.VK_T) {
                return true;
            }
            
        // Monsteritaistelutappio: [J]atka
            
        } else if(paikka == Paikka.MONSTERITAISTELUTAPPIO || paikka == Paikka.PAHOLAINENTAPPIO) {
            
            if (koodi == KeyEvent.VK_J) {
                return true;
            }
            
        // Taisteluareenan taistelun tulos [J]atka
            
        } else if(paikka == Paikka.TAISTELUAREENATULOS) {
            
            if (koodi == KeyEvent.VK_J) {
                return true;
            }
            
        // Pelaaja ei valmis taisteluareenaan [T]akaisin
            
        } else if(paikka == Paikka.TAISTELUAREENAEI) {
            
            if (koodi == KeyEvent.VK_T) {
                return true;
            }
            
        // Areenataistelu: [L]yö   Paholainen: [L]yö
            
        } else if(paikka == Paikka.AREENATAISTELU || paikka == Paikka.PAHOLAINEN) {
            if (koodi == KeyEvent.VK_L) {
                return true;
            }
            
        // Luola: [E]tsi Punainen Paholainen [T]akaisin
            
        } else if(paikka == Paikka.LUOLA) {
            if (koodi == KeyEvent.VK_E || koodi == KeyEvent.VK_T) {
                return true;
            }
            
            
        }
        
        return false;
    }

}
