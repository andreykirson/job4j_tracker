package ru.job4j.tracker;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void add() throws Exception {
        Store store = new HbmTracker();
        Item item = new Item("Fix bag");
        store.add(item);
        List<Item> all = store.findByName("Fix bag");
        assertEquals("Fix bag", all.get(0).getName());
    }

    @Test
    public void replace() throws Exception {
        Store store = new HbmTracker();
        Item oldItem = new Item("Fix bag");
        store.add(oldItem);
        Item newItem = new Item("Create feature");
        store.replace("1", newItem);
        List<Item> all = store.findByName("Create feature");
        assertEquals("Create feature", all.get(0).getName());
    }

    @Test
    public void delete() throws Exception {
        Store store = new HbmTracker();
        Item item = new Item("Fix bag");
        store.add(item);
        store.delete("2");
        List<Item> all = store.findAll();
        assertEquals(3, all.size());
    }

    @Test
    public void findAll() throws Exception {
        Store store = new HbmTracker();
        Item item = new Item("Fix bag");
        store.add(item);
        List<Item> all = store.findAll();
        assertEquals(12, all.size());
    }

    @Test
    public void findByName() throws Exception {
        Store store = new HbmTracker();
        Item item = new Item("Fix bag");
        store.add(item);
        List<Item> all = store.findByName("Fix bag");
        assertEquals("Fix bag", all.get(0).getName());
    }

    @Test
    public void findById() throws Exception {
        Store store = new HbmTracker();
        Item item = new Item("Fix bag");
        System.out.println(store.findAll());
        store.add(item);
        Item rsl = store.findById("4");
        assertEquals("Fix bag", rsl.getName());
    }
}