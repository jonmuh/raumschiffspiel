package com.raumschiffspiel;

import java.util.ArrayList;

public class Raumschiff {

    private String name;
    private int posY;
    private int posX;
    private Kapitaen kapitaen;
    private ArrayList<Ladung> ladung;
    double ladungskapazitaet;
    private int integritaetsgrad;
    private int energieschild;
    private double energieVersorgung;
    private int manoevrierFaehigkeit;
    private int waffenstaerke;
    private int laserWaffenstaerke;
    private int raketenWaffenstaerke;

    public Raumschiff() { }

    public Raumschiff(String name, Kapitaen kapitaen, int posX, int posY) {
        this.name = name;
        this.kapitaen = kapitaen;
        this.posX = posX;
        this.posY = posY;
    }

    public Raumschiff(String name, int posY, int posX, Kapitaen kapitaen, ArrayList<Ladung> ladung, int integritaetsgrad, int energieschild, double energieVersorgung, int manoevrierFaehigkeit, int waffenstaerke, int laserWaffenstaerke, int raketenWaffenstaerke) {
        this.name = name;
        this.posY = posY;
        this.posX = posX;
        this.kapitaen = kapitaen;
        this.ladung = ladung;
        this.integritaetsgrad = integritaetsgrad;
        this.energieschild = energieschild;
        this.energieVersorgung = energieVersorgung;
        this.manoevrierFaehigkeit = manoevrierFaehigkeit;
        this.waffenstaerke = waffenstaerke;
        this.laserWaffenstaerke = laserWaffenstaerke;
        this.raketenWaffenstaerke = raketenWaffenstaerke;
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
        this.laserWaffenstaerke = raumschiffBuilder.laserWaffenstaerke;
        this.raketenWaffenstaerke = raumschiffBuilder.raketenWaffenstaerke;
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

    public ArrayList<Ladung> getLadung() {
        return ladung;
    }

    public void addLadung(Ladung ladung) {
        if (this.getGesamtgewicht() + ladung.getGewicht() > this.ladungskapazitaet) {
            System.out.println("Ladung kann nicht aufgenommen werden, da das maximale Gewicht überschritten wird.");
        } else {
            this.ladung.add(ladung);
        }
    }

    public void removeLadung(Ladung ladung) {
        this.ladung.remove(ladung);
    }

    public double getLadungskapazitaet() {
        return ladungskapazitaet;
    }

    public void setLadungskapazitaet(double ladungskapazitaet) {
        this.ladungskapazitaet = ladungskapazitaet;
    }

    public int getRaketenWaffenstaerke() {
        return raketenWaffenstaerke;
    }

    public void setRaketenWaffenstaerke(int raketenWaffenstaerke) {
        this.raketenWaffenstaerke = raketenWaffenstaerke;
    }

    public int getLaserWaffenstaerke() {
        return laserWaffenstaerke;
    }

    public void setLaserWaffenstaerke(int laserWaffenstaerke) {
        this.laserWaffenstaerke = laserWaffenstaerke;
    }

    public double getGesamtgewicht() {
        double gesamtgewicht = 0;
        for (Ladung l : ladung) {
            gesamtgewicht += l.getGewicht();
        }
        return gesamtgewicht;
    }

    public void printLadung() {
        for (Ladung l : ladung) {
            System.out.println(l);
        }
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

    public void verteidigen(int schaden) {
        // Berechne den tatsächlichen Schaden basierend auf Manövrierfähigkeit und Erfahrung des Captain
        int verteidigungsbonus = this.kapitaen.getErfahrung() + this.manoevrierFaehigkeit;
        schaden -= verteidigungsbonus;

        // Überprüfe, ob das Schiff Schaden nimmt und verringere den Integritätsgrad
        if (schaden > 0) {
            this.integritaetsgrad -= schaden;
            // Prüfe, ob das eigene Raumschiff zerstört wurde
            if (this.integritaetsgrad <= 0) {
                System.out.println(this.name + " wurde zerstört!");
            }
        } else {
            System.out.println("Der Angriff wurde abgewehrt!");
        }
    }

    public void zerstoeren() {
        if (this.integritaetsgrad <= 0) {
            System.out.println(this.name + " wurde bereits zerstört!");
            return;
        }

        this.integritaetsgrad = 0;
        System.out.println(this.name + " wurde zerstört!");
        //  hier weitere Logik, um das Raumschiff aus dem Spiel zu entfernen
    }

    public void laserAngriff(Raumschiff gegnerischesRaumschiff) {
        int schaden = this.laserWaffenstaerke;

        gegnerischesRaumschiff.integritaetsgrad -= schaden;

        if (gegnerischesRaumschiff.integritaetsgrad <= 0) {
            gegnerischesRaumschiff.zerstoeren();
        }
    }

    public void raketenAngriff(Raumschiff gegnerischesRaumschiff) {
        int schaden = this.raketenWaffenstaerke;

        gegnerischesRaumschiff.integritaetsgrad -= schaden;

        if (gegnerischesRaumschiff.integritaetsgrad <= 0) {
            gegnerischesRaumschiff.zerstoeren();
        }
    }

    // Fügt die Methode hinzu, um den Integritätsgrad des Raumschiffs zu prüfen.
    public void prüfenIntegritätsgrad() {
        if (this.integritaetsgrad <= 0) {
            System.out.println(this.name + " wurde zerstört!");
            this.integritaetsgrad = 0; // Setzt den Integritätsgrad auf 0, um die Zerstörung anzuzeigen.
        }
    }

    // Fügt die Methode hinzu, um anzugreifen.
    public void angreifen(Raumschiff gegner) {
        int schaden = this.waffenstaerke - gegner.getEnergieschild();
        if (schaden > 0) {
            gegner.setIntegritaetsgrad(gegner.getIntegritaetsgrad() - schaden);
            System.out.println(this.name + " greift " + gegner.getName() + " an und verursacht " + schaden + " Schaden.");
        } else {
            System.out.println(this.name + "s Angriff wurde abgewehrt!");
        }
        gegner.prüfenIntegritätsgrad();
    }

    // Fügt die Methode hinzu, um einen Kampf zu initiieren.
    public void kämpfen(Raumschiff gegner) {
        System.out.println(this.name + " und " + gegner.getName() + " befinden sich im Kampf!");
        while (this.integritaetsgrad > 0 && gegner.getIntegritaetsgrad() > 0) {
            this.angreifen(gegner);
            if (gegner.getIntegritaetsgrad() > 0) {
                gegner.angreifen(this);
            }
        }
    }

    @Override
    public String toString() {
        return "Raumschiff{" +
                "name='" + name + '\'' +
                ", posY=" + posY +
                ", posX=" + posX +
                ", kapitaen=" + kapitaen +
                ", ladung=" + ladung +
                ", integritaetsgrad=" + integritaetsgrad +
                ", energieschild=" + energieschild +
                ", energieVersorgung=" + energieVersorgung +
                ", manoevrierFaehigkeit=" + manoevrierFaehigkeit +
                ", waffenstaerke=" + waffenstaerke +
                ", laserWaffenstaerke=" + laserWaffenstaerke +
                ", raketenWaffenstaerke=" + raketenWaffenstaerke +
                '}';
    }

    public static class RaumschiffBuilder {

        private String name;
        private int posY;
        private int posX;
        private Kapitaen kapitaen;
        private ArrayList<Ladung> ladung;
        private int integritaetsgrad;
        private int energieschild;
        private double energieVersorgung;
        private int manoevrierFaehigkeit;
        private int waffenstaerke;
        private int laserWaffenstaerke;
        private int raketenWaffenstaerke;

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

        public RaumschiffBuilder ladung(ArrayList<Ladung> ladung) {
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

        public RaumschiffBuilder laserWaffenstaerke(int laserWaffenstaerke) {
            this.laserWaffenstaerke = laserWaffenstaerke;
            return this;
        }

        public RaumschiffBuilder raketenWaffenStaerke(int raketenWaffenstaerke) {
            this.raketenWaffenstaerke = raketenWaffenstaerke;
            return this;
        }

        public Raumschiff build() {
            return new Raumschiff(this);
        }
    }
}
