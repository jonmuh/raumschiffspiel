package com.raumschiffspiel;

public class Handelsstation {

    public static void ladungAufnehmen(Raumschiff raumschiff, Planet planet, Ladung ladung) {
        raumschiff.addLadung(ladung);
        planet.setLadung(new Ladung());
    }

    public static void ladungAbladen(Raumschiff raumschiff, Planet planet, Ladung ladung) {
        planet.setLadung(ladung);
        raumschiff.removeLadung(ladung);
    }

    public static void handelDurchfuehren(Kapitaen kapitaen, Ladung ladung, boolean kaufen, double preis) {
        if (kaufen) {
            kapitaen.subtractGeld(preis);
        } else {
            kapitaen.addGeld(preis);
        }
    }
}