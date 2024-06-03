package com.raumschiffspiel;

import java.util.Scanner;

public class Sonnensystem {

    // Kapitaene
    private static Kapitaen alexiaNova = new Kapitaen("Alexia Nova", 8, 6);
    private static Kapitaen admiralZenithNightfall = new Kapitaen("Admiral Zenith Nightfall", 10, 10);

    // Raumschiffe
//    private static Raumschiff eosNova = new Raumschiff("EosNova", alexiaNova,0,0);
    private static Raumschiff eosNova = new Raumschiff
            .RaumschiffBuilder()
            .name("EosNova")
            .kapitaen(alexiaNova)
            .posX(0)
            .posY(0)
            .build();
    private static Raumschiff auroraQuest = new Raumschiff("AuroraQuest", admiralZenithNightfall,0,0);

    //Planeten
    private static Planet auroria = new Planet("Auroria", false, 5,3);
    private static Planet solara = new Planet("Solara", true, 80,90);
    private static Planet ktaris = new Planet("Ktaris", true, 30, 90);

    //Ladungen
    private static Ladung kisteBier = new Ladung("Kiste Bier", 20);
    private static Ladung steine = new Ladung("Steine", 50);
    private static Ladung bretter = new Ladung("Bretter", 100);
    private static Ladung schwert = new Ladung("Schwert", 10);

    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);
        char richtung;

        auroria.setLadung(kisteBier);
        solara.setLadung(kisteBier);
        ktaris.setLadung(kisteBier);

        boolean gameOver = false;

        System.out.println("Das Spiel beginnt!\n");

        while(!gameOver) {

            alexiaNova.setName("Alexia Starlight Nova");

            System.out.println("Sie fliegen das Raumschiff " + eosNova.getName() + " gesteuert vom Kapitän " + eosNova.getKapitaen().getName());
            System.out.println(eosNova.getKoordinaten());

            System.out.println("Bewegung (a/w/s/d): ");
            richtung = tastatur.nextLine().charAt(0);
            eosNova.fliegen(richtung);

            String obNebenEinemRaumschiff = eosNova.pruefeObNebenEinemRaumschiff(auroraQuest);
            if (obNebenEinemRaumschiff != null) {
                System.out.println(obNebenEinemRaumschiff);
            }

            String obAufEinemSolara = eosNova.pruefeObAufEinemPlanet(solara);
            if (obAufEinemSolara != null) {
                System.out.println(obAufEinemSolara);
                System.out.println("Der Planet " + solara.getName() + " hat die Ladung: " + solara.getLadung().getName());
                System.out.println("Ladung aufnehmen (y) oder (n): ");
                char choice = tastatur.nextLine().charAt(0);
                if (choice == 'y') {
                    eosNova.setLadung(solara.getLadung());
                    solara.setLadung(null);
                }
                if (solara.getLadung() == null) {
                    System.out.println("Ladung abgeben (y) oder (n): ");
                    choice = tastatur.nextLine().charAt(0);
                    if (choice == 'y') {
                        solara.setLadung(solara.getLadung());
                        eosNova.setLadung(null);
                    }
                }
            }

            String obAufAuroria = eosNova.pruefeObAufEinemPlanet(auroria);
            if (obAufAuroria != null) {
                System.out.println(obAufAuroria);
                System.out.println("Der Planet " + auroria.getName() + " hat die Ladung: " + auroria.getLadung().getName());
                System.out.println("Ladung aufnehmen (y) oder (n): ");
                char choice = tastatur.nextLine().charAt(0);
                if (choice == 'y') {
                    eosNova.setLadung(auroria.getLadung());
                    auroria.setLadung(null);
                }
                if (auroria.getLadung() == null) {
                    System.out.println("Ladung abgeben (y) oder (n): ");
                    choice = tastatur.nextLine().charAt(0);
                    if (choice == 'y') {
                        auroria.setLadung(auroria.getLadung());
                        eosNova.setLadung(null);
                    }
                }
            }

            String obAufEinemKtaris = eosNova.pruefeObAufEinemPlanet(ktaris);
            if (obAufEinemKtaris != null) {
                System.out.println(obAufEinemKtaris);
                System.out.println("Der Planet " + ktaris.getName() + " hat die Ladung: " + ktaris.getLadung().getName());
                System.out.println("Ladung aufnehmen (y) oder (n): ");
                char choice = tastatur.nextLine().charAt(0);
                if (choice == 'y') {
                    eosNova.setLadung(ktaris.getLadung());
                    ktaris.setLadung(null);
                }
                if (ktaris.getLadung() == null) {
                    System.out.println("Ladung abgeben (y) oder (n): ");
                    choice = tastatur.nextLine().charAt(0);
                    if (choice == 'y') {
                        ktaris.setLadung(eosNova.getLadung());
                        eosNova.setLadung(null);
                    }
                }
            }
        }
    }

}
