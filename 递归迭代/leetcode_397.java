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
