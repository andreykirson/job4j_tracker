package ru.job4j.tracker;


/**
 * @author Andrey
 * @version 1
 * @date 2/27/2021
 */

public interface Observe<T> {
    void receive(T model);
}
