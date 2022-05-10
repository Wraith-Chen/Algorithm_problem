package 栈;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * @Time 2022-05-09
 * @Title leetcode_232 用栈实现队列
 * @Difficulty_Level easy
 */
/*
    无论「用栈实现队列」还是「用队列实现栈」，思路都是类似的。
    都可以通过使用两个栈/队列来解决。
    我们创建两个栈，分别为 out 和 in，用作处理「输出」和「输入」操作。
    其实就是两个栈来回「倒腾」。

*/
public class leetcode_232 {
    Deque<Integer> out, in;
    public leetcode_232() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!out.isEmpty()) in.addLast(out.pollLast());
        in.addLast(x);
    }

    public int pop() {
        while (!in.isEmpty()) out.addLast(in.pollLast());
        return out.pollLast();
    }

    public int peek() {
        while (!in.isEmpty()) out.addLast(in.pollLast());
        return out.peekLast();
    }

    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
    }
}
