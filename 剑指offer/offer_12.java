package 剑指offer;
/**
 * @Time 2022-05-21
 * @Title 剑指offer_12 矩阵中的路径
 * @Difficulty_Level middle
 */
/*
    dfs解题，首先这道题没说起点，所以我们要枚举所有起点。
    从该点出发向四周搜索单词word，并记录此时枚举到单词word的第u个位置（u从0开始）
    如果匹配上了board[x][y] == word[u]，则向四周搜索
    直到枚举到单词word的最后一个字母返回true，否则返回false
    当搜索过程出现当前位置board[x][y] != word[u]返回false
    u == word.size() - 1,成功搜索到单词末尾，返回true
    从搜索过的位置继续搜索下一层时，需要对当前位置进行标识，表示已搜索
*/
public class offer_12 {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length; j++)
                if(dfs(board,word,0,i,j)) return true;
                //两层循环枚举二维数组中所有可能起点
        return false;
    }
    int[] dx = new int[]{-1,0,1,0}, dy = new int[]{0,1,0,-1};
    //定义四个方向，左下右上。
    boolean dfs(char[][] board, String word,int u,int x,int y)
    {
        if(board[x][y] != word.charAt(u)) return false;
        //不合法，所以返回false
        if(u == word.length() - 1)   return true;
        //枚举到最后一个返回true
        char t = board[x][y];
        board[x][y] = '.';
        //标记当前为字符为“.”证明已经遍历过
        for(int i = 0; i < 4; i++)//每一个点的四个方向都要遍历
        {
            int a = x + dx[i], b = y + dy[i];
            if(a < 0 || a >= board.length|| b < 0 || b >= board[0].length || board[a][b] == '.')  continue;
            if(dfs(board,word,u+1,a,b)) return true;
        }
        board[x][y] = t;
        //将元素更新回来，以免影响其他通路
        return false;
    }
}
