package com.raumschiffspiel;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class RaumschiffTests {

    @Test
    public void testThatRaumschiffBuilderWorksCorrectly() {
        Kapitaen neuer = new Kapitaen("Neuer", 10, 10, 3);
        Ladung doener = new Ladung("Doener", 300, 5.5, 1000.50);
        ArrayList<Ladung> ladung = new ArrayList<>();
        ladung.add(doener);
        Raumschiff normalesUfo = new Raumschiff("UFO", 69, 69, neuer, ladung, 32, 99, 55, 33, 100, 45, 43);
        Raumschiff builderUfo = new Raumschiff.RaumschiffBuilder()
                .name("UFO")
                .posY(69)
                .posX(69)
                .kapitaen(neuer)
                .energieschild(99)
                .energieVersorgung(55)
                .integritaetsgrad(32)
                .waffenstaerke(100)
                .manoevrierFaehigkeit(33)
                .ladung(ladung)
                .laserWaffenstaerke(45)
                .raketenWaffenStaerke(43)
                .build();
        assertThat(builderUfo.getName()).isEqualTo(normalesUfo.getName());
    }

}
