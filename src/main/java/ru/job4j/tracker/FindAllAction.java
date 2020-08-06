package ru.job4j.tracker;
import java.util.List;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all Items ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws Exception {
        List<Item> items = tracker.findAll();
        for (Item item:items) {
            System.out.println(item.toString());
        }
        return true;
    }
}
