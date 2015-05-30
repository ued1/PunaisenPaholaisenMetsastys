
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.logiikka.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Asepaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.HaarniskaKauppa;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * KomentoOsa on JPanel TarinaPanel-luokan paneelissa. Luokan tehtävänä on
 * piirtää ja päivittää komentovalikko jokaiseen tilanteeseen sopivaksi.
 */
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
        komentoValikko.setFont(new Font("SansSerif Bold", Font.BOLD, 12));
        add(komentoValikko);
    }
    
    /**
     * Metodi aseettaa uuden paikan jonka perusteella piirretään uudet komennot.
     * 
     * @param uusiPaikka uusi paikka, jonka komennot piirretään
     */
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
            String ostettavatAseet = new Asepaja().ostokomennot(pelaaja);
            komentoValikko.setText(ostettavatAseet);
        } else if(uusiPaikka == Paikka.ASEENMYYNTI) {
            if(new Asepaja().voikoMyydaAseen(pelaaja)) {
                komentoValikko.setText("[K]yllä\n[E]i");
            } else {
                komentoValikko.setText("[T]akaisin");
            }
        } else if(uusiPaikka == Paikka.HAARNISKANOSTO) {
            String ostettavatHaarniskat = new HaarniskaKauppa().ostokomennot(pelaaja);
            komentoValikko.setText(ostettavatHaarniskat);
        } else if(uusiPaikka == Paikka.MONSTERITAISTELU) {
            komentoValikko.setText("[L]yö\n[J]uokse");
        } else if(uusiPaikka == Paikka.MONSTERITAISTELUTAPPIO) {
            komentoValikko.setText("[J]atka peliä\n");
        } else if(uusiPaikka == Paikka.TAISTELUAREENAEI) {
            komentoValikko.setText("[T]akaisin");
        } else if(uusiPaikka == Paikka.AREENATAISTELU) {
            komentoValikko.setText("[L]yö");
        } else if(uusiPaikka == Paikka.TAISTELUAREENATULOS) {
            komentoValikko.setText("[J]atka");
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    
}
