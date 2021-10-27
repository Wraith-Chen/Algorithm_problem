package 二分;
/**
 * @Time 2021-10-27
 * @Title leetcode_33 搜索旋转排序数组
 * @Difficulty_Level middle
 */
/*
    首先想到的是用Arrays.sort()去排序该数组然后再用二分去查找，但看了题解后发现可以直接用二分查找。此题的数组特点是螺旋数组，将数组一份为二后可以发现
    两部分都是有序的。我们可以在常规二分查找的时候查看当前 mid 为分割位置分割出来的两个部分 [l, mid] 和 [mid + 1, r] 哪个部分是有序的，
    并根据有序的那个部分确定我们该如何改变二分查找的上下界，因为我们能够根据有序的那部分判断出 target 在不在这个部分。每次通过比较nums[0]和nums[mid]
    的大小关系来确定边界。

 */
public class leetcode_33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0,right = n - 1;
        while(left<=right){
            int mid = (left+right)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}