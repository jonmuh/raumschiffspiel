package com.raumschiffspiel;

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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEinhaiten() {
        return einhaiten;
    }

    public void setEinhaiten(int einhaiten) {
        this.einhaiten = einhaiten;
    }
}
