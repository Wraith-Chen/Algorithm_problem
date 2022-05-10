package 栈;

import java.util.Stack;

/**
 * @Time 2022-5-8
 * @Title leetcode_155 最小栈
 * @Difficulty_Level easy
 */
/*
    新建一个栈用来存放最小的，每次进栈都和栈顶元素比较。
*/
public class leetcode_155 {
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;
    public leetcode_155() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }
    public void push(int x) {
        stack.push(x);
        if(min_stack.isEmpty() || x <= min_stack.peek())
            min_stack.push(x);
    }
    public void pop() {
        if(stack.pop().equals(min_stack.peek()))
            min_stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min_stack.peek();
    }

}
