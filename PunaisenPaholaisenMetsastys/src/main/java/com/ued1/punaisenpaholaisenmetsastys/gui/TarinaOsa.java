
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.logiikka.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.KuvanAsettaja;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Areena;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Asepaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.HaarniskaKauppa;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Kapakka;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Luola;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Metsa;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Luokka hoitaa tarinapaneelin tarinaosan päivittämisen asettamalla
 * tilanteeseen sopivan tekstin käyttäjän näkyville.
 */
public class TarinaOsa extends JPanel {
        
    private Pelaaja pelaaja;
    private Asepaja asepaja;
    private HaarniskaKauppa haarniskaKauppa;
    private JLabel eka;
    private JTextArea toka;
    private Metsa metsa;
    private Areena areena;
    private KuvanAsettaja kuvanAsettaja;
    private Kapakka kapakka;
    private Luola luola;
    
    public TarinaOsa(Pelaaja pelaaja, Metsa metsa, Areena areena, Luola luola) {
        super(new GridLayout(2,1));
        this.pelaaja = pelaaja;
        this.asepaja = new Asepaja();
        this.haarniskaKauppa = new HaarniskaKauppa();
        this.metsa = metsa;
        this.areena = areena;
        this.kapakka = new Kapakka(pelaaja);
        this.luola = luola;
        kuvanAsettaja = new KuvanAsettaja();
        luoKomponentit();
    }
    
    private void luoKomponentit() {
        eka = new JLabel();
        toka = new JTextArea();
        paivita();
        eka.setFocusable(false);
        toka.setFocusable(false);
        add(eka);
        add(toka);
    }
    
