package 剑指offer;

import java.util.Stack;

/**
 * @Time 2022-03-19
 * @Title 剑指offer_30 包含min函数的栈
 * @Difficulty_Level easy
 */
/*
    我们知道普通栈的push()和pop()函数的复杂度为O(1) ；而获取栈最小值 min() 函数需要遍历整个栈，复杂度为O(N)。所以本题难点在于将min()函数的复杂度降为O(1)，
    因此考虑维护两个栈。
    栈stackA用于维护正常的数据栈，保证push()pop()top()函数的正常逻辑。
    栈stackB用于辅助，保证栈A中的最小元素始终对应栈B的栈顶元素。
    因此对于min函数我们保持其实降序排列就好，
    push()函数：
    1.将 x 压入栈 A （即 A.push(x) ）；
    2.若栈B为空或x小于等于栈B的栈顶元素，则将x压入栈B（即 B.push(x)）。
    pop()函数：
    1.执行栈A出栈（即 A.pop() ），将出栈元素记为y；
    2.若y等于栈B的栈顶元素，则执行栈B出栈（即 B.pop() ）。
    top()函数：返回栈A的栈顶元素，即返回 A.peek() 。
    min()函数：返回栈B的栈顶元素，即返回 B.peek() 。

 */
public class offer_30 {

    private Stack<Integer> stackA;
    private Stack<Integer> stackB;

    /** initialize your data structure here. */
    public void MinStack() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {
        stackA.push(x);
        if(stackB.isEmpty()||stackB.peek()>=x){
            stackB.push(x);
        }
    }

    public void pop() {
        if(stackA.pop().equals(stackB.peek()))
            stackB.pop();
    }

    public int top() {
        return stackA.peek();
    }

    public int min() {
        return stackB.peek();
    }
}
