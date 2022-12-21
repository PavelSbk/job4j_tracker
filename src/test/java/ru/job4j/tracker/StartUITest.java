package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

    @Test
    public void whenCreateItemCallBack() {
        String[] answer = {"CallBack"};
        Input input = new StubInput(answer);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("CallBack");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        tracker.add(item);
        String[] answer = {
                String.valueOf(item.getId()),
                "edited item"
        };
        StartUI.editItem(new StubInput(answer), tracker);
        Item edited = tracker.findById(item.getId());
        Item expected = new Item("edited item");
        assertThat(edited.getName()).isEqualTo(expected.getName());
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        StartUI.deleteItem(new StubInput(answers), tracker);
        assertThat(tracker.findById(item.getId())).isNull();
    }
}
