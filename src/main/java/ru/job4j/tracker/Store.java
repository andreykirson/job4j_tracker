package ru.job4j.tracker;

import java.util.List;

public interface Store extends AutoCloseable {

    void init();
    Item add(Item item) throws Exception;
    boolean replace(String id, Item item) throws Exception;
    boolean delete(String id) throws Exception;
    List<Item> findAll(Observe<Item> observe) throws Exception;
    List<Item> findByName(String key) throws Exception;
    Item findById(String id) throws Exception;
    List<Item> findAllByReact(Observe<Item> observe) throws Exception;
}
