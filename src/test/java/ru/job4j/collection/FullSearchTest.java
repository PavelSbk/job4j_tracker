package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class FullSearchTest {

    @Test
    public void extractNumber() {
        List<Task> tasks = Arrays.asList(
                new Task("1", "First desc"),
                new Task("2", "Second desc"),
                new Task("1", "First desc")
        );

        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(new FullSearch().extractNumber(tasks)).containsAll(expected);
    }

    @Test
    public void extractFourNumbers() {
        List<Task> list = List.of(
                new Task("1", "First"),
                new Task("2", "Second"),
                new Task("3", "Third"),
                new Task("4", "Fourth")
        );
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2", "3", "4"));
        Set<String> rst = new FullSearch().extractNumber(list);
        assertThat(rst).containsAll(expected);
    }
}