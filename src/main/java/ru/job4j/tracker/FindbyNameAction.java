package ru.job4j.tracker;

public class FindbyNameAction implements UserAction {
    @Override
    public String name() {
        return "==== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Input the name of items");
        StartUI.printStr(tracker.findByName(name));
        return false;
    }

}
