package com.raumschiffspiel;

import java.util.Objects;

public class Planet {

    private String name;
    private  boolean atmosphaere;
    private int posX;
    private int posY;
    private Ladung ladung;

    public Planet(String name, boolean atmosphaere, int posX, int posY) {
        this.name = name;
        this.atmosphaere = atmosphaere;
        this.posX = posX;
        this.posY = posY;
    }

    public String getName() {
        return Objects.requireNonNull(name, "Namenloser Planet");
    }

    public boolean getAtmosphaere() {
        return atmosphaere;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
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

    public int[] getCoordinates() {
        return new int[]{posX, posY};
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", atmosphaere=" + atmosphaere +
                ", posX=" + posX +
                ", posY=" + posY +
                ", ladung=" + ladung.getName() +
                '}';
    }
}
