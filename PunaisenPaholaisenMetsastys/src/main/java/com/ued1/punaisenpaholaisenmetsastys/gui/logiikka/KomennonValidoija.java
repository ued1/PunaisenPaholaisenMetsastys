package com.ued1.punaisenpaholaisenmetsastys.gui.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.peli.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Asepaja;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Haarniskakauppa;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Kapakka;
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
        if (paikka == Paikka.KYLA) {
            return hoidaKyla(koodi);
        } else if (paikka == Paikka.ASEPAJA) {
            return hoidaAsepaja(koodi);
        } else if (paikka == Paikka.HAARNISKAKAUPPA || paikka == Paikka.KAPAKKA) {
            return hoidaHaarniskakauppa(koodi);
        } else if (paikka == Paikka.METSA) {
            return hoidaMetsa(koodi);
        } else if (paikka == Paikka.MONSTERITAISTELU) {
            return hoidaMonsteritaistelu(koodi);
        } else if (paikka == Paikka.TAISTELUAREENA || paikka == Paikka.PEUKKUPELI) {
            return hoidaTaisteluAreena(koodi);
        } else if (paikka == Paikka.ASEENOSTO) {
            return hoidaAseenOsto(koodi);
        } else if (paikka == Paikka.ASEENMYYNTI) {
            return hoidaAseenMyynti(koodi);
        } else if (paikka == Paikka.HAARNISKANOSTO) {
            return hoidaHaarniskanOsto(koodi);
        } else if (paikka == Paikka.KAPAKKAOSTO) {
            return hoidaKapakkaOsto(koodi);
        } else if (paikka == Paikka.MONSTERITAISTELUTAPPIO || paikka == Paikka.PAHOLAINENTAPPIO || paikka == Paikka.TAISTELUAREENATULOS || paikka == Paikka.RUOSTEINENAVAIN) {
            return hoidaJatka(koodi);
        } else if (paikka == Paikka.TAISTELUAREENAEI || paikka == Paikka.PEUKKUTULOS || paikka == Paikka.METSAPUPU) {
            return hoidaTakaisin(koodi);
        } else if (paikka == Paikka.AREENATAISTELU) {
            return hoidaLyonti(paikka, koodi);
        } else if (paikka == Paikka.LUOLA) {
            return hoidaLuola(koodi);
        } else if (paikka == Paikka.PARANTAJA) {
            return hoidaParantaja(koodi);
        } else if (paikka == Paikka.CASINO) {
            return hoidaCasino(koodi);
        } else if (paikka == Paikka.PAHOLAINEN) {
            return hoidaPaholainen(koodi);
        } else if (paikka == Paikka.HEIKENNETTYPAHOLAINEN) {
            return hoidaHeikennettyPaholainen(koodi);
        } else if (paikka == Paikka.LOPPU) {
            return hoidaLoppu(koodi);
        }
        return false;
    }

    // Kylä: [M]etsa [A]sepaja [H]aarniskakauppa [T]aisteluareena [K]apakka [P]arantaja
    private boolean hoidaKyla(int koodi) {
        if (koodi == KeyEvent.VK_M || koodi == KeyEvent.VK_A || koodi == KeyEvent.VK_H || koodi == KeyEvent.VK_T || koodi == KeyEvent.VK_K || koodi == KeyEvent.VK_P || koodi == KeyEvent.VK_C) {
            return true;
        } else if (pelaaja.getNimi().equalsIgnoreCase("assari") && (koodi == KeyEvent.VK_X || koodi == KeyEvent.VK_PAGE_UP || koodi == KeyEvent.VK_END)) {

            return true;
        }
        return false;
    }

    // Asepajan päävalikko: [O]sta [M]yy [T]akaisin
    private boolean hoidaAsepaja(int koodi) {
        if (koodi == KeyEvent.VK_O || koodi == KeyEvent.VK_M || koodi == KeyEvent.VK_T) {
            return true;
        }
        return false;
    }

    // Haarniskakaupan päävalikko: [O]sta [T]akaisin
    private boolean hoidaHaarniskakauppa(int koodi) {
        if (koodi == KeyEvent.VK_O || koodi == KeyEvent.VK_T) {
            return true;
        }
        return false;
    }

    // Metsän päävalikko: [E]tsi [L]epää [T]akaisin [P]unainen Paholainen
    private boolean hoidaMetsa(int koodi) {
        if (koodi == KeyEvent.VK_E || koodi == KeyEvent.VK_V || koodi == KeyEvent.VK_T) {
            return true;
        } else if (pelaaja.getTaso() == 10 && koodi == KeyEvent.VK_P) {
            return true;
        }
        return false;
    }

    // Monsteritaistelu: [L]yö [J]uokse
    private boolean hoidaMonsteritaistelu(int koodi) {
        if (koodi == KeyEvent.VK_L || koodi == KeyEvent.VK_J) {
            return true;
        }
        return false;
    }

    // Taisteluareena, Peukkupeli: [A] [T]akaisin
    private boolean hoidaTaisteluAreena(int koodi) {
        if (koodi == KeyEvent.VK_T || koodi == KeyEvent.VK_A) {
            return true;
        }
        return false;
    }

    // Parantaja: [P]aranna [T]akaisin [O]sta potion
    private boolean hoidaParantaja(int koodi) {
        if (koodi == KeyEvent.VK_P || koodi == KeyEvent.VK_T || koodi == KeyEvent.VK_O) {
            return true;
        }
        return false;
    }

    // Aseen osto: [aseenNumeroTaiKirjain] [T]akaisin
    private boolean hoidaAseenOsto(int koodi) {
        if (asepaja.voikoPelaajaOstaaOstoksen(pelaaja, koodi - 48) || koodi == KeyEvent.VK_T) {
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
        return false;
    }

    // Aseen myynti: [K]yllä [E]i [T]akaisin
    private boolean hoidaAseenMyynti(int koodi) {
        if ((koodi == KeyEvent.VK_K || koodi == KeyEvent.VK_E) && asepaja.voikoMyydaAseen(pelaaja)) {
            return true;
        } else if (koodi == KeyEvent.VK_T) {
            return true;
        }
        return false;
    }

    // Haarniskan osto: [haarniskanNumeroTaiKirjain] [T]akaisin
    private boolean hoidaHaarniskanOsto(int koodi) {
        if (haarniskaKauppa.voikoPelaajaOstaaOstoksen(pelaaja, koodi - 48) || koodi == KeyEvent.VK_T) {
            return true;
        } else if (koodi == KeyEvent.VK_A) {
            return haarniskaKauppa.voikoPelaajaOstaaOstoksen(pelaaja, 10);
        } else if (koodi == KeyEvent.VK_B) {
            return haarniskaKauppa.voikoPelaajaOstaaOstoksen(pelaaja, 11);
        } else if (koodi == KeyEvent.VK_C) {
            return haarniskaKauppa.voikoPelaajaOstaaOstoksen(pelaaja, 12);
        }
        return false;
    }

    // Kapakka osto: [numero] tai [T]akaisin
    private boolean hoidaKapakkaOsto(int koodi) {
        if (kapakka.voikoPelaajaOstaaOstoksen(pelaaja, koodi - 48) || koodi == KeyEvent.VK_T) {
            return true;
        }
        return false;
    }

    // [J]atka
    private boolean hoidaJatka(int koodi) {
        return (koodi == KeyEvent.VK_J);
    }

    // [T]akaisin
    private boolean hoidaTakaisin(int koodi) {
        return (koodi == KeyEvent.VK_T);
    }

    // [L]yö
    private boolean hoidaLyonti(Paikka paikka, int koodi) {
        if (koodi == KeyEvent.VK_L) {
            return true;
        } else if (paikka == Paikka.AREENATAISTELU && koodi == KeyEvent.VK_O) {
            return true;
        } else if (paikka == Paikka.PAHOLAINEN && koodi == KeyEvent.VK_R) {
            return true;
        }
        return false;
    }

    // Luola: [E]tsi Punainen Paholainen [T]akaisin
    private boolean hoidaLuola(int koodi) {
        if (koodi == KeyEvent.VK_E || koodi == KeyEvent.VK_T) {
            return true;
        }
        return false;
    }

    // Casino: [P]eukku [T]akaisin
    private boolean hoidaCasino(int koodi) {
        if ((koodi == KeyEvent.VK_P && pelaaja.getRahat() > 0) || koodi == KeyEvent.VK_T) {
            return true;
        }
        return false;
    }

    // Punainen Paholainen: [L]lyö [R]uosteinen avain
    private boolean hoidaPaholainen(int koodi) {
        if (koodi == KeyEvent.VK_L || koodi == KeyEvent.VK_R) {
            return true;
        }
        return false;
    }

    // Heikennetty Punainen Paholainen
    private boolean hoidaHeikennettyPaholainen(int koodi) {
        if (koodi == KeyEvent.VK_L || koodi == KeyEvent.VK_P || koodi == KeyEvent.VK_M) {
            return true;
        }
        return false;
    }

    // Pelin loppu
    private boolean hoidaLoppu(int koodi) {
        return (koodi == KeyEvent.VK_V);
    }

}
