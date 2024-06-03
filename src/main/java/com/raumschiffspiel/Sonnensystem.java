package com.raumschiffspiel;

import java.util.ArrayList;
import java.util.Scanner;

public class Sonnensystem {

    // Kapitaene
    private static Kapitaen alexiaNova = new Kapitaen("Alexia Nova", 8, 6);
    private static Kapitaen admiralZenithNightfall = new Kapitaen("Admiral Zenith Nightfall", 10, 10);

    // Raumschiffe
    private static Raumschiff eosNova = new Raumschiff
            .RaumschiffBuilder()
            .name("EosNova")
            .kapitaen(alexiaNova)
            .posX(0)
            .posY(0)
            .integritaetsgrad(100)
            .manoevrierFaehigkeit(75)
            .energieschild(100)
            .waffenstaerke(87)
            .energieVersorgung(7.5)
            .raketenWaffenStaerke(65)
            .laserWaffenstaerke(86)
            .build();
    private static Raumschiff auroraQuest = new Raumschiff("AuroraQuest", admiralZenithNightfall,0,0);

    // Planeten
    private static Planet auroria = new Planet("Auroria", false, 5,3);
    private static Planet solara = new Planet("Solara", true, 80,90);
    private static Planet ktaris = new Planet("Ktaris", true, 30, 90);

    // Ladungen
    private static Ladung kisteBier = new Ladung("Kiste Bier", 20);
    private static Ladung steine = new Ladung("Steine", 50);
    private static Ladung bretter = new Ladung("Bretter", 100);
    private static Ladung schwert = new Ladung("Schwert", 10);

    // Asteroidenfelder
    private static Asteroidfeld asteroidfeld1 = new Asteroidfeld(5, 10, 15);
    private static Asteroidfeld asteroidfeld2 = new Asteroidfeld(7, 20, 25);
    private static Asteroidfeld asteroidfeld3 = new Asteroidfeld(9, 30, 35);

    // Listen
    private static ArrayList<Planet> planets = new ArrayList<Planet>();
    private static ArrayList<Ladung> ladungs = new ArrayList<Ladung>();
    private static ArrayList<Kapitaen> kapitaens = new ArrayList<Kapitaen>();
    private static ArrayList<Raumschiff> raumschiffs = new ArrayList<Raumschiff>();
    private static ArrayList<Asteroidfeld> asteroidfelds = new ArrayList<Asteroidfeld>();

    public static void main(String[] args) {

        planets.add(auroria);
        planets.add(solara);
        planets.add(ktaris);

        raumschiffs.add(eosNova);
        raumschiffs.add(auroraQuest);

        asteroidfelds.add(asteroidfeld1);
        asteroidfelds.add(asteroidfeld2);
        asteroidfelds.add(asteroidfeld3);

        Scanner tastatur = new Scanner(System.in);
        char richtung;

        auroria.setLadung(kisteBier);
        solara.setLadung(kisteBier);
        ktaris.setLadung(kisteBier);

        boolean gameOver = false;

        System.out.println("Das Spiel beginnt!\n");

        while(!gameOver) {

            alexiaNova.setName("Alexia Starlight Nova");

            System.out.println("Sie fliegen das Raumschiff " + eosNova.toString());
            System.out.println(eosNova.getKoordinaten());

            System.out.println("Bewegung (a/w/s/d): ");
            richtung = tastatur.nextLine().charAt(0);
            eosNova.fliegen(richtung);

            asteroidfelds.forEach(field -> {
                if (field.getPosX() == eosNova.getPosX() && field.getPosY() == eosNova.getPosY()) {
                    System.out.println("Sie fliegen neben einem Asteroidfeld!");
                    if (eosNova.getKapitaen().getErfahrung() < 5 && field.getGefahrenpotential() > 5 && eosNova.getManoevrierFaehigkeit() <= 60) {
                        eosNova.setIntegritaetsgrad(eosNova.getIntegritaetsgrad() - 5);
                    }
                }
            });

            planets.forEach(planet -> {
                if (eosNova.pruefeKoordniaten(planet)) {
                    System.out.println("Sie befinden sich auf dem " + planet.toString());
                    if (planet.getAtmosphaere()) {
                        System.out.println("Der Planet " + planet.getName() + " hat eine Atmosphere");
                    } else {
                        System.out.println("Der Planet " + planet.getName() + " hat keine Atmosphere");
                    }
                    System.out.println("Der Planet " + planet.getName() + " hat die Ladung: " + planet.getLadung().getName());
                    System.out.println("Ladung aufnehmen (y) oder (n): ");
                    char choice = tastatur.nextLine().charAt(0);
                    if (choice == 'y') {
                        eosNova.setLadung(planet.getLadung());
                        planet.setLadung(null);
                    }
                    if (planet.getLadung() == null) {
                        System.out.println("Ladung abgeben (y) oder (n): ");
                        choice = tastatur.nextLine().charAt(0);
                        if (choice == 'y') {
                            planet.setLadung(eosNova.getLadung());
                            eosNova.setLadung(null);
                        }
                    }
                }
            });

            raumschiffs.forEach(raumschiff -> {
                if (eosNova.pruefeKoordniaten(raumschiff)) {
                    System.out.println("Hier ist das " + raumschiff.toString());
                    System.out.println("Angreifen (y) oder (n): ");
                    char choice = tastatur.nextLine().charAt(0);
                    if (choice == 'y') {
                        System.out.println("Raketengriff(1) oder Laserangriff(2): ");
                        int weapon = Integer.parseInt(tastatur.nextLine());
                        if (weapon == 1) {
                            eosNova.raketenAngriff(raumschiff);
                        } else {
                            eosNova.laserAngriff(raumschiff);
                        }
                    }
                }
            });
        }
    }

}
