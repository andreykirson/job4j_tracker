package ex;

import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNLessThenZero() {
        Fact fact = new Fact();
        int n = -1;
        int rsl = fact.calc(n);
    }
}