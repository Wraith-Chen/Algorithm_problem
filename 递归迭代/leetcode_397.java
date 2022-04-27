package 递归迭代;

import java.util.HashMap;
import java.util.Map;

/**
 * @Time 2022-4-22
 * @Title leetcode_397 整数替换
 * @Difficulty_Level middle
 */
/*
    方法一：枚举
    方法二：记忆化搜索，DFS，用一个Map集合做标记，如果该值运算过则取消重复运算，跳过即可。
    方法三：贪心（位运算）
    我们可以从二进制角度进行分析，给定起始值n，求其变为（00000...000001）的最小步数
    对于偶数（二进制最低位为 0）而言，我们只能进行一种操作，其作用是将当前值 x 其进行一个单位的右移；
    对于奇数（二进制最低位为 1）而言，我们能够进行 +1 或 -1 操作，分析两种操作为 x 产生的影响：
        对于 +1 操作而言：最低位必然为 1，此时如果次低位为 0 的话， +1 相当于将最低位和次低位交换；
        如果次低位为 1 的话，+1 操作将将「从最低位开始，连续一段的 1」进行消除（置零），并在连续一段的高一位添加一个 1；
        对于 -1 操作而言：最低位必然为 1，其作用是将最低位的 1 进行消除。
    因此，对于 xx 为奇数所能执行的两种操作，+1 能够消除连续一段的 1，只要次低位为 1（存在连续段），应当优先使用 +1 操作，
    但需要注意边界 x=3 时的情况（此时选择 -1 操作）。

 */
public class leetcode_397 {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int integerReplacement_1(int n) {
            if (n == 1) {
                return 0;
            }
            if (n % 2 == 0) {
                return 1 + integerReplacement_1(n / 2);
            }
            return 2 + Math.min(integerReplacement_1(n / 2), integerReplacement_1(n / 2 + 1));
    }

        public int integerReplacement_2(int n) {
            if (n == 1) {
                return 0;
            }
            if (!memo.containsKey(n)) {
                if (n % 2 == 0) {
                    memo.put(n, 1 + integerReplacement_2(n / 2));
                } else {
                    memo.put(n, 2 + Math.min(integerReplacement_2(n / 2), integerReplacement_2(n / 2 + 1)));
                }
            }
            return memo.get(n);
        }
    public int integerReplacement_3(int _n) {
        long n = _n;
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n >>= 1;
            } else {
                if (n != 3 && ((n >> 1) & 1) == 1) n++;
                else n--;
            }
            ans++;
        }
        return ans;
    }
}
