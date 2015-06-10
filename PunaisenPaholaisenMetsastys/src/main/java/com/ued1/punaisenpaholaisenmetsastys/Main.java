package com.ued1.punaisenpaholaisenmetsastys;

import com.ued1.punaisenpaholaisenmetsastys.aseet.Ase;
import com.ued1.punaisenpaholaisenmetsastys.gui.Kyla;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Asepaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Kauppa;
import javax.swing.SwingUtilities;

/**
 * Ohjelman Main. Peli käynnistetään käynnistämällä Kyla (Runnable).
 */
public class Main {

    public static void main(String[] args) {
        Kyla kyla = new Kyla();
        SwingUtilities.invokeLater(kyla);
    }
    
}
