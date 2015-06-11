package com.ued1.punaisenpaholaisenmetsastys;

import com.ued1.punaisenpaholaisenmetsastys.gui.Kyla;
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
