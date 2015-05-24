package com.ued1.punaisenpaholaisenmetsastys.gui.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Asepaja;
import java.awt.event.KeyEvent;

public class KomennonValidoija {

    private Pelaaja pelaaja;
    private Asepaja asepaja;

    public KomennonValidoija(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.asepaja = new Asepaja();
    }

    public boolean onkoKomento(Paikka paikka, int koodi) {
        if (paikka == Paikka.KYLA) {
            if (koodi == KeyEvent.VK_M || koodi == KeyEvent.VK_A || koodi == KeyEvent.VK_H || koodi == KeyEvent.VK_T) {
                return true;
            }
        } else if (paikka == Paikka.ASEPAJA) {
            if (koodi == KeyEvent.VK_O || koodi == KeyEvent.VK_M || koodi == KeyEvent.VK_T) {
                return true;
            }
        } else if (paikka == Paikka.HAARNISKAKAUPPA) {
            if (koodi == KeyEvent.VK_O || koodi == KeyEvent.VK_T) {
                return true;
            }
        } else if (paikka == Paikka.METSA) {
            if (koodi == KeyEvent.VK_E || koodi == KeyEvent.VK_L || koodi == KeyEvent.VK_T) {
                return true;
            }
        } else if (paikka == Paikka.TAISTELU) {
            if (koodi == KeyEvent.VK_L || koodi == KeyEvent.VK_J) {
                return true;
            }
        } else if (paikka == Paikka.TAISTELUAREENA) {
            // TODO
            if (koodi == KeyEvent.VK_T) {
                return true;
            }
        } else if (paikka == Paikka.ASEENOSTO) {
            if (asepaja.voikoPelaajaOstaaAseenNumero(pelaaja, koodi-48) || koodi == KeyEvent.VK_T) {
                return true;
            }
        } else if(paikka == Paikka.ASEENMYYNTI) {
            if ((koodi == KeyEvent.VK_K || koodi == KeyEvent.VK_E) && asepaja.voikoMyydaAseen(pelaaja)) {
                return true;
            } else if (koodi == KeyEvent.VK_T) {
                return true;
            }
        }
        return false;
    }

}
