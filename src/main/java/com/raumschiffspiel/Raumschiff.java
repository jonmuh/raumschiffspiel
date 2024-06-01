package com.raumschiffspiel;

public class Raumschiff {

    private String name;
    private int posY;
    private int posX;
    private Kapitaen kapitaen;
    private Ladung ladung;

    public Raumschiff(String name, Kapitaen kapitaen, int posX, int posY) {
        this.name = name;
        this.kapitaen = kapitaen;
        this.posX = posX;
        this.posY = posY;
    }

    public String getName() {
        return name;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public Kapitaen getKapitaen() {
        return kapitaen;
    }

    public void setKapitaen(Kapitaen kapitaen) {
        this.kapitaen = kapitaen;
    }

    public Ladung getLadung() {
        return ladung;
    }

    public void setLadung(Ladung ladung) {
        this.ladung = ladung;
    }

    public void removeLadung() {
        this.ladung = null;
    }

    public void fliegen(char richtung) {
        switch (richtung) {
            case 'a':
                this.posX -= 1;
                break;
            case 'd':
                this.posX += 1;
                break;
            case 'w':
                this.posY += 1;
                break;
            case 's':
                this.posY -= 1;
                break;
            default:
                break;
        }
    }

    public String getKoordinaten() {
        return "Die Koordinaten des Raumschiffs " + this.getName() + " sind (" + this.getPosX() + ", " + this.getPosY() + ")";
    }

    public boolean pruefeKoordniaten(Raumschiff zweitesRaumschiff) {
        boolean areOnSameField = false;
        if (this.getPosX() == zweitesRaumschiff.getPosY()) {
            if (this.getPosY() == zweitesRaumschiff.getPosY()){
                areOnSameField = true;
            }
        }
        return areOnSameField;
    }

    public boolean pruefeKoordniaten(Planet planet) {
        boolean areOnSameField = false;
        if (this.getPosX() == planet.getPosX()) {
            if (this.getPosY() == planet.getPosY()){
                areOnSameField = true;
            }
        }
        return areOnSameField;
    }

    public String pruefeObNebenEinemRaumschiff (Raumschiff raumschiff) {
        StringBuilder responseBuilder = new StringBuilder();
        if (this.pruefeKoordniaten(raumschiff)) {
            responseBuilder.append("Hier ist das Raumschiff ").append(raumschiff.getName());
            return responseBuilder.toString();
        } else {
            return null;
        }
    }

    public String pruefeObAufEinemPlanet (Planet planet) {
        StringBuilder responseBuilder = new StringBuilder();
        if (this.pruefeKoordniaten(planet)) {
            responseBuilder.append("Hier ist der Planet ").append(planet.getName()).append("\n");
            if (planet.getAtmosphaere()) {
                responseBuilder.append(planet.getName()).append(" hat eine Atmosphaere.");
            } else {
                responseBuilder.append(planet.getName()).append(" hat keine Atmosphaere.");
            }
        }
        return responseBuilder.toString();
    }
}
