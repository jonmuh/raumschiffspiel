package com.raumschiffspiel;

import java.util.Scanner;

public class Sonnensystem {

    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);
        char richtung;

        Kapitaen alexiaNova = new Kapitaen("Alexia Nova", 8, 6);
        Kapitaen admiralZenithNightfall = new Kapitaen("Admiral Zenith Nightfall", 10, 10);
        Raumschiff eosNova = new Raumschiff("EosNova", alexiaNova,0,0);
        Raumschiff auroraQuest = new Raumschiff("AuroraQuest", admiralZenithNightfall,0,0);

        boolean gameOver = false;

        while(!gameOver) {

            System.out.println("Das Spiel beginnt.\n\nSie fliegen das Raumschiff " + eosNova.getName() + " gesteuert vom Kapitän " + eosNova.getKapitaen().getName());
            System.out.println(eosNova.getKoordinaten());

            System.out.println("Bewegung (a/w/s/d): ");
            richtung = tastatur.nextLine().charAt(0);
            eosNova.fliegen(richtung);

            if (RaumschiffInteraktion.pruefeKoordniaten(eosNova, auroraQuest)) {
                System.out.println("Hier ist das Raumschiff Aurora Quest");
            }

            alexiaNova.setName("Alexia Starlight Nova");



        }
    }

}
