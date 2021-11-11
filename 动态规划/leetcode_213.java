package 动态规划;

/**
 * @Time 2021-11-11
 * @Title leetcode_213 打家劫舍 II
 * @Difficulty_Level middle
 */
/*
    最典型的动态规划题
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    首先就此题而言，环形排列意味着第一个房子和最后一个房子只能选择一个偷窃，因此可以把环形排列房间问题简化为两个单排排列房间的子问题
        1.在不偷窃第一个房子的情况下（即 nums[1:]），最大金额是 p1
        2.在不偷窃最后一个房子的情况下（即 nums[:n-1]），最大金额是 p2
    最后比较两个值，取最大即为该题结果。
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    借此，这里也详细写一遍动态规划的标准解题流程：
    1.状态定义
        设动态规划列表 dp，dp[i] 代表前 i个房子在满足条件下的能偷窃到的最高金额。
    2.转移方程
        设： 有 n个房子，前 n间能偷窃到的最高金额是 dp[n]，前 n-1间能偷窃到的最高金额是 dp[n-1]，此时向这些房子后加一间房，此房间价值为 num
        向后加一间房子，由于不能抢相邻的房间，意味着抢第n+1间就不能抢n间，那么dp[n+1]的值分为以下两种情况：
            1.不抢第n+ 1个房间，因此等于前n个房子的最高金额，即dp[n + 1] = dp[n] ;
            2.抢第n+1个房间，此时不能抢第n个房间;因此等于前n-1个房子的最高金额加上当前房间价值，即dp[n+1]=dp[n-1]+num;
    3.初始状态
        前0间房子的最大偷窃价值为0，即dp[0]=0
    4.返回值
        返回dp列表最后一个元素，即所有房间的最大偷窃价值
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    这里学习一个新的方法，来自Arrays类：
    Arrays.copyOfRange(T[ ] original,int from,int to)将一个原始的数组original，从下标from开始复制，复制到上标to，生成一个新的数组。
    左闭右开区间
 */
public class leetcode_213 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(judge(nums, 0, length - 2), judge(nums, 1, length - 1));
    }

    public int judge(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
