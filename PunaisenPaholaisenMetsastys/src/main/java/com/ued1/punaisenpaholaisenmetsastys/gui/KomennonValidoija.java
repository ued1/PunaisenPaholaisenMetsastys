package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.Paikka;
import java.awt.event.KeyEvent;

public class KomennonValidoija {

    public boolean onkoKomento(Paikka paikka, int koodi) {
        if(paikka == Paikka.KYLA) {
            if(koodi == KeyEvent.VK_M || koodi == KeyEvent.VK_A || koodi == KeyEvent.VK_H || koodi == KeyEvent.VK_T) {
                return true;
            }
        } else if(paikka == Paikka.ASEPAJA) {
            if(koodi == KeyEvent.VK_O || koodi == KeyEvent.VK_M || koodi == KeyEvent.VK_T) {
                return true;
            }
        } else if(paikka == Paikka.HAARNISKAKAUPPA) {
            if(koodi == KeyEvent.VK_O || koodi == KeyEvent.VK_T) {
                return true;
            }
        } else if(paikka == Paikka.METSA) {
            if(koodi == KeyEvent.VK_E || koodi == KeyEvent.VK_L || koodi == KeyEvent.VK_T) {
                return true;
            }
        } else if(paikka == Paikka.TAISTELU) {
            if(koodi == KeyEvent.VK_L || koodi == KeyEvent.VK_J) {
                return true;
            }
        } else if(paikka == Paikka.TAISTELUAREENA) {
            // TODO
            if(koodi == KeyEvent.VK_T) {
                return true;
            }
        }
        
        return false;
    }
    
}