    /**
     * Metodi päivittää tarinapaneelin tarinaosan.
     */
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
        } else if(pelaaja.getPaikka() == Paikka.AREENATAISTELU) {
            asetaAreenaTaistelu();
        } else if(pelaaja.getPaikka() == Paikka.TAISTELUAREENATULOS) {
            asetaTaisteluAreenaTulos();
        } else if(pelaaja.getPaikka() == Paikka.KAPAKKA) {
            asetaKapakka();
        } else if(pelaaja.getPaikka() == Paikka.LUOLA) {
            asetaLuola();
        } else if(pelaaja.getPaikka() == Paikka.PAHOLAINEN) {
            asetaPaholainen();
        } else if(pelaaja.getPaikka() == Paikka.PAHOLAINENTAPPIO) {
            asetaPaholainenTappio();
        }
        
        
        
    }
    
    private void asetaKyla() {
        kuvanAsettaja.asetaKuva(eka, "Kylä");
        String kuvaus = "\nTämä on kyläsi.";
        kuvaus += "\n\nAsepajassa voit ostaa uusia aseita.";
        kuvaus += "\n\nHaarniskakaupassa voit päivittää haarniskasi.";
        kuvaus += "\n\nKapakasta löytyy kaikenlaista hyödyllista\nja hyödytöntä.";
        kuvaus += "\n\nTaisteluareenalla voit kehittyä taistelijana";
        kuvaus += "\nja nousta seuraavalla tasolle.";
        kuvaus += "\n\nMetsästä löytyy monstereita, joita tappamalla";
        kuvaus += "\nsaat lisää kultarahoja.";
        toka.setText(kuvaus);
    }
    
    private void asetaAsepaja() {
        kuvanAsettaja.asetaKuva(eka, "Asepaja");
        toka.setText(asepaja.hinnastoMerkkijonona());
    }
    
    private void asetaHaarniskaKauppa() {
        kuvanAsettaja.asetaKuva(eka, "Haarniskakauppa");
        toka.setText(haarniskaKauppa.hinnastoMerkkijonona());
    }
    
    private void asetaKapakka() {
        kuvanAsettaja.asetaKuva(eka, "Kapakka");
        toka.setText(kapakka.hinnastoMerkkijonona());
    }
    
    private void asetaMetsa() {
        kuvanAsettaja.asetaKuva(eka, "Metsä");
        String kuvaus = "\nOlet saapunut kylääsi ympäröivään metsään.";
        // TODO
        toka.setText(kuvaus);
    }
    
    private void asetaLuola() {
        kuvanAsettaja.asetaKuva(eka, "Luola");
        toka.setText("luola");
    }
        
    private void asetaAseenOsto() {
        kuvanAsettaja.asetaKuva(eka, "AseenOsto");
        toka.setText("ostettavat aseet...");
    }
    
    private void asetaAseenMyynti() {
        kuvanAsettaja.asetaKuva(eka, "AseenMyynti");
        if(asepaja.voikoMyydaAseen(pelaaja)) {
            toka.setText("ohje aseen myyntiin");
        } else {
            toka.setText("Et voi myydä omaa nyrkkiäsi");
        }
    }
    
    private void asetaMonsteriTaistelu() {
        eka.setText("MONSTERITAISTELU");
        String tilanne = metsa.getTaistelu().vastustaja().tiedotMerkkijonona();
        if(metsa.getTaistelu().onkoAlkanut()) {
            tilanne += "\n\nOsuit monsteriin: " + metsa.getTaistelu().getEkaIsku() + " osumapistettä";
            tilanne += "\n" + metsa.getTaistelu().vastustaja().getNimi();
            if(metsa.getTaistelu().getTokaIsku() < 1) {
                tilanne += " ei osunut sinuun.";
            } else {
                tilanne += " osui sinuun: " + metsa.getTaistelu().getTokaIsku() + " osumapistettä";
            }
        }
        toka.setText(tilanne);
    }
    
    // TODO: yhdistä ylä ja ala
    
    private void asetaPaholainen() {
        kuvanAsettaja.asetaKuva(eka, "Paholainen");
        toka.setText(luola.getTaistelu().vastustaja().tiedotMerkkijonona());
    }
    
    private void asetaAreenaTaistelu() {
        kuvanAsettaja.asetaKuva(eka, "AreenaTaistelu");
        toka.setText(areena.getVastustajanTiedot());
    }
    
    private void asetaMonsteriTaisteluTappio() {
        kuvanAsettaja.asetaKuva(eka, "Taistelutappio");
        String tokateksti = ("Hävisit taistelun!\n\nMonsteri päätti säästää henkesi,");
        if(pelaaja.getRahat() > 0) {
            tokateksti += "\nmutta vie voittopalkkiona kultarahasi,";
            tokateksti += "\n" + pelaaja.getRahat() + ",";
        }
        tokateksti += "\nlevättyäsi olet taas voimissasi";
        toka.setText(tokateksti);
    }
    
    private void asetaPaholainenTappio() {
        String teksti = "Hävisit paholaiselle.";
        teksti += "\n\nPaholainen ottaa haarniskasi ja kaikki rahasi,";
        teksti += "\nmutta säästää henkesi.";
        toka.setText(teksti);
    }
    
    private void asetaTaisteluAreena() {
        kuvanAsettaja.asetaKuva(eka, "Taisteluareena");;
        String tokateksti = "Olet tasolla " + pelaaja.getTaso() + ". Noustaksesi seuraavalle";
        tokateksti += "\ntasolle sinun on voitettava vielä " + areena.getOtteluitaJaljella() + " ottelua.\n\n";
        tokateksti += areena.getVastustajanTiedot();
        
        toka.setText(tokateksti);
    }
    
    private void asetaTaisteluAreenaEi() {
        kuvanAsettaja.asetaKuva(eka, "Taisteluareena");;
        // TODO: teksti jos on jo level 10
        String tokateksti = "Olet tasolla " + pelaaja.getTaso() + ". Haastaaksesi kilpailijoita";
        tokateksti += "\nja noustaksesi seuraavalle tasolle tarvitset";
        tokateksti += "\n" + (areena.seuraavanTasonKokemus() - pelaaja.getKokemus()) + " lisää kokemusta.";
        tokateksti += "\n\nKokemuksesi: " + pelaaja.getKokemus();
        tokateksti += "\nTarvittava kokemus: " + areena.seuraavanTasonKokemus();
        toka.setText(tokateksti);
    }
    
    private void asetaTaisteluAreenaTulos() {
        String tokateksti = "";
        if(pelaaja.onkoElossa()) {
            eka.setText("TAISTELUAREENATULOS");
            tokateksti += "Voitit taistelun!";
        } else {
            kuvanAsettaja.asetaKuva(eka, "Taistelutappio");
            tokateksti += "Hävisit taistelun.\n\nVoit halutessasi yrittää heti uudestaan,";
            tokateksti += "\nmutta paremmilla varusteilla voisi taistelu";
            tokateksti += "\nolla helpompaa!";
        }
        toka.setText(tokateksti);
        areena.asetaTaistelunTulos();
    }
        
}
