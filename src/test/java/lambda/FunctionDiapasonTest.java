package lambda;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionDiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionDiapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = FunctionDiapason.diapason(5, 8, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(26.0, 37.0, 50.0);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentFunctionThenExponentResults() {
        List<Double> result = FunctionDiapason.diapason(1, 3, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(2.0, 4.0);
        assertThat(result, is(expected));
    }

}