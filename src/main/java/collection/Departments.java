package collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start = start + el;
                tmp.add (start);
                start = start + "/";
            }
        }
        return sortAsc(new ArrayList<>(tmp));
    }

    public static void main(String[] args) {

    }


    public static List<String> sortAsc(List<String> orgs) {
        Collections.sort(orgs, new AscComp());
        return orgs;
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp().thenComparing(new AscComp()));
    }

}
