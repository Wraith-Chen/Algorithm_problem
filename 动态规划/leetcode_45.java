package 动态规划;
/**
 * @Time 2021-11-7
 * @Title leetcode_45 跳跃游戏II
 * @Difficulty_Level middle
 */
/*
    方法一：贪心算法，首先开始位置是nums[0]，根据nums[0]找可跳位置，并且在可跳位置里找最大的可跳次数，将这个次数更新为跳跃的边界，跳到该位置
            以此类推直到边界为最后一个元素。
    方法二：我们知道最终要到达最后一个位置，然后我们找前一个位置，遍历数组，找到能到达它的位置，离它最远的就是要找的位置。
            然后继续找上上个位置，最后到了第 0 个位置就结束了。
 */
public class leetcode_45 {
    public int jump1(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
    public int jump2(int[] nums){
        int position = nums.length-1;
        int steps=0;
        while(position!=0){
            for(int i=0;i<position;i++){
                if(nums[i]>=position-i){
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
