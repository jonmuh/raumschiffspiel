package com.raumschiffspiel;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadungTests {

    @Test
    public void testThatEmptyConstructorGeneratesLeerladung() {
        Ladung ladung = new Ladung();
        assertThat(ladung).isNotNull();
        assertThat(ladung.getName()).isEqualTo("Leerladung");
        assertThat(ladung.getEinhaiten()).isEqualTo(0);
    }

    @Test
    public void testThatFullConstructorGeneratesCorrectLadung() {
        Ladung steine = new Ladung("Steine", 20);
        assertThat(steine).isNotNull().isInstanceOf(Ladung.class);
        assertThat(steine.getName()).isEqualTo("Steine");
        assertThat(steine.getEinhaiten()).isEqualTo(20);
    }
}
