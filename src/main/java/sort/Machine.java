package sort;

import java.util.Arrays;

public class Machine {
    private final int[] COINS = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int smallChange = money - price;
        for (int i = 0; i < COINS.length; i++){
            while (smallChange >= COINS[i]) {
                smallChange = smallChange - COINS[i];
                rsl[size] = COINS[i];
                size++;
            }
            }
        return Arrays.copyOf(rsl, size);
    }
}
