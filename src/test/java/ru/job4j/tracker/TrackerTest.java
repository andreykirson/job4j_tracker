package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import org.hamcrest.collection.IsIterableContainingInOrder;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;


public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(String.valueOf(item.getId()));
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void findByName() {
        MemTracker tracker = new MemTracker();
        Item itemOne = new Item("test1");
        Item itemTwo = new Item("test2");
        tracker.add(itemOne);
        tracker.add(itemOne);
        List<Item> result = tracker.findByName(itemOne.getName());
        assertThat(result.get(0).getName(), is(itemOne.getName()));
    }

    @Test
    public void findAll() {
        MemTracker tracker = new MemTracker();
        List<Item> result = new ArrayList<>();
        Item itemOne = new Item("test1");
        Item itemTwo = new Item("test2");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        result = tracker.findAll();
        assertThat(result.get(0).getName(), is(itemOne.getName()));
    }

    @Test
    public void replace() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = String.valueOf(bug.getId());
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void delete() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = String.valueOf(bug.getId());
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }


    @Test
    public void sort() {
        MemTracker tracker = new MemTracker();
        Item itemOne = new Item("C");
        Item itemTwo = new Item("A");
        Item itemThree = new Item("B");
        Item itemFour = new Item("Y");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.add(itemFour);
        tracker.sortByName();
        List<Item> actual = new ArrayList<>();
        actual = tracker.findAll();
        List<String> name = new ArrayList<>();
        int i = 0;
        for (Item item:actual) {
            name.add(i, item.getName());
            i++;
        }
        Assert.assertThat(name, IsIterableContainingInOrder.contains("A", "B", "C", "Y"));
    }

    @Test
    public void reverseSort() {
        MemTracker tracker = new MemTracker();
        Item itemOne = new Item("C");
        Item itemTwo = new Item("A");
        Item itemThree = new Item("B");
        Item itemFour = new Item("Y");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.add(itemFour);
        tracker.itemReverseSortByName();
        List<Item> actual = new ArrayList<>();
        actual = tracker.findAll();
        List<String> name = new ArrayList<>();
        int i = 0;
        for (Item item:actual) {
            name.add(i, item.getName());
            i++;
        }
        Assert.assertThat(name, IsIterableContainingInOrder.contains("Y", "C", "B", "A"));
    }
}
