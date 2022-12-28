package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertListTest {

    @Test
    public void whenTwoList() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {1});
        list.add(new int[] {2, 3});
        List<Integer> result = ConvertList.convert(list);
        List<Integer> expect = Arrays.asList(1, 2, 3);
        assertThat(result).containsAll(expect);
    }

    @Test
    public void whenFiveNumbersToList() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4});
        list.add(new int[]{5});
        List<Integer> rst = ConvertList.convert(list);
        List<Integer> expected = List.of(1,2,3,4,5);
        assertThat(rst).containsAll(expected);
    }
}
