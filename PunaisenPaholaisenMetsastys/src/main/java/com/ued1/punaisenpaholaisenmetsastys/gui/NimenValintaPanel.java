package com.ued1.punaisenpaholaisenmetsastys.gui;

import com.ued1.punaisenpaholaisenmetsastys.tyokalut.NimenValidoija;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JTextField nimikentta;
    private JTextArea virhekentta;
    private final String ohje;

    public NimenValintaPanel(Kyla kyla) {
        this.kyla = kyla;
        this.ohje = luoOhje();
        luoKomponentit();
    }
    
    private String luoOhje() {
        String ohje = "Nimen tulee olla pituudeltaan 2-15 merkkiä";
        ohje += "\npitkä ja koostua suomen kielen aakkosiin";
        ohje += "\nkuuluvista kirjaimista. Nimessä ei saa olla";
        ohje += "\nvälilyöntiä.";
        return ohje;
    }

    private void luoKomponentit() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);

        add(new JLabel(" "));
        
        JLabel valitseNimi = new JLabel("Valitse pelaajanimesi:");
        valitseNimi.setForeground(Color.RED);
        valitseNimi.setAlignmentX(CENTER_ALIGNMENT);
        add(valitseNimi);

        add(new JLabel(" "));

        nimikentta = new JTextField();
        nimikentta.setMaximumSize(new Dimension(100, 25));
        nimikentta.setAlignmentX(CENTER_ALIGNMENT);
        add(nimikentta);

        add(new JLabel(" "));

        virhekentta = new JTextArea(ohje);
        virhekentta.setEditable(false);
        virhekentta.setMaximumSize(new Dimension(300, 75));
        virhekentta.setAlignmentX(CENTER_ALIGNMENT);
        asetaNormaaliVarit();
        lisaaEnterinKuuntelija();
        add(virhekentta);

        add(new JLabel(" "));

        aloita = new JButton("Aloita peli");
        lisaaAloitaKuuntelija();
        add(aloita);

    }

    private void lisaaEnterinKuuntelija() {
        nimikentta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                NimenValidoija validoija = new NimenValidoija();

                if (!validoija.tarkista(nimikentta.getText())) {
                    asetaVirheTila();
                    nimikentta.setText("");
                } else {
                    asetaNormaaliVarit();
                    virhekentta.setText("Nimi on OK, voit aloittaa pelin.");
                }
            }
        });
    }

    private void lisaaAloitaKuuntelija() {
        aloita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                NimenValidoija validoija = new NimenValidoija();

                if (!validoija.tarkista(nimikentta.getText())) {
                    asetaVirheTila();
                    nimikentta.setText("");
                } else {
                    kyla.aloitaUusiPeli(nimikentta.getText());
                }
            }
        });
    }
    
    private void asetaVirheTila() {
        virhekentta.setText(ohje);
        virhekentta.setForeground(Color.WHITE);
        virhekentta.setBackground(Color.RED);
    }
    
    private void asetaNormaaliVarit() {
        virhekentta.setForeground(Color.WHITE);
        virhekentta.setBackground(Color.BLACK);
    }

}
