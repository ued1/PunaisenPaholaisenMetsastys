package com.ued1.punaisenpaholaisenmetsastys;

import com.ued1.punaisenpaholaisenmetsastys.hahmot.Monsteri;
import com.ued1.punaisenpaholaisenmetsastys.hahmot.Pelaaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Asepaja;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.HaarniskaKauppa;
import com.ued1.punaisenpaholaisenmetsastys.logiikka.Metsa;
import java.util.Scanner;

public class Main {

    

    // YKSINKERTAINEN TOTEUTUS KEHITYKSEN AVUKSI
    // PALJON COPYPASTEA JA RUMAA KOODIA
    // OIKEA KÄYTTÖLIITTYMÄ TULEE MÖYHEMMIN OMAAN LUOKKAAN
    
    static Asepaja asepaja = new Asepaja();
    static HaarniskaKauppa haarniskakauppa = new HaarniskaKauppa();
    static Pelaaja pelaaja = new Pelaaja("Testipelaaja");
    static Scanner lukija = new Scanner(System.in);
    static Metsa metsa = new Metsa(pelaaja);
    
    public static void main(String[] args) {
        
        tulostaValikko();
                        
        while (pelaaja.onkoElossa()) {
            System.out.print("Komento: ");
            String komento = lukija.nextLine();
            if(komento.equalsIgnoreCase("m")) {
                hoidaMetsa();
            } else if(komento.equalsIgnoreCase("a")) {
                hoidaAsekauppa();
            } else if(komento.equalsIgnoreCase("h")) {
                hoidaHaarniskaKauppa();
            } else if(komento.equalsIgnoreCase("t")) {
                System.out.println(pelaaja.tiedotMerkkijonona());
                System.out.println("");
            } else if(komento.equalsIgnoreCase("c")) {
                System.out.println("+100 rahaa");
                pelaaja.muutaRahoja(100);
            } else if(komento.equalsIgnoreCase("q")) {
                break;
            } else {
                tulostaValikko();
            }
        }
        System.out.println("loppu");
    }
        
        
    private static void tulostaValikko() {
        System.out.println("------------");
        System.out.println("[M]etsa");
        System.out.println("[A]sepaja");
        System.out.println("[H]aarniskakauppa");
        System.out.println("[T]iedot");
        System.out.println("[C]HEAT +100 rahaa");
        System.out.println("[Q]uit");
    }
    
    private static void hoidaAsekauppa() {
        System.out.println("\n---Asepaja---");
        System.out.println(asepaja.hinnastoMerkkijonona());
        System.out.println("Aseesi: " + pelaaja.getAse().nimi());
        System.out.println("Rahaa: " + pelaaja.getRahat());
        System.out.println("");
        while(true) {
            System.out.println("[O]sta ase  [M]yy ase  [L]istaa valikoima\n[T]iedot  [P]alaa takaisin");
            System.out.print("Komento: ");
            String komento = lukija.nextLine();
            if(komento.equalsIgnoreCase("o")) {
                System.out.print("Ostetaan ase numero: ");
                int numero = Integer.parseInt(lukija.nextLine());
                if(asepaja.ostaAse(pelaaja, numero)) {
                    System.out.println("Ase ostettu");
                } else {
                    System.out.println("Ei voi ostaa: ei ole rahaa tai kädessä on jo ase");
                }
            } else if(komento.equalsIgnoreCase("m")) {
                if(asepaja.myyAse(pelaaja)) {
                    System.out.println("Ase myyty");
                } else {
                    System.out.println("Omaa nyrkkiä ei voi myydä");
                }
            } else if(komento.equalsIgnoreCase("t")) {
                System.out.println("");
                System.out.println(pelaaja.tiedotMerkkijonona());
                System.out.println("");
            } else if(komento.equalsIgnoreCase("p")) {
                tulostaValikko();
                break;
            } else if(komento.equalsIgnoreCase("l")) {
                System.out.println("\n---Asepaja---");
                System.out.println(asepaja.hinnastoMerkkijonona());
                System.out.println("\nAseesi: " + pelaaja.getAse().nimi());
                System.out.println("Rahaa: " + pelaaja.getRahat());
            }
        }
        
    }
    
        
    private static void hoidaHaarniskaKauppa() {
        System.out.println("\n---Haarniskakauppa---");
        System.out.println(haarniskakauppa.hinnastoMerkkijonona());
        System.out.println("Haarniskasi: " + pelaaja.getHaarniska().nimi());
        System.out.println("Rahaa: " + pelaaja.getRahat());
        System.out.println("");
        while(true) {
            System.out.println("[O]sta  [L]istaa valikoima\n[T]iedot  [P]alaa takaisin");
            System.out.print("Komento: ");
            String komento = lukija.nextLine();
            if(komento.equalsIgnoreCase("o")) {
                System.out.print("Ostetaan haarniska numero: ");
                int numero = Integer.parseInt(lukija.nextLine());
                if(haarniskakauppa.ostaHaarniska(pelaaja, numero)) {
                    System.out.println("Haarniska ostettu");
                } else {
                    System.out.println("Ei voi ostaa: ei ole rahaa");
                }
            
            } else if(komento.equalsIgnoreCase("t")) {
                System.out.println("");
                System.out.println(pelaaja.tiedotMerkkijonona());
                System.out.println("");
            } else if(komento.equalsIgnoreCase("p")) {
                tulostaValikko();
                break;
            } else if(komento.equalsIgnoreCase("l")) {
                System.out.println("\n---Haarniskakauppa---");
                System.out.println(haarniskakauppa.hinnastoMerkkijonona());
                System.out.println("\nHaarniskasi: " + pelaaja.getHaarniska().nimi());
                System.out.println("Rahaa: " + pelaaja.getRahat());
            }
        }
    }
    
    private static void hoidaMetsa() {
        System.out.println("---METSÄ---");
        System.out.println("[E]tsi monsteri  [L]epää ja parane  [T]iedot  [P]alaa takaisin");
        System.out.println("Vointi: " + pelaaja.getVointi() + "/" + pelaaja.getMaxVointi());
        while(pelaaja.onkoElossa()) {
            
            System.out.print("Komento: ");
            String komento = lukija.nextLine();
            if(komento.equalsIgnoreCase("e")) {
                metsa.taistele();
                System.out.println("[E]tsi monsteri  [L]epää ja parane  [T]iedot  [P]alaa takaisin");
            } else if(komento.equalsIgnoreCase("t")) {
                System.out.println("");
                System.out.println(pelaaja.tiedotMerkkijonona());
                System.out.println("");
            } else if(komento.equalsIgnoreCase("p")) {
                tulostaValikko();
                break;
            } else if(komento.equalsIgnoreCase("l")) {
                pelaaja.paranna();
                System.out.println("Vointi: " + pelaaja.getVointi() + "/" + pelaaja.getMaxVointi());
            } else {
                System.out.println("---METSÄ---");
                System.out.println("[E]tsi monsteri  [L]epää ja parane  [T]iedot  [P]alaa takaisin");
                System.out.println("Vointi: " + pelaaja.getVointi() + "/" + pelaaja.getMaxVointi());
            }
        }
    }
    
    private static void etsiMonsteri() {
        Monsteri uusiMonsteri = new Monsteri(10, 10, 5);
        System.out.println("Löytyi monsteri: ");
        
    }
    
    // YKSINKERTAINEN TOTEUTUS KEHITYKSEN AVUKSI
    // PALJON COPYPASTEA JA RUMAA KOODIA
    // OIKEA KÄYTTÖLIITTYMÄ TULEE MÖYHEMMIN OMAAN LUOKKAAN

}
