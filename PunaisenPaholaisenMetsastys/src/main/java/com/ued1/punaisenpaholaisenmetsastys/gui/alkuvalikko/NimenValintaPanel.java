package com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko;

import com.ued1.punaisenpaholaisenmetsastys.gui.alkuvalikko.kuuntelijat.NimenValinnanKuuntelija;
import com.ued1.punaisenpaholaisenmetsastys.gui.Kyla;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * NimenValintaPanel on JPanel nimenvalintaa varten.
 */
public class NimenValintaPanel extends JPanel {

    private Kyla kyla;
    private JButton aloita;
    private JButton takaisin;
    private JRadioButton normaali;
    private JRadioButton helppo;
    private JTextField nimikentta;
    private JTextArea virhekentta;
    private JLabel valitseNimi;
    private JLabel valitseVaikeus;
    private ButtonGroup valintaNapit;
    private NimenValinnanKuuntelija kuuntelija;
    private final String ohje;

    public NimenValintaPanel(Kyla kyla) {
        this.kyla = kyla;
        this.ohje = luoOhje();
        this.aloita = new JButton("Aloita peli");
        this.takaisin = new JButton("Takaisin");
        this.normaali = new JRadioButton("Normaali", true);
        this.helppo = new JRadioButton("Helppo", false);
        this.valintaNapit = new ButtonGroup();
        this.nimikentta = new JTextField("");
        this.virhekentta = new JTextArea(ohje);
        this.kuuntelija = new NimenValinnanKuuntelija(this, kyla, aloita, takaisin, nimikentta, virhekentta, normaali, helppo);
        alusta();
    }

    private String luoOhje() {
        String ohjeTeksti = "Nimen tulee olla pituudeltaan 2-15 merkkiä";
        ohjeTeksti += "\npitkä ja koostua suomen kielen aakkosiin";
        ohjeTeksti += "\nkuuluvista kirjaimista. Nimessä ei saa olla";
        ohjeTeksti += "\nvälilyöntiä.";
        return ohjeTeksti;
    }

    private void alusta() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);

        nimikentta.setMaximumSize(new Dimension(100, 25));
        nimikentta.setAlignmentX(CENTER_ALIGNMENT);
        virhekentta.setEditable(false);
        virhekentta.setPreferredSize(new Dimension(300, 75));
        virhekentta.setMaximumSize(new Dimension(300, 75));
        virhekentta.setMinimumSize(new Dimension(300, 75));
        virhekentta.setAlignmentX(CENTER_ALIGNMENT);

        valitseNimi = new JLabel("Valitse pelaajanimesi");
        valitseNimi.setFont(new Font("Dialog", Font.BOLD, 15));
        valitseNimi.setForeground(Color.RED);
        valitseNimi.setAlignmentX(CENTER_ALIGNMENT);

        valitseVaikeus = new JLabel("Valitse vaikeusaste");
        valitseVaikeus.setFont(new Font("Dialog", Font.BOLD, 15));
        valitseVaikeus.setForeground(Color.RED);
        valitseVaikeus.setAlignmentX(CENTER_ALIGNMENT);

        valintaNapit.add(normaali);
        valintaNapit.add(helppo);
        normaali.setBackground(Color.BLACK);
        normaali.setForeground(Color.WHITE);
        helppo.setBackground(Color.BLACK);
        helppo.setForeground(Color.WHITE);

        asetaNormaaliTila();
        lisaaKuuntelijat();
        lisaaKomponentit();

    }

    private void lisaaKomponentit() {
        add(new JLabel(" "));
        add(new JLabel(" "));
        add(valitseNimi);
        add(new JLabel(" "));
        add(nimikentta);
        add(new JLabel(" "));
        add(virhekentta);
        add(new JLabel(" "));
        add(valitseVaikeus);
        add(new JLabel(" "));
        add(normaali);
        add(helppo);
        add(new JLabel(" "));
        add(new JLabel(" "));
        add(aloita);
        add(new JLabel(" "));
        add(takaisin);
    }

    private void lisaaKuuntelijat() {
        nimikentta.addActionListener(kuuntelija);
        aloita.addActionListener(kuuntelija);
        takaisin.addActionListener(kuuntelija);
        normaali.addActionListener(kuuntelija);
        helppo.addActionListener(kuuntelija);
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
