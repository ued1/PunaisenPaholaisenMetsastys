package com.ued1.punaisenpaholaisenmetsastys.peli.logiikka;

// Yläluokka kaupoille: Asepaja, Haarniskakauppa, Välinekauppa(TODO)
import com.ued1.punaisenpaholaisenmetsastys.peli.apuvalineet.Apu;
import com.ued1.punaisenpaholaisenmetsastys.peli.apuvalineet.VointiPotion;
import com.ued1.punaisenpaholaisenmetsastys.peli.aseet.Ase;
import com.ued1.punaisenpaholaisenmetsastys.peli.aseet.Nyrkki;
import com.ued1.punaisenpaholaisenmetsastys.peli.haarniskat.Haarniska;
import com.ued1.punaisenpaholaisenmetsastys.peli.haarniskat.Riepu;
import com.ued1.punaisenpaholaisenmetsastys.peli.hahmot.Pelaaja;
import java.util.ArrayList;

/**
 * Abstrakti luokka Kauppa, joka on määritelty geneeriseksi. Kauppa on yläluokka
 * pelissä oleville kaupoille ja määrittelee kauppojen yhteisen
 * toiminnallisuuden. Osto ja myyntitapahtumat tapahtuvat osakseen ylä ja
 * osakseen alaluokissa, riippuen tapahtumien luonteesta. Kaupan valikoima
 * (geneerinen ArrayList) määräytyy alaluokan myyntitavaroiden perusteella.
 *
 * @param <T> kaupan valikoiman olioiden luokka, voi olla esim Ase tai Haarniska
 */
public abstract class Kauppa<T> {

    private ArrayList<T> valikoima;

    /**
     * Konstruktorille annetaan alaluokan tekemä valikoima ArrayListinä.
     *
     * @param uusiValikoima geneerinen ArrayList
     */
    public Kauppa(ArrayList<T> uusiValikoima) {
        valikoima = uusiValikoima;
    }

    /**
     * Metodi palauttaa valikoiman ArrayList-muodossa. Tyyppinä on alaluokan
     * myymien tavaroiden tyyppi.
     *
     * @return valikoima ArrayList-muodossa
     */
    public ArrayList<T> getValikoima() {
        return valikoima;
    }

    /**
     * Abstrakti metodi osta. Pelaajalle ostetaan valikoiman tietyssä indeksissä
     * oleva ostos.
     *
     * @param pelaaja Pelaaja, jolle ostetaan
     * @param ostoksenNumero Ostoksen järjestysnumero valikoimassa.
     * @return totuusarvo, true jos ostaminen onnistui
     */
    public abstract boolean osta(Pelaaja pelaaja, int ostoksenNumero);

    /**
     * Metodi tarkistaa voiko pelaaja ostaa hinnastosta ostoksen.
     *
     * @param pelaaja Pelaaja, joka on tekemässä ostosta
     * @param ostoksenNumero Hinnastossa olevan ostoksen numero
     * @return totuusarvo, joka kertoo onko osto mahdollinen, true jos on
     */
    public boolean voikoPelaajaOstaaOstoksen(Pelaaja pelaaja, int ostoksenNumero) {
        boolean aseEhdot = hinnastossaAseita() && pelaaja.getAse().toString().equals("Nyrkki");
        boolean eiAseita = !hinnastossaAseita();
        if (ostoksenNumero < 1 || ostoksenNumero >= valikoima.size()) {
            return false;
        }
        if (hinnastossaApuja() && pelaaja.onkoPelaajallaApu((Apu) valikoima.get(ostoksenNumero))) {
            return false;
        }

        if ((aseEhdot || eiAseita) && pelaaja.getRahat() >= hinta(ostoksenNumero)) {
            return true;
        }
        return false;
    }

    /**
     * Metodi palauttaa komentovalikkoon sopivan merkkijonon ostettavissa
     * olevista ostokista, sekä [T]akaisin komennon listan lopussa.
     *
     * @param pelaaja Pelaaja, joka on ostamassa kaupan tavaroita
     * @return ostokomennot merkkijonona
     */
    public String ostokomennot(Pelaaja pelaaja) {
        String ostettavatOstokset = "";
        for (int i = 1; i < valikoima.size(); i++) {
            if (voikoPelaajaOstaaOstoksen(pelaaja, i)) {
                if (i > 9) {
                    ostettavatOstokset += String.format("%-3s", " [" + (char) (55 + i));
                } else {
                    ostettavatOstokset += String.format("%-3s", " [" + i);
                }
                ostettavatOstokset += String.format("%-18s", "] " + valikoima.get(i).toString());
                if (i != valikoima.size() - 1 && (i % 2 == 0 || hinnastossaApuja())) {
                    ostettavatOstokset += "\n";
                }
            }
        }
        ostettavatOstokset += "\n [T]akaisin";
        return ostettavatOstokset;
    }

