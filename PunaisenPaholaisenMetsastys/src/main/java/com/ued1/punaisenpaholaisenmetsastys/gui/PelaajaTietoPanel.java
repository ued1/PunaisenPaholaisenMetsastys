package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.KuvanAsettaja;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Luokka piirtää ja ylläpitää ruudun oikeassa laidassa olevaan
 * pelaajatietopaneelia. Paneelissa on esillä pelaajan ominaisuudet, jotka
 * päivittyvät muutosten tapahtuessa.
 */
public class PelaajaTietoPanel extends JPanel {

    private Pelaaja pelaaja;
    private JLabel paikkaTeksti;    // poista
    private JLabel tasoTeksti;
    private JLabel kokemusTeksti;
    private JLabel vointiTeksti;
    private JLabel aseTeksti;
    private JLabel voimaTeksti;
    private JLabel haarniskaTeksti;
    private JLabel puolustusTeksti;
    private JLabel rahaTeksti;
    private KuvanAsettaja ikoninAsettaja;

    public PelaajaTietoPanel(Pelaaja pelaaja) {
        super(new GridLayout(9, 2));    // pienennä poisteassa paikkatieto
        this.pelaaja = pelaaja;
        paikkaTeksti = new JLabel();    // poista
        tasoTeksti = new JLabel();
        kokemusTeksti = new JLabel();
        vointiTeksti = new JLabel();
        aseTeksti = new JLabel();
        voimaTeksti = new JLabel();
        haarniskaTeksti = new JLabel();
        puolustusTeksti = new JLabel();
        rahaTeksti = new JLabel();
        ikoninAsettaja = new KuvanAsettaja();
        luoKomponentit();
    }

    private void luoKomponentit() {
        paivitaTiedot();
        // add(new JLabel("Nimi:"));    // Korvattu väliaikaisesti paikkatiedolla
        add(new JLabel("Paikka:"));     // poista
        add(paikkaTeksti);              // poista
        // add(new JLabel(pelaaja.getNimi())); // Korvattu väliaikaisesti paikkatiedolla
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
    }
    
    private void paivitaTiedot() {
        paikkaTeksti.setText("" + pelaaja.getPaikka().toString()); // POISTA
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
