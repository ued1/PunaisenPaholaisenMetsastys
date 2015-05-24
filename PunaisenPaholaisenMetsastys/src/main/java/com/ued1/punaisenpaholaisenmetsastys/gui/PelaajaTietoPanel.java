package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PelaajaTietoPanel extends JPanel {

    private Pelaaja pelaaja;
    private JLabel paikkaTeksti;    // poista
    private JLabel tasoTeksti;
    private JLabel vointiTeksti;
    private JLabel aseTeksti;
    private JLabel voimaTeksti;
    private JLabel haarniskaTeksti;
    private JLabel puolustusTeksti;
    private JLabel rahaTeksti;

    public PelaajaTietoPanel(Pelaaja pelaaja) {
        super(new GridLayout(8, 2));
        this.pelaaja = pelaaja;
        paikkaTeksti = new JLabel();    // poista
        tasoTeksti = new JLabel();
        vointiTeksti = new JLabel();
        aseTeksti = new JLabel();
        voimaTeksti = new JLabel();
        haarniskaTeksti = new JLabel();
        puolustusTeksti = new JLabel();
        rahaTeksti = new JLabel();
        luoKomponentit();
    }

    private void luoKomponentit() {
        paivitaTiedot();
        // add(new JLabel("Nimi:"));    // Korvattu väliaikaisesti paikkatiedolla
        add(new JLabel("Paikka:"));     // poista
        add(paikkaTeksti);              // poista
        // add(new JLabel(pelaaja.getNimi())); // Korvattu väliaikaisesti paikkatiedolla
        add(new JLabel("Taso:"));
        add(tasoTeksti);
        add(new JLabel("Vointi:"));
        add(vointiTeksti);
        add(new JLabel("Ase:"));
        add(aseTeksti);
        add(new JLabel("Voima:"));
        add(voimaTeksti);
        add(new JLabel("Haarniska:"));
        add(haarniskaTeksti);
        add(new JLabel("Puolustus:"));
        add(puolustusTeksti);
        add(new JLabel("Rahat:"));
        add(rahaTeksti);
    }

    private void paivitaTiedot() {
        paikkaTeksti.setText("" + pelaaja.getPaikka().toString()); // POISTA
        tasoTeksti.setText("" + pelaaja.getTaso());
        vointiTeksti.setText(pelaaja.getVointi() + "/" + pelaaja.getMaxVointi());
        aseTeksti.setText(pelaaja.getAse().nimi());
        voimaTeksti.setText("" + pelaaja.lyo());
        haarniskaTeksti.setText(pelaaja.getHaarniska().nimi());
        puolustusTeksti.setText("" + pelaaja.suojaa());
        rahaTeksti.setText("" + pelaaja.getRahat());
    }

    @Override
    protected void paintComponent(Graphics g) {
        paivitaTiedot();
        super.paintComponent(g);
    }

}
