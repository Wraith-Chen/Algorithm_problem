package 剑指offer;

/**
 * @Time 2021-11-16
 * @Title 剑指 Offer 42. 连续子数组的最大和
 * @Difficulty_Level easy
 */
/*
    连续并且状态可继承，优先想到动态规划，这里再按照动态规划解题流程写一遍，加深印象。
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    状态定义：设动态规划列表 dp ，dp[i]代表以元素 nums[i]为结尾的连续子数组最大和。
        为何定义最大和 dp[i]中必须包含元素 nums[i]：保证 dp[i]递推到 dp[i+1]的正确性；如果不包含 nums[i]，递推时则不满足题目的连续子数组要求。
    转移方程：
        若 dp[i−1]≤0 ，说明 dp[i - 1]对 dp[i]产生负贡献，即 dp[i-1] + nums[i]还不如 nums[i]本身大。
        当 dp[i−1]>0 时：执行 dp[i] = dp[i-1] + nums[i]；
        当 dp[i−1]≤0 时：执行 dp[i] = nums[i] ；
    初始状态：
        dp[0] = nums[0]，即以 nums[0]结尾的连续子数组最大和为 nums[0]。
    返回值：
        返回 dp列表中的最大值，代表全局最大值。
 */
public class offer_42 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
