package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.NimenValinnanKuuntelija;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * NimenValintaPanel on JPanel nimenvalintaa varten.
 */
public class NimenValintaPanel extends JPanel {

    private Kyla kyla;
    private JButton aloita;
    private JButton takaisin;
    private JTextField nimikentta;
    private JTextArea virhekentta;
    private NimenValinnanKuuntelija kuuntelija;
    private final String ohje;

    public NimenValintaPanel(Kyla kyla) {
        this.kyla = kyla;
        this.ohje = luoOhje();
        this.aloita = new JButton("Aloita peli");
        this.takaisin = new JButton("Takaisin");
        this.nimikentta = new JTextField("");
        this.virhekentta = new JTextArea(ohje);
        this.kuuntelija = new NimenValinnanKuuntelija(this, kyla, aloita, takaisin, nimikentta, virhekentta);
        
        luoKomponentit();
    }
    
    private String luoOhje() {
        String ohjeTeksti = "Nimen tulee olla pituudeltaan 2-15 merkkiä";
        ohjeTeksti += "\npitkä ja koostua suomen kielen aakkosiin";
        ohjeTeksti += "\nkuuluvista kirjaimista. Nimessä ei saa olla";
        ohjeTeksti += "\nvälilyöntiä.";
        return ohjeTeksti;
    }

    private void luoKomponentit() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);
        nimikentta.setMaximumSize(new Dimension(100, 25));
        nimikentta.setAlignmentX(CENTER_ALIGNMENT);
        virhekentta.setEditable(false);
        virhekentta.setPreferredSize(new Dimension(300, 75));
        virhekentta.setMaximumSize(new Dimension(300, 75));
        virhekentta.setMinimumSize(new Dimension(300, 75));
        virhekentta.setAlignmentX(CENTER_ALIGNMENT);
        
        JLabel valitseNimi = new JLabel("Valitse pelaajanimesi:");
        valitseNimi.setForeground(Color.RED);
        valitseNimi.setAlignmentX(CENTER_ALIGNMENT);
        
        asetaNormaaliTila();
        lisaaKuuntelijat();
        
        add(new JLabel(" "));
        add(new JLabel(" "));
        add(valitseNimi);
        add(new JLabel(" "));
        add(nimikentta);
        add(new JLabel(" "));
        add(virhekentta);
        add(new JLabel(" "));
        add(aloita);
        add(new JLabel(" "));
        add(takaisin);
        
    }
    
    private void lisaaKuuntelijat() {
        nimikentta.addActionListener(kuuntelija);
        aloita.addActionListener(kuuntelija);
        takaisin.addActionListener(kuuntelija);
    }
    
    
    /**
     * Asettaa epäkelvosta pelaajanimestä johtuvat virhetilan näkyviin.
     */
    public void asetaVirheTila() {
        virhekentta.setText(ohje);
        virhekentta.setForeground(Color.WHITE);
        virhekentta.setBackground(Color.RED);
    }
    
    /**
     * Asettaa epäkelvosta pelaajanimestä johtuneen virhetilan takaisin
     * normaaliksi.
     */
    public void asetaNormaaliTila() {
        virhekentta.setForeground(Color.WHITE);
        virhekentta.setBackground(Color.BLACK);
    }

}
