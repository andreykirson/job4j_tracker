package ru.job4j.tracker;

import java.util.*;

/**
 * @version $Id$
 * @since 0.1
 */
public class MemTracker implements Store{
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

    @Override
    public Item add(Item item) {
        item.setId(Integer.valueOf(generateId()));
        items.add(item);
        return item;
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    @Override
    public List<Item> findAllByReact(Observe<Item> observe) throws Exception {
        return null;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextInt() + 10387264);
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item:items) {
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    public List<Item> findAll() {
        return items;
    }

    private int indexOf(String id) {
        int rsl = -1;
        int index = 0;
        for (Item item:items) {
             if (item.getId().equals(id)) {
                 rsl = index;
                 break;
            }
            index++;
        }
        return rsl;
    }

    @Override
    public void init() {

    }


    public boolean replace(String id, Item repItem) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            repItem.setId(Integer.valueOf(id));
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

    public void sortByName() {
        Collections.sort(items, new ItemSortByName());
    }

    public void itemReverseSortByName() {
        Collections.sort(items, new ItemReverseSortByName());
    }

    @Override
    public void close() throws Exception {

    }


    public static void main(String[] args) {
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        System.out.println(tracker.findAll());
    }
}

