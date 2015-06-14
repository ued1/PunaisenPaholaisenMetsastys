package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.OhraPotion;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.RuosteinenAvain;
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
        fontti = new Font("SansSerif", Font.BOLD, 12);
        luoKomponentit();
    }

    private void luoKomponentit() {
        komentoValikko = new JTextArea(kylaValikko());
        komentoValikko.setFocusable(false);
        komentoValikko.setFont(fontti);
        add(komentoValikko);
    }

    private String kylaValikko() {
        return "[M]etsä\n[A]sepaja\n[H]aarniskakauppa\n[P]arantaja\n[K]apakka\n[C]asino\n[T]aisteluareena\n[ESC] Takaisin valikkoon";
    }

    /**
     * Metodi päivittää komentovalikon vastaamaan pelitilannetta.
     *
     * @param uusiPaikka uusi paikka, jonka komennot piirretään
     */
    public void paivita(Paikka uusiPaikka) {
        komentoValikko.setFont(fontti);
        if (uusiPaikka == Paikka.KYLA) {
            komentoValikko.setText(kylaValikko());
        } else if (uusiPaikka == Paikka.ASEPAJA) {
            komentoValikko.setText("[O]sta ase\n[M]yy ase\n[T]akaisin");
        } else if (uusiPaikka == Paikka.HAARNISKAKAUPPA) {
            komentoValikko.setText("[O]sta haarniska\n[T]akaisin");
        } else if (uusiPaikka == Paikka.METSA) {
            komentoValikko.setText(lisaaMetsaKomennot());
        } else if (uusiPaikka == Paikka.TAISTELUAREENA) {
            komentoValikko.setText("[A]stu taisteluareenaan\n[T]akaisin kylään");
        } else if (uusiPaikka == Paikka.ASEENOSTO) {
            String ostettavatAseet = new Asepaja().ostokomennot(pelaaja);
            komentoValikko.setText(ostettavatAseet);
        } else if (uusiPaikka == Paikka.ASEENMYYNTI) {
            komentoValikko.setText(lisaaAseenMyyntiKomento());
        } else if (uusiPaikka == Paikka.HAARNISKANOSTO) {
            String ostettavatHaarniskat = new Haarniskakauppa().ostokomennot(pelaaja);
            komentoValikko.setFont(new Font("SansSerif Bold", Font.BOLD, 10));
            komentoValikko.setText(ostettavatHaarniskat);
        } else if (uusiPaikka == Paikka.MONSTERITAISTELU) {
            komentoValikko.setText("[L]yö\n[J]uokse");
        } else if (uusiPaikka == Paikka.MONSTERITAISTELUTAPPIO || uusiPaikka == Paikka.PAHOLAINENTAPPIO) {
            komentoValikko.setText("[J]atka peliä\n");
        } else if (uusiPaikka == Paikka.TAISTELUAREENAEI) {
            komentoValikko.setText("[T]akaisin");
        } else if (uusiPaikka == Paikka.AREENATAISTELU || uusiPaikka == Paikka.PAHOLAINEN) {
            komentoValikko.setText("[L]yö" + lisaaApuKomento(uusiPaikka));
        } else if (uusiPaikka == Paikka.TAISTELUAREENATULOS || uusiPaikka == Paikka.METSAPUPU) {
            komentoValikko.setText("[J]atka");
        } else if (uusiPaikka == Paikka.KAPAKKA || uusiPaikka == Paikka.KANNI) {
            komentoValikko.setText("[O]sta\n[T]akaisin");
        } else if (uusiPaikka == Paikka.LUOLA) {
            komentoValikko.setText("[E]tsi Punainen Paholainen\n[T]akaisin metsään");
        } else if (uusiPaikka == Paikka.KAPAKKAOSTO) {
            String ostettavatAvut = new Kapakka(pelaaja).ostokomennot(pelaaja);
            komentoValikko.setText(ostettavatAvut);
        } else if (uusiPaikka == Paikka.PARANTAJA) {
            komentoValikko.setText(lisaaParantajaKomento());
        } else if (uusiPaikka == Paikka.CASINO) {
            String komennot = new Casino().getKomennot(pelaaja);
            komentoValikko.setText(komennot);
        } else if (uusiPaikka == Paikka.PEUKKUPELI) {
            komentoValikko.setText("[A]loita\n[T]akaisin");
        } else if (uusiPaikka == Paikka.PEUKKUTULOS) {
            komentoValikko.setText("[T]akaisin");
        }
    }

    private String lisaaApuKomento(Paikka uusiPaikka) {
        if (uusiPaikka == Paikka.AREENATAISTELU && pelaaja.onkoPelaajallaApu(new OhraPotion(pelaaja))) {
            return "\n[O]hraPotion";
        } else if (uusiPaikka == Paikka.PAHOLAINEN && pelaaja.onkoPelaajallaApu(new RuosteinenAvain())) {
            return "\n[R]uosteinen avain";
        } else {
            return "";
        }
    }

    private String lisaaMetsaKomennot() {
        String metsaKomento = "[E]tsi monsteri";
        if (pelaaja.getTaso() == 10) {
            metsaKomento += "\n[P]unainen Paholainen";
        }
        metsaKomento += "\n[V]ointiPotion (" + pelaaja.getPotionit() + ")";
        return metsaKomento + "\n[T]akaisin kylään";
    }

    private String lisaaAseenMyyntiKomento() {
        String komento = "";
        if (new Asepaja().voikoMyydaAseen(pelaaja)) {
            komento += "[K]yllä\n[E]i";
        } else {
            komento += "[T]akaisin";
        }
        return komento;
    }

    private String lisaaParantajaKomento() {
        String komento = "";
        if (new Parantaja().voikoOstaa(pelaaja)) {
            komento += "[P]aranna\n[O]sta VihannesPotion\n[T]akaisin";
        } else {
            komento += "[P]aranna\n[T]akaisin";
        }
        return komento;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
