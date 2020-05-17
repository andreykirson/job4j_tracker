package ru.job4j.tracker;

import java.util.*;
import java.util.Comparator;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();
    /**
     * Указатель ячейки для новой заявки.
     */
    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     */
    public List<Item> add(Item item) {
        item.setId(generateId());
        items.add(item);
        return items;
    }

    public Item findById(String id) {
        // Находим индекс
        int index = indexOf(id);
        // Если индекс найден возвращаем item, иначе null
        return index != -1 ? items.get(index) : null;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public List <Item> findByName(String key){
        List <Item> rsl = new ArrayList<>();
        for (Item item:items) {
            if (item.getName().equals(key)){
                rsl.add(item);
            }
        }
        return rsl;
    }

    public List <Item> findAll(){
        return items;
    }

    private int indexOf(String id) {
        int rsl = -1;
        int index = 0;
        for (Item item:items) {
             if (item.getId().equals(id)){
                 rsl = index;
                 break;
            }
            index++;
        }
        return rsl;
    }

    public boolean replace(String id, Item repItem){
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            repItem.setId(id);
            items.set(index, repItem);
        }
        return rsl;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }

    public void Sort() {
        Collections.sort(items);
    }

    public void ReverseSort() {
        Comparator<Item> comp = (Item::compareTo);
        Collections.sort(items, comp.reversed());
    }


    public void SortByName() {
        Collections.sort(items, new ItemSortByName());
    }



}

