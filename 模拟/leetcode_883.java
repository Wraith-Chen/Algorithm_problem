package 模拟;

import java.util.HashMap;

/**
 * @Time 2022-4-27
 * @Title leetcode_883 三维形体投影面积
 * @Difficulty_Level easy
 */
/*
    简单模拟题，
    俯视图，只要该格子上有方块就占面积；
    侧视图，判断行元素，找出每一行最大的元素
    正视图，判断列元素，找出每一列最大的元素
 */
public class leetcode_883 {
    public int projectionArea(int[][] grid) {
        int up=0,left=0,front=0;
        for(int i = 0;i<grid.length;i++){
            int a=0,b=0;
            for(int j = 0 ;j< grid.length;j++){
                if(grid[i][j]>0) up++;
                a=Math.max(a,grid[i][j]);
                b=Math.max(b,grid[j][i]);
            }
            left+=a;
            front+=b;
        }
        return up+left+front;
    }
}
