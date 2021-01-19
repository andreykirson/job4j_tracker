package ru.job4j.tracker;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void add() {
        HbmTracker store = new HbmTracker();
        store.deleteAll();
        Item item = new Item("Fix bag");
        store.add(item);
        List<Item> all = store.findByName("Fix bag");
        assertEquals("Fix bag", all.get(0).getName());
    }

    @Test
    public void replace() {
        HbmTracker store = new HbmTracker();
        Item oldItem = new Item("Fix bag");
        store.add(oldItem);
        Item newItem = new Item("Create feature");
        store.replace(String.valueOf(oldItem.getId()), newItem);
        List<Item> all = store.findByName("Create feature");
        assertEquals("Create feature", all.get(0).getName());
    }

    @Test
    public void delete() {
        HbmTracker store = new HbmTracker();
        store.deleteAll();
        Item item = new Item("Fix bag");
        store.add(item);
        store.delete(String.valueOf(item.getId()));
        List<Item> all = store.findAll();
        System.out.println(all);
        assertEquals(0, all.size());
    }

    @Test
    public void findAll() {
        HbmTracker store = new HbmTracker();
        store.deleteAll();
        Item item = new Item("Fix bag");
        store.add(item);
        List<Item> all = store.findAll();
        assertEquals(1, all.size());
    }

    @Test
    public void findByName() throws Exception {
        Store store = new HbmTracker();
        Item item = new Item("Fix bag");
        store.add(item);
        List<Item> all = store.findByName("Fix bag");
        store.close();
        assertEquals("Fix bag", all.get(0).getName());
    }

    @Test
    public void findById() throws Exception {
        Store store = new HbmTracker();
        Item item = new Item("Fix bag");
        store.add(item);
        Item rsl =  store.findById(String.valueOf(item.getId()));
        assertEquals("Fix bag", rsl.getName());
    }

}