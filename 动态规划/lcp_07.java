package 动态规划;

/**
 * @Time 2021-11-17
 * @Title LCP 07 传递信息
 * @Difficulty_Level easy
 */
/*
    定义动态规划状态dp[i][j]为可以经过i轮传递到编号j的玩家的方案数。
    对于传信息的关系[src,dst]，如果第 i 轮传递到编号src 的玩家，
    则第 i+1轮可以从编号src 的玩家传递到编号dst 的玩家。因此在计算dp[i+1][dst] 时，需要考虑可以传递到编号dst 的所有玩家
    所以最终方案数为dp[i][dst] += dp[i-1][src]的和
 */
public class lcp_07 {
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int[] r : relation) {
                int a = r[0], b = r[1];
                dp[i][b] += dp[i - 1][a];
            }
        }
        return dp[k][n - 1];
    }
}
