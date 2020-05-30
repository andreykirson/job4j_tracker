package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream.of is generic,  Arrays.stream works with the primitive data type
 */

public class MatrixToList {


    public static void main(String[] args) {

        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );

        List<Integer> flatMatrix = matrix.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(matrix);
        System.out.println(flatMatrix);

        Integer[][] data = new Integer[][]{{1, 2}, {3, 4}, {5, 6}};
        Stream<Integer[]> temp = Arrays.stream(data);
        List<Integer> integerStream = temp.flatMap(x -> Arrays.stream(x))
                .collect(Collectors.toList());

        System.out.println(data);
        System.out.println(integerStream);

        Stream<Integer[]> t = Stream.of(data);

        List<Integer> intStreamNew = t.flatMap(Arrays::stream)
                .collect(Collectors.toList());


        System.out.println(intStreamNew);
    }

}
