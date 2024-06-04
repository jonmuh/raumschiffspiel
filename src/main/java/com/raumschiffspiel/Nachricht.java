package com.raumschiffspiel;

public class Nachricht {

    private String inhalt;
    private String absender;

    public Nachricht(String inhalt, String absender) {
        this.inhalt = inhalt;
        this.absender = absender;
    }

    public String getInhalt() {
        return inhalt;
    }

    public String getAbsender() {
        return absender;
    }

    @Override
    public String toString() {
        return "Nachricht{" +
                "inhalt='" + inhalt + '\'' +
                ", absender='" + absender + '\'' +
                '}';
    }
}
