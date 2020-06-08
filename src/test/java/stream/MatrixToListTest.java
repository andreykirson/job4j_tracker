package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class MatrixToListTest {

    @Test
    public void flatMatrix() {
        Integer[][] data = new Integer[][]{{1, 2}, {3, 4}, {null, 6}};
        MatrixToList matrixToList = new MatrixToList();
        List<Integer> rsl = matrixToList.flatMatrix(data);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, null, 6);

        assertThat(rsl, is(expected));

        boolean isAllNull = Arrays.stream(data).flatMap(Arrays::stream).allMatch(y -> y == null);

        System.out.println(isAllNull);

        }



}