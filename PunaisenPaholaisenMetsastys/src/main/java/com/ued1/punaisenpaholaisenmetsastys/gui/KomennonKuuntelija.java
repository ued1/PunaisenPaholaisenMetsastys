
package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.Paikka;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KomennonKuuntelija implements KeyListener {
    
    private Pelaaja pelaaja;
    private TarinaPanel tarinaPanel;
    private PelaajaTietoPanel pelaajaTietoPanel;
    
    public KomennonKuuntelija(Pelaaja pelaaja, TarinaPanel tarinaPanel, PelaajaTietoPanel pelaajaTietoPanel) {
        this.pelaaja = pelaaja;
        this.tarinaPanel = tarinaPanel;
        this.pelaajaTietoPanel = pelaajaTietoPanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        
        
        /*
        
        main:       [M]etsä
                    [T]aisteluAreena
                    [A]sekauppa
                    [H]aarniskakauppa
                
        metsä:      [E]tsi monsteri
                    [L]epää
                    [T]akaisin
        
        taistelu:   [L]yö
                    [J]uokse
        
        asekauppa:  [O]sta
                    [M]yy
                    [T]akaisin
        
        haarniska:  [O]sta
                    [T]akaisin
        
        
                
                
        
        
        
        
        
        
        
        
        
        
        
        
                
                
                
                
                
                
                
                
                
        
                
        */
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    
}
