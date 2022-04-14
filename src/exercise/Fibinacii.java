package exercise;

public class Fibinacii {
//    public static long fib(int n, long a, long b) {
//        return n == 0 ? b : fib(n-1, a+b, a);
//    }
//

    public static long fibRec(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static long fibTopDown(int n) {
        return fibTopDownCore(n, new long[n + 1]);
    }

    private static long fibTopDownCore(int n, long[] memo) {
        if (n == 0 || n == 1) return n;

        if (memo[n] != 0) {
            return memo[n];
        }
        return fibTopDownCore(n - 1, memo) + fibTopDownCore(n - 2, memo);
    }

    public static long fibBottomUp(int n) {
        if (n == 0 || n == 1) return n;

        long[] memo = new long[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

    public static long fibTwoVar(int n) {
        if (n == 0 || n == 1) return n;

        long a = 0;
        long b = 1;
        long c = -1;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        long result1 = fibRec(4);
        long result2 = fibTopDown(4);
        long result3 = fibBottomUp(4);
        long result4 = fibTwoVar(4);
    }
}
