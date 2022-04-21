package 递归迭代;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Time 2022-4-21
 * @Title leetcode_90 子集II
 * @Difficulty_Level middle
 */
/*
    组合去重问题都可以转化为树形结构。去重有两个维度，一个是同一树枝上使用过，一个是在同一树层上使用过。
    根据题意可知该题是去重在同一树层上的。同一树枝上的都是一个组合里的元素不用去重。
    这里重新申请一个标记数组，用来记录每一个元素是否被使用过。
    将数组排序后，相同元素一定相邻，因此该元素在之前与其他元素合并过，那么后面的相同元素即可跳过，达到去重目的。
 */
public class leetcode_90 {
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0){
            result.add(path);
            return result;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        subsetsWithDupHelper(nums, 0);
        return result;
    }

    private void subsetsWithDupHelper(int[] nums, int startIndex){
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;//不可重复获取
            }
            path.add(nums[i]);
            used[i] = true;
            subsetsWithDupHelper(nums, i + 1);
            path.removeLast();
            used[i] = false;
        }
    }
}
