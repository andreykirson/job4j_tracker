package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Отсортировать департаменты [#34352].
 * Comparator with reverse comparator
 * @author Andrey Kirson <a.s.kirson@gmail.com>
 * @since 23.05.2020
 */

public class DepDescComp implements Comparator<String> {

    /**
     * Comaparator with the special sort order.
     * @param o1
     * @param o2
     * @return - result of comparing element of list.
     */

    @Override
    public int compare(String o1, String o2) {
        List<String> l1 = strConvertList(o1);
        List<String> l2 = strConvertList(o2);
        int c = 0;
        for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
            if (i == 0) { // to reverse order sort by first element
                c = l2.get(i).compareTo(l1.get(i));
                if (c != 0) {
                    return c;
                }
            } else {
                c = l1.get(i).compareTo(l2.get(i));
                if (c != 0) {
                    return c;
                }
            }
        }
        return Integer.compare(l1.size(), l2.size());
    }

    /**
     * Method to convert department structure to list to use this structure of data to compare them by special order.
     * @param str - list of names departments.
     * @return - list of names splited to elements.
     */

    public List<String> strConvertList(String str) {
        List<String> list = new ArrayList<String>();
        for (String el : str.split("/")) {
            list.add(el);
        }
        return list;
    }

}


