
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.KomennonKuuntelija;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Metsa;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Kyla implements Runnable {
    
    private JFrame frame;
    private Pelaaja pelaaja;
    private TarinaPanel tarinaPanel;
    private Metsa metsa;
    
    public Kyla(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.metsa = new Metsa(pelaaja);
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
        PelaajaTietoPanel pelaajaTietoPanel = new PelaajaTietoPanel(pelaaja);
        tarinaPanel = new TarinaPanel(pelaaja, metsa);
        container.add(pelaajaTietoPanel, BorderLayout.EAST);
        container.add(tarinaPanel);
        frame.addKeyListener(new KomennonKuuntelija(pelaaja,tarinaPanel,pelaajaTietoPanel,metsa));
    }
        
    
}
