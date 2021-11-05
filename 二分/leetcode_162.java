package 二分;
/**
 * @Time 2021-11-5
 * @Title leetcode_162 寻找峰值
 * @Difficulty_Level middle
 */
/*
    方法一：遍历数组，设置标志变量，若当前元素大于下一个则为峰值元素。
    方法二：假设当前分割点 mid 满足关系 num[mid] > nums[mid + 1] 的话，
           想法是 num[mid] 可能为峰值，而 nums[mid + 1] 必然不为峰值，于是让 r = mid，从左半部分继续找峰值。
           对于一个满足 nums[x] > nums[x - 1] 的位置，x 的右边一定存在峰值；
           或对于一个满足nums[x]>nums[x+1] 的位置，x 的左边一定存在峰值。

 */
public class leetcode_162 {
    public int findPeakElement1(int[] nums) {
        int m = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[m]) {
                m = i;
            }
        }
        return m;
    }
    public int findPeakElement2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while( left < right ) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
