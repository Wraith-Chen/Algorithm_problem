package 剑指offer;
/**
 * @Time 2022-03-21
 * @Title 剑指offer_04 二维数组中的查找
 * @Difficulty_Level middle
 */
/*
    利用该数组从上到下递增、从左到右递增的特点。我们可以设起始位置为数组左上角或者右下角。
    这里我们设起始搜索位置为数组左下角，设其为flag
    若 flag > target ，则 target 一定在 flag 所在 行的上方 ，即 flag 所在行可被消去。
    若 flag < target ，则 target 一定在 flag 所在 列的右方 ，即 flag 所在列可被消去。
    算法实现：
    从矩阵 matrix 左下角元素（索引设为 (i, j) ）开始遍历，并与目标值对比：
        当 matrix[i][j] > target 时，执行 i-- ，即消去第 i 行元素；
        当 matrix[i][j] < target 时，执行 j++ ，即消去第 j 列元素；
        当 matrix[i][j] = target 时，返回 true ，代表找到目标值。
    若行索引或列索引越界，则代表矩阵中无目标值，返回 false 。
 */
public class offer_04 {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int i = matrix.length - 1, j = 0;
            while(i >= 0 && j < matrix[0].length)
            {
                if(matrix[i][j] > target) i--;
                else if(matrix[i][j] < target) j++;
                else return true;
            }
            return false;
        }
    }
}
