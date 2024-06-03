package com.raumschiffspiel;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaumschiffTests {

    @Test
    public void testThatRaumschiffBuilderWorksCorrectly() {
        Kapitaen neuer = new Kapitaen("Neuer", 10, 10);
        Ladung doener = new Ladung("Doener", 300);
        Raumschiff normalesUfo = new Raumschiff("UFO", 69, 69, neuer, doener, 32, 99, 55, 33, 100);
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
                .ladung(doener)
                .build();
        assertThat(builderUfo.getName()).isEqualTo(normalesUfo.getName());
    }

}
