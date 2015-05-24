package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Hahmo;

public class Taistelu {

    private final Hahmo ekaTaistelija;
    private final Hahmo tokaTaistelija;
    private int ekaIsku;
    private int tokaIsku;

    public Taistelu(Hahmo eka, Hahmo toka) {
        ekaTaistelija = eka;
        tokaTaistelija = toka;
        ekaIsku = -999;
        tokaIsku = -999;
    }

    public boolean taistele() {
        ekaIsku = Math.max(0, ekaTaistelija.lyo() - tokaTaistelija.suojaa());
        laskeVointia(tokaTaistelija, ekaIsku);
        if (!tokaTaistelija.onkoElossa()) {
            return true;
        }
        tokaIsku = Math.max(0, tokaTaistelija.lyo() - ekaTaistelija.suojaa());
        laskeVointia(ekaTaistelija, tokaIsku);
        if (!ekaTaistelija.onkoElossa()) {
            return true;
        }
        return false;
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
