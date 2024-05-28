package com.raumschiffspiel;

public class Sonnensystem {

    public static void main(String[] args) {
        Raumschiff eosNova = new Raumschiff("EosNova",0,0);
        Raumschiff auroraQuest = new Raumschiff("AuroraQuest", 0,0);

        boolean gameOver = false;

        while(!gameOver) {

            System.out.println("Das Spiel beginnt.\n\nSie fliegen das Raumschiff " + eosNova.getName() + ".");
            System.out.println(eosNova.getKoordinaten());
            System.out.println("Bewegung (a/w/s/d): ");
            if (RaumschiffInteraktion.pruefeKoordniaten(eosNova, auroraQuest)) {
                System.out.println("Hier ist das Raumschiff Aurora Quest");
            }



        }
    }

}
