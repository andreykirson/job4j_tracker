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
        for (int index = 0; index < position; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll(){
        Item[] itemsWithoutNull = new Item[items.length];
        for (int index = 0; index < position; index++) {
            Item item = items[index];
                itemsWithoutNull[index] = item;
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

    public boolean replace(String id, Item repItem){
        int index = indexOf(id);
        boolean rsl = index != -1;
       repItem.setId(id);
        if (rsl) {
            items[index] = repItem;
        }
        return rsl;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        int startPos = index + 1;
        int size = position - index;
        int distPos = index;
        items[position - 1] = null;
        position--;
        if (rsl) {
            System.arraycopy(items, startPos, items, distPos, size);
        }
        return rsl;
    }
}

