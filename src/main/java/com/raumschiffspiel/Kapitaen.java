package com.raumschiffspiel;

public class Kapitaen {
    private String name;
    private int charisma;
    private int erfahrung;
    private double geld;

    public Kapitaen(String name, int charisma, int erfahrung, double geld) {
        this.name = name;
        this.charisma = charisma;
        this.erfahrung = erfahrung;
        this.geld = geld;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getErfahrung() {
        return erfahrung;
    }

    public void setErfahrung(int erfahrung) {
        this.erfahrung = erfahrung;
    }

    public String diplomatischeVerhandlung(Kapitaen kapitaen) {
        if (this.erfahrung >= kapitaen.getErfahrung()) {
            if (this.charisma >= kapitaen.getCharisma()) {
                return "Diplomatische Verhandlungen waren erfolgreich!";
            } else {
                return "Diplomatische Verhandlungen waren nicht erfolgreich!";
            }
        } else {
            return "Diplomatische Verhandlungen waren nicht erfolgreich!";
        }
    }

    public double getGeld() {
        return geld;
    }

    public void setGeld(double geld) {
        this.geld = geld;
    }

    public void addGeld(double betrag) {
        this.geld += betrag;
    }

    public void subtractGeld(double betrag) {
        this.geld -= betrag;
    }
}
