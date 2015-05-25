
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.KomennonKuuntelija;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Areena;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Metsa;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Kyla implements Runnable {
    
    private JFrame frame;
    private Pelaaja pelaaja;
    private TarinaPanel tarinaPanel;
    private Metsa metsa;
    private Areena areena;
    
    public Kyla(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.metsa = new Metsa(pelaaja);
        this.areena = new Areena(pelaaja);
    }
        
    @Override
    public void run() {
        frame = new JFrame("PunaisenPaholaisenMetsastys");
        frame.setPreferredSize(new Dimension(600,600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(1,2));
        PelaajaTietoPanel pelaajaTietoPanel = new PelaajaTietoPanel(pelaaja);
        tarinaPanel = new TarinaPanel(pelaaja, metsa, areena);
        container.add(tarinaPanel);
        container.add(pelaajaTietoPanel);
        frame.addKeyListener(new KomennonKuuntelija(pelaaja,tarinaPanel,pelaajaTietoPanel,metsa, areena));
    }
        
    
}
