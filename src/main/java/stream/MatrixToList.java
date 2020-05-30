package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    }

}
