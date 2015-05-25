
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Asepaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.HaarniskaKauppa;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class KomentoOsa extends JPanel {
    
    private JTextArea komentoValikko;
    private Pelaaja pelaaja;
    
    public KomentoOsa(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
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
            komentoValikko.setText("[A]stu taisteluareenaan\n[T]akaisin kylään");
        } else if(uusiPaikka == Paikka.ASEENOSTO) {
            String ostettavatAseet = new Asepaja().ostettavatAseetMerkkijonona(pelaaja);
            komentoValikko.setText(ostettavatAseet);
        } else if(uusiPaikka == Paikka.ASEENMYYNTI) {
            if(new Asepaja().voikoMyydaAseen(pelaaja)) {
                komentoValikko.setText("[K]yllä\n[E]i");
            } else {
                komentoValikko.setText("[T]akaisin");
            }
        } else if(uusiPaikka == Paikka.HAARNISKANOSTO) {
            String ostettavatHaarniskat = new HaarniskaKauppa().ostettavissaOlevatHaarniskatMerkkijonona(pelaaja);
            komentoValikko.setText(ostettavatHaarniskat);
        } else if(uusiPaikka == Paikka.MONSTERITAISTELU) {
            komentoValikko.setText("[L]yö\n[J]uokse");
        } else if(uusiPaikka == Paikka.MONSTERITAISTELUTAPPIO) {
            komentoValikko.setText("[J]atka peliä\n");
        } else if(uusiPaikka == Paikka.TAISTELUAREENAEI) {
            komentoValikko.setText("[T]akaisin");
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    
}
