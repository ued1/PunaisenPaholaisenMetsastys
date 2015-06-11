package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.logiikka.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.KuvanAsettaja;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Areena;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Asepaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Casino;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Haarniskakauppa;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Kapakka;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Luola;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Metsa;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Parantaja;
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
    private Haarniskakauppa haarniskakauppa;
    private JLabel eka;
    private JTextArea toka;
    private Metsa metsa;
    private Areena areena;
    private KuvanAsettaja kuvanAsettaja;
    private Kapakka kapakka;
    private Luola luola;
    private Parantaja parantaja;
    private Casino casino;

    public TarinaOsa(Pelaaja pelaaja, Metsa metsa, Areena areena, Luola luola, Parantaja parantaja, Casino casino) {
        super(new GridLayout(2, 1));
        this.pelaaja = pelaaja;
        this.asepaja = new Asepaja();
        this.haarniskakauppa = new Haarniskakauppa();
        this.metsa = metsa;
        this.areena = areena;
        this.kapakka = new Kapakka(pelaaja);
        this.luola = luola;
        this.parantaja = parantaja;
        this.casino = casino;
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
        if (pelaaja.getPaikka() == Paikka.KYLA) {
            asetaKyla();
        } else if (pelaaja.getPaikka() == Paikka.ASEPAJA) {
            asetaAsepaja();
        } else if (pelaaja.getPaikka() == Paikka.HAARNISKAKAUPPA) {
            asetaHaarniskaKauppa();
        } else if (pelaaja.getPaikka() == Paikka.METSA) {
            asetaMetsa();
        } else if (pelaaja.getPaikka() == Paikka.ASEENOSTO) {
            asetaAseenOsto();
        } else if (pelaaja.getPaikka() == Paikka.ASEENMYYNTI) {
            asetaAseenMyynti();
        } else if (pelaaja.getPaikka() == Paikka.MONSTERITAISTELU) {
            asetaMonsteriTaistelu();
        } else if (pelaaja.getPaikka() == Paikka.MONSTERITAISTELUTAPPIO) {
            asetaMonsteriTaisteluTappio();
        } else if (pelaaja.getPaikka() == Paikka.TAISTELUAREENA) {
            asetaTaisteluAreena();
        } else if (pelaaja.getPaikka() == Paikka.TAISTELUAREENAEI) {
            asetaTaisteluAreenaEi();
        } else if (pelaaja.getPaikka() == Paikka.AREENATAISTELU) {
            asetaAreenaTaistelu();
        } else if (pelaaja.getPaikka() == Paikka.TAISTELUAREENATULOS) {
            asetaTaisteluAreenaTulos();
        } else if (pelaaja.getPaikka() == Paikka.KAPAKKA) {
            asetaKapakka();
        } else if (pelaaja.getPaikka() == Paikka.LUOLA) {
            asetaLuola();
        } else if (pelaaja.getPaikka() == Paikka.PAHOLAINEN) {
            asetaPaholainen();
        } else if (pelaaja.getPaikka() == Paikka.PAHOLAINENTAPPIO) {
            asetaPaholainenTappio();
        } else if (pelaaja.getPaikka() == Paikka.KAPAKKAOSTO) {
            asetaKapakkaOsto();
        } else if (pelaaja.getPaikka() == Paikka.KANNI) {
            asetaKanni();
        } else if (pelaaja.getPaikka() == Paikka.HAARNISKANOSTO) {
            asetaHaarniskaOsto();
        } else if (pelaaja.getPaikka() == Paikka.PARANTAJA) {
            asetaParantaja();
        } else if (pelaaja.getPaikka() == Paikka.CASINO) {
            asetaCasino();
        } else if (pelaaja.getPaikka() == Paikka.PEUKKUPELI) {
            asetaPeukkupeli();
        } else if (pelaaja.getPaikka() == Paikka.PEUKKUTULOS) {
            asetaPeukkupeliTulos();
        }

    }

    private void asetaKyla() {
        kuvanAsettaja.asetaKuva(eka, "Kylä");
        String kuvaus = "Tämä on kyläsi.";
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
        toka.setText(haarniskakauppa.hinnastoMerkkijonona());
    }

    private void asetaKapakka() {
        kuvanAsettaja.asetaKuva(eka, "Kapakka");
        toka.setText(kapakka.hinnastoMerkkijonona());
    }
    
    private void asetaCasino() {
        kuvanAsettaja.asetaKuva(eka, "Casino");
        toka.setText(casino.getCasinoKuvaus(pelaaja));
    }
    
    private void asetaPeukkupeli() {
        kuvanAsettaja.asetaKuva(eka, "Peukkupeli");
        toka.setText(casino.getPeukkupeliKuvaus());
    }
    
    private void asetaPeukkupeliTulos() {
        if(new Casino().pelaaPeukkua(pelaaja)) {
            kuvanAsettaja.asetaKuva(eka, "Peukku ylös");
            toka.setText("\nVoitit! Rahasi on tuplattu!");
        } else {
            kuvanAsettaja.asetaKuva(eka, "Peukku alas");
            toka.setText("\nHävisit. Menenit kaikki rahasi.");
        }
        
    }

    private void asetaKanni() {
        kuvanAsettaja.asetaKuva(eka, "Känni");
        String kanni = "";
        if(pelaaja.getVointi() < 2) {
            kanni += "\nOlet niin kännissä ettei vointisi\nvoi enää enempää laskea!";
            kanni += "\nRahamääräsi kuitenkin jatkaa laskua.\n\n";
        } else {
            kanni = "\nHumaltuminen laskee vointiasi yhdellä!\n\n";
        }
        kanni += kapakka.hinnastoMerkkijonona();
        toka.setText(kanni);
    }

    private void asetaParantaja() {
        kuvanAsettaja.asetaKuva(eka, "Parantaja");
        toka.setText(parantaja.getKuvaus(pelaaja));
    }

    private void asetaMetsa() {
        kuvanAsettaja.asetaKuva(eka, "Metsä");
        String kuvaus = "\nMetsässä voit taistella monstereita vastaan";
        kuvaus += "\nja ansaita kultarahoja. Jos häviät monsterille";
        kuvaus += "\nmenetät kaikki rahasi.";
        kuvaus += "\n\nVoit levätä ja parantaa vointiasi milloin vain";
        kuvaus += "\nkun et ole taistelussa.";
        toka.setText(kuvaus);
    }

    private void asetaLuola() {
        kuvanAsettaja.asetaKuva(eka, "Luola");
        String teksti = "Olet löytänyt luolan, missä asuu\n";
        teksti += "Punainen Paholainen.\n\n";
        toka.setText(teksti);
    }

    private void asetaAseenOsto() {
        toka.setText(asepaja.ostettavissaOlevat(pelaaja));
    }

    private void asetaHaarniskaOsto() {
        toka.setText(haarniskakauppa.ostettavissaOlevat(pelaaja));
    }

    private void asetaAseenMyynti() {
        if (asepaja.voikoMyydaAseen(pelaaja)) {
            toka.setText("ohje aseen myyntiin");
        } else {
            toka.setText("Et voi myydä omaa nyrkkiäsi");
        }
    }

    private void asetaKapakkaOsto() {
        kuvanAsettaja.asetaKuva(eka, "Kapakka");
        toka.setText(kapakka.ostettavissaOlevat(pelaaja));
    }

    private void asetaMonsteriTaistelu() {
        String tilanne = metsa.getTaistelu().vastustaja().tiedotMerkkijonona();
        if (metsa.getTaistelu().onkoKaynnissa()) {
            tilanne += "\n\nOsuit monsteriin: " + metsa.getTaistelu().getEkaIsku() + " osumapistettä";
            tilanne += "\nMonsteri";
            if (metsa.getTaistelu().getTokaIsku() < 1) {
                tilanne += " ei osunut sinuun.";
            } else {
                tilanne += " osui sinuun: " + metsa.getTaistelu().getTokaIsku() + " osumapistettä";
            }
            tilanne += "\n\nVointisi: " + pelaaja.getVointi() + "/" + pelaaja.getMaxVointi();
        }
        toka.setText(tilanne);
    }

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
        if (pelaaja.getRahat() > 0) {
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
        if (pelaaja.onkoElossa()) {
            kuvanAsettaja.asetaKuva(eka, "Taisteluvoitto");
            tokateksti += "Voitit taistelun!\n\n";
            tokateksti += "Voit palata takaisin areenaan heti kun\n";
            tokateksti += "koet olevasi valmis seuraavaan taisteluun.";
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
