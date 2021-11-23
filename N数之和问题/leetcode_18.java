package N数之和问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Time 2021-11-23
 * @Title leetcode_18 四数之和
 * @Difficulty_Level middle
 */
/*
    解题名言：犹豫不决先排序，步步逼近双指针
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    对数组进行排序，使用四个指针 i、j 、k 和 p 分别代表要找的四个数。
    通过枚举 i 确定第一个数，枚举 j 确定第二个数，另外两个指针 k 和 p 分别从左边 j + 1 和右边 n - 1 往中间移动，找到满足 nums[i] + nums[j] + nums[k] + nums[p] == t 的所有组合。
    k 和 p 指针的移动逻辑，分情况讨论 sum = nums[i] + nums[j] + nums[k] + nums[p] ：
    sum > target：p 左移，使 sum 变小
    sum < target：k 右移，使 sum 变大
    sum = target：将组合加入结果集，k 右移继续进行检查
 */
public class leetcode_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1, p = n - 1;
                while (k < p) {
                    while (k > j + 1 &&k<n&& nums[k] == nums[k - 1])
                        k--;
                    if (k >= p)
                        break;
                    int ans = nums[i] + nums[j] + nums[k] + nums[p];
                    if (ans == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[p]));
                        k++;
                    } else if (ans > target) {
                        p--;
                    } else if (ans < target) {
                        k++;
                    }
                }
            }
        }
        return res;
    }
}
