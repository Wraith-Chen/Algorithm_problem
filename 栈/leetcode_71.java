package 栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Time 2022-5-7
 * @Title leetcode_71 简化路径
 * @Difficulty_Level middle
 */
/*
    把每一个字符通过 / 分隔后，变成一个列表。列表中的每一个字符串，都比作我们的一次输入。根据Linux命令行操作，做成一个输入栈。
    遍历分隔后的字符串，当遇到['.' ,'..', '']以外的内容我们可以直接入栈。写一个列表去匹配比较麻烦，我们可以创建一个 " .." 的字符串，
    使用 !" ..".contains(p)通过字符串快速判断。而遇到 ..，表示上一级目录，我们弹出栈顶元素即可。最后再使用/拼接栈内元素就大功告成了。
*/
public class leetcode_71 {
    public String simplifyPath(String path) {
      Stack<String> stack = new Stack<>();
      StringBuilder sb = new StringBuilder();
      for(String p:path.split("/")){
          if(!stack.empty()&&p.equals("..")){
              stack.pop();
          }else if (!"..".contains(p)){
              stack.push(p);
          }
        }
      for (String end:stack){
          sb.append("/"+end);
      }
      return sb.length()==0?"/":sb.toString();
    }
}
