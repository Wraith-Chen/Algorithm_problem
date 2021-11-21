package N数之和问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Time 2021-11-21
 * @Title leetcode_15 三数之和
 * @Difficulty_Level middle
 */
/*
    解题名言：犹豫不决先排序，步步逼近双指针
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    该题难度就在于如何去除重复元素。
    首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的首尾两端，数字分别为 nums[L]和 nums[R]，
    计算三个数的和sum判断是否满足为0，满足则添加进结果
    如果 nums[i]大于 0，则三数之和必然无法等于0，结束循环
    如果nums[i] ==nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
    当 sum==0时，nums[L] ==nums[L+1] 则会导致结果重复，应该跳过，L++
    当 sum==0时，nums[R] == nums[R−1] 则会导致结果重复，应该跳过，R--
 */
public class leetcode_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0)
                break;
            if (k > 0 && nums[k] == nums[k - 1])//k值去重
                continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;//左指针前进并去重
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;//右指针后退并去重
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;//左指针前进并去重
                    while (i < j && nums[j] == nums[--j]) ;//右指针后退并去重
                }
            }
        }
        return res;
    }
}
