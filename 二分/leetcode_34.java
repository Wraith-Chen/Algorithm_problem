package 二分;
/**
 * @Time 2021-10-28
 * @Title leetcode_34 在排序数组中查找元素的第一个和最后一个位置
 * @Difficulty_Level middle
 */
/*
    ”二分很简单，细节是魔鬼”
    现在凡是刷到有序数组的问题都习惯用二分去解决，这题显然很适合二分去做。考虑到用两次二分，第一次二分查找第一个>=target的位置。第二次二分查找最后一个<=target的位置。
    对于第二次二分，当我们更新区间时，如果左边界l更新为l = mid，此时mid的取值就应为mid = (l + r + 1)/ 2。因为当右边界r = l + 1时，此时mid = (l + l + 1)/2，
    相当于下取整，mid为l，左边界再次更新为l = mid = l，相当于没有变化。while循环就会陷入死循环。因此，我们总结出来一个小技巧，当左边界要更新为l = mid时，
    我们就令 mid =(l + r + 1)/2，相当于上取整，此时就不会因为r取特殊值 r = l + 1而陷入死循环了。
    而对于第一次二分，如果左边界l更新为l = mid + 1，是不会出现这样的困扰的。

 */
public class leetcode_34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1,-1};

        int l = 0, r = nums.length - 1;
        while( l < r)
        {
            int mid = (l + r )/2;
            if(nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if( nums[r] != target) return new int[]{-1,-1};
        int L = r;
        l = 0; r = nums.length - 1;
        while( l < r)
        {
            int mid = (l + r + 1)/2;
            if(nums[mid] <= target ) l = mid;
            else r = mid - 1;
        }
        return new int[]{L,r};
    }

}
