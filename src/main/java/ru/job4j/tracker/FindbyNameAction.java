package ru.job4j.tracker;

import java.util.List;

public class FindbyNameAction implements UserAction {
    @Override
    public String name() {
        return "==== Searching items by name ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws Exception {
        String name = input.askStr("Input the name of items");
        List<Item> items = tracker.findByName(name);
        if (items.size() == 0) {
            System.out.println("The item by name " + name + " didn't find");
        } else {
            for (Item item:items) {
                System.out.println((item.toString()));
            }

        }
        return false;
    }

}
