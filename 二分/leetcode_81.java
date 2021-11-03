package 二分;
/**
 * @Time 2021-11-1
 * @Title leetcode_81 搜索旋转排序数组 II
 * @Difficulty_Level middle
 */
/*
    简单恢复二分顺序性的题目。6 77 11 22 33 44 55 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2；
    这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]。则在后半部分找，否则去前半部分找。

 */
public class leetcode_81 {
    public boolean search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int start = 0;
            int end = nums.length - 1;
            int mid;
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                if (nums[start] == nums[mid]) {
                    start++;
                    continue;
                }
                //前半部分有序
                if (nums[start] < nums[mid]) {
                    //target在前半部分
                    if (nums[mid] > target && nums[start] <= target) {
                        end = mid - 1;
                    } else {  //否则，去后半部分找
                        start = mid + 1;
                    }
                } else {
                    //后半部分有序
                    //target在后半部分
                    if (nums[mid] < target && nums[end] >= target) {
                        start = mid + 1;
                    } else {  //否则，去后半部分找
                        end = mid - 1;

                    }
                }
            }
            //一直没找到，返回false
            return false;

        }
    }