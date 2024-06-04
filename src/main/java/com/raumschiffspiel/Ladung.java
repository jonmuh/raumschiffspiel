package com.raumschiffspiel;

import java.util.Objects;

public class Ladung {

    private String name;
    private int einhaiten;
    private double gewicht;
    private double wert;

    public Ladung(){
        this.name = "Leerladung";
        this.einhaiten = 0;
        this.gewicht = 0;
        this.wert = 0;
    }

    public Ladung(String name, int einhaiten, double gewicht, double wert) {
        this.name = name;
        this.einhaiten = einhaiten;
        this.gewicht = gewicht;
        this.wert = wert;
    }

    public String getName() {
        return Objects.requireNonNullElse(name, "Leerladung");
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEinhaiten() {
        return Objects.requireNonNullElse(einhaiten, 0);
    }

    public void setEinhaiten(int einhaiten) {
        this.einhaiten = einhaiten;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public double getWert() {
        return wert;
    }

    public void setWert(double wert) {
        this.wert = wert;
    }
}
