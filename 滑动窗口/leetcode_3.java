package 滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @Time 2022-4-28
 * @Title leetcode_3 无重复字符的最长子串
 * @Difficulty_Level middle
 */
/*
    定义两个指针 start 和 end，表示当前处理到的子串是 [start,end]。
    [start,end] 始终满足要求：无重复字符。
    从前往后进行扫描，同时维护一个哈希表记录 [start,end] 中每个字符出现的次数。
    遍历过程中，end 不断自增，将第 end 个字符在哈希表中出现的次数加一。
    令 right 为 下标 end 对应的字符，当满足 map.get(right) > 1 时，代表此前出现过第 end 位对应的字符。
    此时更新 start 的位置（使其右移），直到不满足 map.get(right) > 1 （代表 [start,end] 恢复满足无重复字符的条件）。同时使用 [start,end] 长度更新答案。
*/
public class leetcode_3 {
 public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0,start=0 ,end=0;
        for (   ; end < s.length(); end++) {
            char right = s.charAt(end);
            map.put(right, map.getOrDefault(right, 0) + 1);
            while (map.get(right) > 1) {
                char left = s.charAt(start);
                map.put(left, map.get(left) - 1);
                start++;
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}
