
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Areena;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Asepaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.HaarniskaKauppa;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Metsa;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TarinaOsa extends JPanel {
        
    private Pelaaja pelaaja;
    private Asepaja asepaja;
    private HaarniskaKauppa haarniskaKauppa;
    private JTextArea eka;
    private JTextArea toka;
    private Metsa metsa;
    private Areena areena;
    
    public TarinaOsa(Pelaaja pelaaja, Metsa metsa, Areena areena) {
        super(new GridLayout(2,1));
        this.pelaaja = pelaaja;
        this.asepaja = new Asepaja();
        this.haarniskaKauppa = new HaarniskaKauppa();
        this.metsa = metsa;
        this.areena = areena;
        luoKomponentit();
    }
    
    private void luoKomponentit() {
        eka = new JTextArea();
        toka = new JTextArea();
        paivita();
        eka.setFocusable(false);
        toka.setFocusable(false);
        add(eka);
        add(toka);
    }
    
    
    
    public void paivita() {
        if(pelaaja.getPaikka() == Paikka.KYLA) {
            asetaKyla();
        } else if(pelaaja.getPaikka() == Paikka.ASEPAJA) {
            asetaAsepaja();
        } else if(pelaaja.getPaikka() == Paikka.HAARNISKAKAUPPA) {
            asetaHaarniskaKauppa();
        } else if(pelaaja.getPaikka() == Paikka.METSA) {
            asetaMetsa();
        } else if(pelaaja.getPaikka() == Paikka.ASEENOSTO) {
            asetaAseenOsto();
        } else if(pelaaja.getPaikka() == Paikka.ASEENMYYNTI) {
            asetaAseenMyynti();
        } else if(pelaaja.getPaikka() == Paikka.MONSTERITAISTELU) {
            asetaMonsteriTaistelu();
        } else if(pelaaja.getPaikka() == Paikka.MONSTERITAISTELUTAPPIO) {
            asetaMonsteriTaisteluTappio();
        } else if(pelaaja.getPaikka() == Paikka.TAISTELUAREENA) {
            asetaTaisteluAreena();
        } else if(pelaaja.getPaikka() == Paikka.TAISTELUAREENAEI) {
            asetaTaisteluAreenaEi();
        }
        
        
    }
    
    private void asetaKyla() {
        eka.setText("KYLÄ");
        toka.setText("kylä");
    }
    
    private void asetaAsepaja() {
        eka.setText("ASEPAJA");
        toka.setText(asepaja.hinnastoMerkkijonona());
    }
    
    private void asetaHaarniskaKauppa() {
        eka.setText("HAARNISKAKAUPPA");
        toka.setText(haarniskaKauppa.hinnastoMerkkijonona());
    }
    
    private void asetaMetsa() {
        eka.setText("METSÄ");
        toka.setText("metsä");
    }
    
    private void asetaAseenOsto() {
        eka.setText("ASEENOSTO");
        toka.setText("ostettavat aseet...");
    }
    
    private void asetaAseenMyynti() {
        eka.setText("ASEENMYYNTI");
        if(asepaja.voikoMyydaAseen(pelaaja)) {
            toka.setText("ohje aseen myyntiin");
        } else {
            toka.setText("Et voi myydä omaa nyrkkiäsi");
        }
    }
    
    private void asetaMonsteriTaistelu() {
        eka.setText("MONSTERITAISTELU");
        toka.setText(metsa.getTaistelu().vastustaja().tiedotMerkkijonona());
    }
    
    private void asetaMonsteriTaisteluTappio() {
        eka.setText("METSÄ");
        String tokateksti = ("Hävisit taistelun!\n\nMonsteri päätti säästää henkesi,");
        if(pelaaja.getRahat() > 0) {
            tokateksti += "\nmutta vie voittopalkkiona kultarahasi,";
            tokateksti += "\n" + pelaaja.getRahat() + ",";
        }
        tokateksti += "\nlevättyäsi olet taas voimissasi";
        toka.setText(tokateksti);
    }
    
    private void asetaTaisteluAreena() {
        eka.setText("TAISTELUAREENA");
        String tokateksti = "Olet tasolla " + pelaaja.getTaso() + ". Noustaksesi seuraavalle";
        tokateksti += "\ntasolle sinun on voitettava vielä " + areena.getOtteluitaJaljella() + " ottelua.";
        // tiedot ensimmäisestä vastustajasta
        // kerrotaan mitä tapahtuu kun voittaa/häviää
        toka.setText(tokateksti);
    }
    
    private void asetaTaisteluAreenaEi() {
        eka.setText("TAISTELUAREENA");
        // TODO: teksti jos on jo level 10
        String tokateksti = "Olet tasolla " + pelaaja.getTaso() + ". Haastaaksesi kilpailijoita";
        tokateksti += "\nja noustaksesi seuraavalle tasolle tarvitset";
        tokateksti += "\nlisää kokemusta.";
        tokateksti += "\n\nKokemuksesi: " + pelaaja.getKokemus();
        tokateksti += "\nTarvittava kokemus: XXX";
        toka.setText(tokateksti);
    }
        
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
        
}
