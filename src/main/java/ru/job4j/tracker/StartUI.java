package ru.job4j.tracker;

/**
 * 0. Add new Item
 * 1. Show all items
 * 2. Edit item
 * 3. Delete item
 * 4. Find item by Id
 * 5. Find items by name
 * 6. Exit Program
 * Select:
 */

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("==== Edit item ====");
        String id = input.askStr("Input id of item:");
        String name = input.askStr("Input the of item to edit name item:");
        Item repItem = new Item(name);
        if (tracker.replace(id, repItem)) {
            System.out.println("==== The item is edited ====");
        } else {
            System.out.println("==== The item by id" + id + "does not exist ====");
        }
    }

    public static void deteleItem(Input input, Tracker tracker) {
        System.out.println("==== Delete item ====");
        String id = input.askStr("Input id of item:");
        if(tracker.delete(id)) {
            System.out.println("==== The item by id " + id + "is deleted ===");
        } else {
            System.out.println("==== The item by id " + id + "does not exist ===");
        }
    }
    //


    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all Items ====");
                for (int i = 0; i < tracker.findAll().length; i++) {
                    System.out.println(tracker.findAll()[i].getId() + " " + tracker.findAll()[i].getName());
                }
            }
             else if (select == 2) {
                System.out.println("==== Edit item ====");
                String id = input.askStr("Input id of item:");
                String name = input.askStr("Input the of item to edit name item:");
                Item repItem = new Item(name);
                if (tracker.replace(id, repItem)) {
                    System.out.println("==== The item is edited ====");
                } else {
                    System.out.println("==== The item by id" + id + "does not exist ====");
                };

            } else if (select == 3) {
                System.out.println("==== Delete item ====");
                String id = input.askStr("Input id of item:");
                if(tracker.delete(id)) {
                    System.out.println("==== The item by id " + id + "is deleted ===");
                } else {
                    System.out.println("==== The item by id " + id + "does not exist ===");
                }

            } else if (select == 4) {
                System.out.println("==== Find item by Id ====");
                String id = input.askStr("Input id of item:");
                System.out.println(tracker.findById(id).getId() + " " + tracker.findById(id).getName());
            }  else if (select == 5) {
                System.out.println("==== Find items by name ====");
                String name = input.askStr("Input the name of items");
                System.out.println(tracker.findByName(name).getId() + " " + tracker.findByName(name).getName());
             }
             else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main (String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
