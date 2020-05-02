package ex;

import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void WhenNLessThenZero() {
        Fact fact = new Fact();
        int n = -1;
        int rsl = fact.calc(n);
    }
}