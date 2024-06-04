package com.raumschiffspiel;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KapitaenTests {

    @Test
    public void testThatKapitaenConstructionWorks() {
        Kapitaen JackSparow = new Kapitaen("Jack Sparow", 88, 99, 10);
        assertThat(JackSparow).isNotNull().isInstanceOf(Kapitaen.class);
        assertThat(JackSparow.getName()).isEqualTo("Jack Sparow");
        assertThat(JackSparow.getCharisma()).isEqualTo(88);
        assertThat(JackSparow.getErfahrung()).isEqualTo(99);
        assertThat(JackSparow.getGeld()).isEqualTo(10);
    }

    @Test
    public void testThatMethodDiplomatischeVerhandlungenWorksCorrectly() {
        Kapitaen capitan1 = new Kapitaen("Jack", 45, 32, 32);
        Kapitaen capitain2 = new Kapitaen("John", 99, 99, 42);
        Kapitaen edgeCase = new Kapitaen("Jack", 45, 32, 232);

        assertThat(capitan1.diplomatischeVerhandlung(capitain2)).isEqualTo("Diplomatische Verhandlungen waren nicht erfolgreich!");
        assertThat(capitain2.diplomatischeVerhandlung(capitan1)).isEqualTo("Diplomatische Verhandlungen waren erfolgreich!");
        assertThat(edgeCase.diplomatischeVerhandlung(capitan1)).isEqualTo("Diplomatische Verhandlungen waren erfolgreich!");

    }

}
