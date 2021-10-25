package 二分;

/**
 * @Time 2021-10-25
 * @Title leetcode_240 搜索二维矩阵 II
 * @Difficulty_Level middle
 */
/*
    第一种：暴力解法
    直接暴力遍历即可。
    第二种：二分查找
    每一行为一组，头尾一起开始查找，每次比较中间值和目标值的大小，并不断缩小区间大小。
 */
public class leetcode_240 {

    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int element : row) {
                if (element == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int left = 0, right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
