package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko.OhjePanel;
import com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko.NimenValintaPanel;
import com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko.LoppuPanel;
import com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko.AsetuksetPanel;
import com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko.AlkuvalikkoPanel;
import com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.KomennonKuuntelija;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Areena;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Casino;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Luola;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Metsa;
import com.ued1.punaisenpaholaisenmetsastys.peli.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.peli.logiikka.Parantaja;
import com.ued1.punaisenpaholaisenmetsastys.peli.Vaikeus;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Käynnistämällä Kyla käynnistyy peli. Luokka luo ja alustaa JFramen ja asettaa
 * kaiken tarvittavan paikoilleen.
 */
public class Kyla implements Runnable {

    private JFrame frame;
    private Pelaaja pelaaja;
    private Metsa metsa;
    private Areena areena;
    private Luola luola;
    private Parantaja parantaja;
    private Casino casino;
    private KomennonKuuntelija kuuntelija;

    public Kyla() {
    }

    @Override
    public void run() {
        frame = new JFrame("PunaisenPaholaisenMetsastys");
        frame.getContentPane().add(new AlkuvalikkoPanel(this));
        frame.setPreferredSize(new Dimension(600, 700));
        frame.setMinimumSize(new Dimension(600, 700));
        frame.setMaximumSize(new Dimension(600, 700));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void asetaPelaaja(String pelaajanNimi, Vaikeus vaikeus) {
        this.pelaaja = new Pelaaja(pelaajanNimi.trim(), vaikeus);
    }

    private void asetaPelialue() {
        pelaaja.setPaikka(Paikka.KYLA);
        this.metsa = new Metsa(pelaaja);
        this.areena = new Areena(pelaaja);
        this.luola = new Luola(pelaaja);
        this.parantaja = new Parantaja();
        this.casino = new Casino();
    }

    private void luoPelinakyma(Container container) {
        asetaPelialue();
        PelaajaTietoPanel pelaajaTietoPanel = new PelaajaTietoPanel(pelaaja);
        pelaajaTietoPanel.setPreferredSize(new Dimension(300, 700));
        pelaajaTietoPanel.setMinimumSize(new Dimension(300, 700));
        pelaajaTietoPanel.setMaximumSize(new Dimension(300, 700));
        TarinaPanel tarinaPanel = new TarinaPanel(pelaaja, metsa, areena, luola, parantaja, casino);
        tarinaPanel.setPreferredSize(new Dimension(300, 700));
        tarinaPanel.setMinimumSize(new Dimension(300, 700));
        tarinaPanel.setMaximumSize(new Dimension(300, 700));
        container.add(tarinaPanel, BorderLayout.WEST);
        container.add(pelaajaTietoPanel, BorderLayout.EAST);
        kuuntelija = new KomennonKuuntelija(this, pelaaja, tarinaPanel, pelaajaTietoPanel, metsa, areena, luola, parantaja);
        frame.addKeyListener(kuuntelija);
    }

    /**
     * Lopettaa pelin poistamalla pelaajan.
     */
    public void poistaPelaaja() {
        pelaaja = null;
    }

    /**
     * Asettaa pelinäkymän ja aloittaa uuden pelin.
     *
     * @param pelaajanNimi uuden pelaajan nimi
     */
    public void aloitaUusiPeli(String pelaajanNimi, Vaikeus vaikeus) {
        tyhjennaFrame();
        asetaPelaaja(pelaajanNimi, vaikeus);
        luoPelinakyma(frame.getContentPane());
        piirraJaAsetaFokus();
    }

    /**
     * Jatkaa peliä, joka oli käynnissä.
     */
    public void jatkaPelia() {
        tyhjennaFrame();
        luoPelinakyma(frame.getContentPane());
        piirraJaAsetaFokus();
    }

    /**
     * Asettaa näkymän nimen valintaa varten.
     */
    public void asetaNimenValinta() {
        tyhjennaFrame();
        frame.getContentPane().add(new NimenValintaPanel(this));
        piirraJaAsetaFokus();
    }

    /**
     * Asettaa alkuvalikon näkyviin.
     */
    public void asetaAlkuvalikko() {
        tyhjennaFrame();
        frame.getContentPane().add(new AlkuvalikkoPanel(this));
        piirraJaAsetaFokus();
    }

    /**
     * Asetetaan alkuvalikko uudestaan näkyviin.
     */
    public void pelistaValikkoon() {
        frame.removeKeyListener(kuuntelija);
        asetaAlkuvalikko();
    }

    /**
     * Asettaa asetusvalikon näkyviin.
     */
    public void asetaAsetusvalikko() {
        tyhjennaFrame();
        frame.getContentPane().add(new AsetuksetPanel(this, pelaaja));
        piirraJaAsetaFokus();
    }

    /**
     * Asettaa ohjeen näkyviin.
     */
    public void asetaOhje() {
        tyhjennaFrame();
        frame.getContentPane().add(new OhjePanel(this));
        piirraJaAsetaFokus();
    }

    /**
     * Asettaa loppuvalikon.
     */
    public void asetaLoppuvalikko() {
        frame.removeKeyListener(kuuntelija);
        tyhjennaFrame();
        frame.getContentPane().add(new LoppuPanel(this, pelaaja));
        piirraJaAsetaFokus();
    }

    private void tyhjennaFrame() {
        frame.getContentPane().removeAll();
        frame.getContentPane().invalidate();
        frame.getContentPane().revalidate();
    }

    private void piirraJaAsetaFokus() {
        frame.repaint();
        frame.requestFocusInWindow();
    }

    /**
     * Metodi tarkistaa onko peli käynnissä eli onko pelaajaolio alustettu.
     *
     * @return totuusarvo, true jos peli on käynnissä
     */
    public boolean onkoPeliKaynnissa() {
        return !(pelaaja == null);
    }

}
