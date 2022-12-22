package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "0", "Item name1", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[1].getName()).isEqualTo("Item name1");
    }

    @Test
    public void whenReplaceAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        String replacedName = "New item name";
        String id = Integer.toString(item.getId());
        Input input = new StubInput(
                new String[]{"0", id, replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(output),
                new ExitAction(output),
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        String id = Integer.toString(item.getId());
        Input input = new StubInput(
                new String[]{"0", id, "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output),
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new StubInput(new String[]{
                "0", String.valueOf(item.getId()), replaceName, "1"
        }
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction(out),
        };
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("test1"));
        Item second = tracker.add(new Item("test2"));
        Item third = tracker.add(new Item("test3"));
        Input input = new StubInput(new String[]{"0", "1"});
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction(out),
        };
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + first + ln
                        + second + ln
                        + third + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("test1"));
        Item second = tracker.add(new Item("test2"));
        Input input = new StubInput(new String[]{"0", "test2", "1"});
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out),
        };
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + second + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("test1"));
        Item second = tracker.add(new Item("test2"));
        Input input = new StubInput(new String[]{"0", String.valueOf(second.getId()), "1"});
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out),
        };
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + second + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"7", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }
}
