package 二分;
import java.util.Arrays;
/**
 * @Time 2021-11-3
 * @Title leetcode_153 寻找旋转排序数组中的最小值
 * @Difficulty_Level middle
 */
/*
    方法一：排序，不多解释
    方法二：二分查找，此题左右临界值需要注意。
    首先是右侧，每次比较后r=mid而不是r=mid-1,，容易丢失最小值
    其次是左侧，如果其大于，则往下前进一个则OK。
 */
public class leetcode_153 {
    public int findMin1(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
    public int findMin2(int[] nums){
        int l = 0,r = nums.length-1;
        while(l<r){
            int mid = l + (r-l)/2 ;
            if(nums[mid]<nums[r]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return nums[l];
    }
}
