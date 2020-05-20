package collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        left = left.replaceAll("[^\\d]", "");
        right = right.replaceAll("[^\\d]", "");
        int leftInt = Integer.parseInt(left);
        int rightInt = Integer.parseInt(right);
        return Integer.compare(leftInt, rightInt);
    }
}
