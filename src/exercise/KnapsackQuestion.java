package exercise;

public class KnapsackQuestion {

    public static int knapsack(int W, int[] weights, int[] values) {
        int[] dp = new int[W + 1];
        for (int i = 0; i < weights.length; i++) {
            int w = weights[i], v = values[i];
            for (int j = W; j >= w; j--) {
                if (dp[j - w] + v > dp[j]) {
                    dp[j] = dp[j - w] + v;
                }
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int[] weights = {1,3,4,5};
        int[] values = {1,4,5,7};
        int maxValue = knapsack(7, weights, values);
    }
}
