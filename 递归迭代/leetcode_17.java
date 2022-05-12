package 递归迭代;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time 2022-05-12
 * @Title leetcode_17 电话号码的字母组合
 * @Difficulty_Level middle
 */
/*
    递归回溯算法，先用一个String数组存储数字和字母的组合，然后根据所给的数字，遍历，思路很简单，但是实现递归函数就需要考虑一下。
    1.先定义一个函数，明确这个函数的功能，由于递归的特点是问题和子问题都会调用函数自身，所以这个函数的功能一旦确定了，
     之后只要找寻问题与子问题的递归关系即可
    2.接下来寻找问题与子问题间的关系（即递推公式），这样由于问题与子问题具有相同解决思路，只要子问题调用步骤 1 定义好的函数，问题即可解决。
    所谓的关系最好能用一个公式表示出来，比如 f(n) = n * f(n-) 这样，
    如果暂时无法得出明确的公式，用伪代码表示也是可以的, 发现递推关系后，要寻找最终不可再分解的子问题的解，即（临界条件），确保子问题不会无限分解下去。
    由于第一步我们已经定义了这个函数的功能，所以当问题拆分成子问题时，子问题可以调用步骤 1 定义的函数，符合递归的条件（函数里调用自身）
*/
public class leetcode_17 {
    //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
    //这里也可以用map，用数组可以更节省点内存
    String[] letter_map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        //注意边界条件
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        iterStr(digits, new StringBuilder(), 0);
        return res;
    }

    //最终输出结果的list
    List<String> res = new ArrayList<>();

    //递归函数
    void iterStr(String str, StringBuilder letter, int index) {
        //递归的终止条件，注意这里的终止条件看上去跟动态演示图有些不同，主要是做了点优化
        //动态图中是每次截取字符串的一部分，"234"，变成"23"，再变成"3"，最后变成""，这样性能不佳
        //而用index记录每次遍历到字符串的位置，这样性能更好
        if (index == str.length()) {
            res.add(letter.toString());
            return;
        }
        //获取index位置的字符，假设输入的字符是"234"
        //第一次递归时index为0所以c=2，第二次index为1所以c=3，第三次c=4
        //subString每次都会生成新的字符串，而index则是取当前的一个字符，所以效率更高一点
        char c = str.charAt(index);
        //map_string的下表是从0开始一直到9， c-'0'就可以取到相对的数组下标位置
        //比如c=2时候，2-'0'，获取下标为2,letter_map[2]就是"abc"
        int pos = c - '0';
        String map_string = letter_map[pos];
        //遍历字符串，比如第一次得到的是2，页就是遍历"abc"
        for (int i = 0; i < map_string.length(); i++) {
            //调用下一层递归，用文字很难描述，请配合动态图理解
            letter.append(map_string.charAt(i));
            //如果是String类型做拼接效率会比较低
            //iterStr(str, letter+map_string.charAt(i), index+1);
            iterStr(str, letter, index + 1);
            letter.deleteCharAt(letter.length() - 1);
        }
    }
}
