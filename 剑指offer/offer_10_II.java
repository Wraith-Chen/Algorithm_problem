package 剑指offer;
/**
 * @Time 2022-5-18
 * @Title 剑指 Offer 10- II. 青蛙跳台阶问题
 * @Difficulty_Level easy
 */
/*
    经典动态规划
    1.状态定义
        设dp数组，dp[i]代表当前台阶有多少种跳法，n个台阶有f(n)种跳法
    2.转移方程
        当为 1 级台阶： 剩 n-1 个台阶，此情况共有 f(n-1) 种跳法；
        当为 2 级台阶： 剩 n-2 个台阶，此情况共有 f(n-2) 种跳法。
        dp[i]=dp[i-1]+dp[i-2],
    3.初始状态
        dp[0]=1 dp[1]=1 dp[2]=1
    4.返回值
        返回dp[n]即到台阶n有多少解法
 */
public class offer_10_II {
    public int numWays_1(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
    public int numWays_2(int n){
        //定义状态数组
        int[] dp = new int[Math.max(n+1,3)];
        dp[0]=1;
        dp[1]=1;
        dp[2]=1;
        for(int i=0;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }
}
