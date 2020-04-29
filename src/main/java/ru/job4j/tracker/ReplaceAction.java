package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

    @Override
    public String name() {
        return "==== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Input id of item:");
        String name = input.askStr("Input the of item to edit name item:");
        Item repItem = new Item(name);
        if (tracker.replace(id, repItem)) {
            System.out.println("==== The item is edited ====");
        } else {
            System.out.println("==== The item by id" + id + "does not exist ====");
        }
        return true;
    }

}
