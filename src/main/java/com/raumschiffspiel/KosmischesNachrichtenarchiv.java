package com.raumschiffspiel;

import java.util.ArrayList;

public class KosmischesNachrichtenarchiv {

    private String name;
    private String planet;

    private static ArrayList<Nachricht> nachrichtenArchiv = new ArrayList<>();

    public KosmischesNachrichtenarchiv(String name, String planet) {
        this.name = name;
        this.planet = planet;
    }

    public void nachrichtEmpfangen(Nachricht nachricht) {
        nachrichtenArchiv.add(nachricht);
    }

    public ArrayList<Nachricht> getAlleNachrichten() {
        return new ArrayList<>(nachrichtenArchiv);
    }

    public String getName() {
        return name;
    }

    public String getPlanet() {
        return planet;
    }

    @Override
    public String toString() {
        return "KosmischesNachrichtenarchiv{" +
                "name='" + name + '\'' +
                ", planet='" + planet + '\'' +
                '}';
    }
}