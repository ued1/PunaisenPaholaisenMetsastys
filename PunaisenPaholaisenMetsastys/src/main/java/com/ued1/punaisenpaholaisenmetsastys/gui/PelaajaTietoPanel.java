package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.Apu;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.OhraPotion;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.Pupu;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.RuosteinenAvain;
import com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.KuvanAsettaja;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Luokka piirtää ja ylläpitää ruudun oikeassa laidassa olevaa
 * pelaajatietopaneelia. Paneelissa on esillä pelaajan ominaisuudet, jotka
 * päivittyvät muutosten tapahtuessa.
 */
public class PelaajaTietoPanel extends JPanel {

    private Pelaaja pelaaja;
    private JLabel tasoTeksti;
    private JLabel kokemusTeksti;
    private JLabel vointiTeksti;
    private JLabel aseTeksti;
    private JLabel voimaTeksti;
    private JLabel haarniskaTeksti;
    private JLabel puolustusTeksti;
    private JLabel rahaTeksti;
    private JLabel potionApu;
    private JLabel pupuApu;
    private JLabel olutApu;
    private JLabel avainApu;
    private KuvanAsettaja ikoninAsettaja;

    public PelaajaTietoPanel(Pelaaja pelaaja) {
        super(new GridLayout(11, 2));
        this.pelaaja = pelaaja;
        tasoTeksti = new JLabel();
        kokemusTeksti = new JLabel();
        vointiTeksti = new JLabel();
        aseTeksti = new JLabel();
        voimaTeksti = new JLabel();
        haarniskaTeksti = new JLabel();
        puolustusTeksti = new JLabel();
        rahaTeksti = new JLabel();
        ikoninAsettaja = new KuvanAsettaja();
        potionApu = ikoninAsettaja.asetaIkoni("VointiPotion");
        pupuApu = ikoninAsettaja.asetaIkoni("Pupu");
        olutApu = ikoninAsettaja.asetaIkoni("OhraPotion");
        avainApu = ikoninAsettaja.asetaIkoni("Ruosteinen avain");
        pupuApu.setVisible(false);
        olutApu.setVisible(false);
        lisaaKomponentit();
    }

    private void lisaaKomponentit() {
        paivitaTiedot();
        add(new JLabel("           Nimi:"));
        add(new JLabel(pelaaja.getNimi()));
        add(ikoninAsettaja.asetaIkoni("Taso"));
        add(tasoTeksti);
        add(ikoninAsettaja.asetaIkoni("Vointi"));
        add(vointiTeksti);
        add(ikoninAsettaja.asetaIkoni("Kokemus"));
        add(kokemusTeksti);
        add(ikoninAsettaja.asetaIkoni("Ase"));
        add(aseTeksti);
        add(ikoninAsettaja.asetaIkoni("Voima"));
        add(voimaTeksti);
        add(ikoninAsettaja.asetaIkoni("Haarniska"));
        add(haarniskaTeksti);
        add(ikoninAsettaja.asetaIkoni("Puolustus"));
        add(puolustusTeksti);
        add(ikoninAsettaja.asetaIkoni("Rahat"));
        add(rahaTeksti);
        add(potionApu);
        add(pupuApu);
        add(olutApu);
        add(avainApu);
    }
    
    private void paivitaTiedot() {
        tasoTeksti.setText("" + pelaaja.getTaso());
        kokemusTeksti.setText("" + pelaaja.getKokemus());
        vointiTeksti.setText(pelaaja.getVointi() + "/" + pelaaja.getMaxVointi());
        if(pelaaja.getVointi() < pelaaja.getMaxVointi()) {
            vointiTeksti.setForeground(Color.RED);
        } else {
            vointiTeksti.setForeground(Color.BLACK);
        }
        aseTeksti.setText(pelaaja.getAse().toString());
        voimaTeksti.setText("" + pelaaja.lyo());
        haarniskaTeksti.setText(pelaaja.getHaarniska().toString());
        puolustusTeksti.setText("" + pelaaja.suojaa());
        rahaTeksti.setText("" + pelaaja.getRahat());
        potionApu.setText("(" + pelaaja.getPotionit() + ")");
        paivitaApuIkonienNakyvyys();
    }
    
                                    // TODO: parempi toteutus
    private void paivitaApuIkonienNakyvyys() {
        ArrayList<Apu> avut = pelaaja.getAvut();
        if(avut.contains(new Pupu(pelaaja))) {
            pupuApu.setVisible(true);
        } else {
            pupuApu.setVisible(false);
        }
        if(avut.contains(new OhraPotion(pelaaja))) {
            olutApu.setVisible(true);
        } else {
            olutApu.setVisible(false);
        }
        if(avut.contains(new RuosteinenAvain())) {
            avainApu.setVisible(true);
        } else {
            avainApu.setVisible(false);
        }
    }
    

    /**
     * Metodi päivittää pelaajapaneelin saadessaan repaint() käskyn.
     */
    @Override
    protected void paintComponent(Graphics g) {
        paivitaTiedot();
        super.paintComponent(g);
    }

}
