package com.raumschiffspiel;

import java.util.Scanner;

public class Raumschiff {

    private String name;
    private int posY;
    private int posX;
    private Kapitaen kapitaen;
    private Ladung ladung;
    private int integritaetsgrad;
    private int energieschild;
    private double energieVersorgung;
    private int manoevrierFaehigkeit;
    private int waffenstaerke;

    public Raumschiff(String name, Kapitaen kapitaen, int posX, int posY) {
        this.name = name;
        this.kapitaen = kapitaen;
        this.posX = posX;
        this.posY = posY;
    }

    public Raumschiff(RaumschiffBuilder raumschiffBuilder) {
        this.name = raumschiffBuilder.name;
        this.posX = raumschiffBuilder.posX;
        this.posY = raumschiffBuilder.posY;
        this.kapitaen = raumschiffBuilder.kapitaen;
        this.ladung = raumschiffBuilder.ladung;
        this.integritaetsgrad = raumschiffBuilder.integritaetsgrad;
        this.energieschild = raumschiffBuilder.energieschild;
        this.energieVersorgung = raumschiffBuilder.energieVersorgung;
        this.manoevrierFaehigkeit = raumschiffBuilder.manoevrierFaehigkeit;
        this.waffenstaerke = raumschiffBuilder.waffenstaerke;
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

    public int getIntegritaetsgrad() {
        return integritaetsgrad;
    }

    public void setIntegritaetsgrad(int integritaetsgrad) {
        this.integritaetsgrad = integritaetsgrad;
    }

    public int getEnergieschild() {
        return energieschild;
    }

    public void setEnergieschild(int energieschild) {
        this.energieschild = energieschild;
    }

    public double getEnergieVersorgung() {
        return energieVersorgung;
    }

    public void setEnergieVersorgung(double energieVersorgung) {
        this.energieVersorgung = energieVersorgung;
    }

    public int getManoevrierFaehigkeit() {
        return manoevrierFaehigkeit;
    }

    public void setManoevrierFaehigkeit(int manoevrierFaehigkeit) {
        this.manoevrierFaehigkeit = manoevrierFaehigkeit;
    }

    public int getWaffenstaerke() {
        return waffenstaerke;
    }

    public void setWaffenstaerke(int waffenstaerke) {
        this.waffenstaerke = waffenstaerke;
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

    public static class RaumschiffBuilder {

        private String name;
        private int posY;
        private int posX;
        private Kapitaen kapitaen;
        private Ladung ladung;
        private int integritaetsgrad;
        private int energieschild;
        private double energieVersorgung;
        private int manoevrierFaehigkeit;
        private int waffenstaerke;

        public RaumschiffBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RaumschiffBuilder posY(int posY) {
            this.posY = posY;
            return this;
        }

        public RaumschiffBuilder posX(int posX) {
            this.posX = posX;
            return this;
        }

        public RaumschiffBuilder kapitaen(Kapitaen kapitaen) {
            this.kapitaen = kapitaen;
            return this;
        }

        public RaumschiffBuilder ladung(Ladung ladung) {
            this.ladung = ladung;
            return this;
        }

        public RaumschiffBuilder integritaetsgrad(int integritaetsgrad) {
            this.integritaetsgrad = integritaetsgrad;
            return this;
        }

        public RaumschiffBuilder energieschild(int energieschild) {
            this.energieschild = energieschild;
            return this;
        }

        public RaumschiffBuilder energieVersorgung(double energieVersorgung) {
            this.energieVersorgung = energieVersorgung;
            return this;
        }

        public RaumschiffBuilder manoevrierFaehigkeit(int manoevrierFaehigkeit) {
            this.manoevrierFaehigkeit = manoevrierFaehigkeit;
            return this;
        }

        public RaumschiffBuilder waffenstaerke(int waffenstaerke) {
            this.waffenstaerke = waffenstaerke;
            return this;
        }

        public Raumschiff build() {
            return new Raumschiff(this);
        }
    }
}
