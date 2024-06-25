package com.raumschiffspiel;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Sonnensystem {

    // Kapitaene
    private static final Kapitaen alexiaNova = new Kapitaen("Alexia Nova", 8, 6, 10);
    private static final Kapitaen admiralZenithNightfall = new Kapitaen("Admiral Zenith Nightfall", 10, 10, 4.30);

    // Ladungen
    private static final Ladung kisteBier = new Ladung("Kiste Bier", 20, 12.5, 50);
    private static final Ladung steine = new Ladung("Steine", 50, 234, 33);
    private static final Ladung bretter = new Ladung("Bretter", 100, 443.25, 230);
    private static final Ladung schwert = new Ladung("Schwert", 10, 100, 1230);

    private static final ArrayList<Ladung> ladungContainer = new ArrayList<>();

    // Raumschiffe
    private static final Raumschiff eosNova = new Raumschiff.RaumschiffBuilder()
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

    private static final Raumschiff auroraQuest = new Raumschiff.RaumschiffBuilder()
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
    private static final Planet auroria = new Planet("Auroria", false, 5, 3);
    private static final Planet solara = new Planet("Solara", true, 80, 90);
    private static final Planet ktaris = new Planet("Ktaris", true, 30, 90);

    // Asteroidenfelder
    private static final Asteroidfeld asteroidfeld1 = new Asteroidfeld(5, 10, 15);
    private static final Asteroidfeld asteroidfeld2 = new Asteroidfeld(7, 20, 25);
    private static final Asteroidfeld asteroidfeld3 = new Asteroidfeld(9, 30, 35);

    // Listen
    private static final ArrayList<Planet> planets = new ArrayList<>();
    private static final ArrayList<Raumschiff> raumschiffs = new ArrayList<>();
    private static final ArrayList<Asteroidfeld> asteroidfelds = new ArrayList<>();

    // Missionen
    private static final ArrayList<String> missionen = new ArrayList<>();
    private static final ArrayList<Boolean> missionErledigt = new ArrayList<>();

    public static void main(String[] args) {
        // Initiale Ladung hinzufügen
        eosNova.addLadung(kisteBier);
        eosNova.addLadung(steine);

        auroraQuest.addLadung(bretter);
        auroraQuest.addLadung(schwert);

        // Planeten zur Liste hinzufügen
        planets.add(auroria);
        planets.add(solara);
        planets.add(ktaris);

        // Raumschiffe zur Liste hinzufügen
        raumschiffs.add(eosNova);
        raumschiffs.add(auroraQuest);

        // Asteroidenfelder zur Liste hinzufügen
        asteroidfelds.add(asteroidfeld1);
        asteroidfelds.add(asteroidfeld2);
        asteroidfelds.add(asteroidfeld3);

        // Scanner für Benutzereingaben
        Scanner tastatur = new Scanner(System.in);
        char richtung;

        // Setze initiale Ladung auf Planeten
        auroria.setLadung(kisteBier);
        solara.setLadung(kisteBier);
        ktaris.setLadung(kisteBier);

        boolean gameOver = false;

        // Wetterbedingungen
        String[] wetterbedingungen = {"Sonnig", "Stürmisch", "Nebel", "Regen"};
        Random random = new Random();

        // Missionen hinzufügen
        missionen.add("Bringe eine Kiste Bier zu Solara.");
        missionErledigt.add(false);
        missionen.add("Sammle Informationen über das Asteroidfeld bei Position (7, 20).");
        missionErledigt.add(false);
        missionen.add("Handel 100 Bretter auf Ktaris.");
        missionErledigt.add(false);

        System.out.println("Das Spiel beginnt!\n");

        while (!gameOver) {
            alexiaNova.setName("Alexia Starlight Nova");

            // Zufällige Wetterbedingung wählen
            String wetter = wetterbedingungen[random.nextInt(wetterbedingungen.length)];
            System.out.println("Aktuelle Wetterbedingung: " + wetter);
            if (wetter.equals("Stürmisch")) {
                eosNova.setManoevrierFaehigkeit(eosNova.getManoevrierFaehigkeit() - 10);
                System.out.println("Manövrierfähigkeit reduziert wegen stürmischem Wetter!");
            } else {
                eosNova.setManoevrierFaehigkeit(75); // Zurücksetzen auf den Standardwert
            }

            System.out.println("Sie fliegen das " + eosNova);
            System.out.println(eosNova.getKoordinaten());

            System.out.println("Bewegung (a/w/s/d), Missionen prüfen (m), Beenden (q): ");
            richtung = tastatur.nextLine().charAt(0);

            if (richtung == 'q') {
                System.out.println("Weiter (y/n)?");
                if (tastatur.nextLine().charAt(0) == 'n') {
                    gameOver = true;
                    System.out.println("Spiel beendet.");
                }
            }

            if (richtung == 'm') {
                // Überprüfung auf abgeschlossene Missionen
                if (!missionen.isEmpty()) {
                    System.out.println("Aktuelle Missionen:");
                    for (int i = 0; i < missionen.size(); i++) {
                        System.out.println((i + 1) + ". " + missionen.get(i) + " - Erledigt: " + missionErledigt.get(i));
                    }

                    System.out.println("Haben Sie eine Mission abgeschlossen? (Index oder -1 für keine): ");
                    int missionIndex = Integer.parseInt(tastatur.nextLine());
                    if (missionIndex >= 1 && missionIndex <= missionen.size() && !missionErledigt.get(missionIndex - 1)) {
                        missionErledigt.set(missionIndex - 1, true);
                        System.out.println("Mission erfolgreich abgeschlossen!");
                    }
                } else {
                    System.out.println("Keine aktuellen Missionen.");
                }
            } else {
                eosNova.fliegen(richtung);

                // Überprüfung auf Asteroidfelder
                asteroidfelds.forEach(field -> {
                    if (field.getPosX() == eosNova.getPosX() && field.getPosY() == eosNova.getPosY()) {
                        System.out.println("Sie fliegen neben einem Asteroidfeld!");
                        if (eosNova.getKapitaen().getErfahrung() < 5 && field.getGefahrenpotential() > 5 && eosNova.getManoevrierFaehigkeit() <= 60) {
                            eosNova.setIntegritaetsgrad(eosNova.getIntegritaetsgrad() - 5);
                        }
                    }
                });

                // Interaktionen mit Planeten
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
                                System.out.println(eosNova.getName() + " hat die Ladung abgenommen");
                                Handelsstation.ladungAbladen(eosNova, planet, eosNova.getLadung().getFirst());
                            }
                        }

                        if (planet.getLadung() != null) {
                            System.out.println("Ladung aufnehmen (y) oder (n): ");
                            choice = tastatur.nextLine().charAt(0);
                            if (choice == 'y') {
                                System.out.println(eosNova.getName() + " nimmt Ladung auf");
                                Handelsstation.ladungAufnehmen(eosNova, planet, planet.getLadung());
                            }
                        }
                    }
                });

                // Kampf zwischen Raumschiffen prüfen und initiieren
                raumschiffs.forEach(raumschiff -> {
                    if (!raumschiff.equals(eosNova) && eosNova.pruefeKoordniaten(raumschiff)) {
                        eosNova.kämpfen(raumschiff);
                    }
                });
            }
        }
    }
}