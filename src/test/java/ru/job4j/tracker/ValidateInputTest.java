package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenMuchValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        int selectShowAll = input.askInt("=== Show all items ===");
        int selectDelete = input.askInt("=== Delete item ===");
        assertThat(selected).isEqualTo(0);
        assertThat(selectShowAll).isEqualTo(1);
        assertThat(selectDelete).isEqualTo(3);
    }

    @Test
    public void whenMinus1InvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Please enter validate data again.");
        assertThat(selected).isEqualTo(-1);
    }
}
