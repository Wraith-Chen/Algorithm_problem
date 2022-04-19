package 双指针;
/**
 * @Time 2022-4-17
 * @Title leetcode_11 盛最多水的容器
 * @Difficulty_Level middle
 */
/*
    双指针，根据题意得到面积公式S(i,j)=min(h[i],h[j])×(j−i)。
    在每个状态下，无论长板或短板向中间收窄一格，都会导致水槽 底边宽度 -1变短：
    若向内移动短板，水槽的短板 min(h[i], h[j]) 可能变大，因此下个水槽的面积 可能增大 。
    若向内移动长板，水槽的短板 min(h[i], h[j])不变或变小，因此下个水槽的面积 一定变小 。
 */
public class leetcode_11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
