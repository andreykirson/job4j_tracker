package collection;

import java.util.Comparator;


public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int minLength = Math.min(o1.length(), o2.length());
        int rsl = 0;

        for (int i = 0; i < minLength; i++) {
                if (o1.charAt(i) == o2.charAt(i) & i == 1) {
                    rsl = Integer.compare(o1.length(), o2.length());
                }
                if (o1.charAt(i) != o2.charAt(i) & i == 1) {
                rsl = Character.compare(o2.charAt(i), o1.charAt(i));
            }
            if (i > 1) {
                rsl = Character.compare(o1.charAt(i), o2.charAt(i));
            }
        }
        return rsl;
    }
}

