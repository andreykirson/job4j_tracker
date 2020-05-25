package collection;

import java.util.Comparator;

/**
 * Отсортировать департаменты [#34352].
 * Comparator with reverse comparator
 * @author Andrey Kirson <a.s.kirson@gmail.com>
 * @since 23.05.2020
 */

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
      String[] o1Splited = o1.split("/");
      String[] o2Splited = o2.split("/");
      int firstStr = o2Splited[0].compareTo(o1Splited[0]);
      return firstStr == 0 ?  o1.compareTo(o2) : firstStr;
    }
}


