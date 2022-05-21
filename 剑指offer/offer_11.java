package 剑指offer;
/**
 * @Time 2022-05-21
 * @Title 剑指 Offer 11 旋转数组的最小数字
 * @Difficulty_Level easy
 */
/*
    水题，遍历即可
 */
public class offer_11 {
    public int minArray(int[] numbers) {
        int min  = numbers[0];
        for(int i = 1 ; i<numbers.length;i++)
            min =  Math.min(min,numbers[i]);
        return min;
    }
}
