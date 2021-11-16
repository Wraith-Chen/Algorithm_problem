package 动态规划;
/**
 * @Time 2021-11-16
 * @Title 剑指 Offer 10- I. 斐波那契数列
 * @Difficulty_Level easy
 */
/*
    简单的斐波那契数列，递归求解。
 */
public class offer_10 {
    int mod = (int)1e9+7;
    public int fib(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            c %= mod;
            a = b;
            b = c;
        }
        return b;
    }
}
