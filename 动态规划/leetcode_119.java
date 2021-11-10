package 动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time 2021-11-10
 * @Title leetcode_119 杨辉三角II
 * @Difficulty_Level easy
 */
/*
    经典杨辉三角，地推即可求解。这里学着写几个优化方法
    优化一：注意到对第 i+1行的计算仅用到了第 i行的数据，因此可以使用滚动数组的思想优化。
    优化二：当前行第 i 项的计算只与上一行第 i-1 项及第 i项有关。因此我们可以倒着计算当前行，这样计算到第i项时，第i-1项仍然是上一行的值。

 */
public class leetcode_119 {
    public List<Integer> getRow1(int rowIndex) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(row);
        }
        return list.get(rowIndex);
    }
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> cur = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }
    public List<Integer> getRow3(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
