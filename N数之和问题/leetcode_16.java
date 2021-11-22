package N数之和问题;

import java.util.Arrays;

/**
 * @Time 2021-11-22
 * @Title leetcode_16 最接近的三数之和
 * @Difficulty_Level middle
 */
/*
    解题名言：犹豫不决先排序，步步逼近双指针
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    类似于leetcode_15三数之和的题，先排序，定义两个指针从头遍历数组，使用前指针指向 start = i + 1 处，后指针指向 end = nums.length - 1 处，也就是结尾处
    根据 sum = nums[i] + nums[start] + nums[end] 的结果，判断 sum 与目标 target 的距离，如果更近则更新结果 ans
    同时判断 sum 与 target 的大小关系，因为数组有序，如果 sum > target 则 end--，
    如果 sum < target 则 start++，如果 sum == target 则说明距离为 0 直接返回结果

 */
public class leetcode_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res=nums[0]+nums[1]+nums[2];
        for(int i = 0;i<nums.length;i++){
            int start=i+1,end=nums.length-1;
            while(start<end){
                int sum=nums[start]+nums[end]+nums[i];
                if(Math.abs(target-sum)<Math.abs(target-res))
                    res=sum;
                if(sum>target)
                    end--;
                else if(sum<target)
                    start++;
                else
                    return res;
            }
        }
        return res;
    }
}
