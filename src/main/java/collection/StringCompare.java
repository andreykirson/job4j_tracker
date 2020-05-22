package collection;

import java.util.Comparator;


public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minLength = Math.min(right.length(), left.length());
        int stringCompareResult = 0;
        for (int i = 0; i < minLength; i++) {
           if(left.charAt(i) != right.charAt(i)) {
               stringCompareResult = Character.compare(left.charAt(i), right.charAt(i));
               break;
           } else {
               stringCompareResult = 0;
           }
        }
        stringCompareResult = stringCompareResult == 0 ? Integer.compare(left.length(), right.length()) : stringCompareResult;
        return stringCompareResult;
    }
}