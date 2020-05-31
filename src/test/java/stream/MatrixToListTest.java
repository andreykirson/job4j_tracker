package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class MatrixToListTest {

    @Test
    public void flatMatrix() {
        Integer[][] data = new Integer[][]{{1, 2}, {3, 4}, {5, 6}};
        MatrixToList matrixToList = new MatrixToList();
        List<Integer> rsl = matrixToList.flatMatrix(data);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(rsl, is(expected));
    }
}