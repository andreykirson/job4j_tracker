package collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String[] el = value.split("/");
            if (el.length != 1) {
                tmp.add(el[0]);
                tmp.add(value);
            } else {
                if (deps.size() == 0) {
                    tmp.add(el[0]);
                }
            }
        }
        ArrayList s = new ArrayList<>(tmp);
        Collections.sort(s);
        return s;
    }

    public static void main(String[] args) {

    }


    public static void sortAsc(List<String> orgs) {
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp().thenComparing(new AscComp()));
    }

}
