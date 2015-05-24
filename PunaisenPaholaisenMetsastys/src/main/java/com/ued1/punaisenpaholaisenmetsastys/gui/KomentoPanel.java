
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.Paikka;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class KomentoPanel extends JPanel {
    
    private JTextArea komentoValikko;
    
    public KomentoPanel() {
        luoKomponentit();
    }
    
    private void luoKomponentit() {
        komentoValikko = new JTextArea("[M]etsä\n[A]sepaja\n[H]aarniskakauppa\n[T]aisteluareena");
        komentoValikko.setFocusable(false);
        add(komentoValikko);
    }
    
    public void setPaikka(Paikka uusiPaikka) {
        if(uusiPaikka == Paikka.KYLA) {
            komentoValikko.setText("[M]etsä\n[A]sepaja\n[H]aarniskakauppa\n[T]aisteluareena");
        } else if(uusiPaikka == Paikka.ASEPAJA) {
            komentoValikko.setText("[O]sta ase\n[M]yy asee\n[T]akaisin");
        } else if(uusiPaikka == Paikka.HAARNISKAKAUPPA) {
            komentoValikko.setText("[O]sta haarniska\n[T]akaisin");
        } else if(uusiPaikka == Paikka.METSA) {
            komentoValikko.setText("[E]tsi monsteri\n[L]epää\n[T]akaisin kylään");
        } else if(uusiPaikka == Paikka.TAISTELUAREENA) {
            komentoValikko.setText("[T]akaisin kylään");
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    
}
