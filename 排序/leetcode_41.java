package 排序;
/**
 * @Time 2021-11-18
 * @Title leetcode_41 缺失的第一个正数
 * @Difficulty_Level hard
 */
/*
    再次来挑战困难题，这道题采用归位法，其实也是桶排序！！
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    我们把所有的1 <= nums[i] <= nums.length的数字进行归位。比如当nums[i] == 1的时候，我们把它放在第0个位置，当nums[i] == 2的时候，我们把它放在第1个位置.....

    举个例子[3,4,-1,1]，归位之后为[1,4,3,-1]，其中数字1和3，分别都归位到了第0个位置和第2个位置。比如现在nums[i]==5，那么我们就要看下标为4 (即nums[i] - 1)的位置，
    看下标为4的位置上放的是不是5 (即nums[i])，如果下标为4的地方存放的是其他的数字，就进行交换，把5归位

    然后遍历归位后的数组，当当前下标存放的数字并不是对应的数字，即nums[i] != i + 1的时候，i + 1就是缺失的第一个整数

    如果遍历结束，说明1到nums.length都出现过了，则返回nums.length + 1
 */
public class leetcode_41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
