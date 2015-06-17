package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.peli.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Areena;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Casino;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Luola;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Metsa;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Parantaja;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * TarinaPanel on JPanel, joka koostuu komento- ja tarinaosasta. Tarinaosassa
 * kerrotaan pelin tarinaa kuvilla ja teksteillä. Komento-osassa listataan
 * komennot, jotka ovat käytettävissä kullakin hetkellä.
 */
public class TarinaPanel extends JPanel {

    private Pelaaja pelaaja;
    private KomentoOsa komentoOsa;
    private TarinaOsa tarinaOsa;

    public TarinaPanel(Pelaaja pelaaja, Metsa metsa, Areena areena, Luola luola, Parantaja parantaja, Casino casino) {
        this.pelaaja = pelaaja;
        this.komentoOsa = new KomentoOsa(pelaaja, luola);
        this.tarinaOsa = new TarinaOsa(pelaaja, metsa, areena, luola, parantaja, casino);
        asetaPaneelit();
    }

    private void asetaPaneelit() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        tarinaOsa.setPreferredSize(new Dimension(300, 520));
        tarinaOsa.setMinimumSize(new Dimension(300, 520));
        tarinaOsa.setMaximumSize(new Dimension(300, 520));
        komentoOsa.setPreferredSize(new Dimension(300, 180));
        komentoOsa.setMinimumSize(new Dimension(300, 180));
        komentoOsa.setMaximumSize(new Dimension(300, 180));
        add(tarinaOsa);
        add(komentoOsa);
    }

    /**
     * Metodi antaa päivityskäskyn komento- ja tarinaosalle. Uusi paikka
     * asetetaan näkyville ja uuden paikan komennot listataan.
     *
     * @param uusiPaikka uusi paikka, joka asetetaan näkyviin
     */
    public void paivita(Paikka uusiPaikka) {
        tarinaOsa.paivita();
        komentoOsa.paivita(uusiPaikka);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
