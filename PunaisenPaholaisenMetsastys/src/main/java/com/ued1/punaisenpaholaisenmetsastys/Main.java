package com.ued1.punaisenpaholaisenmetsastys;

import com.ued1.punaisenpaholaisenmetsastys.gui.Kyla;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        Pelaaja pelaaja = new Pelaaja("Testipelaaja");
        Kyla kyla = new Kyla(pelaaja);
        SwingUtilities.invokeLater(kyla);
    }
    
}
