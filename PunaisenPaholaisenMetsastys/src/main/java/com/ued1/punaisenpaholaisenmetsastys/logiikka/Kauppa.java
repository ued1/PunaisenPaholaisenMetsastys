package com.ued1.punaisenpaholaisenmetsastys.logiikka;

// Yläluokka kaupoille: Asepaja, Haarniskakauppa, Välinekauppa(TODO)
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.Apu;
import com.ued1.punaisenpaholaisenmetsastys.apuvalineet.KossuPotion;
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
                if (i % 2 == 0) {
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
     * Metodi palauttaa hinnaston, joka sisältää tavaroiden nimien lisäksi hinnan
     * ja järjestyksen hinnastossa. Järjestysnumeroa käytettään hyväksi ostovaiheessa.
     * 
     * @return hinnasto merkkijonona
     */
    public String hinnastoMerkkijonona() {
        String hinnasto = "";
        for (int i = 1; i < valikoima.size(); i++) {
            hinnasto += "" + i + ". " + valikoima.get(i).toString() + "           \t" + hinta(i) + "\n";
        }
        return hinnasto;
    }

    private int hinta(int i) {
        if (valikoima.get(0).getClass() == new Nyrkki().getClass()) {
            return ((Ase) valikoima.get(i)).arvo();
        } else if (valikoima.get(0).getClass() == new Riepu().getClass()) {
            return ((Haarniska) valikoima.get(i)).arvo();
        } else if(valikoima.get(0).getClass() == KossuPotion.class) {
            return ((Apu) valikoima.get(i)).arvo();
        }
        return 0; // TODO
    }

    private boolean hinnastossaAseita() {
        if (valikoima.size() > 0 && valikoima.get(0).getClass() == new Nyrkki().getClass()) {
            return true;
        }
        return false;
    }

}
