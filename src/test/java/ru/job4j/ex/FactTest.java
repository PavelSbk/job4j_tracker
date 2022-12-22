package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactTest {

    @Test
    void whenMinus1ThenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Fact().calc(-1));
        assertThat(exception.getMessage()).isEqualTo("N could not be less then 0");
    }

    @Test
    public void whenMinus3ThenException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Fact().calc(-3));
        assertThat(exception.getMessage()).isEqualTo("N could not be less then 0");
    }
}
