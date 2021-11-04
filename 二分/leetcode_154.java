package 二分;
/**
 * @Time 2021-11-4
 * @Title leetcode_154 寻找旋转排序数组中的最小值 II
 * @Difficulty_Level hard
 */
/*
    二分这段时间也做了好多了，来挑战下困难题！！！
    此题相较于153的难点在于有重复元素，所以难以判断分界点。
    旋转有序数组考虑拆分为两个数组nums1和nums2，其中nums1任意一元素大于nums2任意一元素。
    设置 left, right 指针在 nums 数组两端，mid 为每次二分的中点：
    当 nums[mid] > nums[right]时，mid 一定在第 1 个排序数组中，i一定满足 mid < i <= right，因此执行 left = mid + 1；
    当 nums[mid] < nums[right] 时，mid 一定在第 2 个排序数组中，i一定满足 left < i <= mid，因此执行 right = mid；
    当 nums[mid] == nums[right] 时，采用right=right-1来解决这个问题。
        若 nums[right] 是唯一最小值：那就不可能满足判断条件 nums[mid] == nums[right]，
            因为 mid < right（left != right 且 mid = (left + right) // 2 向下取整）；
        若 nums[right] 不是唯一最小值，由于 mid < right 而 nums[mid] == nums[right]，
            即还有最小值存在于 [left, right - 1][left,right−1] 区间，因此不会丢失最小值。
 */
public class leetcode_154 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else if (nums[mid] < nums[right])
                right = mid;
            else
                right = right - 1;
        }
        return nums[left];
    }
}