    /**
     * Metodi palauttaa tarinapaneeliin sopivan merkkijonon ostettavissa
     * olevista ostoksista
     *
     * @param pelaaja Pelaaja, joka on ostamassa kaupan tavaroita
     * @return tarinapaneelin ostettavissa olevat tavarat
     */
    public String ostettavissaOlevat(Pelaaja pelaaja) {
        String merkkijono = "";
        if (hinnastossaAseita() && !pelaaja.getAse().toString().equals("Nyrkki")) {
            merkkijono += "\nSinun pitää ensin myydä aseesi";
            merkkijono += "\njotta voit ostaa uuden.";
            return merkkijono;
        }

        if (!voikoPelaajaOstaaOstoksen(pelaaja, 1)) {
            merkkijono += "\nRahasi eivät riitä mihinkään.";
            if (pelaaja.getRahat() == 0) {
                merkkijono += "\n\nSinulla ei ole yhtään rahaa ja";
            } else {
                merkkijono += "\nSinulla on " + pelaaja.getRahat() + " kultarahaa ja";
            }
            merkkijono += "\nhalvin ostos, " + valikoima.get(1).toString();
            merkkijono += ", maksaa " + hinta(1);
            merkkijono += "\nkultarahaa.";
            merkkijono += "\n\nTarvitset lisää rahaa tehdäkseen";
            merkkijono += "\nostoksia täällä.";
        } else {
            merkkijono += "Rahasi riittävät seuraaviin ostoksiin:\n";
            merkkijono += lisaaOstettavissaOlevat(pelaaja);
        }
        return merkkijono;
    }

    private String lisaaOstettavissaOlevat(Pelaaja pelaaja) {
        String ostettavat = "";
        for (int i = 1; i < valikoima.size(); i++) {
            if (voikoPelaajaOstaaOstoksen(pelaaja, i)) {
                ostettavat += String.format("%-20s", " " + valikoima.get(i).toString());
                ostettavat += String.format("%-7s%9d", "hinta: ", hinta(i)) + "\n";
            }
        }
        return ostettavat;
    }

    /**
     * Metodi palauttaa valikoiman, joka sisältää tavaroiden nimien lisäksi
     * tavaran tärkeimmän ominaisuuden ja järjestyksen hinnastossa.
     * Järjestysnumeroa käytettään hyväksi ostovaiheessa.
     *
     * @return valikoima merkkijonona
     */
    public String valikoimaMerkkijonona() {
        String hinnasto = "";

        for (int i = 1; i < valikoima.size(); i++) {
            if (hinnastossaAseita()) {
                hinnasto += String.format("%-12s", " " + valikoima.get(i).toString());
                hinnasto += String.format("%13d     ", hinta(i));

            } else {
                hinnasto += String.format("%-30s", " " + valikoima.get(i).toString());
            }

            hinnasto += String.format("%-10d%s", ominaisuus(i), "\n");
        }
        return hinnasto;
    }

    private int hinta(int i) {
        if (valikoima.get(0).getClass() == new Nyrkki().getClass()) {
            return ((Ase) valikoima.get(i)).arvo();
        } else if (valikoima.get(0).getClass() == new Riepu().getClass()) {
            return ((Haarniska) valikoima.get(i)).arvo();
        } else if (valikoima.get(0).getClass() == VointiPotion.class) {
            return ((Apu) valikoima.get(i)).arvo();
        }
        return 0;
    }

    private int ominaisuus(int i) {
        if (valikoima.get(0).getClass() == new Nyrkki().getClass()) {
            return ((Ase) valikoima.get(i)).lyo();
        } else if (valikoima.get(0).getClass() == new Riepu().getClass()) {
            return ((Haarniska) valikoima.get(i)).suojaa();
        } else if (valikoima.get(0).getClass() == VointiPotion.class) {
            return ((Apu) valikoima.get(i)).arvo();
        }
        return 0;
    }

    private boolean hinnastossaAseita() {
        if (valikoima.size() > 0 && valikoima.get(0).getClass() == new Nyrkki().getClass()) {
            return true;
        }
        return false;
    }

    private boolean hinnastossaApuja() {
        if (valikoima.size() > 0 && valikoima.get(0).getClass() == new VointiPotion(new Pelaaja("Apupelaaja")).getClass()) {
            return true;
        }
        return false;
    }

    private boolean hinnastossaHaarniskoja() {
        if (valikoima.size() > 0 && valikoima.get(0).getClass() == new Riepu().getClass()) {
            return true;
        }
        return false;
    }

}
