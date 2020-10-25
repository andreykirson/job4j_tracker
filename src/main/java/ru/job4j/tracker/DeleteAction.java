package ru.job4j.tracker;

import java.io.ByteArrayOutputStream;

public class DeleteAction implements UserAction {

    private ByteArrayOutputStream output;

    public DeleteAction() {};

    public DeleteAction(ByteArrayOutputStream output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "==== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws Exception {
        String id = input.askStr("Input id of item:");
        if (tracker.delete(id)) {
            System.out.println("==== The item by id " + id + "is deleted ===");
        } else {
            System.out.println("==== The item by id " + id + "does not exist ===");
        }
        return true;
    }
}
