package 排序;

import java.util.Arrays;

/**
 * @Time 2021-11-19
 * @Title leetcode_268 丢失的数字
 * @Difficulty_Level easy
 */
/*
    方法一：排序
    将数组排序之后，即可根据数组中每个下标处的元素是否和下标相等，得到丢失的数字。
    方法二：数学求和
    计算n个数字的总和，减去数组相加的和，得到的差值就是要找的数字
    方法三：哈希求值
    利用 nums的数值范围为 [0,n]，且只有一个值缺失，我们可以直接开一个大小为 n + 1的数组充当哈希表，进行计数，没被统计到的数值即是答案。
    方法四：异或
 */
public class leetcode_268 {
    public int missingNumber1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i<n;i++){
            if(nums[i]!=i) {
                return i;
            }
        }
        return n;
    }
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int cur = 0, sum = n * (n + 1) / 2;
        for (int i : nums) cur += i;
        return sum - cur;
    }
    public int missingNumber3(int[] nums) {
        int n = nums.length;
        boolean[] hash = new boolean[n + 1];
        for (int i = 0; i < n; i++) hash[nums[i]] = true;
        for (int i = 0; i < n; i++) {
            if (!hash[i]) return i;
        }
        return n;
    }
    public int missingNumber4(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i <= n; i++) ans ^= i;
        for (int i : nums) ans ^= i;
        return ans;
    }
}
