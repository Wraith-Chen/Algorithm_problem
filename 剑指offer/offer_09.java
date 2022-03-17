package 剑指offer;

import java.util.Stack;

/**
 * @Time 2022-03-17
 * @Title 剑指offer_09 用两个栈实现队列
 * @Difficulty_Level easy
 */
/*
    维护连个栈，一个栈A负责数据加入队尾，一个栈B负责数据从队头删除。其中栈B为栈A元素的倒序。
    加入队尾 appendTail()函数： 将数字 value 加入栈 A 即可。删除队首deleteHead()函数： 有以下三种情况。
        当栈 B 不为空： B中仍有已完成倒序的元素，因此直接返回 B 的栈顶元素。
        否则，当 A 为空： 即两个栈都为空，无元素，因此返回 -1 。
        否则： 将栈 A 元素全部转移至栈 B 中，实现元素倒序，并返回栈 B 的栈顶元素。
 */
public class offer_09 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public void CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}
