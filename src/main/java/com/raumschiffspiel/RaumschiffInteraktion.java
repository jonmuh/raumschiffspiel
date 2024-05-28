package com.raumschiffspiel;

public class RaumschiffInteraktion {

    public static boolean pruefeKoordniaten(Raumschiff erstesRaumschiff, Raumschiff zweitesRaumschiff) {
        boolean areOnSameField = false;
        if (erstesRaumschiff.getPosX() == zweitesRaumschiff.getPosY()) {
            if (erstesRaumschiff.getPosY() == zweitesRaumschiff.getPosY()){
                areOnSameField = true;
            }
        }
        return areOnSameField;
    }
}
