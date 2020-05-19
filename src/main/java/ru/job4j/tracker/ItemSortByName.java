package ru.job4j.tracker;

import java.util.Collections;
import java.util.Comparator;

class ItemSortByName implements Comparator <Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getName().compareTo(o2.getName());
    }
}