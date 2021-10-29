package 二分;
/**
 * @Time 2021-10-29
 * @Title leetcode_35 搜索插入位置
 * @Difficulty_Level easy
 */
/*
    ”二分很简单，细节是魔鬼”
    整体思路和二分没有什么区别，每次根据 nums[mid] 和 target 之间的大小进行判断，相等则直接返回下标，nums[mid] < target 则 left 右移，nums[mid] > target 则 right 左移，
    查找结束如果没有相等值则返回 left，该值为插入位置
 */
public class leetcode_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
}
