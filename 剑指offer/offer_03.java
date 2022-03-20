package 剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Time 2022-03-20
 * @Title 剑指offer_03 数组中重复的数字
 * @Difficulty_Level easy
 */
/*
    方法一：
    首先想到哈希表。利用其一对一的数据结构特点,HashSet记录数组的各个数字，当查找到重复数字则直接返回。
    方法二：
    交换索引与数据位置，使元素的 索引 与 值 一一对应（即nums[i]=i ）。因而，就能通过索引映射对应的值，起到与字典等价的作用。
    遍历中，第一次遇到数字x时，将其交换至索引x处；而当第二次遇到数字x时，一定有nums[x]=x此时即可得到一组重复数字。
    1.遍历数组nums，设索引初始值为i=0 :
        1)若nums[i]=i ： 说明此数字已在对应索引位置，无需交换，因此跳过；
        2)若nums[nums[i]]=nums[i] ： 代表索引nums[i] 处和索引i处的元素值都为nums[i]，即找到一组重复值，返回此值nums[i] ；
        3)否则：交换索引为i和nums[i] 的元素值，将此数字交换至对应索引位置。
    2.若遍历完毕尚未返回，则返回−1 。
 */
public class offer_03 {
    private Set<Integer> set = new HashSet<>();
    public int findRepeatNumber_1(int[] nums) {
        for(int num:nums){
            if(set.contains(num)){
                return num;
            }else {
                set.add(num);
            }
        }
        return -1;
    }
    public int findRepeatNumber_2(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
