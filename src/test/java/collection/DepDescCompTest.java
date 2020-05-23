package collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class DepDescCompTest {

    @Test
    public void comparePrintResult() {
        List<String> input = Arrays.asList("K1/SK4/SK2", "K1", "K2/SK2", "K2" , "K2/SK1/SK2", "K1/SK3/SK5", "K0");
        Collections.sort(input, new DepDescComp());
        System.out.println(input);
    }


    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }

}