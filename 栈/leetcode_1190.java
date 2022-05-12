package 栈;

import java.util.Stack;

/**
 * @Time 2022-05-10
 * @Title leetcode_1190 反转每对括号间的子串
 * @Difficulty_Level middle
 */
/*
    维护一个栈，并结合StringBuilder去使用。
    1.创建一个放字符串的栈, 以及一个保存当前字符的变量StringBuilder
    2.遇到 ( 就将当前的字符串推入栈, 并将当前字符串其设置为空
    3.遇到 ) 就将当前的字符串反转, 然后与栈的顶部元素合并, 将栈的顶部元素弹出
    4.遇到普通的字符就将其添加到当前字符串的尾部
    5.遍历结束返回字符串
*/
public class leetcode_1190 {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(sb.toString());
                //当前字符串入栈
                sb.delete(0,sb.length());
                //置空
            }else if(s.charAt(i) == ')'){
                sb.reverse();
                sb.insert(0, stack.pop());
                //取出栈顶元素，并插入合并
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
        }
    }
