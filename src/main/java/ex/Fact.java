package ex;

public class Fact {
    public static void main(String[] args) {
        System.out.println(calc(5));
    }

    public static int calc(int n) {
        int rsl = 1;
        if (n < 0) {
            throw new IllegalArgumentException("n must be more than 0");
        }
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}