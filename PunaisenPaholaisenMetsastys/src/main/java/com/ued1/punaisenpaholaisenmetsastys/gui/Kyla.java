
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
    
    private AlkuvalikkoPanel alkuvalikkoPanel;
    private OhjePanel ohjePanel;
    private NimenValintaPanel nimenValintaPanel;
        
    public Kyla() {
    }
        
    @Override
    public void run() {
        luoAlkuvalikonPaneelit();
        frame = new JFrame("PunaisenPaholaisenMetsastys");
        frame.getContentPane().add(alkuvalikkoPanel);
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
    
    private void luoAlkuvalikonPaneelit() {
        alkuvalikkoPanel = new AlkuvalikkoPanel(this);
        nimenValintaPanel = new NimenValintaPanel(this);
        ohjePanel = new OhjePanel(this);
    }
    
    private void luoPelinakyma(Container container, String pelaajanNimi) {
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
    
    /**
     * Asettaa pelinäkymän ja aloittaa uuden pelin.
     * @param pelaajanNimi uuden pelaajan nimi
     */
    public void aloitaUusiPeli(String pelaajanNimi) {
        tyhjennaFrame();
        luoPelinakyma(frame.getContentPane(), pelaajanNimi);
        piirraJaAsetaFokus();
    }
    
    /**
     * Asettaa näkymän nimen valintaa varten.
     */
    public void asetaNimenValinta() {
        tyhjennaFrame();
        frame.getContentPane().add(nimenValintaPanel);
        piirraJaAsetaFokus();
    }
    
    /**
     * Asettaa alkuvalikon näkyviin.
     */
    public void asetaAlkuvalikko() {
        tyhjennaFrame();
        frame.getContentPane().add(alkuvalikkoPanel);
        piirraJaAsetaFokus();
    }
    
    /**
     * Asettaa ohjeen näkyviin.
     */
    public void asetaOhje() {
        tyhjennaFrame();
        frame.getContentPane().add(ohjePanel);
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
            
    
}
