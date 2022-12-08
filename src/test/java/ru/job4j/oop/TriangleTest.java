package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class TriangleTest {

    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = 8;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when01and10and01ThenMinus1() {
        Point a = new Point (0, 1);
        Point b = new Point (1, 0);
        Point c = new Point (0, 1);
        Triangle triangle = new Triangle (a, b, c);
        double expected = -1;
        double rsl = triangle.area();
        assertThat(rsl).isCloseTo(expected, offset(0.01));
    }
}