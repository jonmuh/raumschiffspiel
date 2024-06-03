package com.raumschiffspiel;

public class Asteroidfeld {

    private int gefahrenpotential;
    private int posX;
    private int posY;

    public Asteroidfeld(int gefahrenpotential, int posX, int posY) {
        this.gefahrenpotential = gefahrenpotential;
        this.posX = posX;
        this.posY = posY;
    }

    public int getGefahrenpotential() {
        return gefahrenpotential;
    }

    public void setGefahrenpotential(int gefahrenpotential) {
        this.gefahrenpotential = gefahrenpotential;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public String toString() {
        return "Asteroidfeld{" +
                "gefahrenpotential=" + gefahrenpotential +
                ", posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
