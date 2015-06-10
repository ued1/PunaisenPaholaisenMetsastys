
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.KomennonKuuntelija;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Areena;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Luola;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Metsa;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Parantaja;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Käynnistämällä Kyla käynnistyy peli. Luokka luo ja alustaa JFramen ja asettaa
 * kaiken tarvittavan paikoilleen.
 */
public class Kyla implements Runnable {
    
    private JFrame frame;
    private Pelaaja pelaaja;
    private TarinaPanel tarinaPanel;
    private Metsa metsa;
    private Areena areena;
    private Luola luola;
    private Parantaja parantaja;
    
    public Kyla() {
    }
        
    @Override
    public void run() {
        frame = new JFrame("PunaisenPaholaisenMetsastys");
        luoAlkuvalikko(frame.getContentPane());
        frame.setPreferredSize(new Dimension(600,600));
        frame.setMinimumSize(new Dimension(600,600));
        frame.setMaximumSize(new Dimension(600,600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private void asetaPelaajaJaAlustaPelialue(String pelaajanNimi) {
        this.pelaaja = new Pelaaja(pelaajanNimi.trim());
        this.metsa = new Metsa(pelaaja);
        this.areena = new Areena(pelaaja);
        this.luola = new Luola(pelaaja);
        this.parantaja = new Parantaja();
    }
    
    private void luoPeliNakyma(Container container, String pelaajanNimi) {
        asetaPelaajaJaAlustaPelialue(pelaajanNimi);
        PelaajaTietoPanel pelaajaTietoPanel = new PelaajaTietoPanel(pelaaja);
        pelaajaTietoPanel.setPreferredSize(new Dimension(300, 600));
        pelaajaTietoPanel.setMinimumSize(new Dimension(300, 600));
        pelaajaTietoPanel.setMaximumSize(new Dimension(300, 600));
        tarinaPanel = new TarinaPanel(pelaaja, metsa, areena, luola, parantaja);
        tarinaPanel.setPreferredSize(new Dimension(300,600));
        tarinaPanel.setMinimumSize(new Dimension(300,600));
        tarinaPanel.setMaximumSize(new Dimension(300,600));
        container.add(tarinaPanel, BorderLayout.WEST);
        container.add(pelaajaTietoPanel, BorderLayout.EAST);
        frame.addKeyListener(new KomennonKuuntelija(pelaaja,tarinaPanel,pelaajaTietoPanel,metsa, areena,luola, parantaja));
    }
    
    private void luoAlkuvalikko(Container container) {
        AlkuvalikkoPanel alkuvalikko = new AlkuvalikkoPanel(this);
        container.add(alkuvalikko);
    }
    
    /**
     * Asettaa pelinäkymän ja aloittaa uuden pelin.
     * @param pelaajanNimi uuden pelaajan nimi
     */
    public void aloitaUusiPeli(String pelaajanNimi) {
        tyhjenna();
        luoPeliNakyma(frame.getContentPane(), pelaajanNimi);
        piirraJaAsetaFokus();
    }
    
    /**
     * Asettaa näkymän nimen valintaa varten.
     */
    public void uusiNimenValinta() {
        tyhjenna();
        NimenValintaPanel nimenValinta = new NimenValintaPanel(this);
        frame.getContentPane().add(nimenValinta);
        piirraJaAsetaFokus();
    }
    
    private void tyhjenna() {
        frame.getContentPane().removeAll();
        frame.getContentPane().invalidate();
        frame.getContentPane().revalidate();
    }
    
    private void piirraJaAsetaFokus() {
        frame.repaint();
        frame.requestFocusInWindow();
    }
            
    
}
