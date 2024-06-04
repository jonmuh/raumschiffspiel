package com.raumschiffspiel;

import java.util.ArrayList;
import java.util.Scanner;

public class Sonnensystem {

    // Kapitaene
    private static Kapitaen alexiaNova = new Kapitaen("Alexia Nova", 8, 6, 10);
    private static Kapitaen admiralZenithNightfall = new Kapitaen("Admiral Zenith Nightfall", 10, 10, 4.30);

    // Ladungen
    private static Ladung kisteBier = new Ladung("Kiste Bier", 20, 12.5, 50);
    private static Ladung steine = new Ladung("Steine", 50, 234, 33);
    private static Ladung bretter = new Ladung("Bretter", 100, 443.25, 230);
    private static Ladung schwert = new Ladung("Schwert", 10, 100, 1230);

    //
    private static ArrayList<Ladung> ladungContainer = new ArrayList<>();

    // Raumschiffe
    private static Raumschiff eosNova = new Raumschiff.RaumschiffBuilder()
            .name("Eos Nova")
            .kapitaen(alexiaNova)
            .posX(0)
            .posY(0)
            .integritaetsgrad(100)
            .manoevrierFaehigkeit(75)
            .energieschild(100)
            .waffenstaerke(87)
            .energieVersorgung(7.5)
            .raketenWaffenStaerke(45)
            .laserWaffenstaerke(12)
            .ladung(ladungContainer)
            .build();

    private static Raumschiff auroraQuest = new Raumschiff.RaumschiffBuilder()
            .name("Aurora Quest")
            .kapitaen(admiralZenithNightfall)
            .posX(3)
            .posY(3)
            .integritaetsgrad(100)
            .manoevrierFaehigkeit(65)
            .energieschild(100)
            .waffenstaerke(60)
            .energieVersorgung(5.3)
            .raketenWaffenStaerke(30)
            .laserWaffenstaerke(15)
            .ladung(ladungContainer)
            .build();

    // Planeten
    private static Planet auroria = new Planet("Auroria", false, 5,3);
    private static Planet solara = new Planet("Solara", true, 80,90);
    private static Planet ktaris = new Planet("Ktaris", true, 30, 90);


    // Asteroidenfelder
    private static Asteroidfeld asteroidfeld1 = new Asteroidfeld(5, 10, 15);
    private static Asteroidfeld asteroidfeld2 = new Asteroidfeld(7, 20, 25);
    private static Asteroidfeld asteroidfeld3 = new Asteroidfeld(9, 30, 35);

    // Listen
    private static ArrayList<Planet> planets = new ArrayList<Planet>();
    private static ArrayList<Raumschiff> raumschiffs = new ArrayList<Raumschiff>();
    private static ArrayList<Asteroidfeld> asteroidfelds = new ArrayList<Asteroidfeld>();

    public static void main(String[] args) {

        eosNova.addLadung(kisteBier);
        eosNova.addLadung(steine);

        auroraQuest.addLadung(bretter);
        auroraQuest.addLadung(schwert);

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

            System.out.println("Sie fliegen das " + eosNova.toString());
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
                    System.out.println("Sie befinden sich auf dem " + planet);
                    if (planet.getAtmosphaere()) {
                        System.out.println("Der Planet " + planet.getName() + " hat eine Atmosphere");
                    } else {
                        System.out.println("Der Planet " + planet.getName() + " hat keine Atmosphere");
                    }
                    System.out.println("Der Planet " + planet.getName() + " hat die Ladung: " + planet.getLadung());
                    char choice;
                    if (!eosNova.getLadung().isEmpty()) {
                        System.out.println("Ladungen abgeben (y) oder (n): ");
                        choice = tastatur.nextLine().charAt(0);
                        if (choice == 'y') {
                            System.out.println(eosNova.getName() + " hat an Board die Ladungen: ");
                            eosNova.getLadung().forEach(System.out::println);
                            System.out.println("Index der Ladung zum abgeben: ");
                            int indexOfLadung = Integer.parseInt(tastatur.nextLine());
                            Handelsstation.ladungAbladen(eosNova, planet, eosNova.getLadung().get(indexOfLadung));
                        }
                    } else if (planet.getLadung() != null) {
                        System.out.println("Der planet " + planet.getName() + " hat die Ladung: " + planet.getLadung());
                        System.out.println("Ladung aufnehmen (y) oder (n): ");
                        choice = tastatur.nextLine().charAt(0);
                        if (choice == 'y') {
                            Handelsstation.ladungAufnehmen(eosNova, planet, planet.getLadung());
                        }
                    }
                    System.out.println("Nun haben Sie die Möglichkeit ihre Nachrichten in dem Nachrichtenarchiv zu speichern (y) oder (n): ");
                    choice = tastatur.nextLine().charAt(0);
                    if (choice == 'y') {
                        System.out.println("1. Nachricht an das Archiv senden");
                        System.out.println("2. Alle Nachrichten anzeigen");
                        int auswahl = Integer.parseInt(tastatur.nextLine());
                        if (auswahl == 1) {
                            System.out.println("Geben Sie die Nachricht ein: ");
                            String nachricht = tastatur.nextLine();
                            Nachrichtenarchiv.nachrichtHinzufuegen(nachricht);
                            System.out.println("Nachricht hinzugefügt!");
                        } else if (auswahl == 2) {
                            System.out.println("Alle Nachrichten im Archiv:");
                            ArrayList<String> alleNachrichten = Nachrichtenarchiv.alleNachrichten();
                            alleNachrichten.forEach(System.out::println);
                        }
                    }
                }
            });

            raumschiffs.forEach(raumschiff -> {
                if (eosNova.pruefeKoordniaten(raumschiff) && raumschiff != eosNova) {
                    System.out.println("Hier ist das " + raumschiff);
                    System.out.println("Angreifen (y) oder (n): ");
                    char choice = tastatur.nextLine().charAt(0);
                    if (choice == 'y') {
                        System.out.println("Raketengriff (1) oder Laserangriff (2): ");
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

    class Nachrichtenarchiv {
        private static ArrayList<String> nachrichten = new ArrayList<>();

        public static void nachrichtHinzufuegen(String nachricht) {
            nachrichten.add(nachricht);
        }

        public static ArrayList<String> alleNachrichten() {
            return new ArrayList<>(nachrichten);
        }
    }

}
