package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[]{"0", "Item name", "0", "Item name1", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[1].getName()).isEqualTo("Item name1");
    }

    @Test
    public void whenReplaceAction() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        String replacedName = "New item name";
        String id = Integer.toString(item.getId());
        Input input = new StubInput(
                new String[]{"0", id, replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(),
                new ExitAction(),
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteAction() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        String id = Integer.toString(item.getId());
        Input input = new StubInput(
                new String[]{"0", id, "1"}
        );
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction(),
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }
}
