package ru.job4j.tracker;

import java.io.ByteArrayOutputStream;

public class ReplaceAction implements UserAction {

    private ByteArrayOutputStream output;

    public ReplaceAction(ByteArrayOutputStream output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "==== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws Exception {
        String id = String.valueOf(input.askInt("Input id of item:"));
        String name = input.askStr("Input the name of item to edit name item:");
        Item repItem = new Item(name);
        if (tracker.replace(id, repItem)) {
            System.out.println("==== The item is edited ====");
        } else {
            System.out.println("==== The item by id " + id + " does not exist ====");
        }
        return true;
    }

}
