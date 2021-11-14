package 动态规划;
/**
 * @Time 2021-11-14
 * @Title leetcode_338 比特位计数
 * @Difficulty_Level easy
 */
/*
    方法一：JAVA中自带Integer.bitCount()方法，用于计算给定整数的二进制表示中1的数目。
    方法二：看题解才明白的方法，利用动态规划，如果当前数字是偶数，则1的个数与当前数字除以2后数字的1的个数相同
    即 dp[i]=dp[i/2],如果当前数字是奇数，则1的个数是当前数字除以2后数字的1的个数+1
    即 dp[i]=dp[i/2]+1
    综合起来，dp[i]=dp[i/2]+(i%2)
 */
public class leetcode_338 {
    public int[] countBits1(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0;i<n;i++){
            ans[i]=Integer.bitCount(i);
        }
        return ans;
    }
    public int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i/2] + (i & 1);
        }
        return bits;
    }
}
