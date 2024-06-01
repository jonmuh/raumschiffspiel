package com.raumschiffspiel;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class PlanetTests {

    @Test
    public void testThatPlanetGeneratesCorrectly() {
        Planet auroria = new Planet("Auroria", true, 15,15);
        assertEquals("Auroria", auroria.getName());
        assertTrue(auroria.getAtmosphaere());
        assertEquals(15, auroria.getPosX());
        assertEquals(15, auroria.getPosY());
        assertInstanceOf(Planet.class, auroria);
    }

    @Test
    public void testThatPlanetClassMethodReturnsCorrectCoordinates() {
        Planet auroria = new Planet("Auroria", true, 45,105);
        assertThat(auroria.getCoordinates()).containsExactly(45,105);
    }


}
