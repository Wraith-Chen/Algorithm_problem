package 动态规划;

/**
 * @Time 2021-11-9
 * @Title leetcode_115 不同的子序列
 * @Difficulty_Level hard
 */
/*
   匹配字符串，想到动态规划。对于两个字符串匹配，一个非常通用的状态定义如下：定义f[i][j]为考虑s中[0,i]个字符串，t中[0,j]个字符的匹配个数
   那么显然对于某个f[i][j]而言，从最后一步的匹配进行分析
   1.s[i]不参与匹配，也就是要让s中[0,i-1]个字符去匹配t中[0,j]字符。此时匹配值为f[i-1][j]
   2.s[i]参与匹配，这时候只需让s中[0,i-1]个字符去匹配t中的[0,j-1]字符即可，同时满足s[i]=t[j]，此时值为f[i-1][j-1]
   最终就是两者之和
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   这里记忆一下字符串匹配的两种通用状态
    1.f[i][j] 表示「第一个字符 s 中 [0,i]个字符」与「第二个字符 t 中 [0,j] 个字符」的匹配结果
    2.f[i][j] 表示「第一个字符 s 中 [0,i] 个字符」与「第二个字符 t 中 [0,j]个字符」且 「最后一个字符为 t[j]」的匹配结果
    3.往两个字符串的头部追加「不存在」的字符，目的是为了能够构造出可以滚动（被累加）下去的初始化值
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   这个模板太巧秒了，三叶姐yyds！！！
 */
public class leetvode_115 {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        if (m < n) {
            return 0;
        }
        s = " " + s;
        t = " " + t;
        char[] cs = s.toCharArray(), ct = t.toCharArray();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (cs[i] == ct[j]) {
                    f[i][j] += f[i - 1][j - 1];
                }
            }
        }
        return f[n][m];
    }
}
