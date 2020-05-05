package sort;

import java.util.Arrays;

public class Machine {
    private final int[] COINS = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int smallChange = money - price;
        int index = 0;
        int smallChangeTemp = smallChange;
        for (int i = 0; i < COINS.length; i++){
            smallChange = smallChangeTemp;
            while (smallChange > 0) {
                smallChangeTemp = smallChange;
                smallChange = smallChange - COINS[i];
                if(smallChange < 0){
                    break;
                }
                rsl[index] = COINS[i];
                index++;
            }
            if (smallChange == 0) {
                size = index;
                break;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}
