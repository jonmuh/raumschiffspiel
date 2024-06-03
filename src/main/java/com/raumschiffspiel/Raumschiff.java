package com.raumschiffspiel;

public class Raumschiff {

    private String name;
    private int posY;
    private int posX;
    private Kapitaen kapitaen;
    private Ladung ladung;
    private int integritaetsgrad;
    private int energieschild;
    private double energieVersorgung;
    private int manoevrierFaehigkeit;
    private int waffenstaerke;
    private int laserWaffenstaerke;
    private int raketenWaffenstaerke;

    public Raumschiff(String name, Kapitaen kapitaen, int posX, int posY) {
        this.name = name;
        this.kapitaen = kapitaen;
        this.posX = posX;
        this.posY = posY;
    }

    public Raumschiff(String name, int posY, int posX, Kapitaen kapitaen, Ladung ladung, int integritaetsgrad, int energieschild, double energieVersorgung, int manoevrierFaehigkeit, int waffenstaerke, int laserWaffenstaerke, int raketenWaffenstaerke) {
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

    public Ladung getLadung() {
        return ladung;
    }

    public void setLadung(Ladung ladung) {
        this.ladung = ladung;
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

    public void removeLadung() {
        this.ladung = null;
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

    public void angreifen(Raumschiff gegnerischesRaumschiff) {
        // Berechne den Schaden basierend auf verschiedenen Faktoren
        int schaden = this.waffenstaerke - gegnerischesRaumschiff.energieschild;

        // Überprüfe, ob der Schaden größer als null ist und füge Schaden zu
        if (schaden > 0) {
            gegnerischesRaumschiff.integritaetsgrad -= schaden;
            // Prüfe, ob das gegnerische Raumschiff zerstört wurde
            if (gegnerischesRaumschiff.integritaetsgrad <= 0) {
                System.out.println(gegnerischesRaumschiff.getName() + " wurde zerstört!");
                gegnerischesRaumschiff.zerstoeren();
            }
        } else {
            System.out.println("Der Angriff hat keinen Schaden verursacht!");
        }
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

    @Override
    public String toString() {
        return "Raumschiff{" +
                "name='" + name + '\'' +
                ", posY=" + posY +
                ", posX=" + posX +
                ", kapitaen=" + kapitaen.getName() +
                ", ladung=" + ladung.getName() +
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
        private Ladung ladung;
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

        public RaumschiffBuilder ladung(Ladung ladung) {
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
