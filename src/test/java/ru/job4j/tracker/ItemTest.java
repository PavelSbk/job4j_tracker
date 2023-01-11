package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemTest {

    @Test
    public void whenSortedByDescendingOrder() {
        List<Item> items = Arrays.asList(
                new Item("Abc", 1),
                new Item("Cba", 4),
                new Item("Bca", 3),
                new Item("Acb", 2)
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Cba", 4),
                new Item("Bca", 3),
                new Item("Acb", 2),
                new Item("Abc", 1)
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenSortedByAscendingOrder() {
        List<Item> items = Arrays.asList(
                new Item("Abc", 1),
                new Item("Cba", 4),
                new Item("Bca", 3),
                new Item("Acb", 2)
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Abc", 1),
                new Item("Acb", 2),
                new Item("Bca", 3),
                new Item("Cba", 4)
        );
        assertThat(items).isEqualTo(expected);
    }
}
