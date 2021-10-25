package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time 2021-10-24
 * @Title leetcode_94 二叉树的中序遍历
 * @Difficulty_Level  easy
 */
/*
    这里介绍递归和迭代两种方法。（虽然我只想到了递归QAQ）
    递归：首先申请一个数组用来输出最后的结果，然后建立一个递归函数，函数每次返回一个根节点，数组，和数组长度。
    在函数内先遍历左子树，然后数组内存放当前节点，再遍历右子树。递归循环即可。
    迭代：首先申请一个数组用来输出最后的结果，接着依次将左子树依次入栈，然后从二叉树的最左子树出栈，存入数组，出栈后达到根节点，
    再从根节点找右子树入栈，再出栈存入数组中。知道根节点为空。
 */
public class leetcode_94 {

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            inorder(root, res);
            return res;
        }

        public void inorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }
    }
