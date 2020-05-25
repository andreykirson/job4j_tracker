package lambda;

import java.util.Comparator;

public class LambdaBlock {
    Comparator<String> cmpText = (left, right) ->  {
        System.out.println("compare - " + left + " : " + right);
       return right.compareTo(left);
    };
}