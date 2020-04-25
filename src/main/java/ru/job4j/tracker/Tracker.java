package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    private int ids = 1;
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        return item;
    }

    public Item findById(String id) {
        // Находим индекс
        int index = indexOf(id);
        // Если индекс найден возвращаем item, иначе null
        return index != -1 ? items[index] : null;
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

    public Item findByName(String key){
        Item rsl = null;
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tracker tracker = (Tracker) o;
        return ids == tracker.ids &&
                Arrays.equals(items, tracker.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(ids);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    public Item[] findAll(){
        Item[] itemsWithoutNull = new Item[items.length];
        for (int index = 0; index < position; index++) {
            Item item = items[index];
            if (item != null) {
                itemsWithoutNull[index] = item;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, position);
        return itemsWithoutNull;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item[] replace(String id, Item repItem){
       // 1. Найти индекс ячейки по id.
        int index = indexOf(id);
       // 2. Проставить id с item. При замене нужно сохранять старый id.
       repItem.setId(id);
       // 3. Записать в ячейку с найденным индекс объект item. Это входящий параметр.
        items[index] = repItem;
        return items;
    }
}