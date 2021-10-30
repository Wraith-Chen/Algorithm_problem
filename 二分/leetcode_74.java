package 二分;
/**
 * @Time 2021-10-30
 * @Title leetcode_74 搜索二维矩阵
 * @Difficulty_Level middle
 */
/*
    搜索二维矩阵。
    以二维数组左下角为原点，建立直角坐标轴。
    若当前数字>查找数，查找往上移一位。
    若当前数字<查找数，查找往右移一位。

 */
public class leetcode_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
                int rows = matrix.length - 1, columns = 0;
                while (rows >= 0 && columns < matrix[0].length) {
                    int num = matrix[rows][columns];
                    if (num == target) {
                        return true;
                    } else if (num > target) {
                        rows--;
                    } else {
                        columns++;
                    }
                }
                return false;
    }
}
