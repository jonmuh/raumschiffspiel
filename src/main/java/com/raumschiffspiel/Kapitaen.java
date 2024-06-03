package com.raumschiffspiel;

public class Kapitaen {
    private String name;
    private int charisma;
    private int erfahrung;

    public Kapitaen(String name, int charisma, int erfahrung) {
        this.name = name;
        this.charisma = charisma;
        this.erfahrung = erfahrung;
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

    @Override
    public String toString() {
        return "Kapitaen{" +
                "name='" + name + '\'' +
                ", charisma=" + charisma +
                ", erfahrung=" + erfahrung +
                '}';
    }
}
