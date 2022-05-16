package 剑指offer;

import java.util.Stack;

/**
 * @Time 2022-05-16
 * @Title offer_06 从尾到头打印链表
 * @Difficulty_Level easy
 */
/*
    辅助栈，每个元素入栈，最后弹栈，填入数组。
*/
public class offer_06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0;i<res.length;i++){
            res[i] = stack.pop();
        }
        return res;
    }
}
