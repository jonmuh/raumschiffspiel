package com.raumschiffspiel;

import java.util.Objects;

public class Ladung {

    private String name;
    private int einhaiten;

    public Ladung(){
        this.name = "Leerladung";
        this.einhaiten = 0;
    }

    public Ladung(String name, int einhaiten) {
        this.name = name;
        this.einhaiten = einhaiten;
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

    @Override
    public String toString() {
        return "Ladung{" +
                "name='" + name + '\'' +
                ", einhaiten=" + einhaiten +
                '}';
    }
}
