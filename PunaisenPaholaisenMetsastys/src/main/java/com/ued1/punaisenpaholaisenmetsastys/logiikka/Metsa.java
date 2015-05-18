
package com.ued1.punaisenpaholaisenmetsastys.logiikka;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Monsteri;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import java.util.Scanner;

public class Metsa {
    // taistellaan monstereita vastaan
    // monsterit luodaan lennosta, arvotaan pelaajan tasolle sopiva vastus
    // monsterin voittaessa pelaajan rahat kasvavat
       
    private Pelaaja pelaaja;
    private Taistelu taistelu;
    private Scanner lukija = new Scanner(System.in);
    
    public Metsa(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }
    
    public Monsteri etsiUusiMonsteriTaisteluun() {
        int monsterinVointi = 20; // TODO: arvotaan sopiva arvo
        int monsterinVoima = 4; // TODO: arvotaan sopiva arvo
        int monsterinPuolustus = 3; // TODO: arvotaan sopiva arvo
        Monsteri monsteri = new Monsteri(monsterinVointi, monsterinVoima, monsterinPuolustus);
        return monsteri;
    }

    // TODO: parempi toteutus
    public void taistele() {
        Monsteri vastustaja = etsiUusiMonsteriTaisteluun();
        taistelu = new Taistelu(pelaaja,vastustaja);
        System.out.println("---Taistelu---");
        System.out.println(pelaaja.getNimi() + ":");
        System.out.println("\tVointi: " + pelaaja.getVointi() + "/" + pelaaja.getMaxVointi());
        System.out.println("\tVoima: " + pelaaja.lyo());
        System.out.println("\tPuolustus " + pelaaja.suojaa());
        System.out.println(vastustaja.getNimi() + ":");
        System.out.println("\tVointi: " + vastustaja.getVointi() + "/" + vastustaja.getMaxVointi());
        System.out.println("\tVoima: " + vastustaja.lyo());
        System.out.println("\tPuolustus " + vastustaja.suojaa());
        
        // TODO: parempi toteutus
        while(pelaaja.onkoElossa() && vastustaja.onkoElossa()) {
            System.out.println("[L]lyö tai [P]akene");
            System.out.print("Komento: ");
            String komento = lukija.nextLine();
            if(komento.equalsIgnoreCase("p")) { // muita komentoja ei määritelty
                break;
            }
            taistelu.taistele();
            System.out.println(pelaaja.getNimi() + ":");
            System.out.println("\tVointi: " + pelaaja.getVointi() + "/" + pelaaja.getMaxVointi());
            System.out.println(vastustaja.getNimi() + ":");
            System.out.println("\tVointi: " + vastustaja.getVointi() + "/" + vastustaja.getMaxVointi());
        }
        
        if(pelaaja.onkoElossa() && vastustaja.onkoElossa()) {
            System.out.println("Taistelu keskeentyi");
        } else if(pelaaja.onkoElossa()) {
            System.out.println("Taistelu loppui, voitit!");
            pelaaja.muutaRahoja(10); // TODO: arvo sopiva luku
        } else {
            System.out.println("Taistelu loppui, hävisit.");
            // TODO: jotain
        }
        
    }
    
    
}
