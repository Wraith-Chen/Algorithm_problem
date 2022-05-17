package 剑指offer;

import java.util.HashMap;

/**
 * @Time 2022-05-16
 * @Title offer_07 重建二叉树
 * @Difficulty_Level middle
 */
/*
    使用递归，具体方法写在代码注释里了，这里阐述下我们正常去根据前序和中序遍历来画二叉树的逻辑：
    1.先看前序遍历第一个节点，第一个节点就是二叉树的根节点
    2.根据根节点去中序遍历中找到对应位置，左边所有元素贼是其左子树，右边所有元素是其右子树
    3.在前序遍历中找到根节点下一个节点，则为左子树的下一根节点
    4.再到中序遍历中去找该节点，新根节点左边所有元素贼是其左子树，右边所有元素是其右子树
    5.如此循环，前序遍历找根节点，中序遍历找左右子树
*/
public class offer_07 {
    int[] preorder;
    //新建前序遍历数组，方便递归调用
    HashMap<Integer, Integer> dic = new HashMap<>();
    //用HashMap存储中序遍历数组，方便根据前序数值（根节点）找到对应中序遍历中根节点位置
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        //引用前序遍历数组
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        //中序遍历结果存入Map里
        return recur(0, 0, inorder.length - 1);
        //递归循环
    }
    /**
     * @param root 根节点在前序遍历中的下标
     * @param left 该节点在中序遍历中的左边界
     * @param right 该节点在中序遍历中的右边界
     */
    TreeNode recur(int root, int left, int right) {
        if(left > right) return null;
        //递归终止条件当左边界大于右边界时，结束循环，该分支递归结束
        TreeNode node = new TreeNode(preorder[root]);
        //创建一个根节点
        int i = dic.get(preorder[root]);
        //根节点在中序遍历中的位置
        node.left = recur(root + 1, left, i - 1);
        //左节点递归
        //在前序遍历中的位置就是 根节点下标 + 1（右边一个单位）root + 1
        //在中序遍历中的位置就是 1.左边界不变2.右边界就是根节点左边一个单位
        node.right = recur(root + i - left + 1, i + 1, right);
        //右节点递归
        //在前序遍历中的位置就是 根节点下标+左子树+1 root+i-left+1（i-left为左子树长度）
        //在中序遍历中的位置就是 1.左边界在根节点的右边一个单位 i+1 2.右边界不变
        return node;
    }
}
