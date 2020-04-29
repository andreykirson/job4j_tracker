package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "==== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Input id of item:");
        Item findItem = tracker.findById(id);
        System.out.println(findItem.getId() + " " + findItem.getName());
        return false;
    }


}
