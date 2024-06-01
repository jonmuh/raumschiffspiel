package com.raumschiffspiel;

import java.util.Scanner;

public class Sonnensystem {

    // Kapitaene
    private static Kapitaen alexiaNova = new Kapitaen("Alexia Nova", 8, 6);
    private static Kapitaen admiralZenithNightfall = new Kapitaen("Admiral Zenith Nightfall", 10, 10);

    // Raumschiffe
    private static Raumschiff eosNova = new Raumschiff("EosNova", alexiaNova,0,0);
    private static Raumschiff auroraQuest = new Raumschiff("AuroraQuest", admiralZenithNightfall,0,0);

    //Planeten
    private static Planet auroria = new Planet("Auroria", false, 30,40);
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

            System.out.println("Sie fliegen das Raumschiff " + eosNova.getName() + " gesteuert vom Kapitän " + eosNova.getKapitaen().getName());
            System.out.println(eosNova.getKoordinaten());

            System.out.println("Bewegung (a/w/s/d): ");
            richtung = tastatur.nextLine().charAt(0);
            eosNova.fliegen(richtung);

            String obNebenEinemRaumschiff = eosNova.pruefeObNebenEinemRaumschiff(auroraQuest);
            if (obNebenEinemRaumschiff != null) {
                System.out.println(obNebenEinemRaumschiff);
            }

            String obNebenEinemSolara = eosNova.pruefeObAufEinemPlanet(solara);
            if (obNebenEinemSolara != null) {
                System.out.println(obNebenEinemSolara);
            }

            String obNebenEinemAuroria = eosNova.pruefeObAufEinemPlanet(auroria);
            if (obNebenEinemAuroria != null) {
                System.out.println(obNebenEinemAuroria);
            }

            String obNebenEinemKtaris = eosNova.pruefeObAufEinemPlanet(ktaris);
            if (obNebenEinemKtaris != null) {
                System.out.println(obNebenEinemKtaris);
            }

            alexiaNova.setName("Alexia Starlight Nova");



        }
    }

}
