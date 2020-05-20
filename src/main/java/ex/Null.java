package ex;

import ru.job4j.tracker.Item;

import java.util.Arrays;

public class Null {


    public static void main(String[] args) {
        Item[] items = new Item[2];
        Item item1 = new Item("g");
        Item item2 = new Item("f");
        items[0] = item1;

            System.out.println(Arrays.deepToString(items));

    }
}
