package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Hahmo;
import java.util.Random;

public class Taistelu {

    private final Hahmo ekaTaistelija;
    private final Hahmo tokaTaistelija;
    private int ekaIsku;
    private int tokaIsku;
    private Random random;

    public Taistelu(Hahmo eka, Hahmo toka) {
        ekaTaistelija = eka;
        tokaTaistelija = toka;
        ekaIsku = -999;
        tokaIsku = -999;
        random = new Random();
    }

    public boolean taistele() {
        ekaIsku = Math.max(1, laskeLyontiVoima(ekaTaistelija.lyo(), tokaTaistelija.suojaa()));
        laskeVointia(tokaTaistelija, ekaIsku);
        if (!tokaTaistelija.onkoElossa()) {
            ekaIsku = -999;
            tokaIsku = -999;
            return true;
        }
        tokaIsku = Math.max(0, laskeLyontiVoima(tokaTaistelija.lyo(), ekaTaistelija.suojaa()));
        laskeVointia(ekaTaistelija, tokaIsku);
        if (!ekaTaistelija.onkoElossa()) {
            ekaIsku = -999;
            tokaIsku = -999;
            return true;
        }
        return false;
    }
    
    public boolean onkoAlkanut() {
        if(ekaIsku > -1 && tokaIsku > -1) {
            return true;
        }
        return false;
    }
    
    private int laskeLyontiVoima(int lyonti, int suojaus) {
        int osuma = lyonti/2 + random.nextInt(lyonti/2 + 1) - suojaus;
        return osuma;
    }

    private void laskeVointia(Hahmo kenen, int paljonko) {
        for (int i = 0; i < paljonko; i++) {
            kenen.laskeVointia();
        }
    }

    public int getEkaIsku() {
        return ekaIsku;
    }

    public int getTokaIsku() {
        return tokaIsku;
    }
    
    public Hahmo vastustaja() {
        return tokaTaistelija;
    }

}
