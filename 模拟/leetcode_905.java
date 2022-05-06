package 模拟;
/**
 * @Time 2022-4-29
 * @Title leetcode_905 按奇偶排序数组
 * @Difficulty_Level easy
 */
/*
    简单模拟，双指针。
*/
public class leetcode_905 {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        for (int i = 0, j = n - 1; i < j; i++) {
            if (nums[i] % 2 == 1) {
                int c = nums[j];
                nums[j--] = nums[i];
                //原有位置i交换后不确保是偶数
                nums[i--] = c;
            }
        }
        return nums;
    }
}
