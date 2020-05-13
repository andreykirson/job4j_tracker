package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item item_1 = new Item("test1");
        Item item_2 = new Item("test2");
        tracker.add(item_1);
        tracker.add(item_2);
        List<Item> result = tracker.findByName(item_1.getName());
        assertThat(result.get(0).getName(), is(item_1.getName()));
    }

    @Test
    public void findAll() {
        Tracker tracker = new Tracker();
        List <Item> result = new ArrayList<>();
        Item item_1 = new Item("test1");
        Item item_2 = new Item("test2");
        tracker.add(item_1);
        tracker.add(item_2);
        result = tracker.findAll();
        assertThat(result.get(0).getName(), is(item_1.getName()));
    }

    @Test
    public void replace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void delete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }


}