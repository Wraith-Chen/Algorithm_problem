package 动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * @Time 2021-11-15
 * @Title leetcode_403 青蛙过河
 * @Difficulty_Level hard
 */
/*
    方法一：DFS
    复习一下之前学过的方法containsKey()判断是否包含指定的键。
    需要知道当前所在位置在哪，也就是需要知道当前石子所在列表中的下标 u。
    需要知道当前所在位置是经过多少步而来的，也就是需要知道上一步的跳跃步长 k。
    直接使用「哈希表」作为记忆化容器。
 */
public class leetcode_403 {
    //方法一DFS
    Map<Integer, Integer> map = new HashMap<>();

    public boolean canCross1(int[] ss) {
        int n = ss.length;
        for (int i = 0; i < n; i++) {
            map.put(ss[i], i);
        }
        if (!map.containsKey(1))
            return false;
        //u：当前石子所在列表的下标u
        //k：上一步跳跃长度k
        return dfs(ss, ss.length, 1, 1);
    }

    boolean dfs(int[] ss, int n, int u, int k) {
        if (u == n - 1)
            return true;
        for (int i = -1; i <= 1; i++) {
            if (k + i == 0)
                continue;
            // 下一步的石子理论编号
            int next = ss[u] + k + i;
            // 如果存在下一步的石子，则跳转到下一步石子，并 DFS 下去
            if (map.containsKey(next)) {
                boolean cur = dfs(ss, n, map.get(next), k + i);
                if (cur)
                    return true;
            }
        }
        return false;
    }

    //方法二 动态规划
    public boolean canCross2(int[] ss) {
        int n = ss.length;
        // check first step
        if (ss[1] != 1) return false;
        boolean[][] f = new boolean[n + 1][n + 1];
        f[1][1] = true;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int k = ss[i] - ss[j];
                // 我们知道从位置 j 到位置 i 是需要步长为 k 的跳跃
                // 而从位置 j 发起的跳跃最多不超过 j + 1
                // 因为每次跳跃，下标至少增加 1，而步长最多增加 1
                if (k <= j + 1) {
                    f[i][k] = f[j][k - 1] || f[j][k] || f[j][k + 1];
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (f[n - 1][i]) return true;
        }
        return false;
    }
}
