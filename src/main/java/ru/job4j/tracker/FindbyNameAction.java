package ru.job4j.tracker;

import java.awt.desktop.SystemEventListener;
import java.util.Arrays;

public class FindbyNameAction implements UserAction {
    @Override
    public String name() {
        return "==== Searching items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Input the name of items");
        Item[] item = tracker.findByName(name);
        if (item.length == 0){
            System.out.println("The item by name " + name + " didn't find");
        } else{
            System.out.println(Arrays.toString(item));
        }
        return false;
    }

}
