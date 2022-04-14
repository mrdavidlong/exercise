package exercise;

import java.util.Arrays;

public class CoinChangeMinimum {
    public static int minCoinChange(int total, int[] coins) {
        if (total == 0) return 0;
        if (coins == null || coins.length == 0) return -1;

        int[] min = new int[total + 1];
        Arrays.fill(min, Integer.MAX_VALUE - 1);
        min[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= total; j++) {
                min[j] = Math.min(min[j], min[j - coin] + 1);
            }
        }
        return min[total] == Integer.MAX_VALUE - 1 ? -1 : min[total];
    }

    public static void main(String[] args) {
        int min = minCoinChange(11, new int[] {1,5,6,8});
    }
}
