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

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
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
                System.out.println("==== Input id of item ====");
                String id = scanner.nextLine();
                System.out.println("==== Input the of item to edit name item ====");
                String name = scanner.nextLine();
                Item repItem = new Item(name);
                if (tracker.replace(id, repItem)) {
                    System.out.println("==== The item is edited ====");
                } else {
                    System.out.println("==== The item by id" + id + "does not exist ====");
                };

            } else if (select == 3) {
                System.out.println("==== Delete item ====");
                System.out.println("==== Input id of item ====");
                String id = scanner.nextLine();
                if(tracker.delete(id)) {
                    System.out.println("==== The item by id " + id + "is deleted ===");
                } else {
                    System.out.println("==== The item by id " + id + "does not exist ===");
                }

            } else if (select == 4) {
                System.out.println("==== Find item by Id ====");
                System.out.println("==== Input id of item ====");
                String id = scanner.nextLine();
                System.out.println(tracker.findById(id).getId() + " " + tracker.findById(id).getName());
            }  else if (select == 5) {
                System.out.println("==== Find items by name ====");
                System.out.println("==== Input the name of items ====");
                String name = scanner.nextLine();
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


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
