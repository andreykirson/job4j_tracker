package ru.job4j.tracker;

import java.sql.SQLException;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "==== Searching item by Id ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws Exception {
        String id = input.askStr("Input id of item:");
        Item findItem = tracker.findById(id);
        if (findItem != null) {
            System.out.println(findItem.getId() + " " + findItem.getName());
        } else {
            System.out.println("Item with id " + id + " didn't find");
        }
        return false;
    }


}
