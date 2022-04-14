package exercise;

public class CoinChangeNumberOfWays {
    public static int numOfWays(int total, int[] coins) {
        int[] ways = new int[total + 1];
        ways[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= total; j++) {
                ways[j] += ways[j - coin];
            }
        }
        return ways[total];
    }

    public static void main(String[] args) {
        int ways = numOfWays(5, new int[] {1,2,3});
    }
}
