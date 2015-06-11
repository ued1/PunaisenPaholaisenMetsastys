
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.logiikka.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Asepaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Casino;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Haarniskakauppa;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Kapakka;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Parantaja;
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
    private Font fontti;
    
    public KomentoOsa(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        fontti = new Font("SansSerif Bold", Font.BOLD, 12);
        luoKomponentit();
    }
    
    private void luoKomponentit() {
        komentoValikko = new JTextArea("[M]etsä\n[A]sepaja\n[H]aarniskakauppa\n[P]arantaja\n[K]apakka\n[C]asino\n[T]aisteluareena");
        komentoValikko.setFocusable(false);
        komentoValikko.setFont(fontti);
        add(komentoValikko);
    }
    
    /**
     * Metodi päivittää komentovalikon vastaamaan pelitilannetta.
     * 
     * @param uusiPaikka uusi paikka, jonka komennot piirretään
     */
    public void paivita(Paikka uusiPaikka) {
        komentoValikko.setFont(fontti);
        if(uusiPaikka == Paikka.KYLA) {
            komentoValikko.setText("[M]etsä\n[A]sepaja\n[H]aarniskakauppa\n[P]arantaja\n[K]apakka\n[C]asino\n[T]aisteluareena");
        } else if(uusiPaikka == Paikka.ASEPAJA) {
            komentoValikko.setText("[O]sta ase\n[M]yy asee\n[T]akaisin");
        } else if(uusiPaikka == Paikka.HAARNISKAKAUPPA) {
            komentoValikko.setText("[O]sta haarniska\n[T]akaisin");
        } else if(uusiPaikka == Paikka.METSA) {
            String metsaKomento = "[E]tsi monsteri";
            if(pelaaja.getTaso() == 10) {
                metsaKomento += "\n[P]unainen Paholainen";
            }
            komentoValikko.setText(metsaKomento + "\n[L]epää\n[T]akaisin kylään");
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
            String ostettavatHaarniskat = new Haarniskakauppa().ostokomennot(pelaaja);
            komentoValikko.setFont(new Font("SansSerif Bold", Font.BOLD, 10));
            komentoValikko.setText(ostettavatHaarniskat);
        } else if(uusiPaikka == Paikka.MONSTERITAISTELU) {
            komentoValikko.setText("[L]yö\n[J]uokse");
        } else if(uusiPaikka == Paikka.MONSTERITAISTELUTAPPIO || uusiPaikka == Paikka.PAHOLAINENTAPPIO) {
            komentoValikko.setText("[J]atka peliä\n");
        } else if(uusiPaikka == Paikka.TAISTELUAREENAEI) {
            komentoValikko.setText("[T]akaisin");
        } else if(uusiPaikka == Paikka.AREENATAISTELU || uusiPaikka == Paikka.PAHOLAINEN) {
            komentoValikko.setText("[L]yö");
        } else if(uusiPaikka == Paikka.TAISTELUAREENATULOS) {
            komentoValikko.setText("[J]atka");
        } else if(uusiPaikka == Paikka.KAPAKKA || uusiPaikka == Paikka.KANNI) {
            komentoValikko.setText("[O]sta\n[T]akaisin");
        } else if(uusiPaikka == Paikka.LUOLA) {
            komentoValikko.setText("[E]tsi Punainen Paholainen\n[T]akaisin metsään");
        } else if(uusiPaikka == Paikka.KAPAKKAOSTO) {
            String ostettavatAvut = new Kapakka(pelaaja).ostokomennot(pelaaja);
            komentoValikko.setText(ostettavatAvut);
        } else if(uusiPaikka == Paikka.PARANTAJA) {
            if(new Parantaja().voikoOstaa(pelaaja)) {
                komentoValikko.setText("[P]aranna\n[O]sta VihannesPotion\n[T]akaisin");
            } else {
                komentoValikko.setText("[P]aranna\n[T]akaisin");
            }
        } else if(uusiPaikka == Paikka.CASINO) {
            String komennot = new Casino().getKomennot(pelaaja);
            komentoValikko.setText(komennot);
        } else if(uusiPaikka == Paikka.PEUKKUPELI) {
            komentoValikko.setText("[A]loita\n[T]akaisin");
        } else if(uusiPaikka == Paikka.PEUKKUTULOS) {
            komentoValikko.setText("[T]akaisin");
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    
}
