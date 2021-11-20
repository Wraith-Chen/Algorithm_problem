package 滑动窗口;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Time 2021-11-20
 * @Title leetcode_594 最长和谐子序列
 * @Difficulty_Level easy
 */
/*
    方法一：排序+双指针
    首先将数组元素排序，并定义双指针从头开始遍历，统计所有符合条件的窗口长度，并在所有长度中取最大值即是答案。
    方法二：哈希计数
    根据题意得出和谐子序列的长度为相邻两数（差值为1）的出现次数之和，利用哈希表统计所有nums[i]的出现次数，然后遍历数组，
    找出两数差值为1的所有可能，并在所有符合可能的的差值中找出长度最大的。
 */
public class leetcode_594 {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length,sum=0;
        for(int i=0,j=0;j<n;j++){
            while(i<j&&nums[j]-nums[i]>1) i++;
            if(nums[j]-nums[i]==1) sum=Math.max(sum,j-i+1);
        }
        return sum;
    }
    public int findLHS2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        int ans = 0;
        for (int i : nums) {
            if (map.containsKey(i - 1)) {
                ans = Math.max(ans, map.get(i) + map.get(i - 1));
            }
        }
        return ans;
    }
}
