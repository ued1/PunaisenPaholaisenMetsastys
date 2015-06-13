package com.ued1.punaisenpaholaisenmetsastys.logiikka;

// Yläluokka kaupoille: Asepaja, Haarniskakauppa, Välinekauppa(TODO)
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.Apu;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.KossuPotion;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.VihannesPotion;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Ase;
import com.ued1.punaisenpaholaisenmetsastys.aseet.Nyrkki;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Haarniska;
import com.ued1.punaisenpaholaisenmetsastys.haarniskat.Riepu;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
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
        if(hinnastossaApuja() && pelaaja.onkoPelaajallaApu((Apu)valikoima.get(ostoksenNumero))) {
            return false;
        }
        
        if ((aseEhdot || eiAseita) && ostoksenNumero > 0 && ostoksenNumero < valikoima.size() && pelaaja.getRahat() >= hinta(ostoksenNumero)) {
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
                    ostettavatOstokset += "[" + (char) (55 + i);
                } else {
                    ostettavatOstokset += "[" + i;
                }
                ostettavatOstokset += "] " + valikoima.get(i).toString();
                if (hinnastossaHaarniskoja() && (i == 1 || i == 3 || i == 9)) {
                    ostettavatOstokset += "      \t";
                } else if (i % 2 == 0 || hinnastossaApuja()) {
                    ostettavatOstokset += "\n";
                } else {
                    ostettavatOstokset += "\t";
                }
            }
        }
        ostettavatOstokset += "[T]akaisin";
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
                ostettavat += valikoima.get(i).toString();
                if (hinnastossaHaarniskoja() && (i < 4 || i > 8)) {
                    ostettavat += "         \t";
                } else {
                    ostettavat += "\t";
                }
                ostettavat += "hinta: " + hinta(i) + "\n";
            }
        }
        return ostettavat;
    }

    /**
     * Metodi palauttaa hinnaston, joka sisältää tavaroiden nimien lisäksi
     * hinnan ja järjestyksen hinnastossa. Järjestysnumeroa käytettään hyväksi
     * ostovaiheessa.
     *
     * @return hinnasto merkkijonona
     */
    public String hinnastoMerkkijonona() {
        String hinnasto = "";
        for (int i = 1; i < valikoima.size(); i++) {
            hinnasto += "" + i + ". " + valikoima.get(i).toString();
            if (valikoima.get(i).toString().length() > 10) {
                hinnasto += "\t" + arvo(i) + "\n";
            } else {
                hinnasto += "\t\t" + arvo(i) + "\n";
            }
        }
        return hinnasto;
    }

    private int hinta(int i) {
        if (valikoima.get(0).getClass() == new Nyrkki().getClass()) {
            return ((Ase) valikoima.get(i)).arvo();
        } else if (valikoima.get(0).getClass() == new Riepu().getClass()) {
            return ((Haarniska) valikoima.get(i)).arvo();
        } else if (valikoima.get(0).getClass() == KossuPotion.class) {
            return ((Apu) valikoima.get(i)).arvo();
        }
        return 0;
    }

    private int arvo(int i) {
        if (valikoima.get(0).getClass() == new Nyrkki().getClass()) {
            return ((Ase) valikoima.get(i)).lyo();
        } else if (valikoima.get(0).getClass() == new Riepu().getClass()) {
            return ((Haarniska) valikoima.get(i)).suojaa();
        } else if (valikoima.get(0).getClass() == KossuPotion.class) {
            return ((Apu) valikoima.get(i)).arvo();                 // TODO
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
        if (valikoima.size() > 0 && valikoima.get(0).getClass() == new VihannesPotion().getClass()) {
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
